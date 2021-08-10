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
package gmd.addins.demo.client.application.banner;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.addins.client.banner.MaterialBanner;
import gwt.material.design.addins.client.banner.MaterialBannerActions;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialColumn;
import gwt.material.design.client.ui.MaterialPanel;
import gwt.material.design.client.ui.MaterialToast;

import javax.inject.Inject;

public class BannerView extends ViewImpl implements BannerPresenter.MyView {

    interface Binder extends UiBinder<Widget, BannerView> {
    }

    @UiField
    MaterialBanner banner;

    @UiField
    MaterialBannerActions actions;

    @UiField
    MaterialColumn target;

    private MaterialButton button = new MaterialButton("Another Action");

    @Inject
    BannerView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));

        banner.setTargetContainer(target);
    }

    @UiHandler("open")
    void open(ClickEvent event) {
        banner.open();
    }

    @UiHandler("action1")
    void action1(ClickEvent event) {
        banner.close();
    }

    @UiHandler("withIcon")
    void withIcon(ValueChangeEvent<Boolean> event) {
        banner.setIconType(event.getValue() ? IconType.SIGNAL_WIFI_OFF : null);
    }

    @UiHandler("singleLine")
    void singleLine(ValueChangeEvent<Boolean> event) {
        banner.setMessage(event.getValue() ? "Lorem ipsum dolor sit amet, consectetur adipiscing elit" :
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam.");
    }

    @UiHandler("multiActions")
    void multiActions(ValueChangeEvent<Boolean> event) {
        if (event.getValue()) {
            actions.insert(button, 0);
        } else {
            button.removeFromParent();
        }
    }
}
