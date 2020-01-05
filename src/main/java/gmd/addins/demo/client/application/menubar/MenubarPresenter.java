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
package gmd.addins.demo.client.application.menubar;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import gmd.addins.demo.client.application.ApplicationPresenter;
import gmd.addins.demo.client.application.BasePresenter;
import gmd.addins.demo.client.events.DarkThemeChangeEvent;
import gmd.addins.demo.client.place.NameTokens;
import gwt.material.design.client.ui.MaterialToast;

public class MenubarPresenter extends BasePresenter<MenubarPresenter.MyView, MenubarPresenter.MyProxy>
    implements DarkThemeChangeEvent.DarkThemeChangeHandler {

    interface MyView extends View {

    }

    @ProxyStandard
    @NameToken(NameTokens.MENU_BAR)
    interface MyProxy extends ProxyPlace<MenubarPresenter> {
    }

    @Inject
    MenubarPresenter(
        EventBus eventBus,
        MyView view,
        MyProxy proxy) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_MAIN);
        addRegisteredHandler(DarkThemeChangeEvent.TYPE, this);
    }

    @Override
    protected void onBind() {
        super.onBind();

        setHeaderTitle("Menu Bar", "Menu bar is a component that bring a good UI UX navigation for Desktop or tablet interface. This component provides a multi dropdown heirarchy best suit for larger applications.", "");
    }

    @Override
    public void onContentPush(DarkThemeChangeEvent event) {
        MaterialToast.fireToast(event.isDark() + "");
    }
}
