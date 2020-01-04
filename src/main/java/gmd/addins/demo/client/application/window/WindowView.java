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
package gmd.addins.demo.client.application.window;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.addins.client.window.MaterialWindow;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.theme.dark.DarkThemeManager;
import gwt.material.design.client.ui.MaterialCheckBox;
import gwt.material.design.client.ui.MaterialRow;
import gwt.material.design.client.ui.MaterialTab;

import javax.inject.Inject;

public class WindowView extends ViewImpl implements WindowPresenter.MyView {

    interface Binder extends UiBinder<Widget, WindowView> {
    }

    @UiField
    MaterialWindow window, windowTab;

    @UiField
    MaterialCheckBox maximize, overlay, toolbarColor, backgroundColor;

    @UiField
    MaterialRow headerPanel, tabsPanel;

    @UiField
    MaterialTab tabs;

    @Inject
    WindowView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @UiHandler("btnOpenWindow")
    void onOpenWindow(ClickEvent e) {
        window.setToolbarColor(toolbarColor.getValue() ? Color.GREEN_DARKEN_1 : null);
        window.setBackgroundColor(backgroundColor.getValue() ? Color.GREEN_LIGHTEN_5 : null);
        window.setTextColor(backgroundColor.getValue() ? Color.BLACK : null);
        window.setMaximize(maximize.getValue());
        MaterialWindow.setOverlay(overlay.getValue());
        window.open();
    }

    @UiHandler("btnWindowTab")
    void onOpenWindowWithTab(ClickEvent e) {
        boolean dark = DarkThemeManager.get().isDarkMode();
        windowTab.setToolbarColor(dark ? Color.BLACK : Color.BLUE);
        windowTab.setBackgroundColor(dark ? Color.GREY_DARKEN_3 : Color.WHITE);
        headerPanel.setBackgroundColor(dark ? Color.GREY_DARKEN_4 : Color.BLUE);
        tabsPanel.setBackgroundColor(dark ? Color.GREY_DARKEN_4 : Color.BLUE);
        tabs.setBackgroundColor(dark ? Color.GREY_DARKEN_4 : Color.BLUE);
        windowTab.open();
    }
}
