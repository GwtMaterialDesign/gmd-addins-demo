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
package gmd.addins.demo.client.application.dropzone;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.addins.client.fileuploader.MaterialFileUploader;
import gwt.material.design.client.ui.MaterialCheckBox;
import gwt.material.design.client.ui.MaterialToast;

import javax.inject.Inject;

public class DropzoneView extends ViewImpl implements DropzonePresenter.MyView {

    interface Binder extends UiBinder<Widget, DropzoneView> {
    }

    @UiField
    MaterialFileUploader uploader;

    @UiField
    MaterialCheckBox events;

    @Inject
    DropzoneView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));

        uploader.setUploadMultiple(true);

        uploader.addDropHandler(event -> toastEvents("Drop Event"));
        uploader.addDragStartHandler(event -> toastEvents("Drag Start"));
        uploader.addDragEndHandler(event -> toastEvents("Drag End"));
        uploader.addDragEnterHandler(event -> toastEvents("Drag Enter"));
        uploader.addDragOverHandler(event -> toastEvents("Drag Over"));
        uploader.addDragLeaveHandler(event -> toastEvents("Drag Leave"));

        uploader.addAddedFileHandler(event -> toastEvents("Added File"));
        uploader.addRemovedFileHandler(event -> toastEvents("Removed File"));
        uploader.addErrorHandler(event -> toastEvents("Error"));
        uploader.addTotalUploadProgressHandler(event -> toastEvents("Total Upload Progress"));
        uploader.addCurrentUploadProgressHandler(event -> toastEvents("Current Upload Progress"));
        uploader.addSendingHandler(event -> toastEvents("Sending"));
        uploader.addSuccessHandler(event -> toastEvents("Success"));
        uploader.addCompleteHandler(event -> toastEvents("Complete"));
        uploader.addCanceledHandler(event -> toastEvents("Canceled"));
        uploader.addMaxFilesReachHandler(event -> toastEvents("Max File Reach"));
        uploader.addMaxFilesExceededHandler(event -> toastEvents("Max File Exceeded"));
        uploader.addProcessingHandler(event -> toastEvents("Processing"));
        uploader.addProcessingMultipleHandler(event -> toastEvents("Processing Multiple"));
        uploader.addSendingMultipleHandler(event -> toastEvents("Sending Multiple"));
        uploader.addSuccessMultipleHandler(event -> toastEvents("Success Multiple"));
        uploader.addCompleteMultipleHandler(event -> toastEvents("Complete Multiple"));
        uploader.addCanceledMultipleHandler(event -> toastEvents("Canceled Multiple"));
        uploader.addResetHandler(event -> toastEvents("Reset"));
        uploader.addQueueCompleteHandler(event -> toastEvents("Queue Complete"));
    }

    protected void toastEvents(String name) {
        if (events.getValue()) {
            MaterialToast.fireToast(name + " Event fired");
        }
    }

    @UiHandler("enable")
    void enable(ValueChangeEvent<Boolean> event) {
        uploader.setEnabled(event.getValue());
    }
}
