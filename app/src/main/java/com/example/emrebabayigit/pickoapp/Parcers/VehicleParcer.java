package com.example.emrebabayigit.pickoapp.Parcers;

import com.example.emrebabayigit.pickoapp.Util.Utility;
import com.example.emrebabayigit.pickoapp.enums.TrailerTypeCode;
import com.example.emrebabayigit.pickoapp.models.VehicleBrand;
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
    private static final String TAG_IMAGEPATHS = "ImagePaths";
    private static final String TAG_VEHICLEIDENTIFICATIONNUMBER = "VehicleIdentificationNumber";
    private static final String TAG_COMPANY = "Company";

    public static VehicleViewModel Parse(String jsonData) {

        VehicleViewModel vehicle = new VehicleViewModel();

        if (jsonData == null)
            return vehicle;

        try {
            JSONObject vehicleObject = new JSONObject(jsonData);


            if (Utility.contains(vehicleObject, TAG_VEHICLEIDENTIFICATIONNUMBER)) {
                vehicle.SetVehicleIdentificationNumber(vehicleObject.getString(TAG_VEHICLEIDENTIFICATIONNUMBER));
            }
            if (Utility.contains(vehicleObject, TAG_BRAND)) {
                vehicle.SetBrand(vehicleObject.getString(TAG_BRAND));
            }

            if (Utility.contains(vehicleObject, TAG_COMPANY)) {
                vehicle.SetCompany(vehicleObject.getString(TAG_COMPANY));
            }

            if (Utility.contains(vehicleObject, TAG_VEHICLETYPE)) {
                vehicle.SetVehicleType(TrailerTypeCode.values()[(Integer.parseInt(vehicleObject.getString(TAG_VEHICLETYPE)))]);
            }

            if (Utility.contains(vehicleObject, TAG_MODEL)) {
                vehicle.SetModel(vehicleObject.getString(TAG_MODEL));
            }

            if (Utility.contains(vehicleObject, TAG_COLOUR)) {
                vehicle.SetColour(vehicleObject.getString(TAG_COLOUR));
            }

            if (Utility.contains(vehicleObject, TAG_PLATENUMBER)) {
                vehicle.SetPlateNumber(vehicleObject.getString(TAG_PLATENUMBER));
            }

            if (Utility.contains(vehicleObject, TAG_ENGINENUMBER)) {
                vehicle.SetEngineNumber(vehicleObject.getString(TAG_ENGINENUMBER));
            }

            if (Utility.contains(vehicleObject, TAG_ISLOADED)) {
                vehicle.SetIsLoaded(vehicleObject.getBoolean(TAG_ISLOADED));
            }

            if (Utility.contains(vehicleObject, TAG_IMAGEPATHS)) {
                JSONArray jsonArray = vehicleObject.getJSONArray(TAG_IMAGEPATHS);
                int length = jsonArray.length();
                ArrayList<String> imageList = new ArrayList<>();
                for (int i = 0; i < length; i++) {
                    imageList.add(String.valueOf(jsonArray.get(i)));
                }
                vehicle.SetImagePaths(imageList.toArray(new String[imageList.size()]));
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }

        return vehicle;

    }

}
