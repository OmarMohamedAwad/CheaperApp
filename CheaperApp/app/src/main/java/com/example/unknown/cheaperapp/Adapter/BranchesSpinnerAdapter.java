package com.example.unknown.cheaperapp.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.unknown.cheaperapp.Classes.Branch_Class;
import com.example.unknown.cheaperapp.R;

import java.util.ArrayList;

public class BranchesSpinnerAdapter extends BaseAdapter {

    ArrayList<Branch_Class> mbranchesList;
    Context mcontext;

    public BranchesSpinnerAdapter(Context context, ArrayList<Branch_Class> branchesList) {
        mbranchesList=branchesList;
        mcontext=context;
    }


    @Override
    public int getCount() {
        return mbranchesList.size();
    }

    @Override
    public Object getItem(int position) {
        return mbranchesList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return mbranchesList.get(position).getID();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView= LayoutInflater.from(mcontext).inflate(R.layout.branch_spinner_item_layout,parent,false);
        }

        TextView branchSpinner_Textview=  convertView.findViewById(R.id.branchSpinner_Textview);

        branchSpinner_Textview.setText(mbranchesList.get(position).getName());

        return  convertView;
    }
}
