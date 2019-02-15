package com.example.emrebabayigit.pickoapp.Adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.emrebabayigit.pickoapp.Helpers.StaticHelpers;
import com.example.emrebabayigit.pickoapp.R;
import com.example.emrebabayigit.pickoapp.models.FreightOfferViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ebabayigit on 22/05/2018.
 */

public class FreightOfferAdapter extends RecyclerView.Adapter<FreightOfferAdapter.FreightOfferViewHolder> {

    Context _context;
    private List<FreightOfferViewModel> offers;

    public FreightOfferAdapter(Context context) {
        this.offers = new ArrayList<FreightOfferViewModel>();
        _context = context;
    }

    public void set (List<FreightOfferViewModel> offerList)
    {
        offers = offerList;
        notifyDataSetChanged();
    }

    @Override
    public FreightOfferViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.freight_offer_card, parent, false);
        FreightOfferViewHolder viewHolder = new FreightOfferViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(FreightOfferViewHolder holder, int position) {
        FreightOfferViewModel offer = offers.get(position);
        holder.offerObject = offer;
        holder.fromCity.setText(offer.GetFrom());
        holder.toCity.setText(offer.GetTo());
        holder.weight.setText(offer.GetWeight()+ " Kg");
        holder.freightType.setText(StaticHelpers.getResourceStringByName(_context, "Freight_Type_"+offer.GetFreightType().name()));
        holder.price.setText(offer.GetPrice());

    }

    @Override
    public int getItemCount() {
        return offers.size();
    }

    public static class FreightOfferViewHolder extends RecyclerView.ViewHolder{

        CardView cv;
        TextView fromCity;
        TextView price;
        TextView toCity;
        TextView freightType;
        TextView weight;

        FreightOfferViewModel offerObject;

        public FreightOfferViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.freightOfferCardView);
            fromCity = (TextView) itemView.findViewById(R.id.textViewFreightOfferFrom);
            toCity = (TextView) itemView.findViewById(R.id.textViewFreightOfferTo);
            freightType = (TextView) itemView.findViewById(R.id.textViewFreightOfferFreightType);
            price = (TextView) itemView.findViewById(R.id.textViewFreightOfferPrice);
            weight = (TextView) itemView.findViewById(R.id.textViewFreightOfferWeight);
        }
    }
}
