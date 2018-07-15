package com.example.unknown.cheaperapp.Activity;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.unknown.cheaperapp.R;

import java.util.ArrayList;

public class Add_Notification_Activity extends AppCompatActivity {
    Button send_btn;
    EditText ChooseDebartment_edit_text;
    Spinner productName_spinner;
    ImageView productName_spinner_btn;
    ArrayAdapter adapter;
    TextView dialog_feedback_txt;
    LinearLayout containerlayout;
    //fortesting
    ArrayList<String>Productsnsame;
    Boolean SendState;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__notification_);
        GetElements();
        LoadSpinnersData();
        send_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shownotification();
            }
        });
    }



    public void GetElements(){
        send_btn=findViewById(R.id.send_btn);
        ChooseDebartment_edit_text=findViewById(R.id.ChooseDebartment_edit_text);
        productName_spinner=findViewById(R.id.productName_spinner);
        productName_spinner_btn=findViewById(R.id.productName_spinner_btn);
        containerlayout=findViewById(R.id.containerlayout);
    }


    private void LoadSpinnersData(){


        productName_spinner_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                productName_spinner.performClick();
            }
        });

        Productsnsame = new ArrayList<>();
        Productsnsame.add(getString(R.string.productname));
        Productsnsame.add("Dell xp 15225");
        Productsnsame.add("Lenovo 552245");
        Productsnsame.add("Samsung s8+");

        adapter = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,Productsnsame);

        productName_spinner.setAdapter(adapter);
    }

    private void shownotification(){
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.notificationlayout_send_feedback,
                (ViewGroup) findViewById(R.id.notify));
        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.BOTTOM, 0, 350);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        dialog_feedback_txt=layout.findViewById(R.id.dialog_feedback_txt);

        //test
        SendState=true;
        if(SendState){
            dialog_feedback_txt.setText("فشل الارسال");
        }else {
            dialog_feedback_txt.setText("تم ارسال طلبك بنجاح");

        }
        containerlayout.setAlpha(.3f);
        toast.show();
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //Do something after 100ms
                containerlayout.setAlpha(1f);

            }
        }, 2000);


    }

}
