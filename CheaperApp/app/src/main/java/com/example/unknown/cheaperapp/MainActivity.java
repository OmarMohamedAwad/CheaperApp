package com.example.unknown.cheaperapp;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    NavigationView navigationView;

    Toast mtoast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        handleNavigationClicks();

        navigationView.getMenu().clear();
        navigationView.inflateMenu(R.menu.drawable_nav_items_logout);

    }

    private void handleNavigationClicks(){

        drawerLayout=findViewById(R.id.nav_drawer_layout);
        toggle = new ActionBarDrawerToggle(this,drawerLayout, R.string.open, R.string.close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        navigationView = findViewById(R.id.navigation_layout);
        navigationView.setNavigationItemSelectedListener(this);

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(toggle.onOptionsItemSelected(item)){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        if(mtoast!=null){
            mtoast.cancel();
        }


        int id = item.getItemId();


        if(id==R.id.home_nav_btn){
            mtoast = Toast.makeText(this,"Home",Toast.LENGTH_SHORT);
            mtoast.show();
        }

        return true;
    }
}
