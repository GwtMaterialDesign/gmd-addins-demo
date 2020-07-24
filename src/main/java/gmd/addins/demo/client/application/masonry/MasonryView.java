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
package gmd.addins.demo.client.application.masonry;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.addins.client.masonry.MaterialMasonry;
import gwt.material.design.client.ui.MaterialToast;

import javax.inject.Inject;

public class MasonryView extends ViewImpl implements MasonryPresenter.MyView {

    interface Binder extends UiBinder<Widget, MasonryView> {
    }

    @UiField
    MaterialMasonry masonry;

    @Inject
    MasonryView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));

        masonry.addLayoutCompleteHandler(event -> MaterialToast.fireToast("Layout Complete event fired"));
        masonry.addRemoveCompleteHandler(event -> MaterialToast.fireToast("Remove Complete event fired"));
    }

    @Override
    protected void onAttach() {
        super.onAttach();
    }
}
