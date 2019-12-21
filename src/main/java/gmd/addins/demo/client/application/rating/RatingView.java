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
package gmd.addins.demo.client.application.rating;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.addins.client.rating.MaterialRating;
import gwt.material.design.addins.client.timepicker.MaterialTimePicker;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.ui.MaterialToast;

import javax.inject.Inject;

public class RatingView extends ViewImpl implements RatingPresenter.MyView {

    interface Binder extends UiBinder<Widget, RatingView> {
    }

    @UiField
    MaterialRating rating;

    @Inject
    RatingView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @UiHandler("icon")
    void icon(ValueChangeEvent<Boolean> e) {
        rating.setUnselectedRatingIcon(!e.getValue() ? IconType.STAR_BORDER : IconType.FAVORITE_BORDER);
        rating.setSelectedRatingIcon(!e.getValue() ? IconType.STAR : IconType.FAVORITE);
    }

    @UiHandler("editable")
    void editable(ValueChangeEvent<Boolean> e) {
        rating.setEditable(e.getValue());
    }

    @UiHandler("maxRating")
    void maxRating(ValueChangeEvent<Boolean> e) {
        rating.setMaxRating(e.getValue() ? 10 : 5);
    }

    @UiHandler("setValue")
    void setValue(ClickEvent event) {
        rating.setValue(3);
    }

    @UiHandler("setValueWithEvent")
    void setValueWithEvent(ClickEvent e) {
        rating.setValue(1, true);
    }

    @UiHandler("rating")
    void rating(ValueChangeEvent<Integer> event) {
        MaterialToast.fireToast( "Value Change Fired : " + event.getValue());
    }
}
