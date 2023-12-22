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
package gmd.addins.demo.client.application;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import gmd.addins.demo.client.application.autocomplete.AutocompleteModule;
import gmd.addins.demo.client.application.avatar.AvatarModule;
import gmd.addins.demo.client.application.banner.BannerModule;
import gmd.addins.demo.client.application.beta.address.AddressLookupModule;
import gmd.addins.demo.client.application.beta.checkmark.CheckMarkModule;
import gmd.addins.demo.client.application.beta.daterange.DateRangeModule;
import gmd.addins.demo.client.application.beta.kanban.KanbanModule;
import gmd.addins.demo.client.application.beta.keyboard.ScreenKeyboardModule;
import gmd.addins.demo.client.application.beta.placeholder.PlaceholderModule;
import gmd.addins.demo.client.application.beta.progress.ProgressLineBarModule;
import gmd.addins.demo.client.application.beta.search.SearchModule;
import gmd.addins.demo.client.application.beta.storage.LocalStorageModule;
import gmd.addins.demo.client.application.beta.tag.TagModule;
import gmd.addins.demo.client.application.beta.timer.TimerModule;
import gmd.addins.demo.client.application.beta.toggle.GroupToggleModule;
import gmd.addins.demo.client.application.bubble.BubbleModule;
import gmd.addins.demo.client.application.camera.CameraModule;
import gmd.addins.demo.client.application.carousel.CarouselModule;
import gmd.addins.demo.client.application.circularprogress.CircularProgressModule;
import gmd.addins.demo.client.application.combobox.ComboBoxModule;
import gmd.addins.demo.client.application.countup.CountUpModule;
import gmd.addins.demo.client.application.cutout.CutoutModule;
import gmd.addins.demo.client.application.dnd.DndModule;
import gmd.addins.demo.client.application.dob.DateOfBirthPickerModule;
import gmd.addins.demo.client.application.docviewer.DocViewerModule;
import gmd.addins.demo.client.application.dragula.DragulaModule;
import gmd.addins.demo.client.application.dropzone.DropzoneModule;
import gmd.addins.demo.client.application.emptystate.EmptyStateModule;
import gmd.addins.demo.client.application.google.recaptcha.RecaptchaModule;
import gmd.addins.demo.client.application.hero.HeroVideoModule;
import gmd.addins.demo.client.application.home.HomeModule;
import gmd.addins.demo.client.application.iconmorph.IconMorphModule;
import gmd.addins.demo.client.application.imagecropper.ImageCropperModule;
import gmd.addins.demo.client.application.infinitescroll.InfiniteScrollPanelModule;
import gmd.addins.demo.client.application.inputmask.InputMaskModule;
import gmd.addins.demo.client.application.jsontable.JsonTableModule;
import gmd.addins.demo.client.application.language.LanguageSelectorModule;
import gmd.addins.demo.client.application.livestamp.LiveStampModule;
import gmd.addins.demo.client.application.loadingdot.LoadingDotsModule;
import gmd.addins.demo.client.application.loadingstate.LoadingStatePanelModule;
import gmd.addins.demo.client.application.masonry.MasonryModule;
import gmd.addins.demo.client.application.md5.Md5Module;
import gmd.addins.demo.client.application.menubar.MenubarModule;
import gmd.addins.demo.client.application.note.NoteModule;
import gmd.addins.demo.client.application.overlay.OverlayModule;
import gmd.addins.demo.client.application.password.PasswordStrengthTextBoxModule;
import gmd.addins.demo.client.application.pathanimator.PathAnimatorModule;
import gmd.addins.demo.client.application.pinch.PinchZoomPanelModule;
import gmd.addins.demo.client.application.popupmenu.PopupMenuModule;
import gmd.addins.demo.client.application.question.RatingQuestionModule;
import gmd.addins.demo.client.application.range.ContinousRangeSliderModule;
import gmd.addins.demo.client.application.rating.RatingModule;
import gmd.addins.demo.client.application.richeditor.RichEditorModule;
import gmd.addins.demo.client.application.scrollfire.ScrollfireModule;
import gmd.addins.demo.client.application.sideprofile.SideProfileModule;
import gmd.addins.demo.client.application.signaturepad.SignaturePadModule;
import gmd.addins.demo.client.application.splitpanel.SplitPanelModule;
import gmd.addins.demo.client.application.sprout.SproutVideoModule;
import gmd.addins.demo.client.application.stepper.StepperModule;
import gmd.addins.demo.client.application.subheader.SubheaderModule;
import gmd.addins.demo.client.application.swipeable.SwipeableModule;
import gmd.addins.demo.client.application.timeline.TimeLineModule;
import gmd.addins.demo.client.application.timepicker.TimePickerModule;
import gmd.addins.demo.client.application.timer.CircularSVGTimerModule;
import gmd.addins.demo.client.application.tree.TreeModule;
import gmd.addins.demo.client.application.viewer.ImageViewerModule;
import gmd.addins.demo.client.application.waterfall.WaterfallModule;
import gmd.addins.demo.client.application.webp.WebpModule;
import gmd.addins.demo.client.application.window.WindowModule;

