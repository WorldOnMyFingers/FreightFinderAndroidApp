package com.example.emrebabayigit.pickoapp.models;

import java.io.Serializable;
import java.util.Date;

import com.example.emrebabayigit.pickoapp.enums.UserTypeCodes;

/**
 * Created by ebabayigit on 20/04/2017.
 */

public class User implements Serializable {

    public int Id;

    public long NationalIdentity;

    public String Username;

    public String Password;

    public String Name;

    public String Surname;

    public String Mobile;

    public String Email;

    public Date DateOfBirth;

    public String PicturePath;

    public Company Company;

    public UserTypeCodes UserType;

    public Date DateCreated;

    public boolean IsActive;

    //Setters and Getters
    public void SetId(int id){
        Id = id;
    }

    public int GetId(){
        return Id;
    }
    public void SetUserName(String userName){
        Username = userName;
    }

    public String GetUserName(){
        return Username;
    }

    public void SetPassword(String password){
        Password = password;
    }

    public String GetPassword(){
        return Password;
    }

    public void SetName(String name){
        Name = name;
    }

    public String GetName(){
        return Name;
    }

    public void SetSurname(String surname){
        Surname = surname;
    }

    public String GetSurname(){
        return Surname;
    }

    public void SetEmail(String email){
        Email = email;
    }

    public String GetEmail(){
        return Email;
    }

    public void SetMobile(String mobile){
        Mobile = mobile;
    }

    public String GetMobile(){
        return Mobile;
    }

    public void SetDateOfBirth(Date dateOfBirth){
        DateOfBirth = dateOfBirth;
    }

    public Date GetDateOfBirth(){
        return DateOfBirth;
    }


}
