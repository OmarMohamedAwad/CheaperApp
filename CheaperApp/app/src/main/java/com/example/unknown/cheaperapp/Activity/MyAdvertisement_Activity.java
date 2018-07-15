package com.example.unknown.cheaperapp.Activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.unknown.cheaperapp.Adapter.SectionsPageAdapter;
import com.example.unknown.cheaperapp.Fragment.AllAdsFragment;
import com.example.unknown.cheaperapp.Fragment.CurrentAdviretesmentFragment;
import com.example.unknown.cheaperapp.Fragment.PerviousAdviretesmentFragment;
import com.example.unknown.cheaperapp.Fragment.TodaysAdsFragment;
import com.example.unknown.cheaperapp.R;

public class MyAdvertisement_Activity extends AppCompatActivity {
    private SectionsPageAdapter mSectionsPageAdapter;
    private ViewPager mViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_advertisement_);

        mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());
        //Set up view pager with adapter
        mViewPager =(ViewPager)findViewById(R.id.container);
        setupViewPager(mViewPager);
        TabLayout tabLayout=(TabLayout)findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

    }

    private void setupViewPager(ViewPager viewPager){
        SectionsPageAdapter adapter =new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new CurrentAdviretesmentFragment(),"الحاليه");
        adapter.addFragment(new PerviousAdviretesmentFragment(),"السابقه");

        viewPager.setAdapter(adapter);
    }
}
