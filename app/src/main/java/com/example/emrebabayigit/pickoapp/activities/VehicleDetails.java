package com.example.emrebabayigit.pickoapp.activities;

import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.emrebabayigit.pickoapp.Adapters.ImageSliderAdapter;
import com.example.emrebabayigit.pickoapp.Adapters.ViewPagerAdapter;
import com.example.emrebabayigit.pickoapp.Parcers.OfferParcer;
import com.example.emrebabayigit.pickoapp.Parcers.VehicleParcer;
import com.example.emrebabayigit.pickoapp.R;
import com.example.emrebabayigit.pickoapp.Volley.CustomVolley;
import com.example.emrebabayigit.pickoapp.fragments.ImageSlider;
import com.example.emrebabayigit.pickoapp.models.FreightOfferViewModel;
import com.example.emrebabayigit.pickoapp.models.VehicleViewModel;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class VehicleDetails extends AppCompatActivity {

    RequestQueue requestQueue;
    String baseUrl;
    String url;
    Context context;
    ViewPager viewPager;
    TextView plateNumber, companyName, vehicleBrand, vehicleModel, vehicleColor, engineNumber, vehicleIdentificationNumber, loaded;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_details);
        requestQueue = CustomVolley.getInstance(this).getRequestQueue();
        baseUrl = this.getResources().getString(R.string.BaseUrl);
        url = baseUrl+"api/vehicle/get?id=3";
        context = this;
        getImageList();
        Toolbar toolbar = findViewById(R.id.vehicleDetailsToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Vehicle Details");
        viewPager = findViewById(R.id.view_pager);

        plateNumber =  findViewById(R.id.textViewPlateNumber);
        companyName =  findViewById(R.id.textViewVehicleCompany);
        vehicleBrand = findViewById(R.id.textViewVehicleBrand);
        vehicleModel = findViewById(R.id.textViewModel);
        vehicleColor = findViewById(R.id.textViewVehicleColor);
        engineNumber = findViewById(R.id.textViewVehicleEngineNumber);
        vehicleIdentificationNumber =  findViewById(R.id.textViewVehicleIdentificationNumber);
        loaded = findViewById(R.id.textViewIsLoaded);

    }

    private void getImageList(){
        Log.d("ResponseUrl",url);
        StringRequest request = new StringRequest(url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        VehicleViewModel vehicle = VehicleParcer.Parse(response);
                        ArrayList<String> imageUrls = new ArrayList<String>();
                        for (String s: vehicle.ImagePaths) {
                            imageUrls.add(BuildImageUrl(s));
                        }
                        String[] array = imageUrls.toArray(new String[imageUrls.size()]);
                        ViewPagerAdapter adapter = new ViewPagerAdapter(context, array );
                        viewPager.setAdapter(adapter);
                        setVehicleDetailsTableData(vehicle);
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
        request.setTag("Images");
        requestQueue.add(request);
    }

    /*@Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed();
        } else {
            // Otherwise, select the previous step.
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }
    }*/

    private void setVehicleDetailsTableData(VehicleViewModel vehicle){
        plateNumber.setText(vehicle.GetPlateNumber());
        companyName.setText(vehicle.GetCompany());
        vehicleBrand.setText(vehicle.GetBrand());
        vehicleModel.setText(vehicle.GetModel());
        vehicleColor.setText(vehicle.GetColour());
        engineNumber.setText(vehicle.GetEngineNumber());
        vehicleIdentificationNumber.setText(vehicle.GetVehicleIdentificationNumber());
        loaded.setText(vehicle.IsLoaded ? "Yes" : "No");
    }

    private ArrayList<String> JsonToImageUrlList(String json)
    {
        ArrayList<String> imageList = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(json);
            int length = jsonArray.length();
            for(int i=0; i<length; i++)
            {
                imageList.add(String.valueOf(jsonArray.get(i)));
            }
        }catch (Exception ex)
        {
            Log.d("parcer", ex.getMessage());
        }

        return imageList;
    }

    private String BuildImageUrl(String urlEnd){
        String url = baseUrl+"api/image/get?url="+urlEnd;
        return url;
    }
}
