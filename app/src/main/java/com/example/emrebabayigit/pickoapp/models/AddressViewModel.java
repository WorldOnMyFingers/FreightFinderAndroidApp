package com.example.emrebabayigit.pickoapp.models;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by ebabayigit on 20/04/2017.
 */

public class AddressViewModel implements Serializable {

    public long Id ;

    public String District;

    public String AddressLine;

    public String Phone;

    public String City;

    public String Country;

    public String County;

    // Setters and Getters
    public void SetDistrict(String district)
    {
        District = district;
    }

    public String GetDistrict()
    {
        return District;
    }

    public void SetPhone(String phone)
    {
        Phone = phone;
    }

    public String GetPhone()
    {
        return Phone;
    }

    public void SetAddressLine(String addressLine)
    {
        AddressLine = addressLine;
    }

    public String GetAddressLine()
    {
        return AddressLine;
    }

    public void SetCountry(String country)
    {
        Country = country;
    }

    public String GetCountry()
    {
        return Country;
    }

    public void SetCity(String city)
    {
        City = city;
    }

    public String GetCity()
    {
        return City;
    }

    public void SetCounty(String county)
    {
        County = county;
    }

    public String GetCounty()
    {
        return County;
    }



}
