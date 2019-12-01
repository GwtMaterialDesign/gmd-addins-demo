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
package gmd.addins.demo.client.application.avatar;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.addins.client.avatar.MaterialAvatar;
import gwt.material.design.addins.client.avatar.js.AvatarLightnessOptions;
import gwt.material.design.addins.client.avatar.js.AvatarOptions;
import gwt.material.design.addins.client.avatar.js.AvatarSaturationOptions;
import gwt.material.design.client.ui.MaterialCheckBox;
import gwt.material.design.client.ui.MaterialListValueBox;
import gwt.material.design.client.ui.MaterialTextBox;

import javax.inject.Inject;

public class AvatarView extends ViewImpl implements AvatarPresenter.MyView {

    interface Binder extends UiBinder<Widget, AvatarView> {
    }

    @UiField
    MaterialAvatar avatar;

    @UiField
    MaterialTextBox name;

    @UiField
    MaterialCheckBox autoReload;

    @UiField
    MaterialListValueBox<AvatarDimension> dimensions;

    @Inject
    AvatarView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));

        dimensions.addItem(new AvatarDimension(100, 100), "50 x 50 px");
        dimensions.addItem(new AvatarDimension(200, 200), "100 x 100 px");
        dimensions.addItem(new AvatarDimension(300, 300), "150 x 150 px");
        dimensions.addItem(new AvatarDimension(400, 400), "200 x 200 px");

        dimensions.addValueChangeHandler(valueChangeEvent -> {
            AvatarDimension dimension = valueChangeEvent.getValue();
            avatar.setDimension(dimension.getWidth(), dimension.getHeight());
        });
    }

    @UiHandler("name")
    void name(KeyUpEvent event) {
        avatar.setValue(name.getValue(), false, autoReload.getValue());
    }

    @UiHandler("reload")
    void onReload(ClickEvent e) {
        avatar.reload();
    }

    @UiHandler("enabledOptions")
    void enabledOptions(ValueChangeEvent<Boolean> e) {
        if (e.getValue()) {
            AvatarOptions options = new AvatarOptions();

            options.setHues(new Double[]{128.0});
            options.setBackColor("#fff");
            options.setPadding(0.08);

            AvatarLightnessOptions lightnessOptions = new AvatarLightnessOptions();
            lightnessOptions.setColor(new Double[]{0.4, 0.8});
            options.setLightness(lightnessOptions);

            AvatarSaturationOptions saturationOptions = new AvatarSaturationOptions();
            saturationOptions.setColor(0.5);
            saturationOptions.setGrayscale(0.0);
            options.setSaturation(saturationOptions);
            avatar.setOptions(options);
        } else {
            avatar.setOptions(new AvatarOptions());
        }
        avatar.reload();
    }

    public static class AvatarDimension {
        private int width;
        private int height;

        public AvatarDimension(int width, int height) {
            this.width = width;
            this.height = height;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getWidth() {
            return width;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public int getHeight() {
            return height;
        }
    }
}
