package com.example.emrebabayigit.pickoapp.models;

import com.example.emrebabayigit.pickoapp.enums.TrailerTypeCode;

import java.io.Serializable;
import java.util.Date;
/**
 * Created by ebabayigit on 20/04/2017.
 */

public class VehicleViewModel implements Serializable {

    public int Id;

    public int Capacity;

    public String PlateNumber;

    public TrailerTypeCode VehicleType;

    public String VehicleIdentificationNumber;

    public String EngineNumber ;

    public String PicturePath;

    public Date DateCreated;

    public boolean IsLoaded ;

    public boolean IsActive;

    public String Colour;

    public String Brand;

    public String Model;

    public String[] ImagePaths;

    public String Company;

    public String Driver;


    // Setters and Getters
    public void SetImagePaths(String[] paths)
    {
        ImagePaths = paths;
    }

    public String[] GetImagePaths()
    {
        return ImagePaths;
    }

    public void SetVehicleIdentificationNumber(String vehicleIdentificationNumber)
    {
        VehicleIdentificationNumber = vehicleIdentificationNumber;
    }

    public String GetVehicleIdentificationNumber()
    {
        return VehicleIdentificationNumber;
    }

    public void SetCompany(String company)
    {
        Company = company;
    }

    public String GetCompany()
    {
        return Company;
    }

    public void SetVehicleType(TrailerTypeCode vehicleType)
    {
        VehicleType = vehicleType;
    }

    public TrailerTypeCode GetVehicleType()
    {
        return VehicleType;
    }

    public void SetBrand(String brand)
    {
        Brand = brand;
    }

    public String GetBrand()
    {
        return Brand;
    }

    public void SetModel(String model)
    {
        Model = model;
    }

    public String GetModel()
    {
        return Model;
    }

    public void SetPlateNumber(String plateNumber)
    {
        PlateNumber = plateNumber;
    }

    public String GetPlateNumber()
    {
        return PlateNumber;
    }

    public void SetCapacity(int capacity)
    {
        Capacity = capacity;
    }

    public int GetCapacity()
    {
        return Capacity;
    }

    public void SetEngineNumber(String engineNumber)
    {
        EngineNumber = engineNumber;
    }

    public String GetEngineNumber()
    {
        return EngineNumber;
    }

public void SetColour(String colour)
    {
        Colour = colour;
    }

    public String GetColour()
    {
        return Colour;
    }

public void SetIsLoaded(boolean isLoaded)
    {
        IsLoaded = isLoaded;
    }

    public boolean GetIsLoaded()
    {
        return IsLoaded;
    }


}
