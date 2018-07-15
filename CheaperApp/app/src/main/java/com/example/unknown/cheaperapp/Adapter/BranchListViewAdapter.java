package com.example.unknown.cheaperapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.unknown.cheaperapp.Classes.Branch_Class;
import com.example.unknown.cheaperapp.R;

import java.util.ArrayList;

public class BranchListViewAdapter extends ArrayAdapter<Branch_Class> {
    private int backgrouncolor;


    public BranchListViewAdapter(Context context, ArrayList<Branch_Class> branches) {
        super(context, 0, branches);

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.specialbranchlayout, parent, false);
        }
        Branch_Class currentbranch = getItem(position);

        TextView phonenumber = (TextView) listItemView.findViewById(R.id.phonenumber_txt);
        phonenumber.setText(currentbranch.getPhone().toString());

        TextView loation = (TextView) listItemView.findViewById(R.id.location_txt);
        loation.setText(currentbranch.getLocation().toString());

        TextView CityName = (TextView) listItemView.findViewById(R.id.location_txt);
        CityName.setText(currentbranch.getCityName().toString());

               return listItemView;
    }
}
