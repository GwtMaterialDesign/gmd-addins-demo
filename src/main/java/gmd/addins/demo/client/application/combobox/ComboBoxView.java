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
import gwt.material.design.addins.client.combobox.template.DefaultResultTemplate;
import gwt.material.design.addins.client.combobox.template.DefaultSelectionTemplate;
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
        comboCloseOnSelect, events, eventsMultiple, templateComboBox, matcherComboBox;

    @UiField
    MaterialComboBox<String> tags, comboTags;

    @UiField
    MaterialCheckBox disable;

    @Inject
    ComboBoxView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    protected void onAttach() {
        super.onAttach();

        labelAndPlaceholder.setCloseOnSelect(true);
        labelAndPlaceholder.setScrollAfterSelect(false);

        events.addValueChangeHandler(event -> MaterialToast.fireToast("Value Change Event: " + event.getValue().get(0).getProductName()));
        eventsMultiple.addValueChangeHandler(event -> {
            for (Product product : event.getValue()) {
                MaterialToast.fireToast("Value Change Event: " + product.getProductName());
            }
        });

        events.addSelectionHandler(event -> MaterialToast.fireToast("Selection Event: " + event.getSelectedValues().get(0).getProductName()));
        eventsMultiple.addSelectionHandler(event -> {
            for (Product product : event.getSelectedValues()) {
                MaterialToast.fireToast("Selection Event: " + product.getProductName());
            }
        });

        events.addFocusHandler(event -> {
           MaterialToast.fireToast("Focus Event Fired");
        });
        eventsMultiple.addFocusHandler(event -> {
            MaterialToast.fireToast("Focus Event Fired");
        });

        events.addBlurHandler(event -> {
            MaterialToast.fireToast("Blur Event Fired");
        });
        eventsMultiple.addBlurHandler(event -> {
            MaterialToast.fireToast("Blur Event Fired");
        });

        events.addOpenHandler(event -> MaterialToast.fireToast("Open Event Fired"));
        eventsMultiple.addOpenHandler(event -> MaterialToast.fireToast("Open Event Fired"));

        events.addOpeningHandler(event -> MaterialToast.fireToast("Opening Event Fired"));
        eventsMultiple.addOpeningHandler(event -> MaterialToast.fireToast("Opening Event Fired"));

        events.addCloseHandler(event -> MaterialToast.fireToast("Close Event Fired"));
        eventsMultiple.addCloseHandler(event -> MaterialToast.fireToast("Close Event Fired"));

        events.addClosingHandler(event -> MaterialToast.fireToast("Closing Event Fired"));
        eventsMultiple.addClosingHandler(event -> MaterialToast.fireToast("Closing Event Fired"));

        events.addClearHandler(event -> MaterialToast.fireToast("Clear Event Fired"));
        eventsMultiple.addClearHandler(event -> MaterialToast.fireToast("Clear Event Fired"));

        events.addClearingHandler(event -> MaterialToast.fireToast("Clearing Event Fired"));
        eventsMultiple.addClearingHandler(event -> MaterialToast.fireToast("Clearing Event Fired"));

        events.addRemoveItemHandler(event -> MaterialToast.fireToast("Remove Item Event Fired"));
        eventsMultiple.addRemoveItemHandler(event -> MaterialToast.fireToast("Remove Item Event Fired"));


        allowClear.addClearHandler(event -> MaterialToast.fireToast("Clear Event Fired"));
        allowClear.addClearingHandler(event -> MaterialToast.fireToast("Clearing Event Fired"));
        singleAllowClear.addClearHandler(event -> MaterialToast.fireToast("Clear Event Fired"));
        singleAllowClear.addClearingHandler(event -> MaterialToast.fireToast("Clearing Event Fired"));

        templateComboBox.setTemplateResult((template) -> {
            if (template.id != null) {
                Product product = this.products.getValueByString(template.id);
                if (product != null) {
                    return new DefaultResultTemplate(product.getImage(), product.getProductName(), product.getProductMaterial()).getElement();
                }
            }
            return template.text;
        });

        templateComboBox.setTemplateSelection(template -> {
            if (template.id != null) {
                Product product = this.products.getValueByString(template.id);
                if (product != null) {
                    return new DefaultSelectionTemplate(product.getImage(), product.getProductName()).getElement();
                }
            }
            return template.text;
        });

        // Matcher Demo
        matcherComboBox.setMatcher((params, data) -> {
            if (params.term != null) {

                // If there are no search terms, return all of the data
                if (params.term.equals("")) {
                    return data;
                }

                // Do not display the item if there is no 'text' property
                if (data.text == null) {
                    return null;
                }

                // `params.term` should be the term that is used for searching
                // `data.text` is the text that is displayed for the data object
                if (data.text.indexOf(params.term) > -1) {
                    data.text = "matched:" + data.text;

                    // You can return modified objects from here
                    // This includes matching the `children` how you want in nested data sets
                    return data;
                }

                // Return `null` if the term should not be displayed
            }
            return null;
        });

        // Tags will support only String generic Comboboxes
        List<Product> products = new DataGenerator().generateProducts(10);
        products.forEach(product -> {
            tags.addItem(product.getProductName());
            comboTags.addItem(product.getProductName());
        });
    }

    @Override
    public void setProducts(List<Product> products) {
        addProducts(products, this.products, multipleSelect, disabled, comboCloseOnSelect,
            events, eventsMultiple, templateComboBox, matcherComboBox);
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
        List<String> value = tags.getValue();
        if (value != null) {
            for (String productName : value) {
                MaterialToast.fireToast(productName);
            }
        } else {
            MaterialToast.fireToast("Nothing is selected");
        }

    }

    @UiHandler("comboTagsGetValue")
    void comboTagsGetValue(ClickEvent e) {
        List<String> value = comboTags.getValue();
        if (value != null) {
            for (String productName : value) {
                MaterialToast.fireToast(productName);
            }
        } else {
            MaterialToast.fireToast("Nothing is selected");
        }
    }
}
