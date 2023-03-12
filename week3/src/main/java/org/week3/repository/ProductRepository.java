package org.week3.repository;

import org.week3.model.Product;

import java.util.List;

public interface ProductRepository extends Repository<String, Product> {
    Product findById(String id);
    List<Product> findBetweenPrices(double min, double max);
}
