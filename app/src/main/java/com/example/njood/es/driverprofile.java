package com.example.njood.es;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class driverprofile extends AppCompatActivity {
    String id , name,welcome;
    TextView idTV ,nameTV, welcomeTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driverprofile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        idTV = (TextView) findViewById(R.id.home_id);
        nameTV = (TextView) findViewById(R.id.home_name);
        welcomeTV = (TextView) findViewById(R.id.welcomename);

        id = getIntent().getStringExtra("r_id");
        name = getIntent().getStringExtra("r_name");

        welcome = getIntent().getStringExtra("r_name");


        idTV.setText("ID No:"+id);
        nameTV.setText("Name: "+name);
        welcomeTV.setText(" "+name);

    }


}
