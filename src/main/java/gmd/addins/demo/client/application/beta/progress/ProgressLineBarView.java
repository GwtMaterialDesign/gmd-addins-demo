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
package gmd.addins.demo.client.application.beta.progress;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.incubator.client.progress.ProgressLineBar;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class ProgressLineBarView extends ViewImpl implements ProgressLineBarPresenter.MyView {

    interface Binder extends UiBinder<Widget, ProgressLineBarView> {
    }

    @UiField
    ProgressLineBar<Integer> progressLineBar;

    @Inject
    ProgressLineBarView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));

        for (int i = 0; i <= 10; i++) {
            progressLineBar.addOption(i);
        }

        List<Integer> values = new ArrayList<>();
        for (int i = 0; i <= 5; i++) {
            values.add(i);
        }

        progressLineBar.setValues(values);
    }
}
