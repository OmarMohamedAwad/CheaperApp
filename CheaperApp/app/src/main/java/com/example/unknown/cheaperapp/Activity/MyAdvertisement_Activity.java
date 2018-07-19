package com.example.unknown.cheaperapp.Activity;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toolbar;

import com.example.unknown.cheaperapp.Adapter.SectionsPageAdapter;
import com.example.unknown.cheaperapp.Fragment.AllAdsFragment;
import com.example.unknown.cheaperapp.Fragment.CurrentAdviretesmentFragment;
import com.example.unknown.cheaperapp.Fragment.PerviousAdviretesmentFragment;
import com.example.unknown.cheaperapp.Fragment.TodaysAdsFragment;
import com.example.unknown.cheaperapp.R;

public class MyAdvertisement_Activity extends AppCompatActivity {
    private SectionsPageAdapter mSectionsPageAdapter;
    private ViewPager mViewPager;
android.support.v7.widget.Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_advertisement_);

        //Set up view pager with adapter
        mViewPager =(ViewPager)findViewById(R.id.container);
        setupViewPager(mViewPager);
        TabLayout tabLayout=(TabLayout)findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
        AddBackbtnInToolbar();

    }

    private void setupViewPager(ViewPager viewPager){
        SectionsPageAdapter adapter =new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new CurrentAdviretesmentFragment(),"الحاليه");
        adapter.addFragment(new PerviousAdviretesmentFragment(),"السابقه");

        viewPager.setAdapter(adapter);
    }

    private void AddBackbtnInToolbar(){

        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null);
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_arrow_back_black_24dp));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
