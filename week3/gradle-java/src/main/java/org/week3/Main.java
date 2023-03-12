package org.week3;

import org.week3.model.Product;
import org.week3.repository.ProductDBRepository;
import org.week3.repository.ProductRepository;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        Properties properties = new Properties();

        try {
            properties.load(new FileReader("db.config"));
        } catch(IOException e) {
            System.out.println("Error: reading the db config failed " + e);
        }

        ProductRepository products = new ProductDBRepository(properties);

        products.add(new Product("4008110433585", "A4 Map with clip", 7.00, 10));

        products.update("4008110433585", new Product("4008110433585", "A4 Map with clip, black", 7.00, 10));

        for(Product product : products.findAll()) {
            System.out.println(product);
        }

        System.out.println("Product with price between 7 and 8");
        for(Product product: products.findBetweenPrices(7, 8)){
            System.out.println(product);
        }
    }
}