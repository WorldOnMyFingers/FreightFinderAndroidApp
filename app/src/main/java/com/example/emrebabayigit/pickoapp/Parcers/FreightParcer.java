package com.example.emrebabayigit.pickoapp.Parcers;

import com.example.emrebabayigit.pickoapp.Util.Utility;
import com.example.emrebabayigit.pickoapp.enums.FreightTypeCode;
import com.example.emrebabayigit.pickoapp.models.AddressViewModel;
import com.example.emrebabayigit.pickoapp.models.FreightViewModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by Prashanth Reddy (facebook.com/pr.amrita) (github.com/itspr)  on 1/4/2016.
 */
public class FreightParcer {
  private static final String TAG_FREIGHTS = "Freights";
  private static final String TAG_ID = "Id";
  private static final String TAG_FREIGHTTYPE = "FreightType";
  private static final String TAG_WEIGHT = "Weight";
  private static final String TAG_ISFULLVEHICLEQUANTITY = "IsFullVehicleQuantity";
  private static final String TAG_LOADINGDATE = "LoadingDate";
  private static final String TAG_DATETAKEN = "DateTaken";
  private static final String TAG_DATECREATED = "DateCreated";
  private static final String TAG_DELIVERYBYDATE = "DeliverByDate";
  private static final String TAG_UNITPRICE = "UnitPrice";
  private static final String TAG_TOTALPRICE = "TotalPrice";
  private static final String TAG_ISVATINCLUDED = "IsVatIncluded";
  private static final String TAG_ISDELIVERED = "IsDelivered";
  private static final String TAG_ISACTIVE = "IsActive";
  private static final String TAG_DESCRIPTION = "Description";
  private static final String TAG_ISTAKEN = "IsTaken";

  private static final String TAG_ADDRESS = "Address";
  private static final String TAG_DESTINATIONADDRESS = "DestinationAddress";
  private static final String TAG_LOCATION = "Location";

  private static SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
  private static SimpleDateFormat formatterr = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SS");


  public static FreightViewModel parse(String jsonData) {

    FreightViewModel freight = new FreightViewModel();

    if(jsonData==null)
      return freight;

    try {
      JSONObject freightObject = new JSONObject(jsonData);

        if (Utility.contains(freightObject, TAG_ID)) {
          freight.SetId(Long.parseLong(freightObject.getString(TAG_ID)));
        }

        if (Utility.contains(freightObject, TAG_FREIGHTTYPE)) {
          freight.SetFreightType(FreightTypeCode.values()[(Integer.parseInt(freightObject.getString(TAG_FREIGHTTYPE)))]);
        }

        if (Utility.contains(freightObject, TAG_DELIVERYBYDATE)) {
          freight.SetDeliverByDate(formatter.parse(freightObject.getString(TAG_DELIVERYBYDATE)));
        }

        if (Utility.contains(freightObject, TAG_LOADINGDATE)) {
          freight.SetLoadingDate(formatter.parse(freightObject.getString(TAG_LOADINGDATE)));
        }

       if (Utility.contains(freightObject, TAG_DATECREATED)) {
        freight.SetDateCreated(formatterr.parse(freightObject.getString(TAG_DATECREATED)));
       }


      if (Utility.contains(freightObject, TAG_ISACTIVE)) {
          freight.SetIsActive(freightObject.getBoolean(TAG_ISACTIVE));
        }
        if (Utility.contains(freightObject, TAG_ISDELIVERED)) {
          freight.SetIsDelivered(freightObject.getBoolean(TAG_ISDELIVERED));
        }
        if (Utility.contains(freightObject, TAG_ISFULLVEHICLEQUANTITY)) {
          freight.SetIsFullVehicleQuantity(freightObject.getBoolean(TAG_ISFULLVEHICLEQUANTITY));
        }

        if (Utility.contains(freightObject, TAG_ISVATINCLUDED)) {
          freight.SetIsVatIncluded(freightObject.getBoolean(TAG_ISVATINCLUDED));
        }

        if (Utility.contains(freightObject, TAG_ISTAKEN)) {
          freight.SetIsTaken(freightObject.getBoolean(TAG_ISTAKEN));
        }

        if (Utility.contains(freightObject, TAG_WEIGHT)) {
          freight.SetWeight(freightObject.getInt(TAG_WEIGHT));
        }

        if (Utility.contains(freightObject, TAG_TOTALPRICE)) {
          freight.SetTotalPrice(Integer.parseInt(freightObject.getString(TAG_TOTALPRICE)));
        }

        if (Utility.contains(freightObject, TAG_UNITPRICE)) {
          freight.SetUnitPrice(Integer.parseInt(freightObject.getString(TAG_UNITPRICE)));
        }

        if (Utility.contains(freightObject, TAG_ADDRESS)) {
          freight.SetAddress(AddressParcer.parse((freightObject.getString(TAG_ADDRESS))));
        }

        if (Utility.contains(freightObject, TAG_DESTINATIONADDRESS)) {
          freight.SetDestinationAddress(AddressParcer.parse((freightObject.getString(TAG_DESTINATIONADDRESS))));
        }

        if (Utility.contains(freightObject, TAG_LOCATION)) {
          freight.SetLocation(LocationParcer.parse((freightObject.getString(TAG_LOCATION))));
        }
    }

    catch (JSONException e) {
      e.printStackTrace();
    } catch (ParseException e) {
      e.printStackTrace();
    }

    return freight;
  }

}

