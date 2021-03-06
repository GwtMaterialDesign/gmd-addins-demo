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
package gmd.addins.demo.client.application.tree;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.addins.client.pathanimator.MaterialPathAnimator;
import gwt.material.design.addins.client.tree.MaterialTree;
import gwt.material.design.addins.client.tree.MaterialTreeItem;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.theme.dark.ColorScheme;
import gwt.material.design.client.theme.dark.DarkThemeManager;
import gwt.material.design.client.ui.*;

import javax.inject.Inject;

public class TreeView extends ViewImpl implements TreePresenter.MyView {

    interface Binder extends UiBinder<Widget, TreeView> {
    }

    @UiField
    MaterialTree docTree;

    @UiField
    MaterialDialog addDialog;

    @UiField
    MaterialTextBox txtName;

    @UiField
    MaterialIcon btnAdd, btnDelete;

    @UiField
    MaterialPanel titlePanel;


    @Inject
    TreeView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));

        docTree.addCloseHandler(event -> MaterialToast.fireToast("Closed : " + event.getTarget().getText()));
        docTree.addOpenHandler(event -> MaterialToast.fireToast("Opened : " + event.getTarget().getText()));
        docTree.addSelectionHandler(event -> {
            btnAdd.setVisible(true);
            btnDelete.setVisible(true);
            MaterialToast.fireToast("Selected : " + event.getSelectedItem().getText());
        });

        DarkThemeManager manager = DarkThemeManager.get();
        setDarkMode(manager.isDarkMode());
        manager.addColorSchemeChangeHandler(event -> setDarkMode(event.getColorScheme() == ColorScheme.DARK));
    }

    protected void setDarkMode(boolean darkMode) {
        titlePanel.setBackgroundColor(darkMode ? Color.DEEP_PURPLE_ACCENT_1 : Color.BLUE);
    }

    @UiHandler("btnCollapse")
    void onCollapseTree(ClickEvent e) {
        docTree.collapse();
    }

    @UiHandler("btnExpand")
    void onExpandTree(ClickEvent e) {
        docTree.expand();
    }

    @UiHandler("btnAdd")
    void onAddDialog(ClickEvent e) {
        addDialog.open();
    }

    @UiHandler("btnDelete")
    void onDeleteDialog(ClickEvent e) {
        docTree.getSelectedItem().removeFromTree();
    }

    @UiHandler("btnDeselectItem")
    void onDeselectItem(ClickEvent e) {
        if (docTree.getSelectedItem() == null) {
            MaterialToast.fireToast("You must select an item first.");
        } else {
            MaterialToast.fireToast("Item " + docTree.getSelectedItem().getText() + " was deselected.");
            docTree.deselectSelectedItem();
        }
    }

    @UiHandler("btnFinish")
    void onFinishDialog(ClickEvent e) {
        MaterialTreeItem item = new MaterialTreeItem();
        item.setText(txtName.getText());
        item.setIconType(IconType.FOLDER);
        item.setIconColor(Color.BLUE);
        docTree.getSelectedItem().addItem(item);
        addDialog.close();
    }

    @UiHandler("btnCancel")
    void onCancelDialog(ClickEvent e) {
        MaterialPathAnimator.reverseAnimate(btnAdd.getElement(), addDialog.getElement());
    }
}
