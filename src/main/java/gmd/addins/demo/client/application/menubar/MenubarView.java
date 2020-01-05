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
package gmd.addins.demo.client.application.menubar;

import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.theme.dark.ColorScheme;
import gwt.material.design.client.theme.dark.DarkThemeManager;
import gwt.material.design.client.ui.*;

import javax.inject.Inject;

public class MenubarView extends ViewImpl implements MenubarPresenter.MyView {

    interface Binder extends UiBinder<Widget, MenubarView> {
    }

    @UiField
    MaterialDropDown dpMode;

    @UiField
    MaterialRow header;

    @UiField
    MaterialPanel content;

    @UiField
    MaterialCard card;

    @UiField
    MaterialColumn logColumn;

    @Inject
    MenubarView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    protected void onAttach() {
        super.onAttach();

        DarkThemeManager darkThemeManager = DarkThemeManager.get();
        darkThemeManager.addColorSchemeChangeHandler(event -> setDarkTheme(event.getColorScheme() == ColorScheme.DARK));
        setDarkTheme(darkThemeManager.isDarkMode());
    }

    protected void setDarkTheme(boolean dark) {
        header.setBackgroundColor(dark ? Color.GREY_DARKEN_4 : Color.WHITE);
        card.setBackgroundColor(dark ? Color.GREY_DARKEN_3: Color.GREY_LIGHTEN_3);
        content.setBackgroundColor(dark ? Color.GREY_DARKEN_4 : Color.WHITE);
        logColumn.setBackgroundColor(dark ? Color.PURPLE : Color.BLUE);
    }

    @UiHandler({"dpFile", "dpNew", "dpView", "dpEdit", "dpFormat"})
    void onSelectionFileDropdown(SelectionEvent<Widget> selection) {
        if (selection.getSelectedItem() instanceof MaterialLink) {
            MaterialToast.fireToast("Triggered : " + ((MaterialLink) selection.getSelectedItem()).getText());
        } else if (selection.getSelectedItem() instanceof MaterialCheckBox) {
            MaterialToast.fireToast("Checked : " + ((MaterialCheckBox) selection.getSelectedItem()).getText());
        }
    }

    @UiHandler("dpMode")
    void onSelectionMode(SelectionEvent<Widget> selection) {
        dpMode.getItems().forEach(w -> {
            if (w instanceof MaterialCheckBox) {
                ((MaterialCheckBox) w).setValue(false);
            }
        });
        if (selection.getSelectedItem() instanceof MaterialCheckBox) {
            ((MaterialCheckBox) selection.getSelectedItem()).setValue(true);
            MaterialToast.fireToast("Checked : " + ((MaterialCheckBox) selection.getSelectedItem()).getText());
        }
    }
}
