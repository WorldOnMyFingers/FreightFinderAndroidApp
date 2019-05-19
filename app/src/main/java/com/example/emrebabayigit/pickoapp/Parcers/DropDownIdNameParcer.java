package com.example.emrebabayigit.pickoapp.Parcers;

import com.example.emrebabayigit.pickoapp.Util.Utility;
import com.example.emrebabayigit.pickoapp.models.DropDownIdNameViewModel;
import org.json.JSONException;
import org.json.JSONObject;


public class DropDownIdNameParcer {
    private static final String TAG_ID = "Id";
    private static final String TAG_NAME = "Name";


    public static DropDownIdNameViewModel Parse(String jsonData) {

        DropDownIdNameViewModel dropDownIdNameViewModel = new DropDownIdNameViewModel();

        if (jsonData == null)
            return dropDownIdNameViewModel;

        try {
            JSONObject dropDownObject = new JSONObject(jsonData);


            if (Utility.contains(dropDownObject, TAG_ID)) {
                dropDownIdNameViewModel.SetId(dropDownObject.getInt(TAG_ID));
            }
            if (Utility.contains(dropDownObject, TAG_NAME)) {
                dropDownIdNameViewModel.SetName(dropDownObject.getString(TAG_NAME));
            }



        } catch (JSONException e) {
            e.printStackTrace();
        }

        return dropDownIdNameViewModel;

    }
}
