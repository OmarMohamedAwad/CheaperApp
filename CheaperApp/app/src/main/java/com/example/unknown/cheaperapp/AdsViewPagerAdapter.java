package com.example.unknown.cheaperapp;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;

public class AdsViewPagerAdapter extends FragmentPagerAdapter {


    ArrayList<Fragment> mfragmenList;
    ArrayList<String> mtitles;

    public AdsViewPagerAdapter(FragmentManager fm, ArrayList<Fragment> fragmenList,ArrayList<String> titles) {
        super(fm);
        mfragmenList=fragmenList;
        mtitles=titles;
    }

    @Override
    public Fragment getItem(int position) {
        return mfragmenList.get(position);
    }


    @Override
    public int getCount() {
        return mfragmenList.size();
    }


    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mtitles.get(position);
    }
}
