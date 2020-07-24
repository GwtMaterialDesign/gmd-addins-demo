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
package gmd.addins.demo.client.application.beta.keyboard;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.client.ui.MaterialCheckBox;
import gwt.material.design.client.ui.MaterialToast;
import gwt.material.design.incubator.client.keyboard.ScreenKeyboard;

import javax.inject.Inject;

public class ScreenKeyboardView extends ViewImpl implements ScreenKeyboardPresenter.MyView {

    interface Binder extends UiBinder<Widget, ScreenKeyboardView> {
    }

    @UiField
    ScreenKeyboard screenKeyboard;

    @UiField
    MaterialCheckBox toastEvents;

    @Inject
    ScreenKeyboardView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));

        screenKeyboard.addRenderHandler(event -> toastEvent("Render"));
        screenKeyboard.addInitHandler(event -> toastEvent("Init"));
        screenKeyboard.addChangeAllHandler(event -> toastEvent("Change All"));
        screenKeyboard.addKeyboardPressHandler(event -> toastEvent("Keyboard Press"));
        screenKeyboard.addBeforeFirstRenderHandler(event -> toastEvent("Before First Render"));
        screenKeyboard.addBeforeRenderHandler(event -> toastEvent("Before Render"));
        screenKeyboard.addChangeHandler(event -> toastEvent("Change", event.getInput()));
    }

    protected void toastEvent(String event, String... params) {
        if (toastEvents.getValue()) {
            StringBuilder cleanedParams = new StringBuilder();
            for (String param : params) {
                cleanedParams.append(" ").append(param);
            }
            MaterialToast.fireToast(event + " event fired." + cleanedParams);
        }
    }
}
