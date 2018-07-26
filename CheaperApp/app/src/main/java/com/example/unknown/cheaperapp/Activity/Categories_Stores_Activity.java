package com.example.unknown.cheaperapp.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.example.unknown.cheaperapp.Adapter.CategoriesRecyclerviewAdapter;
import com.example.unknown.cheaperapp.Adapter.StoresRecyclerviewAdapter;
import com.example.unknown.cheaperapp.Classes.Category_Class;
import com.example.unknown.cheaperapp.Classes.Constraints;
import com.example.unknown.cheaperapp.Classes.StoreClass;
import com.example.unknown.cheaperapp.Classes.URLS;
import com.example.unknown.cheaperapp.Interface.CategoryOnItemCliclkListenerInterface;
import com.example.unknown.cheaperapp.Interface.StoreOnItemCliclkListenerInterface;
import com.example.unknown.cheaperapp.R;
import com.example.unknown.cheaperapp.Volley.AppController;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Categories_Stores_Activity extends AppCompatActivity implements CategoryOnItemCliclkListenerInterface,StoreOnItemCliclkListenerInterface {

    RecyclerView categories_sellers_recyclerview;
    GridLayoutManager layoutManager;

    CategoriesRecyclerviewAdapter categoriesAdapter;
    ArrayList<Category_Class> categoriesList;

    StoresRecyclerviewAdapter storesAdapter;
    ArrayList<StoreClass> storeList;
    android.support.v7.widget.Toolbar toolbar;

    ProgressBar categories_sellers_progressbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories__sellers_);

        GetElements();


        int type =getIntent().getIntExtra("type",0);

        if(type==1){



            getCategoriesData();

            categoriesAdapter = new CategoriesRecyclerviewAdapter(categoriesList,this);

            layoutManager = new GridLayoutManager(this,2);

            categories_sellers_recyclerview.setLayoutManager(layoutManager);
            categories_sellers_recyclerview.setHasFixedSize(true);
            categories_sellers_recyclerview.setAdapter(categoriesAdapter);
        }
        else {
            //this just dumy data for test purposes
            storeList = new ArrayList<>();
            storeList.add(new StoreClass(1,"ابو الخير",R.drawable.toys));
            storeList.add(new StoreClass(1,"ابو الخير",R.drawable.toys));
            storeList.add(new StoreClass(1,"ابو الخير",R.drawable.toys));
            storeList.add(new StoreClass(1,"ابو الخير",R.drawable.toys));
            storeList.add(new StoreClass(1,"ابو الخير",R.drawable.toys));
            storeList.add(new StoreClass(1,"ابو الخير",R.drawable.toys));
            storeList.add(new StoreClass(1,"ابو الخير",R.drawable.toys));
            storeList.add(new StoreClass(1,"ابو الخير",R.drawable.toys));

            storesAdapter = new StoresRecyclerviewAdapter(storeList,this);

            layoutManager = new GridLayoutManager(this,2);

            categories_sellers_recyclerview.setLayoutManager(layoutManager);
            categories_sellers_recyclerview.setHasFixedSize(true);
            categories_sellers_recyclerview.setAdapter(storesAdapter);

        }


        AddBackbtnInToolbar();
    }


    private void  GetElements(){
        categories_sellers_recyclerview=findViewById(R.id.categories_sellers_recyclerview);
        categories_sellers_progressbar=findViewById(R.id.categories_sellers_progressbar);
    }

    @Override
    public void OnCategoryItemClick(int position) {

        Intent intent = new Intent(Categories_Stores_Activity.this,SpecificAdsActivity.class);
        intent.putExtra("type",1);
        startActivity(intent);
    }

    @Override
    public void OnStoreItemClick(int position) {

        Intent intent = new Intent(Categories_Stores_Activity.this,SpecificAdsActivity.class);
        intent.putExtra("type",2);
        startActivity(intent);
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


    private void getCategoriesData(){

        String url = URLS.BaseUrl+URLS.getCategoriesUrl;

        categoriesList= new ArrayList<>();

        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {

                    JSONArray rootArry = new JSONArray(response);

                    for (int i=0;i<rootArry.length();i++){

                        Category_Class currentCategory= new Category_Class();

                        JSONObject catObj= rootArry.getJSONObject(i);

                        currentCategory.setID(catObj.getInt("id"));
                        currentCategory.setName(catObj.getString("name"));
                        currentCategory.setImageUrl(catObj.getString("path"));

                        categoriesList.add(currentCategory);
                    }

                    categories_sellers_progressbar.setVisibility(View.GONE);
                }
                catch (JSONException e) {
                    Constraints.MyToast(Categories_Stores_Activity.this,getString(R.string.errorParsing),Toast.LENGTH_SHORT);
                }
                categoriesAdapter.notifyDataSetChanged();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                String errorMsg ="حدث خطأ,برجاء المحاولة مرة اخرى" ;

                NetworkResponse response = error.networkResponse;
                if(response != null && response.data != null){
                    errorMsg = new String(response.data);
                }

                Constraints.MyToast(Categories_Stores_Activity.this,errorMsg, Toast.LENGTH_SHORT);
            }
        });

        AppController.getInstance().addToRequestQueue(request);
        categoriesList.size();

    }

}
