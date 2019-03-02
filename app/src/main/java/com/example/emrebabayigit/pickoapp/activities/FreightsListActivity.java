package com.example.emrebabayigit.pickoapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
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

public class FreightsListActivity extends AppCompatActivity {

    TextView fromCity;
    TextView fromCounty;
    RvAdapter adapter;
    RequestQueue requestQueue;
    String baseUrl;
    String url;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int maxDistance = getIntent().getIntExtra("MAX_DISTANCE", 100);
        setContentView(R.layout.activity_freights_list);
        adapter = new RvAdapter(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Freight Search List");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        RecyclerView rv = (RecyclerView) findViewById(R.id.cardsRecyclerView);
        rv.setHasFixedSize(true);


        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setAdapter(adapter);

        fromCity = (TextView) findViewById(R.id.textViewFromCity);
        fromCounty = (TextView) findViewById(R.id.textViewFromCounty);
        requestQueue = CustomVolley.getInstance(this).getRequestQueue();
        baseUrl = this.getResources().getString(R.string.BaseUrl);
        url = baseUrl+"api/Freight/getfreight?lon=34.4672222&lat=39.6580556&distance="+ maxDistance;

        // Inflate the layout for this fragment
        loadFeed();
    }

/*    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent();
        intent.putExtra("tab", 3);
        setResult(RESULT_OK, intent);
        finish();
    }*/



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return true;
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
