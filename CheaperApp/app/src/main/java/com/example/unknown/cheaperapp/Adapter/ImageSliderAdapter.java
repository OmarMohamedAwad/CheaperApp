package com.example.unknown.cheaperapp.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.unknown.cheaperapp.Classes.Images_Class;

import java.util.ArrayList;

public class ImageSliderAdapter extends PagerAdapter {

    ArrayList<Images_Class> mimagesList;
    Context mcontext;

    public ImageSliderAdapter(Context context, ArrayList<Images_Class> imagesList){
        mcontext=context;
        mimagesList=imagesList;
    }

    @Override
    public int getCount() {
        return mimagesList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        ImageView imageView = new ImageView(mcontext);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setImageResource(mimagesList.get(position).getResourceID());
        container.addView(imageView,0);

        return imageView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ImageView) object);
    }
}
