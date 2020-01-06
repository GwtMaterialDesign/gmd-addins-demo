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

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import gmd.addins.demo.client.application.ApplicationPresenter;
import gmd.addins.demo.client.place.ExternalLink;
import gmd.addins.demo.client.place.NameTokens;
import gmd.addins.demo.client.widget.Dashboard;
import gwt.material.design.client.base.helper.ScrollHelper;
import gwt.material.design.client.constants.Color;

import java.util.Arrays;
import java.util.List;

public class HomePresenter extends Presenter<HomePresenter.MyView, HomePresenter.MyProxy> {
    interface MyView extends View {
        void setDashboard(List<Dashboard> dashboards);
    }

    private PlaceManager placeManager;

    @ProxyStandard
    @NameToken(NameTokens.HOME)
    interface MyProxy extends ProxyPlace<HomePresenter> {
    }

    @Inject
    HomePresenter(
        EventBus eventBus,
        MyView view,
        MyProxy proxy,
        PlaceManager placeManager) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_MAIN);

        this.placeManager = placeManager;
    }

    @Override
    protected void onBind() {
        super.onBind();


        getView().setDashboard(Arrays.asList(
            new Dashboard(placeManager, "Autocomplete", "Native", NameTokens.AUTOCOMPLETE, Color.RED),
            new Dashboard(placeManager, "Avatar", ExternalLink.AVATAR.getLongName(), NameTokens.AVATAR, Color.AMBER),
            new Dashboard(placeManager, "Bubble", "Native", NameTokens.BUBBLE, Color.BLUE),
            new Dashboard(placeManager, "Camera", "Native", NameTokens.CAMERA, Color.GREEN),
            new Dashboard(placeManager, "Carousel", ExternalLink.CAROUSEL.getLongName(), NameTokens.CAROUSEL, Color.PURPLE),
            new Dashboard(placeManager, "Circular Progress", ExternalLink.CIRCULAR_PROGRESS.getLongName(), NameTokens.CIRCULAR_PROGRESS, Color.ORANGE),
            new Dashboard(placeManager, "ComboBox", ExternalLink.COMBOBOX.getLongName(), NameTokens.COMBOBOX, Color.BROWN),
            new Dashboard(placeManager, "CountUp", ExternalLink.COUNT_UP.getLongName(), NameTokens.COUNT_UP, Color.CYAN),
            new Dashboard(placeManager, "CutOut", "Native", NameTokens.CUT_OUT, Color.DEEP_ORANGE),
            new Dashboard(placeManager, "DocViewer", "Native", NameTokens.DOC_VIEWER, Color.INDIGO),
            new Dashboard(placeManager,"Drag and Drop", ExternalLink.DRAG_AND_DROP.getLongName(), NameTokens.DRAG_AND_DROP, Color.GREY),
            new Dashboard(placeManager, "Empty States", "Native", NameTokens.EMPTY_STATE, Color.LIGHT_BLUE),
            new Dashboard(placeManager, "FileUploader", ExternalLink.DROPZONE.getLongName(), NameTokens.DROPZONE, Color.CYAN),
            new Dashboard(placeManager, "Icon Morph", "Native", NameTokens.ICON_MORPH, Color.LIME),
            new Dashboard(placeManager, "Image Cropper", ExternalLink.IMAGE_CROPPER.getLongName(), NameTokens.IMAGE_CROPPER, Color.BLUE),
            new Dashboard(placeManager, "Input Mask", ExternalLink.INPUTMASK.getLongName(), NameTokens.INPUTMASK, Color.GREY),
            new Dashboard(placeManager, "Live Stamp", ExternalLink.LIVESTAMP.getLongName(), NameTokens.LIVE_STAMP, Color.BROWN),
            //new Dashboard(placeManager,"Masonry", "Native", NameTokens.DROPZONE, Color.ORANGE),
            new Dashboard(placeManager, "MenuBar", "Native", NameTokens.MENU_BAR, Color.DEEP_ORANGE),
            new Dashboard(placeManager,"Overlay", "Native", NameTokens.OVERLAY, Color.LIME),
            new Dashboard(placeManager, "Path Animator", ExternalLink.PATH_ANIMATOR.getLongName(), NameTokens.PATH_ANIMATOR, Color.LIGHT_BLUE),
            new Dashboard(placeManager, "Rating", "Native", NameTokens.RATING, Color.INDIGO),
            new Dashboard(placeManager, "Rich Editor", ExternalLink.RICH_EDITOR.getLongName(), NameTokens.RICH_EDITOR, Color.RED),
            new Dashboard(placeManager, "Signature Pad", ExternalLink.SIGNATURE_PAD.getLongName(), NameTokens.SIGNATURE_PAD, Color.LIGHT_BLUE),
            new Dashboard(placeManager, "Split Panel", ExternalLink.SPLIT_PANEL.getLongName(), NameTokens.SPLIT_PANEL, Color.PINK),
            new Dashboard(placeManager, "SubHeader", "Native", NameTokens.SUBHEADER, Color.PURPLE),
            new Dashboard(placeManager, "Stepper", "Native", NameTokens.STEPPER, Color.BROWN),
            new Dashboard(placeManager, "Swipeable", "Native", NameTokens.SWIPEABLE, Color.ORANGE),
            new Dashboard(placeManager, "Time Picker", ExternalLink.TIME_PICKER.getLongName(), NameTokens.TIME_PICKER, Color.DEEP_ORANGE),
            new Dashboard(placeManager, "Tree View", "Native", NameTokens.TREE, Color.INDIGO),
            new Dashboard(placeManager, "WebP", "Native", NameTokens.WEBP, Color.LIGHT_BLUE),
            new Dashboard(placeManager, "Window", "Native", NameTokens.WINDOW, Color.RED)
        ));
    }

    @Override
    protected void onReveal() {
        super.onReveal();

        new ScrollHelper().scrollTo(0);
    }
}
