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
package gmd.addins.demo.client.application.richeditor;

import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.addins.client.richeditor.MaterialRichEditor;
import gwt.material.design.addins.client.richeditor.base.constants.ToolbarButton;
import gwt.material.design.client.events.PasteEvent;
import gwt.material.design.client.ui.MaterialCheckBox;
import gwt.material.design.client.ui.MaterialToast;

import javax.inject.Inject;

public class RichEditorView extends ViewImpl implements RichEditorPresenter.MyView {

    interface Binder extends UiBinder<Widget, RichEditorView> {
    }

    @UiField
    MaterialRichEditor richEditor;

    @UiField
    MaterialCheckBox toastEvents;

    @Inject
    RichEditorView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    protected void onAttach() {
        super.onAttach();

        richEditor.setValue(getRichEditorHTML());
    }

    @UiHandler("airmode")
    void airmode(ValueChangeEvent<Boolean> event) {
        richEditor.setAirMode(event.getValue());
        richEditor.reload();
    }

    @UiHandler("toggleHeight")
    void toggleHeight(ValueChangeEvent<Boolean> event) {
        richEditor.setHeight(event.getValue() ? "200px" : "600px");
        richEditor.reload();
    }

    @UiHandler("setValue")
    void setValue(ValueChangeEvent<Boolean> event) {
        richEditor.setValue(event.getValue() ? getRichEditorHTML() : null);
    }

    @UiHandler("controlOptions")
    void controlOptions(ValueChangeEvent<Boolean> event) {
        if (event.getValue()) {
            richEditor.setStyleOptions(ToolbarButton.STYLE, ToolbarButton.BOLD, ToolbarButton.ITALIC);
            richEditor.setParaOptions(ToolbarButton.LEFT, ToolbarButton.RIGHT, ToolbarButton.JUSTIFY);
            richEditor.setMiscOptions(ToolbarButton.CODE_VIEW, ToolbarButton.FULLSCREEN);
            richEditor.setUndoOptions();
        } else {
            ToolbarButton[] styleOptions = new ToolbarButton[]
                {ToolbarButton.STYLE, ToolbarButton.BOLD, ToolbarButton.ITALIC, ToolbarButton.UNDERLINE, ToolbarButton.STRIKETHROUGH, ToolbarButton.CLEAR, ToolbarButton.SUPERSCRIPT, ToolbarButton.SUBSCRIPT};
            richEditor.setStyleOptions(styleOptions);

            ToolbarButton[] fontOptions = new ToolbarButton[]
                {ToolbarButton.FONT_SIZE, ToolbarButton.FONT_NAME};
            richEditor.setFontOptions(fontOptions);

            ToolbarButton[] colorOptions = new ToolbarButton[]
                {ToolbarButton.COLOR};
            richEditor.setColorOptions(colorOptions);

            ToolbarButton[] undoOptions = new ToolbarButton[]
                {ToolbarButton.UNDO, ToolbarButton.REDO, ToolbarButton.HELP};
            richEditor.setUndoOptions(undoOptions);

            ToolbarButton[] ckMediaOptions = new ToolbarButton[]
                {ToolbarButton.CK_IMAGE_UPLOAD, ToolbarButton.CK_IMAGE_VIDEO};
            richEditor.setCkMediaOptions(ckMediaOptions);

            ToolbarButton[] miscOptions = new ToolbarButton[]
                {ToolbarButton.LINK, ToolbarButton.PICTURE, ToolbarButton.TABLE, ToolbarButton.HR, ToolbarButton.CODE_VIEW, ToolbarButton.FULLSCREEN};
            richEditor.setMiscOptions(miscOptions);

            ToolbarButton[] paraOptions = new ToolbarButton[]
                {ToolbarButton.UL, ToolbarButton.OL, ToolbarButton.PARAGRAPH, ToolbarButton.LEFT, ToolbarButton.CENTER, ToolbarButton.RIGHT, ToolbarButton.JUSTIFY, ToolbarButton.OUTDENT, ToolbarButton.INDENT};
            richEditor.setParaOptions(paraOptions);

            ToolbarButton[] heightOptions = new ToolbarButton[]
                {ToolbarButton.LINE_HEIGHT};
            richEditor.setHeightOptions(heightOptions);
        }

        richEditor.reload();
    }

    public static String getRichEditorHTML() {
        String html = "<h2 style=\"text-align: center; \"> <span style=\"color: rgb(101, 31, 255);\"> I Love Material Design </span> </h2> <p style=\"text-align: center;\"> <span style=\"font-size: 17px;\"> Using </span> <span style=\"font-weight: bold; font-size: 17px; text-decoration: underline;\"> Airmode </span> <span style=\"font-size: 17px;\"> you can directly modify this html. </span> </p> <p style=\"text-align: center;\"> <br> </p> <table class=\"hoverable bordered striped responsive-table\"> <thead> <tr> <th> State </th> <th> Capital </th> <th> Currency </th> </tr> </thead> <tbody> <tr> <td> Philippines </td> <td> Manila </td> <td> Peso </td> </tr> <tr> <td> Japan </td> <td> Tokyo </td> <td> Yen </td> </tr> </tbody> </table> <p> </p>";
        return html;
    }

    @UiHandler("richEditor")
    void onValueChange(ValueChangeEvent<String> e) {
        if (toastEvents.getValue()) {
            MaterialToast.fireToast("Value Change Event Fired : " + richEditor.getHTML());
        }
    }

    @UiHandler("richEditor")
    void onFocus(FocusEvent e) {
        if (toastEvents.getValue()) {
            MaterialToast.fireToast("Focus Event Fired : " + richEditor.getHTML());
        }
    }

    @UiHandler("richEditor")
    void onBlur(BlurEvent event) {
        if (toastEvents.getValue()) {
            MaterialToast.fireToast("Blur Event Fired : " + richEditor.getHTML());
        }
    }

    @UiHandler("richEditor")
    void onKeyUp(KeyUpEvent e) {
        if (toastEvents.getValue()) {
            MaterialToast.fireToast("Key Up Fired : " + richEditor.getHTML());
        }
    }

    @UiHandler("richEditor")
    void onKeyDown(KeyDownEvent e) {
        if (toastEvents.getValue()) {
            MaterialToast.fireToast("Key Down Fired : " + richEditor.getHTML());
        }
    }

    @UiHandler("richEditor")
    void onPaste(PasteEvent e) {
        if (toastEvents.getValue()) {
            MaterialToast.fireToast("Paste Fired : " + richEditor.getHTML());
        }
    }
}
