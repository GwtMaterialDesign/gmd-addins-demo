package gmd.addins.demo.client.generator.product;

public class ProductGenerator {

    public static Product generate() {
        Product product = new Product(date(), productName(), productAdjective(), price(), color(), productMaterial(), department());
        product.setImage(image());
        return product;
    }

    protected static native String image() /*-{
        return $wnd.faker.image.avatar();
    }-*/;

    protected static native String date() /*-{
        return $wnd.faker.company.companyName();
    }-*/;

    protected static native String productName() /*-{
        return $wnd.faker.commerce.productName();
    }-*/;

    protected static native String productAdjective() /*-{
        return $wnd.faker.commerce.productAdjective();
    }-*/;

    protected static native String price() /*-{
        return $wnd.faker.commerce.price();
    }-*/;

    protected static native String color() /*-{
        return $wnd.faker.commerce.color();
    }-*/;

    protected static native String productMaterial() /*-{
        return $wnd.faker.commerce.productMaterial();
    }-*/;

    protected static native String department() /*-{
        return $wnd.faker.commerce.department();
    }-*/;
}
