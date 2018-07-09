package com.example.unknown.cheaperapp.Classes;

import java.util.ArrayList;
import java.util.Date;

public class AdvertismentClass {


    int ID;
    String ProductName;
    String Description;
    double Price;
    double PriceAfterDiscount;
    String StartDate;
    String EndDate;
    String CreationDate;
    boolean IsLimited;
    boolean IsActive;
    int CategoryId;

    int SellerID;
    String SellerName;

    ArrayList<Images_Class>Images;
    ArrayList<Branch_Class>AdvertisementBranchs;


    public AdvertismentClass() {
    }

    public AdvertismentClass(int ID, String productName, double price, double priceAfterDiscount, String startDate, String endDate, boolean isLimited, String sellerName) {
        this.ID = ID;
        ProductName = productName;
        Price = price;
        PriceAfterDiscount = priceAfterDiscount;
        StartDate = startDate;
        EndDate = endDate;
        IsLimited = isLimited;
        SellerName = sellerName;
    }

    public AdvertismentClass(int ID, String productName, String description, double price, double priceAfterDiscount, String startDate, String endDate, String creationDate, boolean isLimited, boolean isActive, int categoryId, ArrayList<Images_Class> images, ArrayList<Branch_Class> advertisementBranchs) {
        this.ID = ID;
        ProductName = productName;
        Description = description;
        Price = price;
        PriceAfterDiscount = priceAfterDiscount;
        StartDate = startDate;
        EndDate = endDate;
        CreationDate = creationDate;
        IsLimited = isLimited;
        IsActive = isActive;
        CategoryId = categoryId;
        Images = images;
        AdvertisementBranchs = advertisementBranchs;
    }

    public AdvertismentClass(int ID, String productName, String description, double price, double priceAfterDiscount, String startDate, String endDate, String creationDate, boolean isLimited, boolean isActive, int categoryId) {
        this.ID = ID;
        ProductName = productName;
        Description = description;
        Price = price;
        PriceAfterDiscount = priceAfterDiscount;
        StartDate = startDate;
        EndDate = endDate;
        CreationDate = creationDate;
        IsLimited = isLimited;
        IsActive = isActive;
        CategoryId = categoryId;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public double getPriceAfterDiscount() {
        return PriceAfterDiscount;
    }

    public void setPriceAfterDiscount(double priceAfterDiscount) {
        PriceAfterDiscount = priceAfterDiscount;
    }

    public String getStartDate() {
        return StartDate;
    }

    public void setStartDate(String startDate) {
        StartDate = startDate;
    }

    public String getEndDate() {
        return EndDate;
    }

    public void setEndDate(String endDate) {
        EndDate = endDate;
    }

    public String getCreationDate() {
        return CreationDate;
    }

    public void setCreationDate(String creationDate) {
        CreationDate = creationDate;
    }

    public boolean isLimited() {
        return IsLimited;
    }

    public void setLimited(boolean limited) {
        IsLimited = limited;
    }

    public boolean isActive() {
        return IsActive;
    }

    public void setActive(boolean active) {
        IsActive = active;
    }

    public int getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(int categoryId) {
        CategoryId = categoryId;
    }

    public int getSellerID() {
        return SellerID;
    }

    public void setSellerID(int sellerID) {
        SellerID = sellerID;
    }

    public String getSellerName() {
        return SellerName;
    }

    public void setSellerName(String sellerName) {
        SellerName = sellerName;
    }

    public ArrayList<Images_Class> getImages() {
        return Images;
    }

    public void setImages(ArrayList<Images_Class> images) {
        Images = images;
    }

    public ArrayList<Branch_Class> getAdvertisementBranchs() {
        return AdvertisementBranchs;
    }

    public void setAdvertisementBranchs(ArrayList<Branch_Class> advertisementBranchs) {
        AdvertisementBranchs = advertisementBranchs;
    }
}
