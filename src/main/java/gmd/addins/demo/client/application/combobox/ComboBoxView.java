/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2017 GwtMaterialDesign
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package gmd.addins.demo.client.application.combobox;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gmd.addins.demo.client.generator.DataGenerator;
import gmd.addins.demo.client.generator.product.Product;
import gmd.addins.demo.client.generator.user.User;
import gwt.material.design.addins.client.combobox.MaterialComboBox;
import gwt.material.design.addins.client.combobox.template.ImageTextResultTemplate;
import gwt.material.design.addins.client.combobox.template.ImageTextSelectionTempate;
import gwt.material.design.client.ui.MaterialCheckBox;
import gwt.material.design.client.ui.MaterialToast;
import gwt.material.design.client.ui.html.OptGroup;

import javax.inject.Inject;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ComboBoxView extends ViewImpl implements ComboBoxPresenter.MyView {

    interface Binder extends UiBinder<Widget, ComboBoxView> {
    }

    @UiField
    MaterialComboBox<Product> products, labelAndPlaceholder, singleAllowClear, allowClear, withOptGroup, multipleSelect, disabled, limit,
        tags, comboTags, comboCloseOnSelect, valueChange, valueChangeMultiple, selection, selectionMultiple, templateComboBox;

    @UiField
    MaterialCheckBox disable;

    @Inject
    ComboBoxView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));


        labelAndPlaceholder.setCloseOnSelect(true);
        labelAndPlaceholder.setScrollAfterSelect(false);

        valueChange.addValueChangeHandler(event -> MaterialToast.fireToast(event.getValue().get(0).getProductName()));
        valueChangeMultiple.addValueChangeHandler(event -> {
            for (Product product : event.getValue()) {
                MaterialToast.fireToast(product.getProductName());
            }
        });

        selection.addSelectionHandler(event -> MaterialToast.fireToast(event.getSelectedValues().get(0).getProductName()));
        selectionMultiple.addSelectionHandler(event -> {
            for (Product product : event.getSelectedValues()) {
                MaterialToast.fireToast(product.getProductName());
            }
        });

        allowClear.addClearHandler(event -> MaterialToast.fireToast("Clear Event Fired"));
        allowClear.addClearingHandler(event -> MaterialToast.fireToast("Clearing Event Fired"));
        singleAllowClear.addClearHandler(event -> MaterialToast.fireToast("Clear Event Fired"));
        singleAllowClear.addClearingHandler(event -> MaterialToast.fireToast("Clearing Event Fired"));

        //TODO: Prepare a template samples for the combobox.
        //TODO: Might need to create a class to be defined.
        templateComboBox.setTemplateResult((template) -> {
            if (template.id != null) {
                Product product = this.products.getValueByString(template.id);
                if (product != null) {
                    return new ImageTextSelectionTempate(product.getImage(), product.getProductName()).getElement();
                }
            }
            return template.text;
        });

        templateComboBox.setTemplateSelection(template -> {
            if (template.id != null) {
                Product product = this.products.getValueByString(template.id);
                if (product != null) {
                    return new ImageTextResultTemplate(product.getImage(), product.getProductName()).getElement();
                }
            }
            return template.text;
        });
    }

    @Override
    public void setProducts(List<Product> products) {
        addProducts(products, this.products, multipleSelect, disabled, tags, comboTags, comboCloseOnSelect, valueChange, valueChangeMultiple,
            selection, selectionMultiple, templateComboBox);
        addProductMaterials(products, labelAndPlaceholder, allowClear);
        addProductsGroup(products, withOptGroup, limit);
    }

    protected void addProducts(List<Product> products, MaterialComboBox<Product>... comboBoxes) {
        for (MaterialComboBox<Product> comboBox : comboBoxes) {
            products.forEach(product -> comboBox.addItem(product.getProductName(), product));
        }
    }

    protected void addProductMaterials(List<Product> products, MaterialComboBox<Product>... comboBoxes) {
        Collection<Product> nonDuplicatedEmployees = products.stream()
            .<Map<String, Product>>collect(HashMap::new, (m, e) -> m.put(e.getProductMaterial(), e), Map::putAll)
            .values();

        for (MaterialComboBox<Product> comboBox : comboBoxes) {
            nonDuplicatedEmployees.forEach(product -> {
                comboBox.addItem(product.getProductMaterial(), product);
            });
        }
    }

    protected void addProductsGroup(List<Product> products, MaterialComboBox<Product>... comboBoxes) {
        for (MaterialComboBox comboBox : comboBoxes) {
            for (Product product : products) {
                OptGroup optGroup = new OptGroup();
                optGroup.setLabel(product.getDepartment());
                for (User user : new DataGenerator().generateUsers(5)) {
                    comboBox.addItem(user.getName(), user, optGroup);
                }
                comboBox.addGroup(optGroup);
            }

        }
    }

    @UiHandler("disable")
    void disable(ValueChangeEvent<Boolean> event) {
        disabled.setEnabled(event.getValue());
        disable.setText(event.getValue() ? "Disable" : "Enable");
    }

    @UiHandler("tagsGetValue")
    void tagsGetValue(ClickEvent e) {
        for (Product product : tags.getValue()) {
            if (product != null && product.getProductName() != null) {
                MaterialToast.fireToast(product.getProductName());
            }
        }
    }

    @UiHandler("comboTagsGetValue")
    void comboTagsGetValue(ClickEvent e) {
        for (Product product : comboTags.getValue()) {
            MaterialToast.fireToast(product.getProductName());
        }
    }
}
