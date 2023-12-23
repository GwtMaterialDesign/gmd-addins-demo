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
            new Dashboard(placeManager, "Banner", "Native", NameTokens.BANNER, Color.BLUE_GREY),
            new Dashboard(placeManager, "Bubble", "Native", NameTokens.BUBBLE, Color.BLUE),
            new Dashboard(placeManager, "Camera", "Native", NameTokens.CAMERA, Color.GREEN),
            new Dashboard(placeManager, "Carousel", ExternalLink.CAROUSEL.getLongName(), NameTokens.CAROUSEL, Color.PURPLE),
            new Dashboard(placeManager, "Circular Progress", ExternalLink.CIRCULAR_PROGRESS.getLongName(), NameTokens.CIRCULAR_PROGRESS, Color.ORANGE),
            new Dashboard(placeManager, "Circular SVG Timer", "Native", NameTokens.CIRCULAR_SVG_TIMER, Color.BLUE_GREY),
            new Dashboard(placeManager, "ComboBox", ExternalLink.COMBOBOX.getLongName(), NameTokens.COMBOBOX, Color.BROWN),
            new Dashboard(placeManager, "Continous Range Slider", "Native", NameTokens.RANGE_SLIDER, Color.BLUE_GREY),
            new Dashboard(placeManager, "CountUp", ExternalLink.COUNT_UP.getLongName(), NameTokens.COUNT_UP, Color.CYAN),
            new Dashboard(placeManager, "CutOut", "Native", NameTokens.CUT_OUT, Color.DEEP_ORANGE),
            new Dashboard(placeManager, "Date of Birth Picker", "Native", NameTokens.DOB_PICKER, Color.RED),
            new Dashboard(placeManager, "Dragula", "Native", NameTokens.DRAGULA, Color.BLUE),
            new Dashboard(placeManager, "DocViewer", "Native", NameTokens.DOC_VIEWER, Color.INDIGO),
            new Dashboard(placeManager,"Drag and Drop", ExternalLink.DRAG_AND_DROP.getLongName(), NameTokens.DRAG_AND_DROP, Color.GREY),
            new Dashboard(placeManager, "Empty States", "Native", NameTokens.EMPTY_STATE, Color.LIGHT_BLUE),
            new Dashboard(placeManager, "FileUploader", ExternalLink.DROPZONE.getLongName(), NameTokens.DROPZONE, Color.CYAN),
            new Dashboard(placeManager, "HeroVideo", "Native", NameTokens.HERO_VIDEO, Color.GREY),
            new Dashboard(placeManager, "Icon Morph", "Native", NameTokens.ICON_MORPH, Color.LIME),
            new Dashboard(placeManager, "Image Cropper", ExternalLink.IMAGE_CROPPER.getLongName(), NameTokens.IMAGE_CROPPER, Color.BLUE),
            new Dashboard(placeManager, "Image Viewer", "Native", NameTokens.IMAGE_VIEWER, Color.BROWN),
            new Dashboard(placeManager, "Infinite Scroll", "Native", NameTokens.INFINITE_SCROLL, Color.BLUE),
            new Dashboard(placeManager, "Input Mask", ExternalLink.INPUTMASK.getLongName(), NameTokens.INPUTMASK, Color.GREY),
            new Dashboard(placeManager, "JsonTable", "Native", NameTokens.JSON_TABLE, Color.PURPLE),
            new Dashboard(placeManager, "Language Selector", "Native", NameTokens.LANGUAGE_SELECTOR, Color.AMBER),
            new Dashboard(placeManager, "Live Stamp", ExternalLink.LIVESTAMP.getLongName(), NameTokens.LIVE_STAMP, Color.BROWN),
            new Dashboard(placeManager, "Loading Dots", "Native", NameTokens.LOADING_DOTS, Color.BROWN),
            new Dashboard(placeManager, "Loading State Panel", "Native", NameTokens.LOADING_STATE, Color.INDIGO),
            new Dashboard(placeManager,"Masonry", ExternalLink.MASONRY.getLongName(), NameTokens.MASONRY, Color.ORANGE),
            new Dashboard(placeManager, "Md5", "Native", NameTokens.MD5, Color.LIME),
            new Dashboard(placeManager, "MenuBar", "Native", NameTokens.MENU_BAR, Color.DEEP_ORANGE),
            new Dashboard(placeManager,"Overlay", "Native", NameTokens.OVERLAY, Color.LIME),
            new Dashboard(placeManager, "Password Strength TextBox", "Native", NameTokens.PASSWORD_STRENGTH_TEXTBOX, Color.ORANGE),
            new Dashboard(placeManager, "Path Animator", ExternalLink.PATH_ANIMATOR.getLongName(), NameTokens.PATH_ANIMATOR, Color.LIGHT_BLUE),
            new Dashboard(placeManager, "Pinch Zoom Panel", "Native", NameTokens.PINCH_ZOOM, Color.LIGHT_BLUE),
            new Dashboard(placeManager, "PopupMenu", "Native", NameTokens.POPUP_MENU, Color.GREY),
            new Dashboard(placeManager, "Rating", "Native", NameTokens.RATING, Color.INDIGO),
            new Dashboard(placeManager, "Rating Question Item", "Native", NameTokens.RATING_QUESTION, Color.LIME),
            new Dashboard(placeManager, "Recaptcha", "Native" , NameTokens.RECAPTCHA, Color.ORANGE),
            new Dashboard(placeManager, "Rich Editor", ExternalLink.RICH_EDITOR.getLongName(), NameTokens.RICH_EDITOR, Color.RED),
            new Dashboard(placeManager, "Scrollfire", "Native", NameTokens.SCROLL_FIRE, Color.INDIGO),
            new Dashboard(placeManager, "SideProfile", "Native", NameTokens.SIDE_PROFILE, Color.LIGHT_BLUE),
            new Dashboard(placeManager, "Signature Pad", ExternalLink.SIGNATURE_PAD.getLongName(), NameTokens.SIGNATURE_PAD, Color.LIGHT_BLUE),
            new Dashboard(placeManager, "Split Panel", ExternalLink.SPLIT_PANEL.getLongName(), NameTokens.SPLIT_PANEL, Color.PINK),
            new Dashboard(placeManager, "Sprout Video", "Native", NameTokens.SPROUT_VIDEO, Color.BROWN),
            new Dashboard(placeManager, "SubHeader", "Native", NameTokens.SUBHEADER, Color.PURPLE),
            new Dashboard(placeManager, "Stepper", "Native", NameTokens.STEPPER, Color.BROWN),
            new Dashboard(placeManager, "Swipeable", "Native", NameTokens.SWIPEABLE, Color.ORANGE),
            new Dashboard(placeManager, "TimeLine View", "Native", NameTokens.TIME_LINE, Color.LIME),
            new Dashboard(placeManager, "Time Picker", ExternalLink.TIME_PICKER.getLongName(), NameTokens.TIME_PICKER, Color.DEEP_ORANGE),
            new Dashboard(placeManager, "Tree View", "Native", NameTokens.TREE, Color.INDIGO),
            new Dashboard(placeManager, "Waterfall View", "Native", NameTokens.WATERFALL, Color.LIME),
            new Dashboard(placeManager, "WebP", "Native", NameTokens.WEBP, Color.LIGHT_BLUE),
            new Dashboard(placeManager, "Window", "Native", NameTokens.WINDOW, Color.RED),
            new Dashboard(placeManager, "Note", "Native", NameTokens.NOTE, Color.GREEN),

            // Beta
            new Dashboard(placeManager, "Address Lookup", "Incubator", NameTokens.ADDRESS_LOOKUP, Color.RED, true),
            new Dashboard(placeManager, "Check Mark", "Incubator", NameTokens.CHECK_MARK, Color.RED, true),
            new Dashboard(placeManager, "Date Range", "Incubator", NameTokens.DATE_RANGE, Color.RED, true),
            new Dashboard(placeManager, "Group Toggle", "Incubator", NameTokens.GROUP_TOGGLE, Color.RED, true),
            new Dashboard(placeManager, "Place Holder", "Incubator", NameTokens.PLACEHOLDER, Color.RED, true),
            new Dashboard(placeManager, "Line Bar", "Incubator", NameTokens.PROGRESS_LINE_BAR, Color.RED, true),
            new Dashboard(placeManager, "Local Storage", "Incubator", NameTokens.LOCAL_STORAGE, Color.RED, true),
            new Dashboard(placeManager, "Kanban", "Incubator", NameTokens.KANBAN, Color.RED, true),
            new Dashboard(placeManager, "Keyboard", "Incubator", NameTokens.SCREEN_KEYBOARD, Color.RED, true),
            new Dashboard(placeManager, "Search", "Incubator", NameTokens.SEARCH, Color.RED, true),
            new Dashboard(placeManager, "Tag", "Incubator", NameTokens.TAG, Color.RED, true),
            new Dashboard(placeManager, "Timer", "Incubator", NameTokens.TIMER, Color.RED, true)
        ));
    }

    @Override
    protected void onReveal() {
        super.onReveal();

        new ScrollHelper().scrollTo(0);
    }
}
