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
package gmd.addins.demo.client.application.home;

import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gmd.addins.demo.client.widget.Dashboard;
import gmd.addins.demo.client.widget.DashboardCard;
import gwt.material.design.client.ui.MaterialRow;
import gwt.material.design.incubator.client.search.InlineSearch;

import javax.inject.Inject;
import java.util.List;

public class HomeView extends ViewImpl implements HomePresenter.MyView {

    interface Binder extends UiBinder<Widget, HomeView> {
    }

    @UiField
    MaterialRow row;

    @UiField
    InlineSearch search;

    @Inject
    HomeView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    public void setDashboard(List<Dashboard> dashboards) {
        row.clear();

        for (Dashboard dashboard : dashboards) {
            DashboardCard card = new DashboardCard(dashboard);
            row.add(card);
        }
    }

    @UiHandler("search")
    void search(KeyUpEvent event) {
        row.forEach(widget -> {
            if (widget instanceof DashboardCard) {
                DashboardCard card = (DashboardCard) widget;
                card.setVisible(card.getDashboard().getName().toLowerCase().contains(search.getValue().toLowerCase()));
            }
        });
    }
}
