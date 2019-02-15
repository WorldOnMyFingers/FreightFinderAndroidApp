package model;

import java.util.Date;

import gamyoncular.freightfinder.enums.CompanyTypeCodes;

/**
 * Created by ebabayigit on 20/04/2017.
 */

public class Company {

    public int Id;

    public int AddressId;

    public String CompanyName;

    public String Telephone;

    public String Email;

    public String TaxNumber;

    public String TaxOffice;

    public Date MembershipDate;

    public boolean IsActive;

    public Address Address;

    public CompanyTypeCodes CompanyType;
}
