


package com.example.unknown.cheaperapp.Activity;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.unknown.cheaperapp.Adapter.BranchListViewAdapter;
import com.example.unknown.cheaperapp.Classes.Branch_Class;
import com.example.unknown.cheaperapp.R;

import java.util.ArrayList;

public class AdvertiserData_Activity extends AppCompatActivity {

    ListView brancheslist;
    ArrayList<Branch_Class> branches;

    Button addBranch_btn,save_btn;
    BranchListViewAdapter adapter;
    android.support.v7.widget.Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advertiser_data_);

        branches = new ArrayList<Branch_Class>();
        branches.add(new Branch_Class("01099441240","Mansoura","Dachlia , Egypte"));
        branches.add(new Branch_Class("01099441240","Mansoura","Dachlia , Egypte"));
        brancheslist = findViewById(R.id.listofstores);


        adapter = new BranchListViewAdapter(getApplication(),branches);
        brancheslist.setAdapter(adapter);
        brancheslist.setDivider(null);
        setListViewHeightBasedOnItems(brancheslist);


        brancheslist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, final int i, long l) {


                ImageView edit_btn=(ImageView)view.findViewById(R.id.edit_btn);
                edit_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                     public void onClick(View view) {
                     startActivity(new Intent(AdvertiserData_Activity.this,EditBranch_Activity.class));

                }});


                        ImageView delete_btn = (ImageView) view.findViewById(R.id.delete_btn);
                delete_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // dialog set
                        final Dialog dialog = new Dialog(AdvertiserData_Activity.this, R.style.NewDialog);
                        dialog.setContentView(R.layout.special_confirmiation_delete);

                        dialog.setCancelable(false);


                        Button onfirm_delete_btm = (Button) dialog.findViewById(R.id.onfirm_delete_btm);
                        onfirm_delete_btm.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialog.dismiss();
                                branches.remove(i);
                                adapter.notifyDataSetChanged();
                                Toast.makeText(AdvertiserData_Activity.this, "تم المسح", Toast.LENGTH_LONG).show();
                            }
                        });

                        Button back_btn = (Button) dialog.findViewById(R.id.back_btn);
                        back_btn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialog.dismiss();

                            }
                        });

                        dialog.show();



                    }



                });






            }
        });


        addBranch_btn=findViewById(R.id.addBranch_btn);
        save_btn=findViewById(R.id.save_btn);

        addBranch_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AdvertiserData_Activity.this,AddBranch_Activity.class));
            }
        });
        AddBackbtnInToolbar();
    }

    //this method to make the listview height expand to cover all items
    public static boolean setListViewHeightBasedOnItems(ListView listView) {

        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter != null) {

            int numberOfItems = listAdapter.getCount();

            // Get total height of all items.
            int totalItemsHeight = 0;
            for (int itemPos = 0; itemPos < numberOfItems; itemPos++) {
                View item = listAdapter.getView(itemPos, null, listView);
                item.measure(0, 0);
                totalItemsHeight += item.getMeasuredHeight();
            }

            // Get total height of all item dividers.
            int totalDividersHeight = listView.getDividerHeight() *
                    (numberOfItems - 1);

            // Set list height.
            ViewGroup.LayoutParams params = listView.getLayoutParams();
            params.height = totalItemsHeight + totalDividersHeight;
            listView.setLayoutParams(params);
            listView.requestLayout();

            return true;

        } else {
            return false;
        }

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







