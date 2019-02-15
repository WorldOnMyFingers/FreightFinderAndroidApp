package com.example.emrebabayigit.pickoapp.models;

import com.example.emrebabayigit.pickoapp.enums.LocationTypeCodes;

import java.io.Serializable;

/**
 * Created by ebabayigit on 20/04/2017.
 */

public class LocationViewModel implements Serializable {

    public long Id;

    public LocationTypeCodes LocationType ;

    public double Latitude;

    public double Longitude;

    public void SetId(long id)
    {
        Id = id;
    }

    public long GetId()
    {
        return Id;
    }

    public void SetLocationType(int locationType)
    {
        LocationType = LocationTypeCodes.values()[locationType];
    }

    public LocationTypeCodes GetLocationType()
    {
        return LocationType;
    }

    public void SetLatitude(double lat)
    {
        Latitude = lat;
    }

    public double GetLatitude()
    {
        return Latitude;
    }

    public void SetLongitude(double lon)
    {
        Longitude = lon;
    }

    public double GetLongitude()
    {
        return Longitude;
    }
}
