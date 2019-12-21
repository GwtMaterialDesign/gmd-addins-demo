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
package gmd.addins.demo.client.application.timepicker;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.addins.client.timepicker.MaterialTimePicker;
import gwt.material.design.client.constants.Orientation;

import javax.inject.Inject;

public class TimePickerView extends ViewImpl implements TimePickerPresenter.MyView {

    interface Binder extends UiBinder<Widget, TimePickerView> {
    }

    @UiField
    MaterialTimePicker timePicker;

    @Inject
    TimePickerView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @UiHandler("enabled")
    void enabled(ValueChangeEvent<Boolean> event) {
        timePicker.setEnabled(event.getValue());
    }

    @UiHandler("hour24")
    void changeHour(ValueChangeEvent<Boolean> event) {
        timePicker.setHour24(event.getValue());
        timePicker.reload();
    }

    @UiHandler("autoClose")
    void autoClose(ValueChangeEvent<Boolean> event) {
        timePicker.setAutoClose(event.getValue());
        timePicker.reload();
    }

    @UiHandler("localized")
    void localized(ValueChangeEvent<Boolean> event) {
        if (event.getValue()) {
            timePicker.setCancelText("Kanselahin");
            timePicker.setOkText("Tapos na");
        } else {
            timePicker.setCancelText("Cancel");
            timePicker.setOkText("Ok");
        }
    }

    @UiHandler("portrait")
    void portrait(ValueChangeEvent<Boolean> event) {
        timePicker.setOrientation(event.getValue() ? Orientation.PORTRAIT : Orientation.LANDSCAPE);
    }
}
