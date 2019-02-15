package com.example.emrebabayigit.pickoapp.models;

import com.example.emrebabayigit.pickoapp.enums.VehicleTypeCodes;

import java.util.Date;
/**
 * Created by ebabayigit on 20/04/2017.
 */

public class Vehicle {

    public int Id;

    public int Capacity;

    public String PlateNumber;

    public VehicleTypeCodes VehicleType;

    public String VehicleIdentificationNumber;

    public String EngineNumber ;

    public String PicturePath;

    public Date DateCreated;

    public boolean IsLoaded ;

    public boolean IsActive;

    public Colour Colour;

    public VehicleBrand Brand;

    public VehicleModel Model;

    public Company Company;

    public User Driver;
}
