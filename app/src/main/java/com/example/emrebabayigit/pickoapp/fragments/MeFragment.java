package com.example.emrebabayigit.pickoapp.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.emrebabayigit.pickoapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MeFragment extends Fragment {
    View vehicleDetails;
    View personalDetails;
    View settings;


    public MeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_me, container, false);
        vehicleDetails = (View) view.findViewById(R.id.viewVehicleDetails);
        personalDetails = (View) view.findViewById(R.id.viewPersonalDetails);
        settings = (View) view.findViewById(R.id.viewSettings);

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        personalDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        vehicleDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        return view;
    }

}
