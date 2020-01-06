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
package gmd.addins.demo.client.application.pathanimator;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.addins.client.pathanimator.MaterialPathAnimator;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.ui.*;

import javax.inject.Inject;

public class PathAnimatorView extends ViewImpl implements PathAnimatorPresenter.MyView {

    interface Binder extends UiBinder<Widget, PathAnimatorView> {
    }

    @UiField
    MaterialButton btnOptionSource;

    @UiField
    MaterialCard panelWithOptions;

    @UiField
    MaterialLink btnCloseWithOptions;

    @UiField
    MaterialCheckBox withBackground, withBorder, withShadow;

    @UiField
    MaterialIntegerBox txtDuration, txtTargetShowDuration, txtExtraTransitionDuration;

    private MaterialPathAnimator animator = new MaterialPathAnimator();

    @Inject
    PathAnimatorView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));

        txtDuration.setValue(300);
        txtDuration.setHelperText("Duration (in milliseconds) of animation. Default is 3000 ms.");

        txtTargetShowDuration.setValue(0);
        txtTargetShowDuration.setHelperText("Duration (in milliseconds) of targetElement to become visible, if hidden initially. The library will automatically try to figure this out from the element's computed styles. Default is 0 ms.");

        txtExtraTransitionDuration.setValue(1000);
        txtExtraTransitionDuration.setHelperText("Extra duration (in milliseconds) of targetElement to provide visual continuity between the animation and the rendering of the targetElement. Default is 1000ms");
    }

    @UiHandler("btnCloseWithOptions")
    void onCloseWithOptions(ClickEvent e) {
        animator.reverseAnimate();
    }

    @UiHandler("btnOptionSource")
    void onOptionSource(ClickEvent e) {
        animator.setSourceElement(btnOptionSource.getElement());
        animator.setTargetElement(panelWithOptions.getElement());
        animator.setDuration(txtDuration.getValue());
        animator.setTargetShowDuration(txtTargetShowDuration.getValue());
        animator.setExtraTransitionDuration(txtExtraTransitionDuration.getValue());
        animator.animate();

    }

    @UiHandler("withBackground")
    void withBackground(ValueChangeEvent<Boolean> e) {
        if (e.getValue()) {
            animator.setBackgroundColor(Color.RED);
        } else {
            animator.setBackgroundColor(Color.WHITE);
        }
    }

    @UiHandler("withBorder")
    void withBorder(ValueChangeEvent<Boolean> e) {
        if (e.getValue()) {
            animator.setStyleProperty("border", "4px solid");
        } else {
            animator.clearStyleProperty("border");
        }
    }

    @UiHandler("withShadow")
    void withShadow(ValueChangeEvent<Boolean> e) {
        if (e.getValue()) {
            animator.setShadow(3);
        } else {
            animator.setShadow(0);
        }
    }
}
