package com.example.emrebabayigit.pickoapp.models;

import java.util.Date;

public class OfferDetailsViewModel {
    public long Id;
    public Date DateAccepted;
    public Date OfferDate;
    public boolean IsAccepted;
    public FreightViewModel Freight;

    public long GetId(){
        return Id;
    }

    public Date GetDateAccepted(){
        return DateAccepted;
    }
    public Date GetOfferDate(){
        return OfferDate;
    }

    public boolean GetIsAccepted(){
        return IsAccepted;
    }

    public FreightViewModel GetFreight(){
        return Freight;
    }

    public void SetId(long id){
        Id = id;
    }

    public void SetDateAccepted(Date dateAccepted){
        DateAccepted = dateAccepted;
    }

    public void SetOfferDate(Date offerDate){
        OfferDate = offerDate;
    }

    public void SetIsAccepted(boolean isAccepted){
        IsAccepted = isAccepted;
    }

    public void SetFreight(FreightViewModel freight){
        Freight = freight;
    }
}
