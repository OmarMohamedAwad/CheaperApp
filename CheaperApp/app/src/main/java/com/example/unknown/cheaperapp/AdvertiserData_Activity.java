


package com.example.unknown.cheaperapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;

import com.example.unknown.cheaperapp.Classes.Branch_Class;

import java.util.ArrayList;

public class AdvertiserData_Activity extends AppCompatActivity {


    Button addBranch_btn,save_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advertiser_data_);

        ArrayList<Branch_Class> branches = new ArrayList<Branch_Class>();
        branches.add(new Branch_Class("01099441240","Mansoura","Dachlia , Egypte"));
        branches.add(new Branch_Class("01099441240","Mansoura","Dachlia , Egypte"));
        ListView brancheslist = (ListView)findViewById(R.id.listofstores);
        BranchListViewAdapter adapter = new BranchListViewAdapter(getApplication(),branches);
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







