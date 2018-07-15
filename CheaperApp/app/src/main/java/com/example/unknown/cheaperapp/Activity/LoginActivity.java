package com.example.unknown.cheaperapp.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.unknown.cheaperapp.Classes.User_Class;
import com.example.unknown.cheaperapp.R;

public class LoginActivity extends AppCompatActivity {


    Button signin_btn;


     public static User_Class currentUser;



//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        callbackManager.onActivityResult(requestCode,resultCode,data);
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        signin_btn= findViewById(R.id.signin_btn);

        signin_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(LoginActivity.this,MainActivity.class));
            }
        });


    }

//
//    private void FBLogin(){
//
//        ///
//
//        CallbackManager callbackManager;
//        ProgressDialog mdialog;
//        ///
//
//
//
//        GetViewELements();
//
//        callbackManager=CallbackManager.Factory.create();
//
//        loginButton.setReadPermissions(Arrays.asList("public_profile","email","user_birthday","user_friends"));
//
//        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
//            @Override
//            public void onSuccess(LoginResult loginResult) {
//
//                mdialog= new ProgressDialog(LoginActivity.this);
//                mdialog.setMessage("Retrieving Data From FB.....");
//                mdialog.show();
//
//                String accessToken = loginResult.getAccessToken().getToken();
//
//
//                GraphRequest request = GraphRequest.newMeRequest(loginResult.getAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
//                    @Override
//                    public void onCompleted(JSONObject object, GraphResponse response) {
//
//                        mdialog.dismiss();
//
//                        Log.d("response",object.toString());
//
//                        GetData(object);
//                    }
//                });
//
//
//                Bundle params = new Bundle();
//                params.putString("field","id,email,birthday,friends");
//                request.setParameters(params);
//                request.executeAsync();
//
//            }
//
//            @Override
//            public void onCancel() {
//
//            }
//
//            @Override
//            public void onError(FacebookException error) {
//
//            }
//        });
//
//
//        if(AccessToken.getCurrentAccessToken()!=null){
//
//
//        }
//    }
//
//    private void GetData(JSONObject object){
//
//        try {
//            String picture_url ="https://graph.facebook.com/"+object.getString("id")+"picture?width=250&height=250";
//
//            name_Edittext.setText(object.getString("name"));
//            name_Edittext.setText(object.getString("first_name")+" "+object.getString("last_name"));
//            phone_Edittext.setText(object.getString("birthday"));
//            email_Edittext.setText(object.getString("email"));
//            password_Edittext.setText(object.getString("gender"));
//            retypePassword_Edittext.setText(object.getJSONObject("friends").getJSONObject("summary").getString("total_count"));
//
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//
//
//    }
//
//    //this method for inflating view elements
//    private void GetViewELements(){
//
//        ImageView user_ImageView;
//        EditText name_Edittext;
//        EditText email_Edittext;
//        EditText phone_Edittext;
//        EditText password_Edittext;
//        EditText retypePassword_Edittext;
//        Button signup_btn;
//        LoginButton loginButton;
//
//
//
//        name_Edittext=findViewById(R.id.name_Edittext);
//        email_Edittext=findViewById(R.id.email_Edittext);
//        phone_Edittext=findViewById(R.id.phone_Edittext);
//        password_Edittext=findViewById(R.id.password_Edittext);
//        retypePassword_Edittext=findViewById(R.id.retypePassword_Edittext);
//        signup_btn=findViewById(R.id.signup_btn);
//        user_ImageView=findViewById(R.id.user_ImageView);
//        loginButton=findViewById(R.id.facebookLogin);
//
//    }
}