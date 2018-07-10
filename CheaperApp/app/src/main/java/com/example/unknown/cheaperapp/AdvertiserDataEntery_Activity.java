package com.example.unknown.cheaperapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

public class AdvertiserDataEntery_Activity extends AppCompatActivity {

    ImageView GetLocation_btn;
    EditText storeaddress_Edittext;
    Button btn_conditions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advertiser_data_entery_);
        Intent intent = getIntent();
        String address = intent.getStringExtra("address");

        // spiner code
        Spinner spinner = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Country, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        //
        storeaddress_Edittext =(EditText)findViewById(R.id.storeaddress_Edittext);
        storeaddress_Edittext.setText(address);
        GetLocation_btn=(ImageView)findViewById(R.id.GetLocation_btn);
        GetLocation_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdvertiserDataEntery_Activity.this, MapActivity.class);
                startActivity(intent);
            }
        });



    }
}
