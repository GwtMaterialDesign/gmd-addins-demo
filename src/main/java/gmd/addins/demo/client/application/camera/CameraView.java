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
package gmd.addins.demo.client.application.camera;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.addins.client.camera.MaterialCameraCapture;
import gwt.material.design.client.ui.MaterialImage;
import gwt.material.design.client.ui.MaterialToast;

import javax.inject.Inject;

public class CameraView extends ViewImpl implements CameraPresenter.MyView {

    interface Binder extends UiBinder<Widget, CameraView> {
    }

    @UiField
    MaterialCameraCapture camera;

    @UiField
    MaterialImage resultImage;

    @Inject
    CameraView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    protected void onAttach() {
        super.onAttach();

        if (MaterialCameraCapture.isSupported()) {
            camera.addCameraCaptureHandler(event -> {
                switch (event.getCaptureStatus()) {
                    case STARTED:
                        GWT.log("Started");
                        break;
                    case PAUSED:
                        GWT.log("Paused");
                        break;
                    case ERRORED:
                        GWT.log("Errored");
                        break;
                    default:
                        break;
                }
            });
        } else {
            MaterialToast.fireToast("Camera Capture is not supported in your browser.");
        }
    }

    @UiHandler("capture")
    void capture(ClickEvent e) {
        String url = camera.captureToDataURL();
        resultImage.setUrl(url);
    }

    @UiHandler("play")
    void play(ClickEvent e) {
        camera.play();
    }

    @UiHandler("pause")
    void pause(ClickEvent e) {
        camera.pause();
    }
}
