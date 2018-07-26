package com.example.unknown.cheaperapp.Classes;

import java.util.ArrayList;

public class Add_Details {
    int id;
    String productName,description,
            storeName,price,priceAfterDiscount,
            startDate,endDate;
    boolean isLimited,isFavourite;
    ArrayList<String>images;
    ArrayList<Branch_Class>branches;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPriceAfterDiscount() {
        return priceAfterDiscount;
    }

    public void setPriceAfterDiscount(String priceAfterDiscount) {
        this.priceAfterDiscount = priceAfterDiscount;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }


    public ArrayList<String> getImages() {
        return images;
    }

    public void setImages(ArrayList<String> images) {
        this.images = images;
    }

    public ArrayList<Branch_Class> getBranches() {
        return branches;
    }

    public void setBranches(ArrayList<Branch_Class> branches) {
        this.branches = branches;
    }

    public boolean getLimited() {
        return isLimited;
    }

    public void setLimited(boolean limited) {
        isLimited = limited;
    }

    public boolean getFavourite() {
        return isFavourite;
    }

    public void setFavourite(boolean favourite) {
        isFavourite = favourite;
    }
}
