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
package gmd.addins.demo.client.application.stepper;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.addins.client.stepper.MaterialStepper;
import gwt.material.design.client.constants.Axis;
import gwt.material.design.client.ui.MaterialToast;

import javax.inject.Inject;

public class StepperView extends ViewImpl implements StepperPresenter.MyView {

    interface Binder extends UiBinder<Widget, StepperView> {
    }

    @UiField
    MaterialStepper stepper;

    @Inject
    StepperView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));

        stepper.addStartHandler(event -> MaterialToast.fireToast("Start Event Fired"));
        stepper.addSelectionChangeHandler(event -> MaterialToast.fireToast( "Selection Event Fired : " + stepper.getCurrentStepIndex()));
        stepper.addNextHandler(event -> MaterialToast.fireToast("Next Event Fired"));
        stepper.addPreviousHandler(event -> MaterialToast.fireToast("Previous Event Fired"));
        stepper.addCompleteHandler(event -> MaterialToast.fireToast("Complete Event Fired"));
    }

    @Override
    protected void onAttach() {
        super.onAttach();


    }

    @UiHandler({"btnContinue1", "btnContinue2", "btnContinue3"})
    void btnContinue1(ClickEvent e) {
        stepper.nextStep();
    }

    @UiHandler("btnContinue3")
    void btnContinue3(ClickEvent event) {
        stepper.reset();
    }

    @UiHandler("vertical")
    void vertical(ValueChangeEvent<Boolean> event) {
        stepper.setAxis(event.getValue() ? Axis.VERTICAL : Axis.HORIZONTAL);
    }

    @UiHandler("card")
    void card(ValueChangeEvent<Boolean> event) {
        stepper.setShadow(event.getValue() ? 1 : 0);
    }

    @UiHandler("error")
    void withError(ValueChangeEvent<Boolean> event) {
        if (event.getValue()) {
            stepper.setErrorText("Somethings wrong");
        } else {
            stepper.clearStatusText();
        }
    }

    @UiHandler("success")
    void withSuccess(ValueChangeEvent<Boolean> event) {
        if (event.getValue()) {
            stepper.setSuccessText("Success");
        } else {
            stepper.clearStatusText();
        }
    }

    @UiHandler("animation")
    void animation(ValueChangeEvent<Boolean> event) {
        stepper.setEnableTransition(event.getValue());
    }

    @UiHandler("feedback")
    void withFeedback(ValueChangeEvent<Boolean> event) {
        if (event.getValue()) {
            stepper.showFeedback("Please wait...");
        } else {
            stepper.hideFeedback();
        }
    }
}
