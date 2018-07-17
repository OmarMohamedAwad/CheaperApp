package com.example.unknown.cheaperapp.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.unknown.cheaperapp.Adapter.CategoriesRecyclerviewAdapter;
import com.example.unknown.cheaperapp.Classes.Category_Class;
import com.example.unknown.cheaperapp.Interface.CustomOnItemCliclkListenerInterface;
import com.example.unknown.cheaperapp.R;

import java.util.ArrayList;

public class Categories_Sellers_Activity extends AppCompatActivity implements CustomOnItemCliclkListenerInterface {

    RecyclerView categories_sellers_recyclerview;
    CategoriesRecyclerviewAdapter categoriesAdapter;
    ArrayList<Category_Class> categoriesList;
    GridLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories__sellers_);

        GetElements();


        int type =getIntent().getIntExtra("type",0);

        if(type==1){

            //this just dumy data for test purposes
            categoriesList = new ArrayList<>();
            categoriesList.add(new Category_Class(1,"ملابس","sdsdcsdcs",R.drawable.village));
            categoriesList.add(new Category_Class(1,"احذية","sdsdcsdcs",R.drawable.village));
            categoriesList.add(new Category_Class(1,"ملابس","sdsdcsdcs",R.drawable.village));
            categoriesList.add(new Category_Class(1,"ملابس","sdsdcsdcs",R.drawable.village));
            categoriesList.add(new Category_Class(1,"ملابس","sdsdcsdcs",R.drawable.village));

            categoriesAdapter = new CategoriesRecyclerviewAdapter(categoriesList,this);

            layoutManager = new GridLayoutManager(this,2);

            categories_sellers_recyclerview.setLayoutManager(layoutManager);
            categories_sellers_recyclerview.setHasFixedSize(true);
            categories_sellers_recyclerview.setAdapter(categoriesAdapter);
        }
        else {

        }



    }


    private void  GetElements(){
        categories_sellers_recyclerview=findViewById(R.id.categories_sellers_recyclerview);
    }

    @Override
    public void OnItemClick(int position) {

    }
}
