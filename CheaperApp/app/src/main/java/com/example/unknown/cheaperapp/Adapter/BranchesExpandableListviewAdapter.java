package com.example.unknown.cheaperapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;

import com.example.unknown.cheaperapp.Classes.Branch_Class;
import com.example.unknown.cheaperapp.R;

import java.util.ArrayList;

public class BranchesExpandableListviewAdapter extends BaseExpandableListAdapter {

    ArrayList<Branch_Class> mbranchesList;
    Context mcontext;

    public BranchesExpandableListviewAdapter(ArrayList<Branch_Class> branchesList, Context context) {
        this.mbranchesList = branchesList;
        mcontext=context;
    }

    @Override
    public int getGroupCount() {
        return 1;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return mbranchesList.size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return R.string.ChooseBranches ;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return mbranchesList.get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return mbranchesList.get(childPosition).getID();
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(mcontext).inflate(R.layout.special_branches_parent_layout,null);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        convertView =LayoutInflater.from(mcontext).inflate(R.layout.special_branches_child_layout,null);

        CheckBox checkBox= convertView.findViewById(R.id.branch_checkbox);

        checkBox.setText(mbranchesList.get(childPosition).getName());

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
