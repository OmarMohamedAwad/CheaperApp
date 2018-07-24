package com.example.unknown.cheaperapp.Classes;

import android.content.Context;
import android.widget.Toast;

public class Constraints {


    private static Toast mToast;

    public static void MyToast(Context context, String text, int duration) {
        if (mToast != null) mToast.cancel();
        mToast = Toast.makeText(context, text, duration);
        mToast.show();
    }

    public static boolean NotEmpty(String text){

        if(text!=null&&text.length()>=1){

            return true;

        }

        return false;

    }


}
