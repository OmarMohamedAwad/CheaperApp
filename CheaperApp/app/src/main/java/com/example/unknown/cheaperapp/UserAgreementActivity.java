package com.example.unknown.cheaperapp;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;

public class UserAgreementActivity extends AppCompatActivity {

    ExpandableListView userAgreement_expandablelistview;

    CheckBox userAgreement_checkbox;

    Button sign_btn;

    HashMap<String ,ArrayList<String>> AgreementHashmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_agreement);

        GetViewELements();

        ArrayList<String> Conditions= new ArrayList<>();
        Conditions.add("يحظر على المتاجر الانشطه التاليه");
        Conditions.add("الاعلان عن اى منتجات لا تخص اقسام المنتجات المعروضه بالتطبيق. \n كذلك اى استخدام غير مصرح به لخدمات ارخصلى بما فى ذلك جميع اسماء المستخدمين او عناوين البريد الالكترونى ");

        AgreementHashmap = new HashMap<>();

        AgreementHashmap.put("اعتماد الاتفاقيه",Conditions);
        AgreementHashmap.put("وصف الخدمة",Conditions);
        AgreementHashmap.put("الانشطة المحظورة",Conditions);

        /////////////////////////////////////////////////////////////////////////////////


        UserAgreementAdapter adapter = new UserAgreementAdapter(this,AgreementHashmap);

        userAgreement_expandablelistview.setAdapter(adapter);


        sign_btn. setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ConfirmUserAgreement();

            }
        });

//        AddSpaceBetweenItems();

    }

    //this method display dialog to user to confirm that request has been submitted
    private void ConfirmUserAgreement() {

        Dialog dialog = new Dialog(this,R.style.Theme_Dialog);

        dialog.setTitle(R.string.SuccessRequest);

        dialog.setContentView(R.layout.special_confirmation_dilaog_layout);


        dialog.show();


    }


    //this method for inflating view elements
    private void GetViewELements() {

        userAgreement_expandablelistview = findViewById(R.id.userAgreement_expandablelistview);
        userAgreement_checkbox = findViewById(R.id.userAgreement_checkbox);
        sign_btn = findViewById(R.id.sign_btn);

    }

    //this method used to add white space between expandablelistview items
    private void AddSpaceBetweenItems(){
        userAgreement_expandablelistview.setDividerHeight(10);
    }
}
