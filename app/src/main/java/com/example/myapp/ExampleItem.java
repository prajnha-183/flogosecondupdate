package com.example.myapp;

public class ExampleItem {

    private String mName;
    private String mDescription;
    private int mPrice;

    public ExampleItem(String Name, String Description, int Price) {
        mName = Name;
        mDescription = Description;
        mPrice = Price;
    }

    public String getName() {
        return mName;
    }
    public String getDescription() {
        return mDescription;
    }
    public int getPrice() {
        return mPrice;
    }
}
