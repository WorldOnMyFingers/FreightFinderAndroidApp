package com.example.emrebabayigit.pickoapp.fragments;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.emrebabayigit.pickoapp.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewPickoFragment extends Fragment {

    EditText editText;

    public NewPickoFragment() {
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


        View view =  inflater.inflate(R.layout.fragment_new_picko, container, false);
        editText = (EditText) view.findViewById(R.id.descriptionText);
        SharedPreferences settings = this.getActivity().getSharedPreferences("PREFS", 0);
        editText.setText(settings.getString("value", ""));

        return view;
    }



}
