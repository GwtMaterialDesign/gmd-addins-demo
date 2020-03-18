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
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.addins.client.inputmask.MaterialDateInputMask;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.theme.dark.ColorScheme;
import gwt.material.design.client.theme.dark.DarkThemeManager;
import gwt.material.design.client.ui.*;
import gwt.material.design.incubator.client.daterange.DateRangePicker;
import gwt.material.design.incubator.client.daterange.js.*;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.Date;

public class DateRangeView extends ViewImpl implements DateRangePresenter.MyView {

    interface Binder extends UiBinder<Widget, DateRangeView> {
    }

    @UiField
    DateRangePicker dateRangePicker;

    @UiField
    MaterialDateInputMask minDate, maxDate;

    @UiField
    MaterialListValueBox<DropdownAlignment> alignment;

    @UiField
    MaterialListValueBox<DropdownPosition> position;


    @UiField
    MaterialPanel eventsPanel;

    @Inject
    DateRangeView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));

        alignment.clear();
        position.clear();
        Arrays.asList(DropdownAlignment.values()).forEach(a -> alignment.add(a));
        Arrays.asList(DropdownPosition.values()).forEach(p -> position.add(p));


        dateRangePicker.addValueChangeHandler(event -> log("ValueChangeEvent", "[StartDate: " + event.getValue()[0] + "], [" + event.getValue()[1] + "]"));
        dateRangePicker.addApplyHandler(event -> log("ApplyEvent", "fired"));
        dateRangePicker.addOpenHandler(event -> log("OpenEvent", "fired"));
        dateRangePicker.addCloseHandler(event -> log("CloseEvent", "fired"));
        dateRangePicker.addCancelHandler(event -> log("CancelEvent", "fired"));
        dateRangePicker.addNextCalendarHandler(event -> log("NextCalendarEvent", "fired"));
        dateRangePicker.addPreviousCalendarHandler(event -> log("PreviousCalendarEvent", "fired"));
        dateRangePicker.addSelectionHandler(event -> log("SelectionEvent", "fired"));

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

    @UiHandler("getValue")
    void getValue(ClickEvent e) {
        MaterialToast.fireToast("[StartDate: " + dateRangePicker.getValue()[0] + "], [" + dateRangePicker.getValue()[1] + "]");
    }


    @UiHandler("parentEl")
    void parentEl(ValueChangeEvent<String> event) {
        dateRangePicker.setParentEl(event.getValue());
        dateRangePicker.reload();
    }

    @UiHandler("startDate")
    void startDate(ValueChangeEvent<Date[]> event) {
        dateRangePicker.setStartDate(event.getValue()[0]);
        dateRangePicker.reload();
    }

    @UiHandler("endDate")
    void endDate(ValueChangeEvent<Date[]> event) {
        dateRangePicker.setEndDate(event.getValue()[0]);
        dateRangePicker.reload();
    }

    @UiHandler("minDate")
    void minDate(ValueChangeEvent<Date> event) {
        dateRangePicker.setMinDate(minDate.getValue());
        dateRangePicker.reload();
    }

    @UiHandler("maxDate")
    void maxDate(ValueChangeEvent<Date> event) {
        dateRangePicker.setMaxDate(maxDate.getValue());
        dateRangePicker.reload();
    }

    @UiHandler("alignment")
    void alignment(ValueChangeEvent<DropdownAlignment> event) {
        dateRangePicker.setDropdownAlignment(event.getValue());
        dateRangePicker.reload();
    }

    @UiHandler("position")
    void position(ValueChangeEvent<DropdownPosition> event) {
        dateRangePicker.setDropdownPosition(event.getValue());
        dateRangePicker.reload();
    }

    @UiHandler("minYear")
    void minYear(ValueChangeEvent<Integer> event) {
        dateRangePicker.setMinYear(event.getValue());
        dateRangePicker.reload();
    }

    @UiHandler("maxYear")
    void maxYear(ValueChangeEvent<Integer> event) {
        dateRangePicker.setMaxYear(event.getValue());
        dateRangePicker.reload();
    }

    @UiHandler("showDropdowns")
    void showDropdowns(ValueChangeEvent<Boolean> event) {
        dateRangePicker.setShowDropdowns(event.getValue());
        dateRangePicker.reload();
    }

    @UiHandler("showWeekNumbers")
    void showWeekNumbers(ValueChangeEvent<Boolean> event) {
        dateRangePicker.setShowWeekNumbers(event.getValue());
        dateRangePicker.reload();
    }

    @UiHandler("showISOWeekNumbers")
    void showISOWeekNumbers(ValueChangeEvent<Boolean> event) {
        dateRangePicker.setShowISOWeekNumbers(event.getValue());
        dateRangePicker.reload();
    }

    @UiHandler("singleDatePicker")
    void singleDatePicker(ValueChangeEvent<Boolean> event) {
        dateRangePicker.setSingleDatePicker(event.getValue());
        dateRangePicker.reload();
    }

    @UiHandler("timePicker")
    void timePicker(ValueChangeEvent<Boolean> event) {
        dateRangePicker.setTimePicker(event.getValue());
        dateRangePicker.reload();
    }

    @UiHandler("timePicker24Hour")
    void timePicker24Hour(ValueChangeEvent<Boolean> event) {
        dateRangePicker.setTimePicker24Hour(event.getValue());
        dateRangePicker.reload();
    }

    @UiHandler("timePickerIncrement")
    void timePickerIncrement(ValueChangeEvent<Integer> event) {
        dateRangePicker.setTimePickerIncrement(event.getValue());
        dateRangePicker.reload();
    }

    @UiHandler("timePickerSeconds")
    void timePickerSeconds(ValueChangeEvent<Boolean> event) {
        dateRangePicker.setTimePickerSeconds(event.getValue());
        dateRangePicker.reload();
    }

    @UiHandler("maxSpan")
    void maxSpan(ValueChangeEvent<Boolean> event) {
        dateRangePicker.setMaxSpan(event.getValue());
        dateRangePicker.reload();
    }

    @UiHandler("locale")
    void locale(ValueChangeEvent<Boolean> event) {
        if (event.getValue()) {
            DateRangeLocale locale = new DateRangeLocale();
            locale.setApplyLabel("Apply (FR)");
            locale.setCancelLabel("Cancel (FR)");
            locale.setFormat("YYYY/MM/DD");
            locale.setSeparator(" to ");
            locale.setFromLabel("From (FR)");
            locale.setToLabel("To (FR)");
            locale.setCustomRangeLabel("Custom (FR)");
            locale.setWeekLabel("W");

            locale.setDaysOfWeek(new LocaleString[]{
                new LocaleString("Su(!)"),
                new LocaleString("M(!)"),
                new LocaleString("T(!)"),
                new LocaleString("W(!)"),
                new LocaleString("Th(!)"),
                new LocaleString("F(!)"),
                new LocaleString("S(!)"),
            });

            locale.setMonthNames(new LocaleString[]{
                new LocaleString("Enero"),
                new LocaleString("Pebrero"),
                new LocaleString("Marso"),
                new LocaleString("Abril"),
                new LocaleString("Mayo"),
                new LocaleString("Hunyo"),
                new LocaleString("Hulyo"),
                new LocaleString("Agusto"),
                new LocaleString("Setyembre"),
                new LocaleString("Oktubre"),
                new LocaleString("Nobyembre"),
                new LocaleString("Disyembre")
            });
            dateRangePicker.setLocale(locale);
        } else {
            dateRangePicker.setLocale(null);
        }
        dateRangePicker.reload();
    }

    @UiHandler("autoApply")
    void autoApply(ValueChangeEvent<Boolean> event) {
        dateRangePicker.setAutoApply(event.getValue());
        dateRangePicker.reload();
    }

    @UiHandler("buttonClasses")
    void buttonClasses(ValueChangeEvent<String> event) {
        dateRangePicker.setButtonClasses(event.getValue());
        dateRangePicker.reload();
    }

    @UiHandler("applyButtonClasses")
    void applyButtonClasses(ValueChangeEvent<String> event) {
        dateRangePicker.setApplyButtonClasses(event.getValue());
        dateRangePicker.reload();
    }

    @UiHandler("cancelButtonClasses")
    void cancelButtonClasses(ValueChangeEvent<String> event) {
        dateRangePicker.setCancelButtonClasses(event.getValue());
        dateRangePicker.reload();
    }

    @UiHandler("ranges")
    void ranges(ValueChangeEvent<Boolean> event) {
        dateRangePicker.setRanges(event.getValue() ? RangeOption.create() : false);
        dateRangePicker.reload();
    }

    @UiHandler("alwaysShowCalendars")
    void alwaysShowCalendars(ValueChangeEvent<Boolean> event) {
        dateRangePicker.setAlwaysShowCalendars(event.getValue());
        dateRangePicker.reload();
    }

    @UiHandler("showCustomRangeLabel")
    void showCustomRangeLabel(ValueChangeEvent<Boolean> event) {
        dateRangePicker.setShowCustomRangeLabel(event.getValue());
        dateRangePicker.reload();
    }

    @UiHandler("linkedCalendars")
    void linkedCalendars(ValueChangeEvent<Boolean> event) {
        dateRangePicker.setLinkedCalendars(event.getValue());
        dateRangePicker.reload();
    }

    @UiHandler("autoUpdateInput")
    void autoUpdateInput(ValueChangeEvent<Boolean> event) {
        dateRangePicker.setAutoUpdateInput(event.getValue());
        dateRangePicker.reload();
    }

}
