package com.example.unknown.cheaperapp.Activity;

import android.app.Dialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.unknown.cheaperapp.Adapter.BranchesExpandableListviewAdapter;
import com.example.unknown.cheaperapp.Classes.AdvertismentClass;
import com.example.unknown.cheaperapp.Classes.Branch_Class;
import com.example.unknown.cheaperapp.R;

import java.util.ArrayList;

public class MakeOfferActivity extends AppCompatActivity {

    ArrayAdapter adapter1,adapter2;
    ArrayList<String> categoriesList;
    ArrayList<String> durationList;

    Spinner categoriesSpinner,durationSpinner;

    ImageView categoriesSpinnerImageView,durationSpinnerImageView;

    EditText productName_edittext,productDescription_edittext,priceBefore_edittext,priceAfter_edittext;
    Button send_btn;

    ExpandableListView branches_expendablelistview;
    BranchesExpandableListviewAdapter exapendableAdapter;
    ArrayList<Branch_Class> branchList;


    TextView startDate_textview,endDate_textview;
    LinearLayout linearLayout ;
    android.support.v7.widget.Toolbar toolbar;



    private AdvertismentClass currentAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_offer);

        GetViewELements();


        currentAd = new AdvertismentClass();

        LoadSpinnersData();

        ChooseDuration();


        //just dumy data

        branchList= new ArrayList<>();
        branchList.add(new Branch_Class(1,getString(R.string.Allbranches)));
        branchList.add(new Branch_Class(1,"المنصورة"));
        branchList.add(new Branch_Class(1,"اجا"));
        branchList.add(new Branch_Class(1,"ميت غمر"));
        branchList.add(new Branch_Class(1,"دكرنس"));


        exapendableAdapter = new BranchesExpandableListviewAdapter(branchList,MakeOfferActivity.this);

        branches_expendablelistview.setAdapter(exapendableAdapter);
        branches_expendablelistview.setDivider(null);
        branches_expendablelistview.setChildDivider(null);
        branches_expendablelistview.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                setListViewHeight(parent,groupPosition);
                return false;
            }
        });


        AddBackbtnInToolbar();

    }


    private void ChooseDuration(){

        final Dialog dialog = new Dialog(this,R.style.NewDialog);
        dialog.setContentView(R.layout.calender_layout);
        final Button btn_ok = dialog.findViewById(R.id.ok_btn);
        final Button btn_next = dialog.findViewById(R.id.next_btn);
        final TextView date_textview=dialog.findViewById(R.id.date_textview);
        final  TextView selectedDate_textview=dialog.findViewById(R.id.selectedDate_textview);
        final CalendarView calendarView = dialog.findViewById(R.id.calendarView);



        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {

                selectedDate_textview.setText(String.valueOf(year)+"/"+String.valueOf(month)+"/"+String.valueOf(dayOfMonth));
            }
        });

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_next.setVisibility(View.GONE);
                btn_ok.setVisibility(View.VISIBLE);
                startDate_textview.setText(getString(R.string.StartDate)+selectedDate_textview.getText());
                date_textview.setText(getString(R.string.EndDate));
            }
        });


        durationSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                btn_next.setVisibility(View.VISIBLE);
                btn_ok.setVisibility(View.VISIBLE);


                if(parent.getItemAtPosition(position).toString()==getString(R.string.StartandEndDate)){

                    date_textview.setText(getString(R.string.StartDate));

                    btn_ok.setVisibility(View.GONE);

                    btn_ok.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            endDate_textview.setText(getString(R.string.EndDate)+selectedDate_textview.getText());
                            linearLayout.setVisibility(View.VISIBLE);
                            dialog.dismiss();
                        }
                    });

                    dialog.show();
                }
                else if(parent.getItemAtPosition(position).toString()==getString(R.string.StartDateUntilOfferEnd)){

                    btn_ok.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });
                    btn_next.setVisibility(View.GONE);


                    dialog.show();

                }
                else if(parent.getItemAtPosition(position).toString()==getString(R.string.ChooseOfferDuration)){
                    linearLayout.setVisibility(View.GONE);
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



        adapter1 = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,categoriesList);
        adapter2 = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,durationList);

        categoriesSpinner.setAdapter(adapter1);
        durationSpinner.setAdapter(adapter2);
    }

    //this method for inflating view elements
    private void GetViewELements(){

        productName_edittext = findViewById(R.id.productName_edittext);
        productDescription_edittext = findViewById(R.id.productDescription_edittext);
        priceBefore_edittext = findViewById(R.id.priceBefore_edittext);
        priceAfter_edittext = findViewById(R.id.priceAfter_edittext);
        send_btn = findViewById(R.id.send_btn);

        linearLayout= findViewById(R.id.linear_layout);

        startDate_textview=findViewById(R.id.startDate_textview);
        endDate_textview=findViewById(R.id.endDate_textview);

        categoriesSpinner=findViewById(R.id.category_spinner);
        durationSpinner = findViewById(R.id.offerDuration_spinner);

        categoriesSpinnerImageView=findViewById(R.id.selectCategory_spinner_imageview);
        durationSpinnerImageView=findViewById(R.id.selectOfferDuration_spinner_imageview);

        branches_expendablelistview = findViewById(R.id.branches_expendablelistview);



    }

    private void setListViewHeight(ExpandableListView listView,
                                   int group) {
        ExpandableListAdapter listAdapter = (ExpandableListAdapter) listView.getExpandableListAdapter();
        int totalHeight = 0;
        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(),
                View.MeasureSpec.EXACTLY);
        for (int i = 0; i < listAdapter.getGroupCount(); i++) {
            View groupItem = listAdapter.getGroupView(i, false, null, listView);
            groupItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);

            totalHeight += groupItem.getMeasuredHeight();

            if (((listView.isGroupExpanded(i)) && (i != group))
                    || ((!listView.isGroupExpanded(i)) && (i == group))) {
                for (int j = 0; j < listAdapter.getChildrenCount(i); j++) {
                    View listItem = listAdapter.getChildView(i, j, false, null,
                            listView);
                    listItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);

                    totalHeight += listItem.getMeasuredHeight();

                }
            }
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        int height = totalHeight
                + (listView.getDividerHeight() * (listAdapter.getGroupCount() - 1));
        if (height < 10)
            height = 200;
        params.height = height;
        listView.setLayoutParams(params);
        listView.requestLayout();

    }

    private  void SendData(){


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
