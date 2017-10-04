package com.example.ruchita.touristinfoapp.Adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.ruchita.touristinfoapp.ItemClickListener;
import com.example.ruchita.touristinfoapp.Model.City;
import com.example.ruchita.touristinfoapp.R;

/**
 * Created by ruchita on 22/9/17.
 */
public class CityNameViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    CardView cardView;
    private TextView city_name;
    private City current;
    private ItemClickListener itemClickListener;

    public CityNameViewHolder(View itemView, ItemClickListener itemClickListener) {
        super(itemView);
        this.itemClickListener = itemClickListener;
        city_name = (TextView) itemView.findViewById(R.id.city_name);
        cardView = (CardView) itemView.findViewById(R.id.cardView);
    }

    public void setData(City current) {
        this.city_name.setText(current.getCityName());
        this.current = current;
        cardView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        itemClickListener.onItemClick(v, current);
    }


}