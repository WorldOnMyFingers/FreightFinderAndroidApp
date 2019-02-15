package com.example.emrebabayigit.pickoapp.fragments;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.emrebabayigit.pickoapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    TextView textViewStatus;

    Button mButton;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_home, container, false);
        textViewStatus = (TextView) view.findViewById(R.id.textviewStatus);
        textViewStatus.setText("merhabaret merhabaret merhabaret merhabaret merhabaret merhabaret merhabaret merhabaret merhabaretmerhabaret merhabaret merhabaret merhabaret merhabaret merhabaret");

        return view;
    }

}
