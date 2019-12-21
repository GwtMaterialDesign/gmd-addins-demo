package gmd.addins.demo.client.application;

import gmd.addins.demo.client.resources.AppResources;
import gwt.material.design.client.theme.dark.DarkThemeLoader;

public class AppDarkThemeLoader extends DarkThemeLoader {

    public AppDarkThemeLoader() {
        super(AppResources.INSTANCE.appDarkCss());
    }
}
