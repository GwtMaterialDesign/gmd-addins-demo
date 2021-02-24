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
package gmd.addins.demo.client.application.iconmorph;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.addins.client.iconmorph.MaterialIconMorph;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.ui.MaterialIcon;

import javax.inject.Inject;

public class IconMorphView extends ViewImpl implements IconMorphPresenter.MyView {

    interface Binder extends UiBinder<Widget, IconMorphView> {
    }

    @UiField
    MaterialIconMorph dynamic;

    @Inject
    IconMorphView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));

        dynamic.setSource(new MaterialIcon(IconType.CHECK_CIRCLE));
        dynamic.setTarget(new MaterialIcon(IconType.CHECK));
    }
}
