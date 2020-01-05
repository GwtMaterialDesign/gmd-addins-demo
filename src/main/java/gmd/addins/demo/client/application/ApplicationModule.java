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
import gmd.addins.demo.client.application.avatar.AvatarModule;
import gmd.addins.demo.client.application.bubble.BubbleModule;
import gmd.addins.demo.client.application.camera.CameraModule;
import gmd.addins.demo.client.application.carousel.CarouselModule;
import gmd.addins.demo.client.application.circularprogress.CircularProgressModule;
import gmd.addins.demo.client.application.combobox.ComboBoxModule;
import gmd.addins.demo.client.application.countup.CountUpModule;
import gmd.addins.demo.client.application.cutout.CutoutModule;
import gmd.addins.demo.client.application.docviewer.DocViewerModule;
import gmd.addins.demo.client.application.dropzone.DropzoneModule;
import gmd.addins.demo.client.application.emptystate.EmptyStateModule;
import gmd.addins.demo.client.application.home.HomeModule;
import gmd.addins.demo.client.application.iconmorph.IconMorphModule;
import gmd.addins.demo.client.application.imagecropper.ImageCropperModule;
import gmd.addins.demo.client.application.inputmask.InputMaskModule;
import gmd.addins.demo.client.application.livestamp.LiveStampModule;
import gmd.addins.demo.client.application.menubar.MenubarModule;
import gmd.addins.demo.client.application.rating.RatingModule;
import gmd.addins.demo.client.application.richeditor.RichEditorModule;
import gmd.addins.demo.client.application.signaturepad.SignaturePadModule;
import gmd.addins.demo.client.application.splitpanel.SplitPanelModule;
import gmd.addins.demo.client.application.stepper.StepperModule;
import gmd.addins.demo.client.application.subheader.SubheaderModule;
import gmd.addins.demo.client.application.timepicker.TimePickerModule;
import gmd.addins.demo.client.application.tree.TreeModule;
import gmd.addins.demo.client.application.window.WindowModule;

public class ApplicationModule extends AbstractPresenterModule {

    @Override
    protected void configure() {
        install(new HomeModule());
        install(new AvatarModule());
        install(new BubbleModule());
        install(new CameraModule());
        install(new CarouselModule());
        install(new CircularProgressModule());
        install(new ComboBoxModule());
        install(new CountUpModule());
        install(new CutoutModule());
        install(new DocViewerModule());
        install(new DropzoneModule());
        install(new EmptyStateModule());
        install(new IconMorphModule());
        install(new ImageCropperModule());
        install(new InputMaskModule());
        install(new LiveStampModule());
        install(new MenubarModule());
        install(new RatingModule());
        install(new RichEditorModule());
        install(new SignaturePadModule());
        install(new SplitPanelModule());
        install(new StepperModule());
        install(new SubheaderModule());
        install(new TimePickerModule());
        install(new TreeModule());
        install(new WindowModule());

        bindPresenter(ApplicationPresenter.class, ApplicationPresenter.MyView.class, ApplicationView.class,
            ApplicationPresenter.MyProxy.class);
    }
}
