package com.example.emrebabayigit.pickoapp.activities;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.emrebabayigit.pickoapp.Adapters.RvAdapter;
import com.example.emrebabayigit.pickoapp.Helpers.StaticHelpers;
import com.example.emrebabayigit.pickoapp.R;
import com.example.emrebabayigit.pickoapp.Volley.CustomVolley;
import com.example.emrebabayigit.pickoapp.models.FreightViewModel;

import java.util.HashMap;
import java.util.Map;

public class FreightDetails extends AppCompatActivity {

    TextView cityFrom, countyFrom, cityTo, countyTo, freightType, weight, volume, loadingDate, dateCreated, description, deliverByDate;
    Button apply;
    FreightViewModel freight;
    RequestQueue requestQueue;
    String baseUrl, url;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_freight_details);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Freight Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Resources res = getResources();
         baseUrl = res.getString(R.string.BaseUrl);
         url = baseUrl+"api/offertofreight/post";

        requestQueue = CustomVolley.getInstance(this).getRequestQueue();
        cityFrom = (TextView)findViewById(R.id.citytextfrom);
        countyFrom = (TextView)findViewById(R.id.countytextfrom);
        cityTo = (TextView)findViewById(R.id.citytextto);
        countyTo = (TextView)findViewById(R.id.countytextto);

        freightType = (TextView)findViewById(R.id.FreightType);
        weight = (TextView)findViewById(R.id.FreightWeight);
        volume = (TextView)findViewById(R.id.FreightVolume);
        loadingDate = (TextView)findViewById(R.id.LoadingDate);
        dateCreated = (TextView)findViewById(R.id.DateCreated);
        description = (TextView)findViewById(R.id.Description);
        deliverByDate = (TextView)findViewById(R.id.DeliverByDate);


        apply = (Button) findViewById(R.id.buttonApply);
        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Apply();
            }
        });

        freight = (FreightViewModel)getIntent().getSerializableExtra("Freight");

        cityFrom.setText(freight.Address.City);
        countyFrom.setText(freight.Address.County);
        cityTo.setText(freight.DestinationAddress.City);
        countyTo.setText(freight.DestinationAddress.County);

        freightType.setText(StaticHelpers.getResourceStringByName(this, "Freight_Type_"+freight.GetFreightType().name()));
        dateCreated.setText(DateFormat.format("dd/MM/yyyy  HH:mm", freight.GetDateCreated()).toString());
        loadingDate.setText(DateFormat.format("dd/MM/yyyy", freight.GetLoadingDate()).toString());
        deliverByDate.setText(DateFormat.format("dd/MM/yyyy", freight.GetDeliverByDate()).toString());
        weight.setText(Long.toString(freight.GetIWeight()) + " Kg");
        description.setText(freight.Description);
        baseUrl = this.getResources().getString(R.string.BaseUrl);
        url = baseUrl+"api/offertofreight/post";
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return true;
    }

    private void publishToastMessage(String toastMessage){
        Context context = getApplicationContext();
        CharSequence toastText = toastMessage;
        int toastDuration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, toastText, toastDuration);
        toast.show();
    }

    private void Apply()
    {
        StringRequest postRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("Response", response);

                String resName = "OfferToFreightMessage"+response;
                int resid = getResources().getIdentifier( resName, "string", getPackageName());
                String toastText = getString(resid);
                publishToastMessage(toastText);

            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Error.Response", error.getMessage());
                    }
                })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("userid", "85a62ad2-6b32-4f75-bc4e-8e6bc81d4e00");
                params.put("freightid", Long.toString(freight.Id));

                return params;
            }
        };
        postRequest.setTag("OfferToFreight");
        requestQueue.add(postRequest);
    }
}
