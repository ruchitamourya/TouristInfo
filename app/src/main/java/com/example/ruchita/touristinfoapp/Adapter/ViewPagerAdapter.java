package com.example.ruchita.touristinfoapp.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.ruchita.touristinfoapp.R;

import java.util.List;

/**
 * Created by ruchita on 26/9/17.
 */

public class ViewPagerAdapter extends PagerAdapter {

    private LayoutInflater mInflater;
    private Context context;
    private List<Bitmap> mList;

    public ViewPagerAdapter(Context context, List<Bitmap> list) {
        this.context = context;
        this.mList = list;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == (CardView) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        mInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view_pager = mInflater.inflate(R.layout.view_pager_item, container, false);
        ImageView pager_view_img = (ImageView) view_pager.findViewById(R.id.view_pager_img);
        pager_view_img.setImageBitmap(mList.get(position));
        container.addView(view_pager);
        return view_pager;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((CardView) object);
    }
}
