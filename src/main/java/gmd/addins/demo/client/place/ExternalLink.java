package gmd.addins.demo.client.place;

public enum ExternalLink {

    AVATAR("Jdenticon", "2.2.0", "https://jdenticon.com/"),
    CAROUSEL("SlickJs", "1.8.0", "https://kenwheeler.github.io/slick/"),
    CIRCULAR_PROGRESS("Jquery Circular Progress", "1.2.2", "https://github.com/kottenator/jquery-circle-progress"),
    COMBOBOX("Select2Js", "4.0.13", "https://select2.org/"),
    COUNT_UP("CountUpJs", "2.0.4", "https://github.com/inorganik/countUp.js"),
    DRAG_AND_DROP("InteractJs", "1.9.4", "https://github.com/taye/interact.js"),
    DROPZONE("DropzoneJs", "5.7.0", "https://github.com/enyo/dropzone"),
    IMAGE_CROPPER("Croppie", "2.6.4", "https://github.com/Foliotek/Croppie"),
    INPUTMASK("JQuery Mask Plugin", "1.14.16", "https://igorescobar.github.io/jQuery-Mask-Plugin/"),
    LIVESTAMP("Livestampjs", "1.1.2", "https://github.com/mattbradley/livestampjs"),
    MASONRY("Masonry", "4.2.2", "https://github.com/desandro/masonry"),
    PATH_ANIMATOR("CTAJs", "0.3.2", "https://github.com/chinchang/cta.js"),
    RICH_EDITOR("MaterialNote", "1.2.1", "https://github.com/Cerealkillerway/materialNote"),
    SIGNATURE_PAD("SignaturePad", "3.0.0 Beta 3", "https://github.com/szimek/signature_pad"),
    SPLIT_PANEL("TouchSplitterJQuery", "0.5.1", "https://github.com/colelawrence/Touch-Splitter-jQuery"),
    TIME_PICKER("Lolliclock", "0.1.0", "https://github.com/mattkrick/lolliclock"),

    DATE_RANGE_PICKER("DateRangePicker", "3.0.5", "http://www.daterangepicker.com/"),;

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
