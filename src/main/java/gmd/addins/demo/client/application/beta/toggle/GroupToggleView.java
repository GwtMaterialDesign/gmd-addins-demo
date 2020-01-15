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
package gmd.addins.demo.client.application.beta.toggle;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.client.ui.MaterialToast;
import gwt.material.design.incubator.client.toggle.GroupToggleButton;

import javax.inject.Inject;
import java.util.List;

public class GroupToggleView extends ViewImpl implements GroupTogglePresenter.MyView {

    interface Binder extends UiBinder<Widget, GroupToggleView> {
    }

    @UiField
    GroupToggleButton<Integer> groupToggle;

    @Inject
    GroupToggleView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));

        updateItems(true);
    }

    public void updateItems(boolean value) {
        groupToggle.getWrapper().clear();

        if (value) {
            groupToggle.addItem(1);
            groupToggle.addItem(2);
            groupToggle.addItem(3);
            groupToggle.addItem(4);
            groupToggle.addItem(5);
        } else {
            groupToggle.addItem("a", 1);
            groupToggle.addItem("b", 2);
            groupToggle.addItem("c", 3);
            groupToggle.addItem("d", 4);
            groupToggle.addItem("e", 5);
        }
    }

    @UiHandler("groupToggle")
    void selection(SelectionEvent<Integer> e) {
        MaterialToast.fireToast("Selected Index : " + e.getSelectedItem());
    }

    @UiHandler("groupToggle")
    void valueChange(ValueChangeEvent<List<Integer>> event) {
        MaterialToast.fireToast(event.getValue().toString());
    }

    @UiHandler("getIndex")
    void getIndex(ClickEvent e) {
        MaterialToast.fireToast("Selected Index : " + groupToggle.getValue().get(0));
    }

    @UiHandler("multiple")
    void multiple(ValueChangeEvent<Boolean> event) {
        groupToggle.setMultiple(event.getValue());
    }

    @UiHandler("changeText")
    void changeText(ValueChangeEvent<Boolean> event) {
        updateItems(!event.getValue());
    }

    @UiHandler("reset")
    void reset(ClickEvent e) {
        groupToggle.reset();
    }
}
