package com.example.emrebabayigit.pickoapp.Parcers;

import com.example.emrebabayigit.pickoapp.Util.Utility;
import com.example.emrebabayigit.pickoapp.models.VehicleViewModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by emrebabayigit on 13/08/2017.
 */

public class VehicleParcer {

    private static final String TAG_BRAND = "Brand";
    private static final String TAG_MODEL = "Model";
    private static final String TAG_COLOUR = "Colour";
    private static final String TAG_CAPACITY = "Capacity";
    private static final String TAG_PLATENUMBER = "PlateNumber";
    private static final String TAG_VEHICLETYPE = "VehicleType";
    private static final String TAG_ISLOADED = "IsLoaded";
    private static final String TAG_ENGINENUMBER = "EngineNumber";
    private static final String TAG_VEHICLEIDENTIFICATIONNUMBER = "VehicleIdentificationNumber";

    public static ArrayList<VehicleViewModel> parse(String jsonData) {

        ArrayList<VehicleViewModel> VehicleList = new ArrayList<>();

        if(jsonData==null)
            return VehicleList;

        try {
            JSONArray storyArray = new JSONArray(jsonData);
            int length = storyArray.length();

            for(int i=0; i<length; i++)

            {

                VehicleViewModel vehicle = new VehicleViewModel();
                JSONObject storyObject = storyArray.getJSONObject(i);

                if (Utility.contains(storyObject, TAG_BRAND)) {
                    vehicle.SetBrand(storyObject.getString(TAG_BRAND));
                }

                if (Utility.contains(storyObject, TAG_MODEL)) {
                    vehicle.SetModel(storyObject.getString(TAG_MODEL));
                }

                if (Utility.contains(storyObject, TAG_COLOUR)) {
                    vehicle.SetColour(storyObject.getString(TAG_COLOUR));
                }

                if (Utility.contains(storyObject, TAG_PLATENUMBER)) {
                    vehicle.SetPlateNumber(storyObject.getString(TAG_PLATENUMBER));
                }

                if (Utility.contains(storyObject, TAG_ENGINENUMBER)) {
                    vehicle.SetEngineNumber(storyObject.getString(TAG_ENGINENUMBER));
                }

                if (Utility.contains(storyObject, TAG_ISLOADED)) {
                    vehicle.SetEngineNumber(storyObject.getString(TAG_ISLOADED));
                }

                VehicleList.add(vehicle);
            }

        }

        catch (JSONException e) {
            e.printStackTrace();
        }

        return VehicleList;

    }

}
