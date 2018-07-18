package com.example.unknown.cheaperapp.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.unknown.cheaperapp.Classes.StoreClass;
import com.example.unknown.cheaperapp.Interface.StoreOnItemCliclkListenerInterface;
import com.example.unknown.cheaperapp.R;

import java.util.ArrayList;

public class StoresRecyclerviewAdapter extends RecyclerView.Adapter<StoresRecyclerviewAdapter.StoresRecyclerviewViewHolder> {

    ArrayList<StoreClass> mstoresList;
    StoreOnItemCliclkListenerInterface monItemCliclkListener;

    public StoresRecyclerviewAdapter(ArrayList<StoreClass> storesList,StoreOnItemCliclkListenerInterface onItemCliclkListener){
        monItemCliclkListener=onItemCliclkListener;
        mstoresList=storesList;
    }

    @NonNull
    @Override
    public StoresRecyclerviewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_seller_item_cardview_layout,parent,false);

        StoresRecyclerviewViewHolder viewHolder = new StoresRecyclerviewViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull StoresRecyclerviewViewHolder holder, int position) {

        holder.bind(mstoresList.get(position));
    }

    @Override
    public int getItemCount() {
        return mstoresList.size();
    }

    public class StoresRecyclerviewViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView textView;
        ImageView imageView;

        public StoresRecyclerviewViewHolder(View itemView) {
            super(itemView);

            textView =itemView.findViewById(R.id.cardview_textview);
            imageView =itemView.findViewById(R.id.cardview_imageview);

            itemView.setOnClickListener(this);
        }

        public void bind(StoreClass store){
            textView.setText(store.getName());
            imageView.setImageResource(store.getImageResourceId());
        }

        @Override
        public void onClick(View v) {
            int SelectedPosition =getAdapterPosition();
            monItemCliclkListener.OnStoreItemClick(SelectedPosition);
        }
    }
}
