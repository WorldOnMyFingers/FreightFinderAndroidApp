package com.example.emrebabayigit.pickoapp.Util;

import android.net.Uri;

import org.json.JSONObject;

/**
 * Created by Prashanth Reddy (facebook.com/pr.amrita) (github.com/itspr)  on 04-01-2016.
 */
public class Utility {

    public static boolean contains(JSONObject jsonObject, String key) {
        return jsonObject != null && jsonObject.has(key) && !jsonObject.isNull(key) ? true : false;
    }
}
