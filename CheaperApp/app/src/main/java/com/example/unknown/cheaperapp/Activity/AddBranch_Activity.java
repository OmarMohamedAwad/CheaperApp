package com.example.unknown.cheaperapp.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.unknown.cheaperapp.R;

public class AddBranch_Activity extends AppCompatActivity {
ImageView GetLocation_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_branch_);
        GetLocation_btn=(ImageView)findViewById(R.id.GetLocation_btn);
        GetLocation_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddBranch_Activity.this, MapActivity.class);
                startActivity(intent);
            }
        });

    }
}
