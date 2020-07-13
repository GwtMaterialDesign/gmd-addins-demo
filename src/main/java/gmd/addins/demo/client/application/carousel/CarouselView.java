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
package gmd.addins.demo.client.application.carousel;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.addins.client.carousel.MaterialCarousel;
import gwt.material.design.client.ui.MaterialCheckBox;
import gwt.material.design.client.ui.MaterialToast;

import javax.inject.Inject;

public class CarouselView extends ViewImpl implements CarouselPresenter.MyView {

    interface Binder extends UiBinder<Widget, CarouselView> {
    }

    @UiField
    MaterialCarousel carousel, imageCarousel;

    @UiField
    MaterialCheckBox toastEvents;

    @UiField
    MaterialCheckBox infinite;

    @Inject
    CarouselView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    protected void onAttach() {
        super.onAttach();

        carousel.addAfterChangeHandler(event -> {
            if (toastEvents.getValue()) {
                MaterialToast.fireToast("AfterChangeEvent Fired : " + event.getCurrentSlide());
            }
        });

        carousel.addBeforeChangeHandler(event -> {
            if (toastEvents.getValue()) {
                MaterialToast.fireToast("BeforeChangeEvent Fired : " + event.getCurrentSlide());
            }
        });

        carousel.addInitHandler(event -> {
            if (toastEvents.getValue()) {
                MaterialToast.fireToast("InitEvent Fired");
            }
        });

        carousel.addDestroyHandler(event -> {
            if (toastEvents.getValue()) {
                MaterialToast.fireToast("Destroy Fired");
            }
        });

        carousel.addSwipeHandler(event -> {
            if (toastEvents.getValue()) {
                MaterialToast.fireToast("SwipeEvent Fired : " + event.getDirection());
            }
        });
    }

    @UiHandler("infinite")
    void infinite(ValueChangeEvent<Boolean> event) {
        carousel.setInfinite(true);
        carousel.reload();
    }

    @UiHandler("multiple")
    void multiple(ValueChangeEvent<Boolean> event) {
        carousel.setSlidesToShow(event.getValue() ? 3 : 1);
        carousel.setSlidesToScroll(event.getValue() ? 3 : 1);
        carousel.reload();
    }

    @UiHandler("autoplay")
    void autoplay(ValueChangeEvent<Boolean> event) {
        carousel.setAutoplay(event.getValue());
        carousel.setAutoplaySpeed(800);
        carousel.reload();
    }

    @UiHandler("hideDots")
    void hideDots(ValueChangeEvent<Boolean> event) {
        carousel.setShowDots(!event.getValue());
        carousel.reload();
    }

    @UiHandler("hideArrows")
    void hideArrows(ValueChangeEvent<Boolean> event) {
        carousel.setShowArrows(!event.getValue());
        carousel.reload();
    }

    @UiHandler("fade")
    void fade(ValueChangeEvent<Boolean> event) {
        imageCarousel.setFade(event.getValue());
        imageCarousel.reload();
    }

    @UiHandler("currentIndex")
    void currentIndex(ClickEvent event) {
        MaterialToast.fireToast(imageCarousel.getCurrentSlideIndex() + "");
    }

    @UiHandler("next")
    void next(ClickEvent event) {
        imageCarousel.next();
    }

    @UiHandler("previous")
    void previous(ClickEvent event) {
        imageCarousel.previous();
    }

    @UiHandler("secondSlide")
    void secondSlide(ClickEvent event) {
        imageCarousel.goToSlide(1);
    }

    @UiHandler("pause")
    void pause(ClickEvent event) {
        imageCarousel.pause();
    }

    @UiHandler("play")
    void play(ClickEvent event) {
        imageCarousel.play();
    }
}
