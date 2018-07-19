package com.example.unknown.cheaperapp.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.unknown.cheaperapp.R;

public class SignUpActivity extends AppCompatActivity {

    TextView haveAccount_textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        haveAccount_textview=findViewById(R.id.haveAccount_textview);

        haveAccount_textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

    }
}
