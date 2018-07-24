package com.example.unknown.cheaperapp.Classes;

import android.os.Parcel;
import android.os.Parcelable;

public class User_Class implements Parcelable {

    int ID;
    String Name;
    String Email;
    String Phone;
    String Image;

    public User_Class(String name, String email, String phone, String image) {
        Name = name;
        Email = email;
        Phone = phone;
        Image = image;
    }

    protected User_Class(Parcel in) {
        ID = in.readInt();
        Name = in.readString();
        Email = in.readString();
        Phone = in.readString();
        Image = in.readString();
    }

    public static final Creator<User_Class> CREATOR = new Creator<User_Class>() {
        @Override
        public User_Class createFromParcel(Parcel in) {
            return new User_Class(in);
        }

        @Override
        public User_Class[] newArray(int size) {
            return new User_Class[size];
        }
    };

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

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(ID);
        parcel.writeString(Name);
        parcel.writeString(Email);
        parcel.writeString(Phone);
        parcel.writeString(Image);
    }
}
