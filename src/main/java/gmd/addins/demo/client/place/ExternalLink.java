package gmd.addins.demo.client.place;

public enum ExternalLink {

    AVATAR("Jdenticon", "2.2.0", "https://jdenticon.com/"),
    CAROUSEL("SlickJs", "1.6.0", "https://kenwheeler.github.io/slick/"),
    CIRCULAR_PROGRESS("Jquery Circular Progress", "1.2.2", "https://github.com/kottenator/jquery-circle-progress"),
    COMBOBOX("Select2Js", "4.0.3", "https://select2.org/"),
    RICH_EDITOR("MaterialNote", "1.2.1", "https://github.com/Cerealkillerway/materialNote"),
    TIME_PICKER("Lolliclock", "0.1.0", "https://github.com/mattkrick/lolliclock");

    String name;
    String longName;
    String version;
    String link;

    ExternalLink(String name, String version, String link) {
        this.name = name;
        this.version = version;
        this.link = link;
    }

    public String getLongName() {
        return name + " " + version;
    }

    public String getVersion() {
        return version;
    }

    public String getLink() {
        return link;
    }
}
