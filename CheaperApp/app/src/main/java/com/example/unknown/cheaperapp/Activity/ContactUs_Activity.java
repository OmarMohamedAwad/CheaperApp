package com.example.unknown.cheaperapp.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.unknown.cheaperapp.R;

public class ContactUs_Activity extends AppCompatActivity {
    android.support.v7.widget.Toolbar toolbar;
    EditText email,username,message;
    Button send_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us_);
        AddBackbtnInToolbar();
        GetElements();
        send_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
    private void GetElements(){
        email=findViewById(R.id.email_Edittext);
        username=findViewById(R.id.name_Edittext);
        message=findViewById(R.id.message);
        send_btn=findViewById(R.id.send_btn);
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
