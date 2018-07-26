package com.example.unknown.cheaperapp.Activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.unknown.cheaperapp.Classes.URLS;
import com.example.unknown.cheaperapp.Classes.User_Class;
import com.example.unknown.cheaperapp.R;
import com.example.unknown.cheaperapp.Volley.AppController;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

public class SignUpActivity extends AppCompatActivity {

    ImageView user_ImageView;
    EditText name_Edittext;
    EditText email_Edittext;
    EditText phone_Edittext;
    EditText password_Edittext;
    EditText retypePassword_Edittext;
    Button signup_btn;
    static int choose_photo = 1;
    static int take_photo = 0;
    private Toast toast;
    Bitmap bitmap;
    User_Class user;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        GetViewELements();

        user_ImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SelectPhotoOption();

            }
        });


        signup_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                progressBar.setVisibility(progressBar.VISIBLE);
                //checkconstraint
                String url= URLS.Register;

                if(name_Edittext.getText().toString().matches("")||email_Edittext.getText().toString().matches("")||
                        phone_Edittext.getText().toString().matches("")||password_Edittext.getText().toString().matches(""))
                {
                    showToast(getString(R.string.commpleteinfo));

                }
                if(bitmap==null)
                {
                    showToast(getString(R.string.chooseimagewarning));

                }
                else

                {
                    getdata();

                    StringRequest MyRequest=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {

                                JSONObject rootObj = new JSONObject(response);
                                if(rootObj.has("status")){
                                    Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                                    intent.putExtra("user", user);
                                    startActivity(intent);
                                }

                            }
                            catch(JSONException e){
                                showToast(getString(R.string.checkInternert));
                                progressBar.setVisibility(progressBar.GONE);

                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                            showToast(getString(R.string.TryAgainError));
                            progressBar.setVisibility(progressBar.GONE);

                        }
                    })
                    {
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String, String> params = new HashMap<>();
                            params.put("UserName",user.getName());
                            params.put("PhoneNumber",user.getPhone());
                            params.put("Password",password_Edittext.getText().toString());
                            params.put("Email",user.getEmail());
                            // user.getimage()   just but any string now until they fix it
                            params.put("Photo","dopca");
                            return params;
                        }

                    };
                    AppController.getInstance().addToRequestQueue(MyRequest);

                }

            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        try {

            if (requestCode == take_photo) {

                bitmap = (Bitmap) data.getExtras().get("data");
                user_ImageView.setImageBitmap(bitmap);
                Toast.makeText(SignUpActivity.this, R.string.ImageSuccessfullyChoosed, Toast.LENGTH_SHORT);

            } else {

                Uri path = data.getData();
                bitmap= MediaStore.Images.Media.getBitmap(getContentResolver(),path);
                user_ImageView.setImageBitmap(bitmap);

            }
        } catch (Exception e) {

            Log.v("error", e.getMessage());
            Toast.makeText(SignUpActivity.this, R.string.ImageFailedChoosed, Toast.LENGTH_SHORT).show();

        }


    }


    //this method to display Image Options
    private void SelectPhotoOption() {

        AlertDialog.Builder builder = new AlertDialog.Builder(SignUpActivity.this);
        builder.setTitle(R.string.ChooseImage);
        builder.setMessage(R.string.ImageChooseOptions);
        builder.setPositiveButton(getString(R.string.TakePhoto), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                TakePhoto();

            }
        });

        builder.setNegativeButton(getString(R.string.ChooseImage), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ChoosePhoto();
            }
        });

        builder.setNeutralButton(getString(R.string.Cancel), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog dialog = builder.create();

        dialog.show();

    }


    private void TakePhoto() {

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, take_photo);

    }

    private void ChoosePhoto() {

        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

        intent.setType("image/*");

        startActivityForResult(Intent.createChooser(intent, "Choose Your Photo"), choose_photo);

    }



    //this method for inflating view elements
    private void GetViewELements() {

        name_Edittext = findViewById(R.id.name_Edittext);
        email_Edittext = findViewById(R.id.email_Edittext);
        phone_Edittext = findViewById(R.id.phone_Edittext);
        password_Edittext = findViewById(R.id.password_Edittext);
        retypePassword_Edittext = findViewById(R.id.retypePassword_Edittext);
        signup_btn = findViewById(R.id.signup_btn);
        user_ImageView = findViewById(R.id.user_ImageView);
        progressBar=findViewById(R.id.progress_bar);

    }
    // show toast
    void showToast(String msg) {
        if (toast == null || toast.getView().getWindowVisibility() != View.VISIBLE) {
            toast = Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG);
            toast.show();
        }
    }
    //  compress image to base64
    public String imagetostring(Bitmap bitmap){

        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream);
        byte[] imagebytes=byteArrayOutputStream.toByteArray();
        return android.util.Base64.encodeToString(imagebytes, android.util.Base64.DEFAULT);
    }
    // get user data
    public void getdata(){
        user=new User_Class(name_Edittext.getText().toString()
                ,email_Edittext.getText().toString(),
                phone_Edittext.getText().toString(),password_Edittext.getText().toString(),
                imagetostring(bitmap)
        );
    }

}