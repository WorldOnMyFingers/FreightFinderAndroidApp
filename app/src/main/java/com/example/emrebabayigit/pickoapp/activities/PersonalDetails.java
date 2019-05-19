package com.example.emrebabayigit.pickoapp.activities;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.emrebabayigit.pickoapp.Adapters.ViewPagerAdapter;
import com.example.emrebabayigit.pickoapp.Parcers.DropDownIdNameParcer;
import com.example.emrebabayigit.pickoapp.Parcers.OfferParcer;
import com.example.emrebabayigit.pickoapp.Parcers.UserParcer;
import com.example.emrebabayigit.pickoapp.Parcers.VehicleParcer;
import com.example.emrebabayigit.pickoapp.R;
import com.example.emrebabayigit.pickoapp.Volley.CustomVolley;
import com.example.emrebabayigit.pickoapp.models.DropDownIdNameViewModel;
import com.example.emrebabayigit.pickoapp.models.FreightOfferViewModel;
import com.example.emrebabayigit.pickoapp.models.User;
import com.example.emrebabayigit.pickoapp.models.VehicleViewModel;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class PersonalDetails extends AppCompatActivity {

    RequestQueue requestQueue;
    String baseUrl;
    String url;
    Context context;
    ViewPager viewPager;
    //TextView fullName, email, mobile, address, birthDate;
    EditText name, surname, email, phone, addressline;
    Spinner countrySpinner, citySpinner, countySpinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_details);
        requestQueue = CustomVolley.getInstance(this).getRequestQueue();
        baseUrl = this.getResources().getString(R.string.BaseUrl);
        url = baseUrl+"api/user/get?id=85a62ad2-6b32-4f75-bc4e-8e6bc81d4e00";
        context = this;
        getImageList();
        Toolbar toolbar = findViewById(R.id.personalDetailsToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Personal Details");
        viewPager = findViewById(R.id.view_pager);

//        fullName = findViewById(R.id.textViewFullName);
//        email = findViewById(R.id.textViewEmail);
//        mobile = findViewById(R.id.textViewPhoneNumber);
//        address = findViewById(R.id.textViewAddress);
//        birthDate = findViewById(R.id.textViewBirthday);

        name = findViewById(R.id.userTextEditName);
        surname = findViewById(R.id.userTextEditSurname);
        email = findViewById(R.id.userTextEditEmail);
        phone = findViewById(R.id.userTextEditPhone);
        addressline = findViewById(R.id.textEditAddresLine);
        countrySpinner = findViewById(R.id.spinnerAddressCountry);
        citySpinner = findViewById(R.id.spinnerAddressCity);
        countySpinner = findViewById(R.id.spinnerAddressCounty);

        //Creating the ArrayAdapter instance having the bank name list

    }

    private void getImageList(){
        Log.d("ResponseUrl",url);
        StringRequest request = new StringRequest(url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        User user = UserParcer.Parse(response);
                        ArrayList<String> imageUrls = new ArrayList<String>();
                        for (String s: user.ImagePaths) {
                            imageUrls.add(BuildImageUrl(s));
                        }
                        String[] array = imageUrls.toArray(new String[imageUrls.size()]);
                        ViewPagerAdapter adapter = new ViewPagerAdapter(context, array );
                        viewPager.setAdapter(adapter);
                        setUserDetailsTableData(user);
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

    private void setUserDetailsTableData(User user){
//        fullName.setText(user.GetName()+" "+ user.GetSurname());
//        email.setText(user.GetEmail());
//        mobile.setText(user.GetMobile());
//        birthDate.setText(user.GetDateOfBirth().toString());
//        birthDate.setText(DateFormat.format("dd/MM/yyyy", user.GetDateOfBirth()).toString());

        name.setText(user.GetName());
        surname.setText(user.GetSurname());
        email.setText(user.GetEmail());
        phone.setText(user.GetMobile());
    }

    private String BuildImageUrl(String urlEnd){
        String url = baseUrl+"api/image/get?url="+urlEnd;
        return url;
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

    private void GetCountryDropDownData(){
        Log.d("ResponseUrl",url);
        StringRequest request = new StringRequest(url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
//                        ArrayList<DropDownIdNameViewModel> list = GetDropDownViewModelArray(response);
//                        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,list.);
//                        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//                        countrySpinner.setAdapter(arrayAdapter);
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
        request.setTag("Countries");
        requestQueue.add(request);
    }

    private ArrayList<DropDownIdNameViewModel> GetDropDownViewModelArray(String json)
    {
        ArrayList<DropDownIdNameViewModel> dropDownList = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(json);
            int length = jsonArray.length();
            for(int i=0; i<length; i++)
            {
                JSONObject item = jsonArray.getJSONObject(i);
                DropDownIdNameViewModel dropDown = DropDownIdNameParcer.Parse(item.toString());
                dropDownList.add(dropDown);
            }
        }catch (Exception ex)
        {
            Log.d("parcer", ex.getMessage());
        }

        return dropDownList;
    }

}
