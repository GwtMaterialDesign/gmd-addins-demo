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
package gmd.addins.demo.client.application.dnd;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.addins.client.dnd.MaterialDnd;
import gwt.material.design.addins.client.dnd.constants.Restriction;
import gwt.material.design.addins.client.dnd.js.JsDragOptions;
import gwt.material.design.addins.client.dnd.js.JsDropOptions;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.constants.Axis;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.theme.dark.ColorScheme;
import gwt.material.design.client.theme.dark.DarkThemeManager;
import gwt.material.design.client.ui.*;
import gwt.material.design.jquery.client.api.JQueryElement;

import javax.inject.Inject;

import static gwt.material.design.jquery.client.api.JQuery.$;

public class DndView extends ViewImpl implements DndPresenter.MyView {

    interface Binder extends UiBinder<Widget, DndView> {
    }

    @UiField
    MaterialPanel panel, woInertialPanel, endOnlyPanel, selfRestrict, restrictPanel, eventPanel, dndIgnoreFrom,
        ignoredPanel, xAxisPanel, yAxisPanel, item1, item2, item3, item4;

    @UiField
    MaterialRow dropzoneContainer;

    @UiField
    MaterialColumn placeContainer, colContainer;

    @UiField
    MaterialLabel lblStarted, lblMoved, lblEnded;

    @Inject
    DndView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));

        MaterialDnd dnd = new MaterialDnd(panel);
        dnd.draggable();

        MaterialDnd dnd2 = new MaterialDnd(woInertialPanel);
        dnd2.draggable(JsDragOptions.create(false));

        Restriction restriction = new Restriction();
        restriction.setEndOnly(false);

        MaterialDnd dnd3 = new MaterialDnd(woInertialPanel);
        dnd3.draggable(JsDragOptions.create(false));

        MaterialDnd dnd4 = new MaterialDnd(endOnlyPanel);
        dnd4.draggable(JsDragOptions.create(restriction));

        Restriction restriction1 = new Restriction();
        restriction1.setRestriction(Restriction.Restrict.SELF);

        MaterialDnd dnd5 = new MaterialDnd(selfRestrict);
        dnd5.draggable(JsDragOptions.create(restriction1));

        Restriction restriction2 = new Restriction();
        restriction2.setTop(0.25);
        restriction2.setLeft(0.25);
        restriction2.setRight(0.75);
        restriction2.setBottom(0.75);

        MaterialDnd dnd6 = new MaterialDnd(restrictPanel);
        dnd6.draggable(JsDragOptions.create(restriction2));

        MaterialDnd dndIgnore = new MaterialDnd(dndIgnoreFrom);
        dndIgnore.draggable().then(p0 -> {
            dndIgnore.ignoreFrom(ignoredPanel);
            return null;
        });

        MaterialDnd dnd7 = new MaterialDnd(xAxisPanel);
        dnd7.draggable(JsDragOptions.create(Axis.HORIZONTAL));

        MaterialDnd dnd8 = new MaterialDnd(yAxisPanel);
        dnd8.draggable(JsDragOptions.create(Axis.VERTICAL));

        MaterialDnd dnd9 = new MaterialDnd(item1);
        dnd9.draggable();

        MaterialDnd dnd10 = new MaterialDnd(item2);
        dnd10.draggable();

        MaterialDnd dnd11 = new MaterialDnd(item3);
        dnd11.draggable();

        MaterialDnd dnd12 = new MaterialDnd(item4);
        dnd12.draggable();


        MaterialDnd drop = new MaterialDnd(dropzoneContainer);
        drop.dropzone(JsDropOptions.create(".test"));

        dropzoneContainer.addDropActivateHandler(event1 -> {
            MaterialToast.fireToast("Drop Activate");
        });

        dropzoneContainer.addDragEnterHandler(dragEnterEvent -> {
            placeContainer.setBackgroundColor(DarkThemeManager.get().isDarkMode() ? Color.GREY_DARKEN_3 : Color.GREY_LIGHTEN_2);
            MaterialToast.fireToast("Drag Enter");
        });

        dropzoneContainer.addDragLeaveHandler(event1 -> {
            MaterialToast.fireToast("Drag Leave");
        });

        dropzoneContainer.addDropHandler(event -> {
            JQueryElement target = $(event.getRelatedTarget());
            MaterialWidget widget = new MaterialWidget(target.asElement());
            placeContainer.add(widget);
            MaterialToast.fireToast("Dropped");
        });

        dropzoneContainer.addDropDeactivateHandler(event -> {
            MaterialToast.fireToast("Drop Deactivate");
        });

        MaterialDnd dnd13 = new MaterialDnd(eventPanel);
        dnd13.draggable();

        // Add Drag Start Handler
        eventPanel.addDragStartHandler(event -> {
            eventPanel.setBackgroundColor(Color.BLUE);
            lblStarted.setVisible(true);
        });
        // Add Drag Move Handler
        eventPanel.addDragMoveHandler(event -> {
            eventPanel.setBackgroundColor(Color.AMBER);
            lblMoved.setVisible(true);
        });
        // Add Drag End Handler
        eventPanel.addDragEndHandler(event -> {
            eventPanel.setBackgroundColor(Color.GREEN);
            lblEnded.setVisible(true);
        });

        DarkThemeManager manager = DarkThemeManager.get();
        setDarkMode(manager.isDarkMode());
        manager.addColorSchemeChangeHandler(event -> setDarkMode(event.getColorScheme() == ColorScheme.DARK));
    }

    protected void setDarkMode(boolean dark) {
        panel.setBackgroundColor(dark ? Color.BLACK : Color.WHITE);
        woInertialPanel.setBackgroundColor(dark ? Color.BLACK : Color.WHITE);
        endOnlyPanel.setBackgroundColor(dark ? Color.BLACK : Color.WHITE);
        selfRestrict.setBackgroundColor(dark ? Color.BLACK : Color.WHITE);
        restrictPanel.setBackgroundColor(dark ? Color.BLACK : Color.WHITE);
        placeContainer.setBackgroundColor(dark ? Color.GREY_DARKEN_4 : Color.GREY_LIGHTEN_5);

        for (Widget widget : colContainer) {
            if (widget instanceof MaterialPanel) {
                ((MaterialPanel) widget).setBackgroundColor(dark ? Color.GREY_DARKEN_3 : Color.GREY_LIGHTEN_4);
            }
        }
    }
}
