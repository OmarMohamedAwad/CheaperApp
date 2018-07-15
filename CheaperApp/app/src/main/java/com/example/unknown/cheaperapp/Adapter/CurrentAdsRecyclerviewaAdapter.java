package com.example.unknown.cheaperapp.Adapter;

import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.unknown.cheaperapp.Classes.Add_Class;
import com.example.unknown.cheaperapp.Classes.AdvertismentClass;
import com.example.unknown.cheaperapp.R;

import java.util.ArrayList;

public class CurrentAdsRecyclerviewaAdapter extends RecyclerView.Adapter<CurrentAdsRecyclerviewaAdapter.AdsViewHolder> {

    ArrayList<Add_Class> madsList;
    RecyclerviewClickListenerInterface mclickListener;

    public CurrentAdsRecyclerviewaAdapter(ArrayList<Add_Class> adsList, RecyclerviewClickListenerInterface clickListener){
        madsList=adsList;
        mclickListener=clickListener;
    }


    @NonNull
    @Override
    public AdsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.speciallayout_ads_curent_previous,parent,false);

        AdsViewHolder holder = new AdsViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdsViewHolder holder, int position) {
        holder.bind(madsList.get(position));
    }

    @Override
    public int getItemCount() {
        return madsList.size();
    }

    public class AdsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView pricepefore_textView;
        TextView price_after_textview;
        TextView productname_textView;
        ImageView add_image;


        public AdsViewHolder(View itemView) {
            super(itemView);

            pricepefore_textView=itemView.findViewById(R.id.pricepefore_textView);
            pricepefore_textView.setPaintFlags(pricepefore_textView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

            price_after_textview=itemView.findViewById(R.id.price_after_textview);
            productname_textView=itemView.findViewById(R.id.productname_textView);
            add_image=itemView.findViewById(R.id.add_image);

        }


        public void bind(Add_Class ad){


            add_image.setImageResource(ad.getImg());
            pricepefore_textView.setText(ad.getPrice_before()+"EGP");
            price_after_textview.setText(String.valueOf(ad.getPrice_aftter())+"EGP");
            productname_textView.setText(String.valueOf(ad.getProduct_name()));

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            int position =getAdapterPosition();
            mclickListener.OnItemClickListener(position);

        }
    }

    public interface RecyclerviewClickListenerInterface{

        void OnItemClickListener(int position);
    }

}
