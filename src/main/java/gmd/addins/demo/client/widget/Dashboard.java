package gmd.addins.demo.client.widget;

import com.gwtplatform.mvp.client.proxy.PlaceManager;
import gwt.material.design.client.constants.Color;

public class Dashboard {

    private String name;
    private String description;
    private String link;
    private Color color;
    private PlaceManager placeManager;
    private boolean beta;

    public Dashboard(PlaceManager placeManager, String name, String description, String link, Color color) {
        this.name = name;
        this.description = description;
        this.link = link;
        this.color = color;
        this.placeManager = placeManager;
    }

    public Dashboard(PlaceManager placeManager, String name, String description, String link, Color color, boolean beta) {
        this.name = name;
        this.description = description;
        this.link = link;
        this.color = color;
        this.placeManager = placeManager;
        this.beta = beta;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public PlaceManager getPlaceManager() {
        return placeManager;
    }

    public void setPlaceManager(PlaceManager placeManager) {
        this.placeManager = placeManager;
    }

    public boolean isBeta() {
        return beta;
    }

    public void setBeta(boolean beta) {
        this.beta = beta;
    }
}
