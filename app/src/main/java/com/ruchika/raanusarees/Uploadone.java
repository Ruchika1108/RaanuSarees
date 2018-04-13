package com.ruchika.raanusarees;

/**
 * Created by Aditya on 12-04-2018.
 */

class Uploadone {
    private String mName;
    private String mImageUrl;
    public Uploadone() {
        //empty constructor needed
    }

    public Uploadone(String name, String imageUrl) {
        if (name.trim().equals("")) {
            name = "No Name";
        }

        mName = name;
        mImageUrl = imageUrl;
    }
    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        mImageUrl = imageUrl;
    }

}
