package com.example.unknown.cheaperapp.Classes;

import java.util.ArrayList;

public class Branch_Class {


    int ID;
    String Name;
    String Phone;
    String Address;
    String CityName;
    String Lang;
    String Lat;
    String location;
    ArrayList<AdvertismentClass> Advertisments_List;
    public  Branch_Class(){}


    public Branch_Class(int ID, String name) {
        this.ID = ID;
        Name = name;
    }

    public Branch_Class(int ID, String name, String phone, String address, String cityName, String lang, String lat, String location, ArrayList<AdvertismentClass> advertisments_List) {
        this.ID = ID;
        Name = name;
        Phone = phone;
        Address = address;
        CityName = cityName;
        Lang = lang;
        Lat = lat;
        this.location = location;
        Advertisments_List = advertisments_List;
    }

    public Branch_Class(String phone, String cityName, String location) {
        Phone = phone;
        CityName = cityName;
        this.location = location;
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

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getCityName() {
        return CityName;
    }

    public void setCityName(String cityName) {
        CityName = cityName;
    }

    public String getLang() {
        return Lang;
    }

    public void setLang(String lang) {
        Lang = lang;
    }

    public String getLat() {
        return Lat;
    }

    public void setLat(String lat) {
        Lat = lat;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public ArrayList<AdvertismentClass> getAdvertisments_List() {
        return Advertisments_List;
    }

    public void setAdvertisments_List(ArrayList<AdvertismentClass> advertisments_List) {
        Advertisments_List = advertisments_List;
    }



}
