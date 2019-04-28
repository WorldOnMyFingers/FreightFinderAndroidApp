package com.example.emrebabayigit.pickoapp.models;

import android.support.annotation.DrawableRes;

public class ImageSlider {
    private String name;

    //optional @DrawableRes
    @DrawableRes
    private int resId;

    public ImageSlider(String name, int resId) {
        this.name = name;
        this.resId = resId;
    }

    @Override
    public String toString() {
        return name;
    }

    //getters and setters

}
