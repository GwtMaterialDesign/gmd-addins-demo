package gmd.addins.demo.client.application;

import com.google.gwt.event.shared.GwtEvent;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;
import gmd.addins.demo.client.place.ExternalLink;
import gmd.addins.demo.client.resources.AppResources;
import gmd.addins.demo.client.widget.HeaderTitle;
import gwt.material.design.client.MaterialDesignBase;
import gwt.material.design.client.base.MaterialWidget;
import gwt.material.design.client.base.helper.ScrollHelper;
import gwt.material.design.client.ui.MaterialToast;

public class BasePresenter<V extends View, Proxy_ extends Proxy<?>> extends Presenter<V, Proxy_> {

    static {
        MaterialDesignBase.injectCss(AppResources.INSTANCE.highlightCSs());
        MaterialDesignBase.injectJs(AppResources.INSTANCE.highlightJs());
    }

    protected HeaderTitle headerTitle;

    public BasePresenter(EventBus eventBus, V view, Proxy_ proxy, GwtEvent.Type<RevealContentHandler<?>> slot) {
        super(eventBus, view, proxy, slot);
    }

    @Override
    protected void onBind() {
        super.onBind();

        if (asWidget() instanceof MaterialWidget) {
            headerTitle = new HeaderTitle();
            ((MaterialWidget) asWidget()).insert(headerTitle, 0);
        }
    }

    @Override
    protected void onReveal() {
        super.onReveal();

        initPre();
        new ScrollHelper().scrollTo(0);
        String url = "https://github.com/GwtMaterialDesign/gmd-addins-demo/tree/master/src/main/java/" + getClass().getName().replace(".", "/");
        url = url.substring(0, url.lastIndexOf("/"));
        headerTitle.setSource(url);
    }

    public void setHeaderTitle(String title, String description, String link) {
        headerTitle.setDetails(title, description, link);
    }

    public void setExternalLibrary(ExternalLink link) {
        headerTitle.setExternalLibrary(link.getLongName(), link.getLink());
    }

    public static native void initPre() /*-{
        $wnd.jQuery(document).ready(function() {
            $wnd.jQuery('pre').each(function(i, block) {
                $wnd.hljs.highlightBlock(block);
            });
        });
    }-*/;
}
