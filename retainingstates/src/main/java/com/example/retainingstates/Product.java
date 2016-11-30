package com.example.retainingstates;

/**
 * Created by Rahul on 11/30/2016.
 */

public class Product {

    private String Name;
    private float Price;
    private int Cashback;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float price) {
        Price = price;
    }

    public int getCashback() {
        return Cashback;
    }

    public void setCashback(int cashback) {
        Cashback = cashback;
    }
}

