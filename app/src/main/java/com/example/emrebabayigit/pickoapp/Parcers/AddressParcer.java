package com.example.emrebabayigit.pickoapp.Parcers;

import com.example.emrebabayigit.pickoapp.Util.Utility;
import com.example.emrebabayigit.pickoapp.models.AddressViewModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.util.ArrayList;

/**
 * Created by emrebabayigit on 13/08/2017.
 */

public class AddressParcer {
    private static final String TAG_ADDRESSLINE = "AddressLine";
    private static final String TAG_DISTRICT= "District";
    private static final String TAG_COUNTRY = "Country";
    private static final String TAG_CITY = "City";
    private static final String TAG_COUNTY = "County";

    private static final String TAG_CITYNAME = "City";
    private static final String TAG_COUNTYNAME = "County";

    public static AddressViewModel parse(String jsonData) {

        AddressViewModel address = new AddressViewModel();

        if(jsonData==null)
            return address;

        try {
            JSONObject addressObject = new JSONObject(jsonData);

                if (Utility.contains(addressObject, TAG_COUNTRY)) {
                    address.SetCountry(addressObject.getString(TAG_COUNTRY));
                }

                if (Utility.contains(addressObject, TAG_CITY)) {
                    address.SetCity(addressObject.getString(TAG_CITY));
                }

                if (Utility.contains(addressObject, TAG_COUNTY)) {
                    address.SetCounty(addressObject.getString(TAG_COUNTY));
                }

                if (Utility.contains(addressObject, TAG_DISTRICT)) {
                    address.SetDistrict(addressObject.getString(TAG_DISTRICT));
                }

                if (Utility.contains(addressObject, TAG_ADDRESSLINE)) {
                    address.SetAddressLine(addressObject.getString(TAG_ADDRESSLINE));
                }


        }

        catch (JSONException e) {
            e.printStackTrace();
        }

        return address;

    }

}
