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
import gmd.addins.demo.client.application.combobox.ComboBoxModule;
import gmd.addins.demo.client.application.dropzone.DropzoneModule;
import gmd.addins.demo.client.application.home.HomeModule;
import gmd.addins.demo.client.application.rating.RatingModule;
import gmd.addins.demo.client.application.richeditor.RichEditorModule;
import gmd.addins.demo.client.application.stepper.StepperModule;
import gmd.addins.demo.client.application.timepicker.TimePickerModule;

public class ApplicationModule extends AbstractPresenterModule {

    @Override
    protected void configure() {
        install(new HomeModule());
        install(new AvatarModule());
        install(new BubbleModule());
        install(new ComboBoxModule());
        install(new DropzoneModule());
        install(new RatingModule());
        install(new RichEditorModule());
        install(new StepperModule());
        install(new TimePickerModule());

        bindPresenter(ApplicationPresenter.class, ApplicationPresenter.MyView.class, ApplicationView.class,
            ApplicationPresenter.MyProxy.class);
    }
}
