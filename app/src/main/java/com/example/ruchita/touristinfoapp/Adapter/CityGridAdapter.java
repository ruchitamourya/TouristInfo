package com.example.ruchita.touristinfoapp.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ruchita.touristinfoapp.ItemClickListener;
import com.example.ruchita.touristinfoapp.Model.City;
import com.example.ruchita.touristinfoapp.R;

import java.util.List;

/**
 * Created by ruchita on 21/9/17.
 */

public class CityGridAdapter extends RecyclerView.Adapter<CityNameViewHolder> {

    private List<City> mData;
    private LayoutInflater mInflater;
    private Context mContext;
    private ItemClickListener mItemClickListener;

    public CityGridAdapter(Context context, ItemClickListener clickListener, List<City> data) {
        this.mData = data;
        this.mContext = context;
        this.mItemClickListener = clickListener;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override
    public CityNameViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = mInflater.inflate(R.layout.grid_item_layout, parent, false);
        CityNameViewHolder cityNameViewHolder = new CityNameViewHolder(view, mItemClickListener);
        return cityNameViewHolder;
    }

    @Override
    public void onBindViewHolder(CityNameViewHolder holder, int position) {
        City currentObj = mData.get(position);
        if (position == 0 || position == 3 || position == 4 || position == 7 || position == 8) {
            holder.cardView.setCardBackgroundColor(mContext.getResources().getColor(R.color.colorTransparent3));
        } else {
            holder.cardView.setCardBackgroundColor(mContext.getResources().getColor(R.color.colorTransparent2));
        }
        holder.setData(currentObj);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
