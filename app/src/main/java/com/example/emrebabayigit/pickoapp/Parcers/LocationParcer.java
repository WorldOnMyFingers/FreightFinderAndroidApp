package com.example.emrebabayigit.pickoapp.Parcers;

import com.example.emrebabayigit.pickoapp.Util.Utility;
import com.example.emrebabayigit.pickoapp.models.AddressViewModel;
import com.example.emrebabayigit.pickoapp.models.LocationViewModel;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by emrebabayigit on 19/08/2017.
 */

public class LocationParcer {

    private static final String TAG_LATITUDE = "Latitude";
    private static final String TAG_LONGITUDE = "Longitude";
    private static final String TAG_ID = "Id";
    private static final String TAG_LOCATIONTYPE = "LocationType";

    public static LocationViewModel parse(String jsonData) {

        LocationViewModel location = new LocationViewModel();

        if (jsonData == null)
            return location;

        try {
            JSONObject addressObject = new JSONObject(jsonData);

            if (Utility.contains(addressObject, TAG_LATITUDE)) {
                location.SetLatitude(Double.parseDouble(addressObject.getString(TAG_LATITUDE)));
            }

            if (Utility.contains(addressObject, TAG_LONGITUDE)) {
                location.SetLongitude(Double.parseDouble(addressObject.getString(TAG_LONGITUDE)));
            }

            if (Utility.contains(addressObject, TAG_ID)) {
                location.SetId(Long.parseLong(addressObject.getString(TAG_ID)));
            }

            if (Utility.contains(addressObject, TAG_LOCATIONTYPE)) {
                location.SetLocationType(Integer.parseInt(addressObject.getString(TAG_LOCATIONTYPE)));
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }

        return location;
    }
}