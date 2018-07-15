package com.example.unknown.cheaperapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.unknown.cheaperapp.R;

import java.util.ArrayList;
import java.util.HashMap;

public class UserAgreementExpandableListviewAdapter extends BaseExpandableListAdapter {

    HashMap<String,ArrayList<String>> itemsGroup;
    Context mcontext;

    public UserAgreementExpandableListviewAdapter(Context context, HashMap<String,ArrayList<String>> itemsGroup) {
        super();
        this.itemsGroup=itemsGroup;
        mcontext=context;
    }

    @Override
    public int getGroupCount() {
        return itemsGroup.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {


        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return itemsGroup.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return itemsGroup.get(groupPosition).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        View view = convertView;

        ParentViewHolder viewHolder ;


        if(view==null){
            view=LayoutInflater.from(mcontext).inflate(R.layout.special_useragreement_parent_layout,null);

            viewHolder = new ParentViewHolder(view);
            view.setTag(viewHolder);
        }
        else {
            viewHolder = (ParentViewHolder) view.getTag();
        }



        ArrayList<String>keys =new ArrayList<>();
        keys.addAll(itemsGroup.keySet());
        viewHolder.parent_textview.setText(keys.get(groupPosition));


        return view;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        View view = convertView;

        ChildViewHolder viewHolder ;

        if(view==null){
            view = LayoutInflater.from(mcontext).inflate(R.layout.special_useragreement_child_layout,null);

            viewHolder = new ChildViewHolder(view);

            view.setTag(viewHolder);
        }
        else {
            viewHolder = (ChildViewHolder) view.getTag();
        }


        ArrayList<String>keys =new ArrayList<>();
        keys.addAll(itemsGroup.keySet());

        ArrayList<String> values = itemsGroup.get(keys.get(groupPosition));

        viewHolder.header_textview.setText(values.get(0));
        viewHolder.body_textview.setText(values.get(1));

        return view;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    public class ParentViewHolder{

        TextView parent_textview;

        public ParentViewHolder(View view){

            parent_textview = view.findViewById(R.id.parent_textview);

        }

    }

    public class ChildViewHolder{

        TextView header_textview;
        TextView body_textview;

        public ChildViewHolder(View view){

            header_textview = view.findViewById(R.id.header_textview);
            body_textview=view.findViewById(R.id.body_textview);

        }

    }

}
