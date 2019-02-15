package com.example.emrebabayigit.pickoapp.Parcers;

import android.content.Context;
import android.content.res.Resources;

import com.example.emrebabayigit.pickoapp.R;
import com.example.emrebabayigit.pickoapp.Util.Utility;
import com.example.emrebabayigit.pickoapp.enums.FreightTypeCode;
import com.example.emrebabayigit.pickoapp.models.FreightOfferViewModel;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by ebabayigit on 01/07/2018.
 */

public class OfferParcer {
    static Context _context;

    private static final String TAG_OFFERID = "OfferId";
    private static final String TAG_FREIGHTID = "FreightId";
    private static final String TAG_OFFERDATE = "OfferDate";
    private static final String TAG_ISACCEPTED = "IsAccepted";
    private static final String TAG_DATEACCEPTED= "DateAccepted";
    private static final String TAG_FROM = "From";
    private static final String TAG_TO = "To";
    private static final String TAG_WEIGHT = "Weight";
    private static final String TAG_PRICE = "Price";
    private static final String TAG_FREIGHTTYPE = "FreightType";

    private static SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
    private static SimpleDateFormat formatterr = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SS");

    public static FreightOfferViewModel Parse(String jsonData, Context context){
        _context = context;
        FreightOfferViewModel offer = new FreightOfferViewModel();

        if(jsonData==null) return offer;

        try{
            JSONObject offerObject = new JSONObject(jsonData);

            if (Utility.contains(offerObject, TAG_OFFERID)) {
                offer.SetOfferId(Long.parseLong(offerObject.getString(TAG_OFFERID)));

            }

            if (Utility.contains(offerObject, TAG_FREIGHTID)) {
                offer.SetFreightId(Long.parseLong(offerObject.getString(TAG_FREIGHTID)));

            }

            if (Utility.contains(offerObject, TAG_WEIGHT)) {
                offer.SetWeight(offerObject.getString(TAG_WEIGHT));
            }

            if (Utility.contains(offerObject, TAG_PRICE)) {
                offer.SetPrice(_context.getResources().getString(R.string.Currency) +offerObject.getString(TAG_PRICE));
            }

            if (Utility.contains(offerObject, TAG_FROM)) {
                offer.SetFrom(offerObject.getString(TAG_FROM));
            }

            if (Utility.contains(offerObject, TAG_TO)) {
                offer.SetTo(offerObject.getString(TAG_TO));
            }

            if (Utility.contains(offerObject, TAG_ISACCEPTED)) {
                offer.SetIsAccepted(offerObject.getBoolean(TAG_ISACCEPTED));
            }

            if (Utility.contains(offerObject, TAG_DATEACCEPTED)) {
                offer.SetDateAccepted(formatterr.parse(offerObject.getString(TAG_DATEACCEPTED)));
            }

            if (Utility.contains(offerObject, TAG_OFFERDATE)) {
                offer.SetOfferDate(formatterr.parse(offerObject.getString(TAG_OFFERDATE)));
            }

            if (Utility.contains(offerObject, TAG_FREIGHTTYPE)) {
                offer.SetFreightType(FreightTypeCode.values()[(Integer.parseInt(offerObject.getString(TAG_FREIGHTTYPE)))]);
            }
        }catch (JSONException e) {
            e.printStackTrace();
        }catch (ParseException e) {
            e.printStackTrace();
        }

        return offer;
    }
}
