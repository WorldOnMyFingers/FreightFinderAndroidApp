package com.example.emrebabayigit.pickoapp.Parcers;

import com.example.emrebabayigit.pickoapp.Util.Utility;
import com.example.emrebabayigit.pickoapp.models.OfferDetailsViewModel;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class OfferDetailsParcer {
    private static final String TAG_ID = "Id";
    private static final String TAG_ISACCEPTED = "IsAccepted";
    private static final String TAG_DATEACCEPTED = "DateAccepted";
    private static final String TAG_OFFERDATE = "OfferDate";
    private static final String TAG_FREIGHT = "Freight";
    private static SimpleDateFormat formatterr = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SS");

    public static OfferDetailsViewModel Parse(String jsonData) {
        OfferDetailsViewModel offerDetails = new OfferDetailsViewModel();

        if (jsonData == null) return offerDetails;

        try {
            JSONObject offerObject = new JSONObject(jsonData);

            if (Utility.contains(offerObject, TAG_ID)) {
                offerDetails.SetId(Long.parseLong(offerObject.getString(TAG_ID)));
            }

            if (Utility.contains(offerObject, TAG_ISACCEPTED)) {
                offerDetails.SetIsAccepted(offerObject.getBoolean(TAG_ISACCEPTED));
            }

            if (offerDetails.GetIsAccepted() == true && Utility.contains(offerObject, TAG_DATEACCEPTED)) {
                offerDetails.SetDateAccepted(formatterr.parse(offerObject.getString(TAG_DATEACCEPTED)));
            }

            if (Utility.contains(offerObject, TAG_OFFERDATE)) {
                offerDetails.SetOfferDate(formatterr.parse(offerObject.getString(TAG_OFFERDATE)));
            }

            if (Utility.contains(offerObject, TAG_FREIGHT)) {
                offerDetails.SetFreight(FreightParcer.parse((offerObject.getString(TAG_FREIGHT))));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return offerDetails;
    }
}
