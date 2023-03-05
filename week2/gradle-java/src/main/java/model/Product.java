package model;

import java.io.Serializable;

public class Product implements Identifiable<String>, Serializable {
    private String barCode;
    private String description;
    private double price;
    private int count;

    public Product() {
        this.barCode = "";
        this.description = "";
        this.price = 0.00;
        this.count = 0;
    }

    public Product(String barCode, String description, double price, int count) {
        this.barCode = barCode;
        this.description = description;
        this.price = price;
        this.count = count;
    }

    public String getId(){
        return barCode;
    }

    @Override
    public void setId(String id) {
        this.barCode = id;
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
        return "|" + barCode + "| "+ description+"; "+price+"$; "+count+" pieces;";
    }
}
