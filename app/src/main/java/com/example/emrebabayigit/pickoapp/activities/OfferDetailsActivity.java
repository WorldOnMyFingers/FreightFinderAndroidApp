package com.example.emrebabayigit.pickoapp.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.format.DateFormat;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.emrebabayigit.pickoapp.Helpers.StaticHelpers;
import com.example.emrebabayigit.pickoapp.Parcers.FreightParcer;
import com.example.emrebabayigit.pickoapp.Parcers.OfferDetailsParcer;
import com.example.emrebabayigit.pickoapp.Parcers.OfferParcer;
import com.example.emrebabayigit.pickoapp.R;
import com.example.emrebabayigit.pickoapp.Volley.CustomVolley;
import com.example.emrebabayigit.pickoapp.models.FreightOfferViewModel;
import com.example.emrebabayigit.pickoapp.models.OfferDetailsViewModel;

public class OfferDetailsActivity extends AppCompatActivity {

    TextView cityFrom, countyFrom, cityTo, countyTo, vehicleType, freightType, weight, volume, loadingDate, dateCreated, description, deliverByDate;
    TextView offerDate, status, dateAccepted;
    TextView addressline, district, county, city, country;
    String baseUrl, url;
    RequestQueue requestQueue;
    OfferDetailsViewModel offerDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer_details);

        requestQueue = CustomVolley.getInstance(this).getRequestQueue();
        baseUrl = this.getResources().getString(R.string.BaseUrl);
        Intent intent = getIntent();
        Long offerId = intent.getLongExtra("OfferId", -1);
        url = baseUrl + "api/Offertofreight/getoffer?offerid=" + offerId;


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getString(R.string.label_offer_details));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        cityFrom = (TextView) findViewById(R.id.citytextfrom);
        countyFrom = (TextView) findViewById(R.id.countytextfrom);
        cityTo = (TextView) findViewById(R.id.citytextto);
        countyTo = (TextView) findViewById(R.id.countytextto);
        vehicleType = (TextView) findViewById(R.id.VehicleType);
        freightType = (TextView) findViewById(R.id.FreightType);
        weight = (TextView) findViewById(R.id.FreightWeight);
        volume = (TextView) findViewById(R.id.FreightVolume);
        loadingDate = (TextView) findViewById(R.id.LoadingDate);
        dateCreated = (TextView) findViewById(R.id.DateCreated);
        description = (TextView) findViewById(R.id.Description);
        deliverByDate = (TextView) findViewById(R.id.DeliverByDate);

        offerDate = (TextView) findViewById(R.id.textViewOfferDateAndTime);
        status = (TextView) findViewById(R.id.textViewStatus);
        dateAccepted = (TextView) findViewById(R.id.textViewDateAccepted);

        addressline = (TextView) findViewById(R.id.textViewAddressLine);
        district = (TextView) findViewById(R.id.textViewDistrict);
        county = (TextView) findViewById(R.id.textViewCounty);
        city = (TextView) findViewById(R.id.textViewCity);
        country = (TextView) findViewById(R.id.textViewCountry);

        getOffer();

    }

    private void SetUI(){
        cityFrom.setText(offerDetails.Freight.Address.City);
        countyFrom.setText(offerDetails.Freight.Address.County);
        cityTo.setText(offerDetails.Freight.DestinationAddress.City);
        countyTo.setText(offerDetails.Freight.DestinationAddress.County);
        freightType.setText(StaticHelpers.getResourceStringByName(this, "Freight_Type_"+offerDetails.Freight.GetFreightType().name()));
        dateCreated.setText(DateFormat.format("dd/MM/yyyy  HH:mm", offerDetails.Freight.GetDateCreated()).toString());
        loadingDate.setText(DateFormat.format("dd/MM/yyyy", offerDetails.Freight.GetLoadingDate()).toString());
        deliverByDate.setText(DateFormat.format("dd/MM/yyyy", offerDetails.Freight.GetDeliverByDate()).toString());
        weight.setText(Long.toString(offerDetails.Freight.GetIWeight()) + " Kg");
        description.setText(offerDetails.Freight.Description);

        offerDate.setText(offerDetails.GetOfferDate().toString());
        if(offerDetails.IsAccepted == true){
            dateAccepted.setText(offerDetails.GetDateAccepted().toString());
        }else{
            dateAccepted.setText(null);
        }
        if(offerDetails.Freight.IsTaken == true && offerDetails.IsAccepted == true){
            status.setText(getResources().getText(R.string.freight_offer_status_accepted));
        }else if(offerDetails.Freight.IsTaken == true && offerDetails.IsAccepted == false) {
            status.setText(getResources().getText(R.string.freight_offer_status_rejected));
        }else if(offerDetails.Freight.IsTaken == false && offerDetails.IsAccepted == false){
            status.setText(getResources().getText(R.string.freight_offer_status_pending));
        }

        addressline.setText(offerDetails.Freight.Address.AddressLine);
        district.setText(offerDetails.Freight.Address.District);
        county.setText(offerDetails.Freight.Address.County);
        city.setText(offerDetails.Freight.Address.City);
        country.setText(offerDetails.Freight.Address.Country);

    }

    private void getOffer() {
        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                offerDetails = OfferDetailsParcer.Parse(response);
                SetUI();
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Log.d("Response", String.valueOf(error));
                        //Snackbar.make(root, "Slow OR Bad Internet Connection", Snackbar.LENGTH_LONG)
                        //    .setAction("Action", null).show();
                        Toast.makeText(getApplicationContext(), "Slow OR Bad Internet Connection", Toast.LENGTH_SHORT).show();
                        //Snackbar.make(root, "Something went wrong", Snackbar.LENGTH_SHORT);
                    }
                });
        int socketTimeout = 30000;//30 seconds - change to what you want
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        request.setRetryPolicy(policy);
        request.setTag("Freights");
        requestQueue.add(request);
    }
}
