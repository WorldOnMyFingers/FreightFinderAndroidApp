package com.example.emrebabayigit.pickoapp.models;

import java.io.Serializable;

/**
 * Created by ebabayigit on 20/04/2017.
 */

public class City implements Serializable {

    public int Id;

    public String CityName;

    public Country Country;

    public boolean IsActive;

    public LocationViewModel Coordinates;
}
