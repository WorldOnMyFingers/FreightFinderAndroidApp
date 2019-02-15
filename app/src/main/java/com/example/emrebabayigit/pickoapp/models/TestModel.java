package com.example.emrebabayigit.pickoapp.models;

/**
 * Created by emrebabayigit on 14/06/2017.
 */

public class TestModel {

    public String Header;

    public String City;

    public String County;


    public String GetHeader()
    {
        return Header;
    }

    public String GetCity()
    {
        return City;
    }

    public String GetCounty()
    {
        return County;
    }

    public void SetHeader(String header)
    {

        Header = header;
    }

    public void SetCity(String city)
    {

        City = city;
    }

    public void SetCounty(String county)
    {

        County = county;
    }
}
