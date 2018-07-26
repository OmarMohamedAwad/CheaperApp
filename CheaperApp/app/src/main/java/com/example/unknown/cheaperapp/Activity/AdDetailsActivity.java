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
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.unknown.cheaperapp.Adapter.BranchesSpinnerAdapter;
import com.example.unknown.cheaperapp.Adapter.ImageSliderAdapter;
import com.example.unknown.cheaperapp.Classes.Add_Details;
import com.example.unknown.cheaperapp.Classes.AdvertismentClass;
import com.example.unknown.cheaperapp.Classes.Branch_Class;
import com.example.unknown.cheaperapp.Classes.Constraints;
import com.example.unknown.cheaperapp.Classes.Images_Class;
import com.example.unknown.cheaperapp.Classes.URLS;
import com.example.unknown.cheaperapp.R;
import com.example.unknown.cheaperapp.Volley.AppController;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class AdDetailsActivity extends AppCompatActivity {

    ViewPager imageSlider_viewpager;
    ArrayList<Images_Class> imageList;
    ImageSliderAdapter sliderAdapter;
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
    android.support.v7.widget.Toolbar toolbar;
    ImageView heartbtn;
    Add_Details currectadd;
    ArrayList<String>imagelistjs;
    ArrayList<Branch_Class>brancheslist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad_details);
        GetElements();
        GetAdDetails();
        //dumy data for testing only
        imageList = new ArrayList<>();
        imageList.add(new Images_Class(R.drawable.rightslider));
        imageList.add(new Images_Class(R.drawable.rightslider));
        imageList.add(new Images_Class(R.drawable.rightslider));


        sliderAdapter = new ImageSliderAdapter(this,imageList);

        imageSlider_viewpager.setAdapter(sliderAdapter);



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
        AddBackbtnInToolbar();



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
        imagelistjs=new ArrayList<>();
        brancheslist=new ArrayList<>();
        currectadd=new Add_Details();
        heartbtn=findViewById(R.id.favouriteicon);

    }

    private  void FillData(){
        categoryName_textview.setText("القسم");
        productName_textview.setText(currectadd.getProductName());
        pricePreOffer_textview.setText(String.valueOf(currectadd.getPrice())+" LE");
        priceAfterOffer_textview.setText(String.valueOf(currectadd.getPriceAfterDiscount()));
        priceAfterOffer_textview.setPaintFlags(pricePreOffer_textview.getPaintFlags()| Paint.STRIKE_THRU_TEXT_FLAG);
        description_textview.setText(currectadd.getDescription());
        sellerName_textview.setText(currectadd.getStoreName());

    }
    public  void OnSpinnerSelect(){
        branches_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, final int position, long id) {

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
                storename_txt.setText(brancheslist.get(position).getName());
                //close_btn
                colse_txt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                phone_number_btn.setText(brancheslist.get(position).getPhone());
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
                        String p = "tel:" + brancheslist.get(position).getPhone();
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



    public  void GetAdDetails(){
        final Branch_Class currentbranch=new Branch_Class();
    String urL= URLS.BaseUrl+URLS.AdDetailsUrl+"13"+"/18";
        StringRequest request=new StringRequest(Request.Method.GET, urL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {

                    JSONObject rootObj = new JSONObject(response);
                    JSONObject myobj=new JSONObject();
                    myobj=rootObj.getJSONObject("adv");
                    currectadd.setId((myobj.getInt("id")));
                    currectadd.setProductName(myobj.getString("productName"));
                    currectadd.setDescription(myobj.getString("description"));
                    currectadd.setStoreName(myobj.getString("storeName"));
                    currectadd.setPrice(String.valueOf(myobj.getInt("price")));
                    currectadd.setPriceAfterDiscount(String.valueOf(myobj.getInt("priceAfterDiscount")));
                    currectadd.setStartDate(myobj.getString("startDate"));
                    currectadd.setEndDate(myobj.getString("endDate"));
                    currectadd.setLimited(myobj.getBoolean("isLimited"));
                    currectadd.setFavourite(myobj.getBoolean("isFavourite"));
                    JSONArray imagesarr=myobj.getJSONArray("images");
                    JSONArray branchesarr=myobj.getJSONArray("branches");
                    for(int i=0;i<imagesarr.length();i++)
                    {
                      String image=imagesarr.getJSONObject(i).getString("path");
                        imagelistjs.add(image);
                    }

                    for(int i=0;i<branchesarr.length();i++)
                    {
                        currentbranch.setID(Integer.parseInt(branchesarr.getJSONObject(i).getString("id")));
                        currentbranch.setName(branchesarr.getJSONObject(i).getString("name"));
                        currentbranch.setPhone(branchesarr.getJSONObject(i).getString("phone"));
                        currentbranch.setAddress(branchesarr.getJSONObject(i).getString("address"));
                       // branchesarr.getJSONObject(i).getDouble("lat"))
                        currentbranch.setLat(String.valueOf("651561651"));
                        currentbranch.setLang(String.valueOf("6498498"));
                        brancheslist.add(currentbranch);
                    }
                    currectadd.setBranches(brancheslist);
                    spinnerAdapter= new BranchesSpinnerAdapter(getApplicationContext(),currectadd.getBranches());

                    branches_spinner.setAdapter(spinnerAdapter);
                    FillData();
                    isFavourite(currectadd.getFavourite());



                }
                catch(JSONException e){
                    Constraints.MyToast(getApplicationContext(),getString(R.string.errorParsing), Toast.LENGTH_SHORT);

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                String errorMsg ="حدث خطأ,برجاء المحاولة مرة اخرى" ;

                NetworkResponse response = error.networkResponse;
                if(response != null && response.data != null){
                    errorMsg = new String(response.data);
                }

                Constraints.MyToast(getApplicationContext(),errorMsg,Toast.LENGTH_SHORT);
            }
        })
        {
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("adId","1");
                params.put("userid","2");
                return params;
            }

        };
        request.setRetryPolicy(new DefaultRetryPolicy(30000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        AppController.getInstance().addToRequestQueue(request);

    }
    public void isFavourite(boolean isfavorite)
    {
        if(isfavorite==true)
        {
            heartbtn.setImageResource(R.drawable.redheart);
        }else
            {
                heartbtn.setImageResource(R.drawable.whiteheart);

            }

    }




}
