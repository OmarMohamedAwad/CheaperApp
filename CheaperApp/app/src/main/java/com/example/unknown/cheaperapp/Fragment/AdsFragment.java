package com.example.unknown.cheaperapp.Fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.unknown.cheaperapp.Adapter.AdsViewPagerAdapter;
import com.example.unknown.cheaperapp.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class AdsFragment extends Fragment {

    ViewPager viewPager;
    AdsViewPagerAdapter adapter;
    TabLayout tabLayout;

    ArrayList<Fragment> fragmentList;
    ArrayList<String>fragmenttitles;
    public AdsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view= inflater.inflate(R.layout.fragment_ads, container, false);

        GetViewELements(view);

        fragmentList= new ArrayList<>();
        fragmentList.add(new AllAdsFragment());
        fragmentList.add(new TodaysAdsFragment());

        fragmenttitles = new ArrayList<>();
        fragmenttitles.add(getString(R.string.AllAds));
        fragmenttitles.add(getString(R.string.TodayAds));

        adapter = new AdsViewPagerAdapter(getActivity().getSupportFragmentManager(),fragmentList,fragmenttitles);

        viewPager.setAdapter(adapter);

        tabLayout.bringToFront();

        tabLayout.setupWithViewPager(viewPager);

        return view;
    }


    //this method for inflating view elements
    private void GetViewELements(View view){

        viewPager=view.findViewById(R.id.ads_viewpager);
        tabLayout=view.findViewById(R.id.ads_tablayout);


    }

}
