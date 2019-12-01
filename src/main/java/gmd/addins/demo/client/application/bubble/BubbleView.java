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
package gmd.addins.demo.client.application.bubble;

import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.addins.client.bubble.MaterialBubble;
import gwt.material.design.client.constants.Position;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialListValueBox;
import gwt.material.design.client.ui.MaterialTextArea;

import javax.inject.Inject;

public class BubbleView extends ViewImpl implements BubblePresenter.MyView {

    interface Binder extends UiBinder<Widget, BubbleView> {
    }

    @UiField
    MaterialBubble bubble;

    @UiField
    MaterialLabel bubbleLabel;

    @UiField
    MaterialTextArea content;

    @UiField
    MaterialListValueBox<Position> arrowPosition;

    @Inject
    BubbleView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));

        content.setText(bubbleLabel.getText());

        arrowPosition.addItem(Position.LEFT, "Left");
        arrowPosition.addItem(Position.RIGHT, "Right");
        arrowPosition.addItem(Position.TOP, "Top");
        arrowPosition.addItem(Position.BOTTOM, "Bottom");
        arrowPosition.addValueChangeHandler(event -> bubble.setPosition(event.getValue()));
    }


    @UiHandler("content")
    void content(KeyUpEvent event) {
        bubbleLabel.setText(content.getText());
    }
}
