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

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import gmd.addins.demo.client.application.ApplicationPresenter;
import gmd.addins.demo.client.application.BasePresenter;
import gmd.addins.demo.client.place.NameTokens;

public class DropzonePresenter extends BasePresenter<DropzonePresenter.MyView, DropzonePresenter.MyProxy> {

    interface MyView extends View {

    }

    @ProxyStandard
    @NameToken(NameTokens.DROPZONE)
    interface MyProxy extends ProxyPlace<DropzonePresenter> {
    }

    @Inject
    DropzonePresenter(
            EventBus eventBus,
            MyView view,
            MyProxy proxy) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_MAIN);
    }

    @Override
    protected void onBind() {
        super.onBind();

        setHeaderTitle("File Uploader", "Custom file uploader with Dnd support with the help of dropzone.js. It has multiple feature just like the GWT File Uploader core widget.", "");
    }
}
