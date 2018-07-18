package com.example.unknown.cheaperapp.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.unknown.cheaperapp.Adapter.CategoriesRecyclerviewAdapter;
import com.example.unknown.cheaperapp.Adapter.StoresRecyclerviewAdapter;
import com.example.unknown.cheaperapp.Classes.Category_Class;
import com.example.unknown.cheaperapp.Classes.StoreClass;
import com.example.unknown.cheaperapp.Interface.CategoryOnItemCliclkListenerInterface;
import com.example.unknown.cheaperapp.Interface.StoreOnItemCliclkListenerInterface;
import com.example.unknown.cheaperapp.R;

import java.util.ArrayList;

public class Categories_Stores_Activity extends AppCompatActivity implements CategoryOnItemCliclkListenerInterface,StoreOnItemCliclkListenerInterface {

    RecyclerView categories_sellers_recyclerview;
    GridLayoutManager layoutManager;

    CategoriesRecyclerviewAdapter categoriesAdapter;
    ArrayList<Category_Class> categoriesList;

    StoresRecyclerviewAdapter storesAdapter;
    ArrayList<StoreClass> storeList;

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
            //this just dumy data for test purposes
            storeList = new ArrayList<>();
            storeList.add(new StoreClass(1,"ابو الخير",R.drawable.toys));
            storeList.add(new StoreClass(1,"ابو الخير",R.drawable.toys));
            storeList.add(new StoreClass(1,"ابو الخير",R.drawable.toys));
            storeList.add(new StoreClass(1,"ابو الخير",R.drawable.toys));
            storeList.add(new StoreClass(1,"ابو الخير",R.drawable.toys));
            storeList.add(new StoreClass(1,"ابو الخير",R.drawable.toys));
            storeList.add(new StoreClass(1,"ابو الخير",R.drawable.toys));
            storeList.add(new StoreClass(1,"ابو الخير",R.drawable.toys));

            storesAdapter = new StoresRecyclerviewAdapter(storeList,this);

            layoutManager = new GridLayoutManager(this,2);

            categories_sellers_recyclerview.setLayoutManager(layoutManager);
            categories_sellers_recyclerview.setHasFixedSize(true);
            categories_sellers_recyclerview.setAdapter(storesAdapter);

        }



    }


    private void  GetElements(){
        categories_sellers_recyclerview=findViewById(R.id.categories_sellers_recyclerview);
    }

    @Override
    public void OnCategoryItemClick(int position) {

        Intent intent = new Intent(Categories_Stores_Activity.this,SpecificAdsActivity.class);
        intent.putExtra("type",1);
        startActivity(intent);
    }

    @Override
    public void OnStoreItemClick(int position) {

        Intent intent = new Intent(Categories_Stores_Activity.this,SpecificAdsActivity.class);
        intent.putExtra("type",2);
        startActivity(intent);
    }


}
