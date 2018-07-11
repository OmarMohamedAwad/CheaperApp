package com.example.unknown.cheaperapp.Classes;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.example.unknown.cheaperapp.R;

public class LoginEmailDialog extends AppCompatDialogFragment {

    private EditText EditTextMail;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder= new AlertDialog.Builder(getActivity());

        LayoutInflater inflater=getActivity().getLayoutInflater();
        View view=inflater.inflate(R.layout.dialog_forgetmail_login,null);

        builder.setView(view);


        EditTextMail=view.findViewById(R.id.email_dialog_Edittext);
        return builder.create();
    }
}
