package com.example.onlinehotelreservationsytem;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toolbar;

public class Dash extends AppCompatActivity implements View.OnClickListener {
    ImageView img,img1;
    private Toolbar toolbar;
    private DrawerLayout drawlayout;
    private NavigationView navigationView;
    Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.dashboard);
        super.onCreate(savedInstanceState);
        img=findViewById(R.id.imgh);
        img1=findViewById(R.id.imga);
       // drawlayout=findViewById(R.id.drawlayout);
        img.setOnClickListener(this);
        img1.setOnClickListener(this);

//        toolbar = findViewById(R.id.toolbar);
////        setSupportActionBar(toolbar);
//        navigationView=findViewById(R.id.nav);
//        navigationView.setNavigationItemSelectedListener(this);

//
//
//        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawlayout,toolbar,"Open navigation drawer","Close navigation drawer");
//        drawlayout.addDrawerListener(actionBarDrawerToggle);

//        actionBarDrawerToggle.syncState();

//        if (savedInstanceState == null){
//            getSupportFragmentManager().beginTransaction().replace(R.id.fragment,new LoginActivity()).commit();
//            navigationView.setCheckedItem(R.id.);
//        }

    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(Dash.this, Dash.class);
        startActivity(i);
        Intent i1 = new Intent(Dash.this, LoginActivity.class);
        startActivity(i1);
    }
}
