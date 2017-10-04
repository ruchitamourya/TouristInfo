package com.example.ruchita.touristinfoapp.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ruchita.touristinfoapp.Model.FamousPlace;
import com.example.ruchita.touristinfoapp.R;

/**
 * Created by ruchita on 25/9/17.
 */

public class FamousPlacesViewHolder extends RecyclerView.ViewHolder {

    private TextView title;
    private TextView description;
    private ImageView famous_placesCity_img;
    FamousPlace current;
    int position;

    public FamousPlacesViewHolder(View itemView) {
        super(itemView);

        title = (TextView) itemView.findViewById(R.id.famous_places_title);
        description = (TextView) itemView.findViewById(R.id.famous_places_description);
        famous_placesCity_img = (ImageView) itemView.findViewById(R.id.famous_places_img);
    }

        public void setData(FamousPlace current, int position) {
            this.title.setText(current.getTitle());
            this.famous_placesCity_img.setImageResource(current.getImgResourceId());
            this.description.setText(current.getDescription());
            this.position = position;
            this.current = current;
        }
    }

