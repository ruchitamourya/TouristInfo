package com.example.ruchita.touristinfoapp.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ruchita.touristinfoapp.FamousPlacesActivity;
import com.example.ruchita.touristinfoapp.ItemClickListener;
import com.example.ruchita.touristinfoapp.ItemClickListenerOfFamousPlace;
import com.example.ruchita.touristinfoapp.Model.FamousPlace;
import com.example.ruchita.touristinfoapp.R;

/**
 * Created by ruchita on 25/9/17.
 */

public class FamousPlacesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private TextView title;
    private TextView description;
    private ImageView famous_placesCity_img;
    private ImageView mapImage;
    FamousPlace current;
    int position;
    private ItemClickListenerOfFamousPlace itemClickListenerOfFamousPlace;

    public FamousPlacesViewHolder(View itemView,ItemClickListenerOfFamousPlace itemClickListenerOfFamousPlace) {
        super(itemView);
        this.itemClickListenerOfFamousPlace = itemClickListenerOfFamousPlace;

        title = (TextView) itemView.findViewById(R.id.famous_places_title);
        description = (TextView) itemView.findViewById(R.id.famous_places_description);
        famous_placesCity_img = (ImageView) itemView.findViewById(R.id.famous_places_img);
        mapImage = (ImageView) itemView.findViewById(R.id.google_img);


    }

    public void setData(FamousPlace current, int position) {
        this.title.setText(current.getTitle());
        this.famous_placesCity_img.setImageResource(current.getImgResourceId());
        this.description.setText(current.getDescription());
        this.mapImage.setOnClickListener(this);
        this.position = position;
        this.current = current;
    }

    @Override
    public void onClick(View v) {
        itemClickListenerOfFamousPlace.onItemClick(v,current);
    }
}

