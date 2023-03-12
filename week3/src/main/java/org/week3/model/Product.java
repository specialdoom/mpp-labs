package org.week3.model;

public class Product {
    private String id;
    private String description;
    private double price;
    private int count;

    public Product(){
        this.id = "";
        this.description = "";
        this.price = 0.00;
        this.count = 0;
    }

    public Product(String id, String description, double price, int count) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.count = count;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString(){
        return "|" + id + "| "+ description+"; "+price+"$; "+count+" pieces;";
    }
}
