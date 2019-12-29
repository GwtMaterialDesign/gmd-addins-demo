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
package gmd.addins.demo.client.application.circularprogress;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.addins.client.circularprogress.MaterialCircularProgress;
import gwt.material.design.client.constants.Color;

import javax.inject.Inject;

public class CircularProgressView extends ViewImpl implements CircularProgressPresenter.MyView {

    interface Binder extends UiBinder<Widget, CircularProgressView> {
    }

    @UiField
    MaterialCircularProgress progress;

    @Inject
    CircularProgressView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @UiHandler("fillColors")
    void fillColors(ValueChangeEvent<Boolean> event) {
        if (event.getValue()) {
            progress.setFillColor(Color.PINK);
            progress.setEmptyFillColor(Color.PINK_LIGHTEN_5);
        } else {
            progress.setFillColor(Color.BLUE);
            progress.setEmptyFillColor(Color.BLUE_LIGHTEN_5);
        }
        progress.reload();
    }

    @UiHandler("thickness")
    void thickness(ValueChangeEvent<Boolean> event) {
        if (event.getValue()) {
            progress.setThickness(20);
        } else {
            progress.setThickness(8);
        }
        progress.reload();
    }

    @UiHandler("reverse")
    void reverse(ValueChangeEvent<Boolean> event) {
        progress.setReverse(event.getValue());
        progress.reload();
    }

    @UiHandler("updateValue")
    void updateValue(ValueChangeEvent<Boolean> event) {
        if (event.getValue()) {
            progress.setValue(75.0);
        } else {
            progress.setValue(30.0);
        }
    }
}
