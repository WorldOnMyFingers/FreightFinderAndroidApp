package com.example.emrebabayigit.pickoapp.models;

import java.io.Serializable;
import java.util.Date;

import com.example.emrebabayigit.pickoapp.enums.FreightTypeCode;
import com.example.emrebabayigit.pickoapp.enums.TrailerTypeCode;

/**
 * Created by ebabayigit on 20/04/2017.
 */

public class FreightViewModel implements Serializable {

    public long Id;

    public FreightTypeCode FreightType;

    public TrailerTypeCode TrailerType;

    public int Weight;

    public boolean IsFullVehicleQuantity;

    public Date DateCreated;

    public Date LoadingDate;

    public Date DeliverByDate;

    public Date DateTaken;

    public double UnitPrice;

    public double TotalPrice;

    public boolean IsVatIncluded;

    public boolean IsDelivered;

    public boolean IsActive;

    public boolean IsTaken;

    public String Description;

    public AddressViewModel DestinationAddress;

    public Company Company;

    public AddressViewModel Address;

    public LocationViewModel Location;

    public VehicleViewModel Vehicle;


    // Getters and Setters
    public long GetId()
    {
        return Id;
    }

    public void SetId(long id)
    {
        Id = id;
    }

    public FreightTypeCode GetFreightType()
    {
        return FreightType;
    }

    public void SetFreightType(FreightTypeCode freightTypeCode)
    {
        FreightType = freightTypeCode;
    }

    public TrailerTypeCode GetTrailerType()
    {
        return TrailerType;
    }

    public void SetTrailerType(TrailerTypeCode trailerTypeCode)
    {
        TrailerType = trailerTypeCode;
    }

    public long GetIWeight()
    {
        return Weight;
    }

    public void SetWeight(int weight)
    {
        Weight = weight;
    }

    public boolean GetIsFullVehicleQuantity()
    {
        return IsFullVehicleQuantity;
    }

    public void SetIsFullVehicleQuantity(boolean isFullVehicleQuantity)
    {
        IsFullVehicleQuantity = isFullVehicleQuantity;
    }

    public Date GetLoadingDate()
    {
        return LoadingDate;
    }

    public void SetLoadingDate(Date loadingDate)
    {
        LoadingDate = loadingDate;
    }

    public Date GetDeliverByDate()
    {
        return DeliverByDate;
    }

    public void SetDeliverByDate(Date deliverByDate)
    {
        DeliverByDate = deliverByDate;
    }

    public Date GetDateTaken()
    {
        return DateTaken;
    }

    public void SetDateTaken(Date dateTaken)
    {
        DateTaken = dateTaken;
    }

    public double GetUnitPrice()
    {
        return UnitPrice;
    }

    public void SetUnitPrice(double unitPrice)
    {
        UnitPrice = unitPrice;
    }

    public double GetTotalPrice()
    {
        return TotalPrice;
    }

    public void SetTotalPrice(double totalPrice)
    {
        TotalPrice = totalPrice;
    }

    public boolean GetIsVatIncluded()
    {
        return IsVatIncluded;
    }

    public void SetIsVatIncluded(boolean isVatIncluded)
    {
        IsVatIncluded = isVatIncluded;
    }

    public boolean GetIsDelivered()
    {
        return IsDelivered;
    }

    public void SetIsDelivered(boolean isDelivered)
    {
        IsDelivered = isDelivered;
    }

    public boolean GetIsActive()
    {
        return IsActive;
    }

    public void SetIsActive(boolean isActive)
    {
        IsDelivered = isActive;
    }

    public boolean GetIsTaken()
    {
        return IsTaken;
    }

    public void SetIsTaken(boolean isTaken)
    {
        IsTaken = isTaken;
    }

    public String GetDescription()
    {
        return Description;
    }

    public void SetDescription(String description)
    {
        Description = description;
    }

    public void SetAddress(AddressViewModel address)
    {
        Address = address;
    }

    public AddressViewModel GetAddress()
    {
        return Address;
    }

    public void SetDestinationAddress(AddressViewModel address)
    {
        DestinationAddress = address;
    }

    public AddressViewModel GetDestinationAddress()
    {
        return DestinationAddress;
    }

    public void SetLocation(LocationViewModel location)
    {
        Location = location;
    }

    public LocationViewModel GetLocation()
    {
        return Location;
    }

    public void SetDateCreated(Date dateCreated)
    {
        DateCreated = dateCreated;
    }

    public Date GetDateCreated()
    {
        return DateCreated;
    }

}
