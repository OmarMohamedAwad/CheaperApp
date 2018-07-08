package com.example.unknown.cheaperapp.Classes;

import java.util.ArrayList;
import java.util.Date;

public class AdvertismentClass {


    int ID;
    String ProductName;
    String Description;
    double Price;
    double PriceAfterDiscount;
    Date StartDate;
    Date EndDate;
    Date CreationDate;
    boolean IsLimited;
    boolean IsActive;
    boolean CategoryId;

    ArrayList<Images_Class>Images;
    ArrayList<Branch_Class>AdvertisementBranchs;


}
