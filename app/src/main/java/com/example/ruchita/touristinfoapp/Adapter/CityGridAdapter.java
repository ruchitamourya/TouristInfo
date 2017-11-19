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
 * Created by Ruchita on 21/9/17.
 */

public class CityGridAdapter extends RecyclerView.Adapter<CityNameViewHolder> {

    //Field variables of class CityGridAdapter.
    private List<City> mData;
    private LayoutInflater mInflater;
    private Context mContext;
    private ItemClickListener mItemClickListener;

    /*
     *Constructor of class CityGridAdapter.
     * @param context is used for getting context of related activity.
     * @param clickListener  is used for getting the property of ItemClickListener in class CityGridAdapter.
     * @param data is used for getting the data in class CityGridAdapter.
      */
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
        if (isRed(position)) {
            holder.cardView.setCardBackgroundColor(mContext.getResources().getColor(R.color.colorTransparent1));
        } else {
            holder.cardView.setCardBackgroundColor(mContext.getResources().getColor(R.color.colorTransparent2));
        }
        holder.setData(currentObj);
    }

    /*
     *Method to find out the color of grid.
     */
    private boolean isRed(int position) {
        int i = position % 4;
        if (i == 0 || i == 3) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
