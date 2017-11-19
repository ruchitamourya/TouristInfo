package com.example.ruchita.touristinfoapp.Adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.ruchita.touristinfoapp.ItemClickListener;
import com.example.ruchita.touristinfoapp.Model.City;
import com.example.ruchita.touristinfoapp.R;

/**
 * Created by Ruchita on 22/9/17.
 */
public class CityNameViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    //Field variables of Class CityNameViewHolder.
    CardView cardView;
    private TextView city_name;
    private City mCurrent;
    private ItemClickListener mItemClickListener;

    //Constructor of Class CityViewHolder.
    public CityNameViewHolder(View itemView, ItemClickListener itemClickListener) {
        super(itemView);
        this.mItemClickListener = itemClickListener;
        city_name = (TextView) itemView.findViewById(R.id.city_name);
        cardView = (CardView) itemView.findViewById(R.id.cardView);
    }

    /*
     *Method to set the data of class City.
     */
    public void setData(City current) {
        this.city_name.setText(current.getCityName());
        this.mCurrent = current;
        cardView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        mItemClickListener.onItemClick(v, mCurrent);
    }


}