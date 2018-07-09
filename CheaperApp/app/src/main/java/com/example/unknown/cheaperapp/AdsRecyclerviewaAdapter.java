package com.example.unknown.cheaperapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.unknown.cheaperapp.Classes.AdvertismentClass;

import java.util.ArrayList;

public class AdsRecyclerviewaAdapter extends RecyclerView.Adapter<AdsRecyclerviewaAdapter.AdsViewHolder> {

    ArrayList<AdvertismentClass> madsList;
    RecyclerviewClickListenerInterface mclickListener;

    public AdsRecyclerviewaAdapter(ArrayList<AdvertismentClass> adsList, RecyclerviewClickListenerInterface clickListener){
        madsList=adsList;
        mclickListener=clickListener;
    }


    @NonNull
    @Override
    public AdsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.special_ads_item_layout,parent,false);

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

        TextView discount_textview;
        TextView offerDate_textview;
        TextView product_name_textview;
        TextView sellerName_textview;
        TextView price_before_offer_textview;
        TextView price_after_offer_textview;


        public AdsViewHolder(View itemView) {
            super(itemView);

            discount_textview=itemView.findViewById(R.id.discount_textview);
            offerDate_textview=itemView.findViewById(R.id.offerDate_textview);
            product_name_textview=itemView.findViewById(R.id.product_name_textview);
            sellerName_textview=itemView.findViewById(R.id.sellerName_textview);
            price_before_offer_textview=itemView.findViewById(R.id.price_before_offer_textview);
            price_after_offer_textview=itemView.findViewById(R.id.price_after_offer_textview);

        }


        public void bind(AdvertismentClass ad){

            boolean limited_quantity=ad.isLimited();
            if(limited_quantity==true){
                offerDate_textview.setText(ad.getEndDate());
            }
            else {
                offerDate_textview.setText(R.string.LimitedOffer);
            }
            product_name_textview.setText(ad.getProductName());
            sellerName_textview.setText(ad.getSellerName());
            price_before_offer_textview.setText(String.valueOf(ad.getPrice()));
            price_after_offer_textview.setText(String.valueOf(ad.getPriceAfterDiscount()));
            discount_textview.setText(String.valueOf(100-((ad.getPriceAfterDiscount()/ad.getPrice())*100))+"%");

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
