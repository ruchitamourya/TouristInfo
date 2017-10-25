package com.example.ruchita.touristinfoapp.Adapter;

import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ruchita.touristinfoapp.ItemClickListenerOfFamousPlace;
import com.example.ruchita.touristinfoapp.Model.FamousPlace;
import com.example.ruchita.touristinfoapp.R;

/**
 * Created by Ruchita on 25/9/17.
 */

public class FamousPlacesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    // Field variables of class of FamousPlacesViewHolder.
    private TextView title;
    private TextView description;
    private ImageView famous_placesCity_img;
    private ImageView mapImage;
    FamousPlace mCurrent;
    int mPosition;
    private ItemClickListenerOfFamousPlace mItemClickListenerOfFamousPlace;

    // Constructor of class FamousPlacesViewHolder.
    public FamousPlacesViewHolder(View itemView, ItemClickListenerOfFamousPlace itemClickListenerOfFamousPlace) {
        super(itemView);
        this.mItemClickListenerOfFamousPlace = itemClickListenerOfFamousPlace;
        title = (TextView) itemView.findViewById(R.id.famous_places_title);
        description = (TextView) itemView.findViewById(R.id.famous_places_description);
        famous_placesCity_img = (ImageView) itemView.findViewById(R.id.famous_places_img);
        mapImage = (ImageView) itemView.findViewById(R.id.google_img);
    }

    // A method to set the data of classFamousPlacesViewHolder.
    public void setData(FamousPlace current, int position, Bitmap imageBitmap) {
        this.title.setText(current.getTitle());
        this.famous_placesCity_img.setImageBitmap(imageBitmap);
        this.description.setText(current.getDescription());
        this.mapImage.setOnClickListener(this);
        this.mPosition = position;
        this.mCurrent = current;
    }

    @Override
    public void onClick(View v) {
        mItemClickListenerOfFamousPlace.onItemClick(v, mCurrent);
    }
}

