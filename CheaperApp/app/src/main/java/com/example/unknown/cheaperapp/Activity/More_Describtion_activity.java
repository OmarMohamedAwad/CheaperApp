package com.example.unknown.cheaperapp.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.unknown.cheaperapp.R;

public class More_Describtion_activity extends AppCompatActivity {
String description;
TextView description_txtview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more__describtion_activity);
        description_txtview=findViewById(R.id.productDescription_edittext);
        Intent i= getIntent();
        Bundle b = i.getExtras();
       description=(String) b.get("description");
       description_txtview.setText(description);
    }
}
