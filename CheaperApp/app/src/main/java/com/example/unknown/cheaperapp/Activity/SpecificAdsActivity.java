package com.example.unknown.cheaperapp.Activity;

import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ProgressBar;

import com.example.unknown.cheaperapp.Adapter.AdsRecyclerviewaAdapter;
import com.example.unknown.cheaperapp.Classes.AdvertismentClass;
import com.example.unknown.cheaperapp.Interface.AdsOnItemClickListenerInterface;
import com.example.unknown.cheaperapp.R;

import java.util.ArrayList;

public class SpecificAdsActivity extends AppCompatActivity implements AdsOnItemClickListenerInterface{


    RecyclerView specificAds_recyclerview;
    SwipeRefreshLayout specificAds_swiperefreshlayout;
    ProgressBar specificAds_progressBar;
    AdsRecyclerviewaAdapter adapter;
    GridLayoutManager layoutManager;
    ArrayList<AdvertismentClass> adsList;


    boolean isScrolling=false;
    int totalItems,currentItems,scrolledOutItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific_ads);

        GetElements();

        int type =getIntent().getIntExtra("type",0);

        if(type==1){

            FillData();
            HandleLoadingAds();
            RefreshData();

        }
        else {

            FillData();
            HandleLoadingAds();
            RefreshData();

        }


    }


    @Override
    public void OnItemClickListener(int position) {

    }

    private void GetElements(){
        specificAds_recyclerview=findViewById(R.id.specificAds_recyclerview);
        specificAds_swiperefreshlayout=findViewById(R.id.specificAds_swiperefreshlayout);
        specificAds_progressBar=findViewById(R.id.specificAds_progressBar);
    }


    private void FillData(){

        ///jsut dumy data for test

        adsList = new ArrayList<>();
        adsList.add(new AdvertismentClass(1,"Shoe",1000,800,"10/8/2018","30/10/2018",false,"Adidas"));
        adsList.add(new AdvertismentClass(1,"Shoe",1000,800,"10/8/2018","30/10/2018",false,"Adidas"));
        adsList.add(new AdvertismentClass(1,"Shoe",1000,800,"10/8/2018","30/10/2018",false,"Adidas"));
        adsList.add(new AdvertismentClass(1,"Shoe",1000,800,"10/8/2018","30/10/2018",false,"Adidas"));
        adsList.add(new AdvertismentClass(1,"Shoe",1000,800,"10/8/2018","30/10/2018",false,"Adidas"));
        adsList.add(new AdvertismentClass(1,"Shoe",1000,800,"10/8/2018","30/10/2018",false,"Adidas"));
        adsList.add(new AdvertismentClass(1,"Shoe",1000,800,"10/8/2018","30/10/2018",false,"Adidas"));
        adsList.add(new AdvertismentClass(1,"Shoe",1000,800,"10/8/2018","30/10/2018",false,"Adidas"));
        adsList.add(new AdvertismentClass(1,"Shoe",1000,800,"10/8/2018","30/10/2018",false,"Adidas"));
        adsList.add(new AdvertismentClass(1,"Shoe",1000,800,"10/8/2018","30/10/2018",false,"Adidas"));
        adsList.add(new AdvertismentClass(1,"Shoe",1000,800,"10/8/2018","30/10/2018",false,"Adidas"));
        adsList.add(new AdvertismentClass(1,"Shoe",1000,800,"10/8/2018","30/10/2018",false,"Adidas"));
        adsList.add(new AdvertismentClass(1,"Shoe",1000,800,"10/8/2018","30/10/2018",false,"Adidas"));
        adsList.add(new AdvertismentClass(1,"Shoe",1000,800,"10/8/2018","30/10/2018",false,"Adidas"));


        ///

        adapter = new AdsRecyclerviewaAdapter(adsList, this);

        layoutManager = new GridLayoutManager(this,2);


        specificAds_recyclerview.setLayoutManager(layoutManager);
        specificAds_recyclerview.setHasFixedSize(true);
        specificAds_recyclerview.setAdapter(adapter);
    }

    //this Method for handling loading more data into recyclerview
    private  void HandleLoadingAds(){


        specificAds_recyclerview.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                if(newState== AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL){
                    isScrolling=true;
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                totalItems=layoutManager.getItemCount();
                currentItems=layoutManager.getChildCount();
                scrolledOutItems=layoutManager.findFirstVisibleItemPosition();

                if(isScrolling==true&&totalItems==(currentItems+scrolledOutItems)){

                    isScrolling=false;

                    loadMoreData();
                }
            }
        });
    }

    //this method for Loading More data into recyclerview
    private void loadMoreData(){

        //just for tesing

        specificAds_progressBar.setVisibility(View.VISIBLE);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                adsList.add(new AdvertismentClass(1,"Shoe",1000,800,"10/8/2018","30/10/2018",false,"Adidas"));
                adsList.add(new AdvertismentClass(1,"Shoe",1000,800,"10/8/2018","30/10/2018",true,"Adidas"));
                adsList.add(new AdvertismentClass(1,"Shoe",1000,800,"10/8/2018","30/10/2018",true,"Adidas"));
                adsList.add(new AdvertismentClass(1,"Shoe",1000,800,"10/8/2018","30/10/2018",false,"Adidas"));

                specificAds_progressBar.setVisibility(View.GONE);

                adapter.notifyDataSetChanged();
            }
        },3000);

    }

    //this Method for handling refreshing data into recyclerview
    private void RefreshData(){

        specificAds_swiperefreshlayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {



                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        adsList.clear();

                        adsList.add(new AdvertismentClass(1,"Shoe",1000,800,"10/8/2018","30/10/2018",false,"Adidas"));
                        adsList.add(new AdvertismentClass(1,"Shoe",1000,800,"10/8/2018","30/10/2018",true,"Adidas"));
                        adsList.add(new AdvertismentClass(1,"Shoe",1000,800,"10/8/2018","30/10/2018",true,"Adidas"));
                        adsList.add(new AdvertismentClass(1,"Shoe",1000,800,"10/8/2018","30/10/2018",false,"Adidas"));
                        adsList.add(new AdvertismentClass(1,"Shoe",1000,800,"10/8/2018","30/10/2018",false,"Adidas"));
                        adsList.add(new AdvertismentClass(1,"Shoe",1000,800,"10/8/2018","30/10/2018",true,"Adidas"));
                        adsList.add(new AdvertismentClass(1,"Shoe",1000,800,"10/8/2018","30/10/2018",true,"Adidas"));
                        adsList.add(new AdvertismentClass(1,"Shoe",1000,800,"10/8/2018","30/10/2018",false,"Adidas"));


                        adapter.notifyDataSetChanged();

                        specificAds_swiperefreshlayout.setRefreshing(false);
                    }
                },3000);



            }
        });
    }
}
