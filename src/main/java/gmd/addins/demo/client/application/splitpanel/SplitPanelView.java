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
package gmd.addins.demo.client.application.splitpanel;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.addins.client.livestamp.MaterialLiveStamp;
import gwt.material.design.addins.client.splitpanel.MaterialSplitPanel;
import gwt.material.design.client.constants.Axis;
import gwt.material.design.client.constants.Color;

import javax.inject.Inject;
import java.util.Date;

public class SplitPanelView extends ViewImpl implements SplitPanelPresenter.MyView {

    interface Binder extends UiBinder<Widget, SplitPanelView> {
    }

    @UiField
    MaterialSplitPanel splitPanel;

    @Inject
    SplitPanelView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @UiHandler("thickness")
    void thickness(ValueChangeEvent<Boolean> event) {
        splitPanel.setThickness(event.getValue() ? 20 : 8);
        splitPanel.reload();
    }

    @UiHandler("vertical")
    void vertical(ValueChangeEvent<Boolean> event) {
        splitPanel.setAxis(event.getValue() ? Axis.VERTICAL : Axis.HORIZONTAL);
        splitPanel.reload();
    }

    @UiHandler("position")
    void position(ValueChangeEvent<Boolean> event) {
        splitPanel.setBarPosition(event.getValue() ? 10.0 : 50.0);
        splitPanel.reload();
    }

    @UiHandler("style")
    void style(ValueChangeEvent<Boolean> event) {
        splitPanel.setSplitterLineColor(event.getValue() ? Color.RED : Color.BLACK);
        splitPanel.reload();
    }
}
