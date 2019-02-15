package model;

import java.util.Date;

import gamyoncular.freightfinder.enums.UserTypeCodes;

/**
 * Created by ebabayigit on 20/04/2017.
 */

public class User {

    public String Id;

    public long NationalIdentity;

    public String Username;

    public String Password;

    public String Name;

    public String Surename;

    public String Mobile;

    public String Email;

    public Date DateOfBirth;

    public String PicturePath;

    public Company Company;

    public UserTypeCodes UserType;

    public Date DateCreated;

    public boolean IsActive;
}
