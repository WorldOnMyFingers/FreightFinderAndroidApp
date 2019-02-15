package com.example.emrebabayigit.pickoapp.Helpers;

import android.content.Context;

/**
 * Created by emrebabayigit on 01/10/2017.
 */

public class StaticHelpers {





    public static String getResourceStringByName(Context context, String resourceName)
    {
        int resourceId = context.getResources().getIdentifier(resourceName, "string", "com.example.emrebabayigit.pickoapp");
        return context.getResources().getString(resourceId);
    }
}
