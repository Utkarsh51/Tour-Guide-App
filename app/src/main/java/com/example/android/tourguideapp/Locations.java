package com.example.android.tourguideapp;

public class Locations {
    /**
     * Name of the location
     */
    private int mName;
    /**
     * Image resource id for the location
     */
    private int mImageResourceId;
    /**
     * Description
     */
    private int mDescription;
    /**
     * public constructor;
     */
    public Locations(int name,int resourceId, int description){
        mName = name;
        mImageResourceId = resourceId;
        mDescription = description;
    }
    /**
     * getter methods
     */
    //returns nsme
    public int getmName(){return  mName;}
    //returns resource id
    public int getmImageResourceId(){
        return mImageResourceId;
    }
    //returns description

    public int getmDescription() {
        return mDescription;
    }
}