public class ApplicationModule extends AbstractPresenterModule {

    @Override
    protected void configure() {
        install(new HomeModule());
        install(new AutocompleteModule());
        install(new AvatarModule());
        install(new BannerModule());
        install(new BubbleModule());
        install(new CameraModule());
        install(new CarouselModule());
        install(new CircularProgressModule());
        install(new CircularSVGTimerModule());
        install(new ComboBoxModule());
        install(new ContinousRangeSliderModule());
        install(new CountUpModule());
        install(new CutoutModule());
        install(new DateOfBirthPickerModule());
        install(new DndModule());
        install(new DocViewerModule());
        install(new DragulaModule());
        install(new OverlayModule());
        install(new DropzoneModule());
        install(new EmptyStateModule());
        install(new HeroVideoModule());
        install(new IconMorphModule());
        install(new ImageCropperModule());
        install(new ImageViewerModule());
        install(new InfiniteScrollPanelModule());
        install(new InputMaskModule());
        install(new JsonTableModule());
        install(new LanguageSelectorModule());
        install(new LiveStampModule());
        install(new LoadingDotsModule());
        install(new LoadingStatePanelModule());
        install(new Md5Module());
        install(new MasonryModule());
        install(new MenubarModule());
        install(new PasswordStrengthTextBoxModule());
        install(new PathAnimatorModule());
        install(new PinchZoomPanelModule());
        install(new PopupMenuModule());
        install(new RatingModule());
        install(new RatingQuestionModule());
        install(new RecaptchaModule());
        install(new RichEditorModule());
        install(new ScrollfireModule());
        install(new SideProfileModule());
        install(new SignaturePadModule());
        install(new SplitPanelModule());
        install(new SproutVideoModule());
        install(new StepperModule());
        install(new SubheaderModule());
        install(new SwipeableModule());
        install(new TimeLineModule());
        install(new TimePickerModule());
        install(new TreeModule());
        install(new WaterfallModule());
        install(new WebpModule());
        install(new WindowModule());
        install(new NoteModule());

        /** Beta **/
        install(new AddressLookupModule());
        install(new CheckMarkModule());
        install(new DateRangeModule());
        install(new GroupToggleModule());
        install(new KanbanModule());
        install(new LocalStorageModule());
        install(new PlaceholderModule());
        install(new ProgressLineBarModule());
        install(new ScreenKeyboardModule());
        install(new SearchModule());
        install(new TagModule());
        install(new TimerModule());

        bindPresenter(ApplicationPresenter.class, ApplicationPresenter.MyView.class, ApplicationView.class,
            ApplicationPresenter.MyProxy.class);
    }
}
