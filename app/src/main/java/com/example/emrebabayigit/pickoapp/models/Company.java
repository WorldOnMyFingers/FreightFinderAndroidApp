package com.example.emrebabayigit.pickoapp.models;

import java.io.Serializable;
import java.util.Date;

import com.example.emrebabayigit.pickoapp.enums.CompanyTypeCodes;

/**
 * Created by ebabayigit on 20/04/2017.
 */

public class Company implements Serializable {

    public int Id;

    public int AddressId;

    public String CompanyName;

    public String Telephone;

    public String Email;

    public String TaxNumber;

    public String TaxOffice;

    public Date MembershipDate;

    public boolean IsActive;

    public AddressViewModel Address;

    public CompanyTypeCodes CompanyType;
}
