package com.example.unknown.cheaperapp.Classes;

import java.util.ArrayList;

public class StoreClass {

    int ID;
    String Name;
    int ImageResourceId;

    Images_Class Image;
    ArrayList<Branch_Class> Branchs_list;
    ArrayList<Category_Class> Categories_list;


    public StoreClass(int ID, String name, int imageResourceId) {
        this.ID = ID;
        Name = name;
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

    public int getImageResourceId() {
        return ImageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        ImageResourceId = imageResourceId;
    }

    public Images_Class getImage() {
        return Image;
    }

    public void setImage(Images_Class image) {
        Image = image;
    }

    public ArrayList<Branch_Class> getBranchs_list() {
        return Branchs_list;
    }

    public void setBranchs_list(ArrayList<Branch_Class> branchs_list) {
        Branchs_list = branchs_list;
    }

    public ArrayList<Category_Class> getCategories_list() {
        return Categories_list;
    }

    public void setCategories_list(ArrayList<Category_Class> categories_list) {
        Categories_list = categories_list;
    }
}
