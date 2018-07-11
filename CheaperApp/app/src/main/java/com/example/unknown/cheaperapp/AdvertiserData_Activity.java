


package com.example.unknown.cheaperapp;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.unknown.cheaperapp.Classes.Branch_Class;

import java.util.ArrayList;

public class AdvertiserData_Activity extends AppCompatActivity {


    Button addBranch_btn,save_btn;
    BranchListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advertiser_data_);

        final ArrayList<Branch_Class> branches = new ArrayList<Branch_Class>();
        branches.add(new Branch_Class("01099441240","Mansoura","Dachlia , Egypte"));
        branches.add(new Branch_Class("01099441240","Mansoura","Dachlia , Egypte"));
        ListView brancheslist = (ListView)findViewById(R.id.listofstores);
         adapter = new BranchListViewAdapter(getApplication(),branches);
        brancheslist.setAdapter(adapter);

        // Handle scroll between parent and listview
        brancheslist.setOnTouchListener(new View.OnTouchListener() {
            // Setting on Touch Listener for handling the touch inside ScrollView
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // Disallow the touch request for parent scroll on touch of child view
                v.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });


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

    }
}







