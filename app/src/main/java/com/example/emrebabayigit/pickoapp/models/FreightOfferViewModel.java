package com.example.emrebabayigit.pickoapp.models;

import com.example.emrebabayigit.pickoapp.enums.FreightTypeCode;

import java.util.Date;

/**
 * Created by ebabayigit on 22/05/2018.
 */

public class FreightOfferViewModel {

    public long OfferId ;
    public long FreightId ;
    public Date OfferDate ;
    public boolean IsAccepted ;
    public boolean IsTheFreightTaken;
    public Date DateAccepted ;
    public String From ;
    public String To ;
    public String Weight ;
    public String Price ;
    public FreightTypeCode FreightType;


    public FreightOfferViewModel(){}
    public FreightOfferViewModel(int offerId, long freightId, Date offerDate, boolean isAccepted, boolean isTheFreightTaken, Date dateAccepted,
                                 String from, String to, String weight, String price, FreightTypeCode freightType){
        OfferId = offerId;
        FreightId = freightId;
        OfferDate = offerDate;
        IsAccepted = isAccepted;
        IsTheFreightTaken = isTheFreightTaken;
        DateAccepted = dateAccepted;
        From = from;
        To = to;
        Weight = weight;
        Price = price;
        FreightType = freightType;
    }

    public long GetOfferId(){return OfferId;}
    public long GetFreightId(){return FreightId;}
    public Date GetOfferDate(){return OfferDate;}
    public boolean GetIsAccepted(){return IsAccepted;}
    public boolean GetIsTheFreightTaken(){return IsTheFreightTaken;}
    public Date GetDateAccepted(){return DateAccepted;}
    public String GetFrom(){return From;}
    public String GetTo(){return To;}
    public String GetWeight(){return Weight;}
    public String GetPrice(){return Price;}
    public FreightTypeCode GetFreightType(){return FreightType;}

    public void SetOfferId(long offerId){
        OfferId = offerId;
    }

    public void SetFreightId(long freightId){
        FreightId = freightId;
    }

    public void SetOfferDate(Date offerDate){
        OfferDate = offerDate;
    }

    public void SetIsAccepted(boolean isAccepted){
        IsAccepted = isAccepted;
    }

    public void SetIsTheFreightTaken(boolean isTheFreightTaken){ IsTheFreightTaken = isTheFreightTaken; }

    public void SetDateAccepted(Date dateAccepted){
        DateAccepted = dateAccepted;
    }

    public void SetFrom(String from){
        From = from;
    }

    public void SetTo(String to){
        To = to;
    }

    public void SetFreightType(FreightTypeCode freightTypeCode){FreightType = freightTypeCode;}

    public void SetWeight(String weight){Weight = weight;}

    public void SetPrice(String price){Price = price;}

}
