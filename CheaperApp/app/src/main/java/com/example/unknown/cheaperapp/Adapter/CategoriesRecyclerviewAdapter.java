package com.example.unknown.cheaperapp.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.example.unknown.cheaperapp.Classes.Category_Class;
import com.example.unknown.cheaperapp.Interface.CategoryOnItemCliclkListenerInterface;
import com.example.unknown.cheaperapp.R;
import com.example.unknown.cheaperapp.Volley.AppController;

import java.util.ArrayList;
public class CategoriesRecyclerviewAdapter extends RecyclerView.Adapter<CategoriesRecyclerviewAdapter.CategoriesRecyclerviewViewHolder> {


    ArrayList<Category_Class> mcategoriesList;
    CategoryOnItemCliclkListenerInterface monItemCliclkListener;

    public CategoriesRecyclerviewAdapter(ArrayList<Category_Class> categoriesList, CategoryOnItemCliclkListenerInterface onItemCliclkListener){
        mcategoriesList=categoriesList;
        monItemCliclkListener=onItemCliclkListener;
    }

    @NonNull
    @Override
    public CategoriesRecyclerviewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_seller_item_cardview_layout,parent,false);

        CategoriesRecyclerviewViewHolder viewHolder = new CategoriesRecyclerviewViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesRecyclerviewViewHolder holder, int position) {
        holder.bind(mcategoriesList.get(position));
    }

    @Override
    public int getItemCount() {
        return mcategoriesList.size();
    }

    public class CategoriesRecyclerviewViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView textView;
        NetworkImageView imageView;

        public CategoriesRecyclerviewViewHolder(View itemView) {
            super(itemView);

            textView =itemView.findViewById(R.id.cardview_textview);
            imageView =itemView.findViewById(R.id.cardview_imageview);

            itemView.setOnClickListener(this);
        }

        public void bind(Category_Class category){

            textView.setText(category.getName());

            if(category.getImageUrl()==null||category.getImageUrl().length()<1){
                imageView.setImageResource(category.getImageResourceId());
            }
            else {
                ImageLoader imageLoader = AppController.getInstance().getImageLoader();
                imageView.setImageUrl(category.getImageUrl(),imageLoader);
            }

        }

        @Override
        public void onClick(View v) {
            int SelectedPosition =getAdapterPosition();
            monItemCliclkListener.OnCategoryItemClick(SelectedPosition);
        }
    }
}
