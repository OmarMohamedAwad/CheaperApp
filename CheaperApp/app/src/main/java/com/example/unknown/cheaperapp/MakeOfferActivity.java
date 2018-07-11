package com.example.unknown.cheaperapp;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.example.unknown.cheaperapp.Classes.AdvertismentClass;

import java.util.ArrayList;

public class MakeOfferActivity extends AppCompatActivity {

    ArrayAdapter adapter1;
    ArrayAdapter adapter2;
    ArrayAdapter adapter3;
    ArrayList<String> categoriesList;
    ArrayList<String> durationList;
    ArrayList<String> branchesList;

    Spinner categoriesSpinner;
    Spinner durationSpinner;
    Spinner brancheSpinner;
    ImageView categoriesSpinnerImageView;
    ImageView durationSpinnerImageView;
    ImageView brancheSpinnerImageView;

    EditText productName_edittext;
    EditText productDescription_edittext;
    EditText priceBefore_edittext;
    EditText priceAfter_edittext;
    Button send_btn;


    private AdvertismentClass currentAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_offer);

        GetViewELements();


        currentAd = new AdvertismentClass();

        LoadSpinnersData();

        ChooseDuration();

    }


    private void ChooseDuration(){

        final Dialog dialog = new Dialog(this,R.style.NewDialog);

        durationSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(parent.getItemAtPosition(position).toString()==getString(R.string.StartandEndDate)){

                }
                else if(parent.getItemAtPosition(position).toString()==getString(R.string.StartDateUntilOfferEnd)){

                    dialog.setContentView(R.layout.calender_layout);



                    Button ok_btn= dialog.findViewById(R.id.ok_btn);

                    ok_btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });
                    dialog.show();

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    // this method for initialize Spinners with data
    private void LoadSpinnersData(){


        categoriesSpinnerImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    categoriesSpinner.performClick();
            }
        });

        durationSpinnerImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    durationSpinner.performClick();
            }
        });

        brancheSpinnerImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    brancheSpinner.performClick();
            }
        });

        //this just dumy data for test only
        categoriesList = new ArrayList<>();
        categoriesList.add(getString(R.string.ChooseCategory));
        categoriesList.add("ملابس");
        categoriesList.add("لابات");
        categoriesList.add("هواتف محمولة");
        categoriesList.add("شاشات");

        durationList = new ArrayList<>();
        durationList.add(getString(R.string.ChooseOfferDuration));
        durationList.add(getString(R.string.StartandEndDate));
        durationList.add(getString(R.string.StartDateUntilOfferEnd));


        branchesList = new ArrayList<>();
        branchesList.add(getString(R.string.ChooseBranches));
        branchesList.add(getString(R.string.Allbranches));
        branchesList.add("المنصورة");
        branchesList.add("اجا");
        branchesList.add("ميت غمر");


        adapter1 = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,categoriesList);
        adapter2 = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,durationList);
        adapter3 = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,branchesList);

        categoriesSpinner.setAdapter(adapter1);
        durationSpinner.setAdapter(adapter2);
        brancheSpinner.setAdapter(adapter3);
    }

    //this method for inflating view elements
    private void GetViewELements(){

        productName_edittext = findViewById(R.id.productName_edittext);
        productDescription_edittext = findViewById(R.id.productDescription_edittext);
        priceBefore_edittext = findViewById(R.id.priceBefore_edittext);
        priceAfter_edittext = findViewById(R.id.priceAfter_edittext);
        send_btn = findViewById(R.id.send_btn);


        categoriesSpinner=findViewById(R.id.category_spinner);
        durationSpinner = findViewById(R.id.offerDuration_spinner);
        brancheSpinner=findViewById(R.id.branches_spinner);

        categoriesSpinnerImageView=findViewById(R.id.selectCategory_spinner_imageview);
        durationSpinnerImageView=findViewById(R.id.selectOfferDuration_spinner_imageview);
        brancheSpinnerImageView=findViewById(R.id.selectBranches_spinner_imageview);



    }

    private  void SendData(){


    }

}
