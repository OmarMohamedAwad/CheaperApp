package com.example.unknown.cheaperapp.Classes;

import java.util.ArrayList;

public class Category_Class {

    int ID;
    String Name;
    String Description;
    String ImageUrl;

    int ImageResourceId;

    ArrayList<AdvertismentClass> AdvertisementList;


    public Category_Class() {

    }


    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public int getImageResourceId() {
        return ImageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        ImageResourceId = imageResourceId;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public ArrayList<AdvertismentClass> getAdvertisementList() {
        return AdvertisementList;
    }

    public void setAdvertisementList(ArrayList<AdvertismentClass> advertisementList) {
        AdvertisementList = advertisementList;
    }
}
