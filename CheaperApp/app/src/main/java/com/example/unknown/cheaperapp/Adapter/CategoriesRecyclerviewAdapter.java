package com.example.unknown.cheaperapp.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.unknown.cheaperapp.Classes.Category_Class;
import com.example.unknown.cheaperapp.Interface.CustomOnItemCliclkListenerInterface;
import com.example.unknown.cheaperapp.R;

import java.util.ArrayList;

public class CategoriesRecyclerviewAdapter extends RecyclerView.Adapter<CategoriesRecyclerviewAdapter.CategoriesSellersViewHolder> {


    ArrayList<Category_Class> mcategoriesList;
    CustomOnItemCliclkListenerInterface monItemCliclkListener;

    public CategoriesRecyclerviewAdapter(ArrayList<Category_Class> categoriesList, CustomOnItemCliclkListenerInterface onItemCliclkListener){
        mcategoriesList=categoriesList;
        monItemCliclkListener=onItemCliclkListener;
    }

    @NonNull
    @Override
    public CategoriesSellersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_seller_item_cardview_layout,parent,false);

        CategoriesSellersViewHolder viewHolder = new CategoriesSellersViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesSellersViewHolder holder, int position) {
        holder.bind(mcategoriesList.get(position));
    }

    @Override
    public int getItemCount() {
        return mcategoriesList.size();
    }

    public class CategoriesSellersViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView textView;
        ImageView imageView;

        public CategoriesSellersViewHolder(View itemView) {
            super(itemView);

            textView =itemView.findViewById(R.id.cardview_textview);
            imageView =itemView.findViewById(R.id.cardview_imageview);

            itemView.setOnClickListener(this);
        }

        public void bind(Category_Class category){
            textView.setText(category.getName());
            imageView.setImageResource(category.getImageResourceId());
        }

        @Override
        public void onClick(View v) {
            int SelectedPosition =getAdapterPosition();
            monItemCliclkListener.OnItemClick(SelectedPosition);
        }
    }
}
