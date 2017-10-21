package com.example.ruchita.touristinfoapp.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ruchita.touristinfoapp.Data.ImageUtils;
import com.example.ruchita.touristinfoapp.ItemClickListenerOfFamousPlace;
import com.example.ruchita.touristinfoapp.Model.FamousPlace;
import com.example.ruchita.touristinfoapp.R;

import java.util.List;

/**
 * Created by ruchita on 25/9/17.
 */

public class FamousPlacesAdapter extends RecyclerView.Adapter<FamousPlacesViewHolder>{

    private List<FamousPlace> mListData;
    private LayoutInflater mInflater;
    private ItemClickListenerOfFamousPlace itemClickListenerOfFamousPlace;
    private String cityName;
    private Context context;

    public FamousPlacesAdapter(Context context, ItemClickListenerOfFamousPlace
            itemClickListenerOfFamousPlace, List<FamousPlace> list, String cityName){
        this.mListData = list;
        this.itemClickListenerOfFamousPlace = itemClickListenerOfFamousPlace;
        this.mInflater = LayoutInflater.from(context);
        this.cityName = cityName;
        this.context = context;
    }
    @Override
    public FamousPlacesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.famous_places_itemlist, parent,false);
        FamousPlacesViewHolder holder = new FamousPlacesViewHolder(view,itemClickListenerOfFamousPlace);
        return holder;
    }

    @Override
    public void onBindViewHolder(FamousPlacesViewHolder holder, int position) {
        FamousPlace currentObj = mListData.get(position);
        Bitmap bitmap = ImageUtils.getFamousPlacesImage(context, cityName, currentObj.getTitle());
        holder.setData(currentObj, position, bitmap);
    }

    @Override
    public int getItemCount() {
        return mListData.size();
    }

}
