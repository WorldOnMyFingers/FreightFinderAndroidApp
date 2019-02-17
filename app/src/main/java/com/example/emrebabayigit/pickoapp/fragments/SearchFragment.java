package com.example.emrebabayigit.pickoapp.fragments;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import com.example.emrebabayigit.pickoapp.R;
import com.example.emrebabayigit.pickoapp.activities.FreightsListActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment {

    SeekBar seekbar;
    TextView seekbarValue;
    String[] list;
    Spinner spinner;
    Button button;

    public SearchFragment() {
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
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        seekbar = (SeekBar) view.findViewById(R.id.seekBar);
        seekbarValue = (TextView) view.findViewById(R.id.seekbarValue);

        seekbarValue.setText(String.valueOf(seekbar.getProgress()));

        button = (Button) view.findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = getActivity().getApplicationContext();
                Intent intent = new Intent(context, FreightsListActivity.class);
                startActivityForResult(intent, 1);
            }
        });

        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekbarValue.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        return view;
    }



}
