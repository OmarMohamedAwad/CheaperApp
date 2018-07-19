package com.example.unknown.cheaperapp.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ProgressBar;

import com.example.unknown.cheaperapp.Activity.AdDetailsActivity;
import com.example.unknown.cheaperapp.Adapter.AdsRecyclerviewaAdapter;
import com.example.unknown.cheaperapp.Classes.AdvertismentClass;
import com.example.unknown.cheaperapp.Interface.AdsOnItemClickListenerInterface;
import com.example.unknown.cheaperapp.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class AllAdsFragment extends Fragment implements AdsOnItemClickListenerInterface {

    RecyclerView recyclerView;
    AdsRecyclerviewaAdapter adapter;
    ArrayList<AdvertismentClass> adsList;
    GridLayoutManager layoutManager;

    ProgressBar progressBar ;
    boolean isScrolling=false;
    int totalItems,currentItems,scrolledOutItems;
    SwipeRefreshLayout allAds_swiperefreshlayout;

    public AllAdsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_all_ads, container, false);


        progressBar=view.findViewById(R.id.allAds_progressBar);
        allAds_swiperefreshlayout=view.findViewById(R.id.allAds_swiperefreshlayout);

        ///jsut dumy data for test


        FillData(view);

        HandleLoadingAds();

        RefreshData();

        return view;
    }

    @Override
    public void OnItemClickListener(int position) {
       startActivity(new Intent(getActivity(), AdDetailsActivity.class));
    }


    private void FillData(View view){
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

        layoutManager = new GridLayoutManager(getActivity(),2);

        recyclerView=view.findViewById(R.id.allAds_recyclerview);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
    }

    //this Method for handling loading more data into recyclerview
    private  void HandleLoadingAds(){


        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
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

    //this Method for handling refreshing data into recyclerview
    private void RefreshData(){

        allAds_swiperefreshlayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
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

                        allAds_swiperefreshlayout.setRefreshing(false);
                    }
                },3000);



            }
        });
    }

    //this method for Loading More data into recyclerview
    private void loadMoreData(){

        //just for tesing

        progressBar.setVisibility(View.VISIBLE);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                adsList.add(new AdvertismentClass(1,"Shoe",1000,800,"10/8/2018","30/10/2018",false,"Adidas"));
                adsList.add(new AdvertismentClass(1,"Shoe",1000,800,"10/8/2018","30/10/2018",true,"Adidas"));
                adsList.add(new AdvertismentClass(1,"Shoe",1000,800,"10/8/2018","30/10/2018",true,"Adidas"));
                adsList.add(new AdvertismentClass(1,"Shoe",1000,800,"10/8/2018","30/10/2018",false,"Adidas"));

                progressBar.setVisibility(View.GONE);

                adapter.notifyDataSetChanged();
            }
        },3000);

    }


}
