package com.example.unknown.cheaperapp.slider;

import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.unknown.cheaperapp.R;

import java.util.ArrayList;

import me.relex.circleindicator.CircleIndicator;

public class ProductDetailsActivity extends AppCompatActivity {

    private static ViewPager mPager;
    ArrayList<String> stores;
    GridView gridView;
    TextView pricebeforeoffere;

    //dialog view elements
    Button signin_btn;
    Button signup_btn;
    Button continue_btn;


    private static int currentPage = 0;
    private static final Integer[] XMEN= {R.drawable.shooes1, R.drawable.shooes2, R.drawable.shooes3jpg};
    private ArrayList<Integer> XMENArray = new ArrayList<Integer>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        GetViewElements();
        initializeImageFlipper();
        pricebeforeoffere = (TextView) findViewById(R.id.pricebeforeoffere);
        pricebeforeoffere.setText("500جنيه");
        pricebeforeoffere.setPaintFlags(pricebeforeoffere.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);



        // spiner code
        Spinner spinner = (Spinner) findViewById(R.id.storespinner);
        ArrayAdapter<CharSequence> adapterspin = ArrayAdapter.createFromResource(this, R.array.Country, android.R.layout.simple_spinner_item);
        adapterspin.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapterspin);
        //


    }





    private void initializeImageFlipper() {
        for(int i=0;i<XMEN.length;i++)
            XMENArray.add(XMEN[i]);


        mPager.setAdapter(new imageadapter(ProductDetailsActivity.this,XMENArray));
        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
        indicator.setViewPager(mPager);

        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == XMEN.length) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };
       /* Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 2500, 2500);*/
    }


    private void GetViewElements(){
        mPager = (ViewPager) findViewById(R.id.pager);
    }

}

