package gmd.addins.demo.client.widget;

/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2016 GwtMaterialDesign
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


import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import gwt.material.design.client.constants.Display;
import gwt.material.design.client.ui.MaterialColumn;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialLink;
import gwt.material.design.client.ui.MaterialPanel;

public class HeaderTitle extends Composite {

    private static DashboardCardUiBinder uiBinder = GWT.create(DashboardCardUiBinder.class);

    @UiField
    MaterialLabel title, description;

    @UiField
    MaterialLink sourceCode, library, youtube;

    interface DashboardCardUiBinder extends UiBinder<MaterialPanel, HeaderTitle> {
    }

    public HeaderTitle() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    protected void onAttach() {
        super.onAttach();

        if (library != null && library.getText() != null && !library.getText().isEmpty()) {
            library.setVisible(false);
        }
    }

    public void setDetails(String title, String description, String link) {
        this.title.setText(title);
        this.description.setText(description);
        this.sourceCode.setHref(link);
    }

    public void setSource(String link) {
        this.sourceCode.setHref(link);
        this.sourceCode.setTarget("_blank");
    }

    public void setExternalLibrary(String library, String link) {
        this.library.setText(library);
        this.library.setTarget("_blank");
        this.library.setHref(link);
    }

    public void hideYoutubeVideo() {
        youtube.setVisible(false);
    }

    public void setYoutubeVideoKey(String key) {
        this.youtube.setDisplay(Display.INLINE_BLOCK);
        this.youtube.setHref("https://www.youtube.com/watch?v=" + key);
    }

    @Override
    protected MaterialColumn getWidget() {
        return (MaterialColumn) super.getWidget();
    }
}
