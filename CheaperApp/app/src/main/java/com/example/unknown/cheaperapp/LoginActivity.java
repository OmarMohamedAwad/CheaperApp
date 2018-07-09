package com.example.unknown.cheaperapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

public class LoginActivity extends AppCompatActivity {

    ImageView user_ImageView;
    EditText name_Edittext;
    EditText email_Edittext;
    EditText phone_Edittext;
    EditText password_Edittext;
    EditText retypePassword_Edittext;
    Button signup_btn;
    LoginButton loginButton;


    CallbackManager callbackManager;
    ProgressDialog mdialog;


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode,resultCode,data);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        GetViewELements();

        callbackManager=CallbackManager.Factory.create();

        loginButton.setReadPermissions(Arrays.asList("public_profile","email","user_birthday","user_friends"));

        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

                mdialog= new ProgressDialog(LoginActivity.this);
                mdialog.setMessage("Retrieving Data From FB.....");
                mdialog.show();

                String accessToken = loginResult.getAccessToken().getToken();


                GraphRequest request = GraphRequest.newMeRequest(loginResult.getAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(JSONObject object, GraphResponse response) {

                        mdialog.dismiss();

                        Log.d("response",object.toString());

                        GetData(object);
                    }
                });


                Bundle params = new Bundle();
                params.putString("field","id,email,birthday,friends");
                request.setParameters(params);
                request.executeAsync();

            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });


        if(AccessToken.getCurrentAccessToken()!=null){


        }

    }


    private void GetData(JSONObject object){

        try {
            String picture_url ="https://graph.facebook.com/"+object.getString("id")+"picture?width=250&height=250";

            name_Edittext.setText(object.getString("name"));
            name_Edittext.setText(object.getString("first_name")+" "+object.getString("last_name"));
            phone_Edittext.setText(object.getString("birthday"));
            email_Edittext.setText(object.getString("email"));
            password_Edittext.setText(object.getString("gender"));
            retypePassword_Edittext.setText(object.getJSONObject("friends").getJSONObject("summary").getString("total_count"));

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    //this method for inflating view elements
    private void GetViewELements(){

        name_Edittext=findViewById(R.id.name_Edittext);
        email_Edittext=findViewById(R.id.email_Edittext);
        phone_Edittext=findViewById(R.id.phone_Edittext);
        password_Edittext=findViewById(R.id.password_Edittext);
        retypePassword_Edittext=findViewById(R.id.retypePassword_Edittext);
        signup_btn=findViewById(R.id.signup_btn);
        user_ImageView=findViewById(R.id.user_ImageView);
        loginButton=findViewById(R.id.facebookLogin);

    }
}
