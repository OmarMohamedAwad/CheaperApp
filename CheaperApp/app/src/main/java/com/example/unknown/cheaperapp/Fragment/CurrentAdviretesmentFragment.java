package com.example.unknown.cheaperapp.Fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.unknown.cheaperapp.Adapter.AdsRecyclerviewaAdapter;
import com.example.unknown.cheaperapp.Adapter.CurrentAdsRecyclerviewaAdapter;
import com.example.unknown.cheaperapp.Classes.Add_Class;
import com.example.unknown.cheaperapp.Classes.AdvertismentClass;
import com.example.unknown.cheaperapp.R;

import java.util.ArrayList;

public class CurrentAdviretesmentFragment extends Fragment implements CurrentAdsRecyclerviewaAdapter.RecyclerviewClickListenerInterface {

    RecyclerView recyclerView;
    CurrentAdsRecyclerviewaAdapter adapter;
    ArrayList<Add_Class> adsList;
    LinearLayoutManager layoutManager;

    ProgressBar progressBar ;
    boolean isScrolling=false;
    int totalItems,currentItems,scrolledOutItems;
    SwipeRefreshLayout allAds_swiperefreshlayout;

    public CurrentAdviretesmentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.currentadviertesment_fragment, container, false);


        progressBar=view.findViewById(R.id.currentAds_progressBar);
        allAds_swiperefreshlayout=view.findViewById(R.id.currentAds_swiperefreshlayout);

        ///jsut dumy data for test

        adsList = new ArrayList<>();
        adsList.add(new Add_Class("نضاره ريبان","3000","1500",R.drawable.shooes1));
        adsList.add(new Add_Class("نضاره ريبان","3000","1500",R.drawable.shooes1));
        adsList.add(new Add_Class("نضاره ريبان","3000","1500",R.drawable.shooes1));
        adsList.add(new Add_Class("نضاره ريبان","3000","1500",R.drawable.shooes1));
        adsList.add(new Add_Class("نضاره ريبان","3000","1500",R.drawable.shooes1));
        adsList.add(new Add_Class("نضاره ريبان","3000","1500",R.drawable.shooes1));
        adsList.add(new Add_Class("نضاره ريبان","3000","1500",R.drawable.shooes1));
        adsList.add(new Add_Class("نضاره ريبان","3000","1500",R.drawable.shooes1));

        ///




        adapter = new CurrentAdsRecyclerviewaAdapter(adsList,this);

        layoutManager=new LinearLayoutManager(getContext());

        recyclerView=view.findViewById(R.id.currentAds_recyclerview);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);


        HandleLoadingAds();

        RefreshData();

        return view;
    }

    @Override
    public void OnItemClickListener(int position) {
        Toast.makeText(getContext(),"Item Selected", Toast.LENGTH_SHORT).show();
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

                        adsList = new ArrayList<>();
                        adsList.add(new Add_Class("نضاره ريبان","3000","1500",R.drawable.shooes1));
                        adsList.add(new Add_Class("نضاره ريبان","3000","1500",R.drawable.shooes1));
                        adsList.add(new Add_Class("نضاره ريبان","3000","1500",R.drawable.shooes1));

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

                adsList = new ArrayList<>();
                adsList.add(new Add_Class("نضاره ريبان","3000","1500",R.drawable.shooes1));
                adsList.add(new Add_Class("نضاره ريبان","3000","1500",R.drawable.shooes1));


                adapter.notifyDataSetChanged();
            }
        },3000);

    }


}

