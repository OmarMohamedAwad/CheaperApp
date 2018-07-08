package com.example.unknown.cheaperapp;


import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * A simple {@link Fragment} subclass.
 */
public class UserAgreementFragment extends Fragment {

    ExpandableListView userAgreement_expandablelistview;

    CheckBox userAgreement_checkbox;

    Button sign_btn;

    HashMap<String ,ArrayList<String>> AgreementHashmap;


    public UserAgreementFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_user_agreement, container, false);

        GetViewELements(view);

        ArrayList<String> Conditions= new ArrayList<>();
        Conditions.add("يحظر على المتاجر الانشطه التاليه");
        Conditions.add("الاعلان عن اى منتجات لا تخص اقسام المنتجات المعروضه بالتطبيق. \n كذلك اى استخدام غير مصرح به لخدمات ارخصلى بما فى ذلك جميع اسماء المستخدمين او عناوين البريد الالكترونى ");

        AgreementHashmap = new HashMap<>();

        AgreementHashmap.put("اعتماد الاتفاقيه",Conditions);
        AgreementHashmap.put("وصف الخدمة",Conditions);
        AgreementHashmap.put("الانشطة المحظورة",Conditions);

        /////////////////////////////////////////////////////////////////////////////////


        UserAgreementAdapter adapter = new UserAgreementAdapter(getActivity(),AgreementHashmap);

        userAgreement_expandablelistview.setAdapter(adapter);


        sign_btn. setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ConfirmUserAgreement();

            }
        });

        return view;
    }


    //this method display dialog to user to confirm that request has been submitted
    private void ConfirmUserAgreement() {

        Dialog dialog = new Dialog(getActivity(),R.style.Theme_Dialog);

        dialog.setTitle(R.string.SuccessRequest);

        dialog.setContentView(R.layout.special_confirmation_dilaog_layout);

        dialog.show();

    }


    //this method for inflating view elements
    private void GetViewELements(View view) {

        userAgreement_expandablelistview = view.findViewById(R.id.userAgreement_expandablelistview);
        userAgreement_checkbox = view.findViewById(R.id.userAgreement_checkbox);
        sign_btn = view.findViewById(R.id.sign_btn);

    }


}
