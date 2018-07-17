package com.example.unknown.cheaperapp.Classes;

public class Images_Class {

    int ID;
    String Base64;
    String Path;
    int ResourceID;


    public Images_Class() {
    }

    public Images_Class(int resourceID) {
        ResourceID = resourceID;
    }

    public Images_Class(int ID, String base64, String path, int resourceID) {
        this.ID = ID;
        Base64 = base64;
        Path = path;
        ResourceID = resourceID;
    }




    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getBase64() {
        return Base64;
    }

    public void setBase64(String base64) {
        Base64 = base64;
    }

    public String getPath() {
        return Path;
    }

    public void setPath(String path) {
        Path = path;
    }

    public int getResourceID() {
        return ResourceID;
    }

    public void setResourceID(int resourceID) {
        ResourceID = resourceID;
    }
}
