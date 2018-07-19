package com.example.unknown.cheaperapp.Activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.unknown.cheaperapp.Fragment.AdsFragment;
import com.example.unknown.cheaperapp.Classes.EndDrawerToggle;
import com.example.unknown.cheaperapp.R;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener  {

    Toolbar toolbar;
    DrawerLayout drawer;
    NavigationView navigationView;
    EndDrawerToggle toggle;
    Toast mtoast;

    boolean IsSeller=true;

    @Override
    protected void onStart() {
        super.onStart();


        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AdsFragment()).commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GetElements();

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AdsFragment()).commit();


        handleNavigationClicks();

//        ChangeNavigation();

    }


    // this code to change navigation drawer according to user status (login / logout)
    private void ChangeNavigation(){

        if(LoginActivity.currentUser==null){

            navigationView.getMenu().clear();
            navigationView.inflateMenu(R.menu.drawable_nav_items_logout);
            navigationView.getHeaderView(0).setVisibility(View.GONE);
            navigationView.setNavigationItemSelectedListener(this);
        }
    }

    private void handleNavigationClicks(){


        setSupportActionBar(toolbar);
        EndDrawerToggle drawerToggle;
        EndDrawerToggle toggle = new EndDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        navigationView = findViewById(R.id.navigation_layout);
        navigationView.setNavigationItemSelectedListener(this);

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();


        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        if(mtoast!=null){
            mtoast.cancel();
        }


        int id = item.getItemId();


        if(id==R.id.home_nav_btn){

            drawer.closeDrawers();
        }
        else if(id==R.id.advertiser_nav_btn){

            if(IsSeller){
                Intent intent = new Intent(MainActivity.this,AdvertiserData_Activity.class);
                startActivity(intent);
            }
            else {
                Intent intent = new Intent(MainActivity.this,AdvertiserDataEntery_Activity.class);
                startActivity(intent);
            }


        }
        else if(id==R.id.make_offer_nav_btn){

            Intent intent = new Intent(MainActivity.this,MakeOfferActivity.class);
            startActivity(intent);
        }
        else if(id==R.id.categories_nav_btn){

            Intent intent = new Intent(MainActivity.this,Categories_Stores_Activity.class);
            intent.putExtra("type",1);
            startActivity(intent);
        }else if(id==R.id.myAds_nav_btn){

            Intent intent = new Intent(MainActivity.this,MyAdvertisement_Activity.class);
            startActivity(intent);
        }
        else if(id==R.id.addnotification_nav_btn){
            Intent intent = new Intent(MainActivity.this,Add_Notification_Activity.class);
            startActivity(intent);
        }
        else if(id==R.id.markets_nav_btn){
            Intent intent = new Intent(MainActivity.this,Categories_Stores_Activity.class);
            intent.putExtra("type",2);
            startActivity(intent);
        }
        else if(id==R.id.logout_nav_btn){

            LogOut();
        }


        return true;
    }


    private void LogOut(){
        finish();
    }

    private void GetElements(){

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        drawer = (DrawerLayout) findViewById(R.id.nav_drawer_layout);
    }


//    private void  getKeyHash(){
//        try {
//            PackageInfo info = getPackageManager().getPackageInfo(
//                    getPackageName(),
//                    PackageManager.GET_SIGNATURES);
//            for (Signature signature : info.signatures) {
//                MessageDigest md = MessageDigest.getInstance("SHA");
//                md.update(signature.toByteArray());
//                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
//            }
//        }
//        catch (PackageManager.NameNotFoundException e) {
//
//        }
//        catch (NoSuchAlgorithmException e) {
//
//        }
//    }


}
