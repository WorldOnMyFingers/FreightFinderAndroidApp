package com.example.emrebabayigit.pickoapp.fragments;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.emrebabayigit.pickoapp.Adapters.FreightOfferAdapter;
import com.example.emrebabayigit.pickoapp.Parcers.FreightParcer;
import com.example.emrebabayigit.pickoapp.Parcers.OfferParcer;
import com.example.emrebabayigit.pickoapp.R;
import com.example.emrebabayigit.pickoapp.Volley.CustomVolley;
import com.example.emrebabayigit.pickoapp.enums.FreightTypeCode;
import com.example.emrebabayigit.pickoapp.models.FreightOfferViewModel;
import com.example.emrebabayigit.pickoapp.models.FreightViewModel;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyOffersFragment extends Fragment {

    FreightOfferAdapter adapter;
    RequestQueue requestQueue;
    String baseUrl;
    String url;



    public MyOffersFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new FreightOfferAdapter(this.getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recyclerview, container, false);
        RecyclerView rv = (RecyclerView) view.findViewById(R.id.cardsRecyclerView);
        rv.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(llm);
        rv.setAdapter(adapter);
        requestQueue = CustomVolley.getInstance(getActivity()).getRequestQueue();
        baseUrl = this.getResources().getString(R.string.BaseUrl);
        url = baseUrl+"api/offertofreight/myoffers?vehiclePlateNumber=66LA442";

        //adapter.set(mockOffer());
        loadOffers();

        return view;
    }

    private ArrayList<FreightOfferViewModel> mockOffer(){
        ArrayList<FreightOfferViewModel> arrayList = new ArrayList<>();
        arrayList.add(new FreightOfferViewModel(1,2, Calendar.getInstance().getTime(), true, true, null,
                "Dublin", "London", "4500 KG", "1800 GBP", FreightTypeCode.values()[(Integer.parseInt("0"))]));
        arrayList.add(new FreightOfferViewModel(1,2, Calendar.getInstance().getTime(), true, false, null,
                "Cork", "London", "3500 KG", "1800 GBP", FreightTypeCode.values()[(Integer.parseInt("0"))]));
        arrayList.add(new FreightOfferViewModel(1,2, Calendar.getInstance().getTime(), true, false, null,
                "Wexford", "London", "9500 KG", "1800 GBP", FreightTypeCode.values()[(Integer.parseInt("0"))]));
        arrayList.add(new FreightOfferViewModel(1,2, Calendar.getInstance().getTime(), true, false, null,
                "Galway", "London", "1500 KG", "1800 GBP", FreightTypeCode.values()[(Integer.parseInt("0"))]));

        return arrayList;
    }

    private void loadOffers(){
        Log.d("ResponseUrl",url);
        StringRequest request = new StringRequest(url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        adapter.set(GetOfferArray(response));
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Log.d("Response", String.valueOf(error));
                        //Snackbar.make(root, "Slow OR Bad Internet Connection", Snackbar.LENGTH_LONG)
                        //    .setAction("Action", null).show();
                        Toast.makeText(getActivity(), "Slow OR Bad Internet Connection", Toast.LENGTH_SHORT).show();
                        //Snackbar.make(root, "Something went wrong", Snackbar.LENGTH_SHORT);
                    }
                });
        int socketTimeout = 30000;//30 seconds - change to what you want
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        request.setRetryPolicy(policy);
        request.setTag("Offers");
        requestQueue.add(request);
    }

    private ArrayList<FreightOfferViewModel> GetOfferArray(String json)
    {
        ArrayList<FreightOfferViewModel> offerList = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(json);
            int length = jsonArray.length();
            for(int i=0; i<length; i++)
            {
                JSONObject item = jsonArray.getJSONObject(i);
                FreightOfferViewModel offer = OfferParcer.Parse(item.toString(), this.getContext());
                offerList.add(offer);
            }
        }catch (Exception ex)
        {
            Log.d("parcer", ex.getMessage());
        }

        return offerList;
    }

}
