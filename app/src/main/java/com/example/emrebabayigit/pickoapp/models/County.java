package com.example.emrebabayigit.pickoapp.models;

import java.io.Serializable;

/**
 * Created by ebabayigit on 20/04/2017.
 */

public class County implements Serializable {

    public int Id;

    public String CountyName;

    public City City;

    public boolean IsActive;

    public LocationViewModel Coordinates;
}
