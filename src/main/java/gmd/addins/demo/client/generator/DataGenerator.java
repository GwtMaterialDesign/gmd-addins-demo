package gmd.addins.demo.client.generator;

import gmd.addins.demo.client.generator.product.Product;
import gmd.addins.demo.client.generator.product.ProductGenerator;
import gmd.addins.demo.client.generator.user.User;
import gmd.addins.demo.client.generator.user.UserGenerator;
import gmd.addins.demo.client.resources.AppResources;
import gwt.material.design.client.MaterialDesign;

import java.util.ArrayList;
import java.util.List;

public class DataGenerator {

    static {
        MaterialDesign.injectJs(AppResources.INSTANCE.fakerJs());
    }

    public List<User> generateUsers(int total) {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < total; i++) {
            users.add(UserGenerator.generate());
        }
        return users;
    }

    public List<Product> generateProducts(int total) {
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < total; i++) {
            Product product = ProductGenerator.generate();
            products.add(product);
        }
        return products;
    }

}
