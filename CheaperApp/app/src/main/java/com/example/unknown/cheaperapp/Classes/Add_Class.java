package com.example.unknown.cheaperapp.Classes;

public class Add_Class {
    private String product_name;
    private String price_before;
    private String price_aftter;
    int img;

    public Add_Class(String product_name, String price_before, String price_aftter, int img) {
        this.product_name = product_name;
        this.price_before = price_before;
        this.price_aftter = price_aftter;
        this.img = img;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getPrice_before() {
        return price_before;
    }

    public void setPrice_before(String price_before) {
        this.price_before = price_before;
    }

    public String getPrice_aftter() {
        return price_aftter;
    }

    public void setPrice_aftter(String price_aftter) {
        this.price_aftter = price_aftter;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
