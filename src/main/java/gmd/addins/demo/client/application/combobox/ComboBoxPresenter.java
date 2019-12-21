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
package gmd.addins.demo.client.application.combobox;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import gmd.addins.demo.client.application.ApplicationPresenter;
import gmd.addins.demo.client.application.BasePresenter;
import gmd.addins.demo.client.generator.DataGenerator;
import gmd.addins.demo.client.generator.product.Product;
import gmd.addins.demo.client.generator.product.ProductGenerator;
import gmd.addins.demo.client.place.ExternalLink;
import gmd.addins.demo.client.place.NameTokens;

import java.util.List;

public class ComboBoxPresenter extends BasePresenter<ComboBoxPresenter.MyView, ComboBoxPresenter.MyProxy> {

    interface MyView extends View {
        void setProducts(List<Product> products);
    }

    @ProxyStandard
    @NameToken(NameTokens.COMBOBOX)
    interface MyProxy extends ProxyPlace<ComboBoxPresenter> {
    }

    @Inject
    ComboBoxPresenter(
            EventBus eventBus,
            MyView view,
            MyProxy proxy) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_MAIN);
    }

    @Override
    protected void onBind() {
        super.onBind();

        setHeaderTitle("ComboBox", "Material ComboBox gives you a customizable select box with support for searching, tagging, remote data sets, infinite scrolling, and many other highly used options.", "");
        setExternalLibrary(ExternalLink.COMBOBOX);
        getView().setProducts(new DataGenerator().generateProducts(30));
    }

    @Override
    protected void onReveal() {
        super.onReveal();

    }
}
