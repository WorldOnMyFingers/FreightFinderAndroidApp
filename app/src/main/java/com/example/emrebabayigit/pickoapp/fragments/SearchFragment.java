package com.example.emrebabayigit.pickoapp.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.emrebabayigit.pickoapp.Adapters.RvAdapter;
import com.example.emrebabayigit.pickoapp.Parcers.FreightParcer;
import com.example.emrebabayigit.pickoapp.R;
import com.example.emrebabayigit.pickoapp.Volley.CustomVolley;
import com.example.emrebabayigit.pickoapp.models.FreightViewModel;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment {

    TextView fromCity;
    TextView fromCounty;
    RvAdapter adapter;
    RequestQueue requestQueue;
    String baseUrl;
    String url;

    public SearchFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //adapter = new RvAdapter(getFreights());
        adapter = new RvAdapter(this.getContext());

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

        fromCity = (TextView) view.findViewById(R.id.textViewFromCity);
        fromCounty = (TextView) view.findViewById(R.id.textViewFromCounty);
        requestQueue = CustomVolley.getInstance(getActivity()).getRequestQueue();
        baseUrl = this.getResources().getString(R.string.BaseUrl);
        url = baseUrl+"api/Freight/getfreight?lon=34.4672222&lat=39.6580556&distance=12200";

        // Inflate the layout for this fragment
        loadFeed();


        return view;
    }

    private void loadFeed(){

        Log.d("Resopnceurl",url);
        StringRequest request = new StringRequest(url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        adapter.set(GetFreightArray(response));
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Log.d("Responce", String.valueOf(error));
                        //Snackbar.make(root, "Slow OR Bad Internet Connection", Snackbar.LENGTH_LONG)
                        //    .setAction("Action", null).show();
                        Toast.makeText(getActivity(), "Slow OR Bad Internet Connection", Toast.LENGTH_SHORT).show();
                        //Snackbar.make(root, "Something went wrong", Snackbar.LENGTH_SHORT);
                    }
                });
        int socketTimeout = 30000;//30 seconds - change to what you want
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        request.setRetryPolicy(policy);
        request.setTag("Freights");
        requestQueue.add(request);
    }

    private ArrayList<FreightViewModel> GetFreightArray(String json)
    {
        ArrayList<FreightViewModel> freightList = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(json);
            int length = jsonArray.length();
            for(int i=0; i<length; i++)
            {
                JSONObject item = jsonArray.getJSONObject(i);
                FreightViewModel freight = FreightParcer.parse(item.toString());
                freightList.add(freight);
            }
        }catch (Exception ex)
        {
            Log.d("parcer", ex.getMessage());
        }

        return freightList;
    }

}
