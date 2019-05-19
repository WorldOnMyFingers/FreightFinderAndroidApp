package com.example.emrebabayigit.pickoapp.Parcers;

import com.example.emrebabayigit.pickoapp.Util.Utility;
import com.example.emrebabayigit.pickoapp.models.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class UserParcer {
    private static final String TAG_ID = "Id";
    private static final String TAG_NATIONALIDENTITY = "NationalIdentity";
    private static final String TAG_USERNAME = "Username";
    private static final String TAG_NAME = "Name";
    private static final String TAG_SURENAME = "Surename";
    private static final String TAG_MOBILE = "Mobile";
    private static final String TAG_EMAIL = "Email";
    private static final String TAG_DATEOFBIRTH = "DateOfBirth";
    private static final String TAG_IMAGEPATHS = "ImagePaths";

    private static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    public static User Parse(String jsonData) {

        User user = new User();

        if (jsonData == null)
            return user;

        try {
            JSONObject userObject = new JSONObject(jsonData);


            if (Utility.contains(userObject, TAG_ID)) {
                user.SetId(userObject.getString(TAG_ID));
            }
            if (Utility.contains(userObject, TAG_NATIONALIDENTITY)) {
                user.SetNationalIdentity(userObject.getLong(TAG_NATIONALIDENTITY));
            }

            if (Utility.contains(userObject, TAG_USERNAME)) {
                user.SetUserName(userObject.getString(TAG_USERNAME));
            }

            if (Utility.contains(userObject, TAG_NAME)) {
                user.SetName(userObject.getString(TAG_NAME));
            }

            if (Utility.contains(userObject, TAG_SURENAME)) {
                user.SetSurname(userObject.getString(TAG_SURENAME));
            }

            if (Utility.contains(userObject, TAG_MOBILE)) {
                user.SetMobile(userObject.getString(TAG_MOBILE));
            }

            if (Utility.contains(userObject, TAG_EMAIL)) {
                user.SetEmail(userObject.getString(TAG_EMAIL));
            }

            if (Utility.contains(userObject, TAG_DATEOFBIRTH)) {
                user.SetDateOfBirth(formatter.parse(userObject.getString(TAG_DATEOFBIRTH)));
            }


            if (Utility.contains(userObject, TAG_IMAGEPATHS)) {
                JSONArray jsonArray = userObject.getJSONArray(TAG_IMAGEPATHS);
                int length = jsonArray.length();
                ArrayList<String> imageList = new ArrayList<>();
                for (int i = 0; i < length; i++) {
                    imageList.add(String.valueOf(jsonArray.get(i)));
                }
                user.SetImagePaths(imageList.toArray(new String[imageList.size()]));
            }


        } catch (JSONException e) {
            e.printStackTrace();
        } catch (
                ParseException e) {
            e.printStackTrace();
        }

        return user;

    }
}
