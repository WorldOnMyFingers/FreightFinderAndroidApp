package com.example.emrebabayigit.pickoapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.emrebabayigit.pickoapp.Helpers.StaticHelpers;
import com.example.emrebabayigit.pickoapp.R;
import com.example.emrebabayigit.pickoapp.activities.FreightDetails;
import com.example.emrebabayigit.pickoapp.activities.MainActivity;
import com.example.emrebabayigit.pickoapp.fragments.SearchFragment;
import com.example.emrebabayigit.pickoapp.models.FreightViewModel;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by emrebabayigit on 11/06/2017.
 */

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.FreightViewHolder> {

    Context _context;

    public static class FreightViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        TextView fromCity;
        TextView fromCounty;
        TextView priceLabel;
        TextView toCity;
        TextView toCounty;
        TextView freightType;
        TextView trailerType;
        TextView weight;
        TextView dateCreated;
        Button buttonDetails;

        private FreightViewModel freightObject;


        public FreightViewHolder(View itemView) {
            super(itemView);
            freightObject = null;
            cv = (CardView) itemView.findViewById(R.id.cardView);
            fromCity = (TextView) itemView.findViewById(R.id.textViewFromCity);
            fromCounty = (TextView) itemView.findViewById(R.id.textViewFromCounty);
            priceLabel = (TextView) itemView.findViewById(R.id.textViewPriceRectangle);
            toCity = (TextView) itemView.findViewById(R.id.textViewToCity);
            toCounty = (TextView) itemView.findViewById(R.id.textViewToCounty);
            freightType = (TextView) itemView.findViewById(R.id.textViewFreightType);
            trailerType = (TextView) itemView.findViewById(R.id.textViewTrailerType);
            weight = (TextView) itemView.findViewById(R.id.textViewWeight);
            dateCreated = (TextView) itemView.findViewById(R.id.datecreated);
            buttonDetails = (Button) itemView.findViewById(R.id.buttonDetails);

            buttonDetails.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(cv.getContext(), FreightDetails.class);
                    intent.putExtra("Freight", freightObject);
                    cv.getContext().startActivity(intent);
                }
            });

        }
    }

    public void set(ArrayList<FreightViewModel> data) {
        freights = data;
        notifyDataSetChanged();
    }

    List<FreightViewModel> freights;

    public RvAdapter(List<FreightViewModel> freights) {
        this.freights = freights;
        notifyDataSetChanged();
    }

    public RvAdapter(Context context) {
        this.freights = new ArrayList<FreightViewModel>();
        _context = context;
    }

    public void add(ArrayList<FreightViewModel> data) {
        for (FreightViewModel info : data) {
            freights.add(info);
        }

        notifyDataSetChanged();
    }



    @Override
    public FreightViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_freight_ad_card, parent, false);
        FreightViewHolder fvh = new FreightViewHolder(v);

        return fvh;
    }

    @Override
    public void onBindViewHolder(FreightViewHolder holder, int position) {
        FreightViewModel freight = freights.get(position);
        holder.freightObject = freight;
        holder.fromCounty.setText(freight.GetAddress().GetCounty());
        holder.fromCity.setText(freight.GetAddress().GetCity());
        holder.dateCreated.setText(DateFormat.format("dd/MM/yyyy  HH:mm", freight.GetDateCreated()).toString());
        holder.toCity.setText(freight.GetDestinationAddress().GetCity());
        holder.toCounty.setText(freight.GetDestinationAddress().GetCounty());
        holder.weight.setText(Long.toString(freight.GetIWeight()) + " Kg");
        holder.freightType.setText(StaticHelpers.getResourceStringByName(_context, "Freight_Type_"+freight.GetFreightType().name()));
//        holder.trailerType.setText(StaticHelpers.getResourceStringByName(_context, "Trailer_Type_"+freight.GetTrailerType().name()));

        if(freight.GetTotalPrice() > 0)
        {
            holder.priceLabel.setText(_context.getResources().getString(R.string.Currency) + Double.toString(freight.GetTotalPrice()));
        }
        if(freight.GetUnitPrice() > 0)
        {
            holder.priceLabel.setText(_context.getResources().getString(R.string.Currency) + Double.toString(freight.GetUnitPrice()));
        }


    }

    @Override
    public int getItemCount() {
        return freights.size();
    }

}
