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
package gmd.addins.demo.client.application.beta.daterange;

import com.google.gwt.dom.client.Style;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.theme.dark.ColorScheme;
import gwt.material.design.client.theme.dark.DarkThemeManager;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialPanel;
import gwt.material.design.client.ui.MaterialRow;
import gwt.material.design.client.ui.MaterialToast;
import gwt.material.design.incubator.client.daterange.DateRangePicker;

import javax.inject.Inject;

public class DateRangeView extends ViewImpl implements DateRangePresenter.MyView {

    interface Binder extends UiBinder<Widget, DateRangeView> {
    }

    @UiField
    DateRangePicker dateRange;

    @UiField
    MaterialPanel eventsPanel;

    @Inject
    DateRangeView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));

        dateRange.addValueChangeHandler(event -> log("ValueChangeEvent", "[StartDate: " + event.getValue()[0] + "], [" + event.getValue()[1] + "]"));
        dateRange.addApplyHandler(event -> log("ApplyEvent", "fired"));
        dateRange.addOpenHandler(event -> log("OpenEvent", "fired"));
        dateRange.addCloseHandler(event -> log("CloseEvent", "fired"));
        dateRange.addCancelHandler(event -> log("CancelEvent", "fired"));
        dateRange.addNextCalendarHandler(event -> log("NextCalendarEvent", "fired"));
        dateRange.addPreviousCalendarHandler(event -> log("PreviousCalendarEvent", "fired"));
        dateRange.addSelectionHandler(event -> log("SelectionEvent", "fired"));

        DarkThemeManager darkThemeManager = DarkThemeManager.get();
        setDarkMode(darkThemeManager.isDarkMode());
        darkThemeManager.addColorSchemeChangeHandler(event -> setDarkMode(event.getColorScheme() == ColorScheme.DARK));
    }

    protected void setDarkMode(boolean darkMode) {
        eventsPanel.setBackgroundColor(darkMode ? Color.GREY_DARKEN_4 : Color.GREY_LIGHTEN_4);
    }

    protected void log(String event, String message) {
        MaterialRow row = new MaterialRow();
        row.setMarginBottom(0);
        MaterialLabel label = new MaterialLabel(event);
        label.setFloat(Style.Float.LEFT);
        label.setMarginRight(12);
        MaterialLabel messageLabel = new MaterialLabel(message);
        messageLabel.setFloat(Style.Float.LEFT);
        row.add(label);
        row.add(messageLabel);
        eventsPanel.add(row);
    }

    @UiHandler("singleDatePicker")
    void singleDatePicker(ValueChangeEvent<Boolean> e) {
        dateRange.setSingleDatePicker(e.getValue());
        dateRange.reload();
    }

    @UiHandler("autoApply")
    void autoApply(ValueChangeEvent<Boolean> e) {
        dateRange.setAutoApply(e.getValue());

        dateRange.reload();
    }
}
