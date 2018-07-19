package com.example.unknown.cheaperapp.Activity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
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
import java.util.Locale;

public class AdDetailsActivity extends AppCompatActivity {

    ViewPager imageSlider_viewpager;
    ArrayList<Images_Class> imageList;
    ImageSliderAdapter sliderAdapter;
    AdvertismentClass currentAd;
    Button moredescribtion_btn;
    TextView categoryName_textview,productName_textview,pricePreOffer_textview,priceAfterOffer_textview,description_textview
             ,sellerName_textview;
    int state;
    BranchesSpinnerAdapter spinnerAdapter;
    String description;
    Spinner branches_spinner;
    //Dialog btns,txt
    TextView colse_txt,storename_txt;
    Button phone_number_btn,getlocation_btn;
    double longitude,latitude;

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

        //handle spinner
        OnSpinnerSelect();



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
    public  void OnSpinnerSelect(){


        branches_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {

                // dialog set
                final Dialog dialog = new Dialog(AdDetailsActivity.this, R.style.NewDialog);
                dialog.setContentView(R.layout.dialog_location_phonenumber);
                dialog.setCancelable(true);
                dialog.show();

                //get elments
                colse_txt=(TextView)dialog.findViewById(R.id.colse_txt);
                storename_txt=(TextView)dialog.findViewById(R.id.storename_txt);
                getlocation_btn=(Button)dialog.findViewById(R.id.store_location_btn);
                phone_number_btn=(Button)dialog.findViewById(R.id.store_number_btn);
                // end


                // store name
                storename_txt.setText(" بيانات الفرع");
                //close_btn
                colse_txt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                phone_number_btn.setText("0109941240");
                //open store location
                getlocation_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String uri = String.format(Locale.ENGLISH, "geo:%f,%f", latitude, longitude);
                        latitude=30.0444;longitude=31.2357;
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                        getApplicationContext().startActivity(intent);
                    }
                });
                // phone number
                phone_number_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(Intent.ACTION_DIAL);
                        String p = "tel:" + "01099441240";
                        i.setData(Uri.parse(p));
                        startActivity(i);
                    }
                });

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });
    }

}
