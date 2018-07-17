package com.example.unknown.cheaperapp.Activity;

import android.content.Intent;
import android.graphics.Paint;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.unknown.cheaperapp.Adapter.BranchesSpinnerAdapter;
import com.example.unknown.cheaperapp.Adapter.ImageSliderAdapter;
import com.example.unknown.cheaperapp.Classes.AdvertismentClass;
import com.example.unknown.cheaperapp.Classes.Branch_Class;
import com.example.unknown.cheaperapp.Classes.Images_Class;
import com.example.unknown.cheaperapp.R;

import java.util.ArrayList;

public class AdDetailsActivity extends AppCompatActivity {

    ViewPager imageSlider_viewpager;
    ArrayList<Images_Class> imageList;
    ImageSliderAdapter sliderAdapter;
    AdvertismentClass currentAd;
    ImageView moredescribtion_btn;
    TextView categoryName_textview,productName_textview,pricePreOffer_textview,priceAfterOffer_textview,description_textview
             ,sellerName_textview;

    BranchesSpinnerAdapter spinnerAdapter;
    String description;
    Spinner branches_spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad_details);

        GetElements();

        FillData();
        //dumy data for testing only
        imageList = new ArrayList<>();
        imageList.add(new Images_Class(R.drawable.rightslider));
        imageList.add(new Images_Class(R.drawable.rightslider));
        imageList.add(new Images_Class(R.drawable.rightslider));


        sliderAdapter = new ImageSliderAdapter(this,imageList);

        imageSlider_viewpager.setAdapter(sliderAdapter);

        spinnerAdapter= new BranchesSpinnerAdapter(this,currentAd.getAdvertisementBranchs());

        branches_spinner.setAdapter(spinnerAdapter);

        // for more describtion
        moredescribtion_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                description=description_textview.getText().toString();
                Intent i = new Intent(AdDetailsActivity.this, More_Describtion_activity.class);
                String strName = null;
                i.putExtra("description", description);
                startActivity(i);
            }
        });

    }

    private void GetElements(){
        categoryName_textview=findViewById(R.id.categoryName_textview);
        productName_textview=findViewById(R.id.productName_textview);
        pricePreOffer_textview=findViewById(R.id.pricePreOffer_textview);
        priceAfterOffer_textview=findViewById(R.id.priceAfterOffer_textview);
        description_textview=findViewById(R.id.description_textview);
        sellerName_textview=findViewById(R.id.sellerName_textview);
        imageSlider_viewpager=findViewById(R.id.imageSlider_viewpager);
        branches_spinner=findViewById(R.id.branches_spinner);
        moredescribtion_btn=findViewById(R.id.more_btn);
    }


    private  void FillData(){

        currentAd= new AdvertismentClass();

        currentAd.setCategoryName("ملابس");
        currentAd.setProductName("تيشرت بات مان");
        currentAd.setPrice(400);
        currentAd.setPriceAfterDiscount(200);
        currentAd.setDescription("تيشرت بات مان للطفال من سن 15 ل 16 سنه");
        currentAd.setSellerName("محلات ديزنى لاند");

        ArrayList<Branch_Class> branchesList = new ArrayList<>();
        branchesList.add(new Branch_Class(1,"الجلاء"));
        branchesList.add(new Branch_Class(1,"اجا"));
        branchesList.add(new Branch_Class(1,"الترعة"));
        branchesList.add(new Branch_Class(1,"قناة السويس"));

        currentAd.setAdvertisementBranchs(branchesList);


        categoryName_textview.setText(currentAd.getCategoryName());
        productName_textview.setText(currentAd.getProductName());
        pricePreOffer_textview.setText(String.valueOf(currentAd.getPrice())+" LE");
        priceAfterOffer_textview.setText(String.valueOf(currentAd.getPriceAfterDiscount()));
        priceAfterOffer_textview.setPaintFlags(priceAfterOffer_textview.getPaintFlags()| Paint.STRIKE_THRU_TEXT_FLAG);
        description_textview.setText(currentAd.getDescription());
        sellerName_textview.setText(currentAd.getSellerName());

    }
}
