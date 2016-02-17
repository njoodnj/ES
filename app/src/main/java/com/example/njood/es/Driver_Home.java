package com.example.njood.es;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Driver_Home extends Activity {

    String did , dname,  dwelcome;
    TextView didTV ,dnameTV,  dwelcomeTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver__home);

        didTV = (TextView) findViewById(R.id.driver_id);
        dnameTV = (TextView) findViewById(R.id.driver_name);
        dwelcomeTV = (TextView) findViewById(R.id.dwelcomename);

        did = getIntent().getStringExtra("dr_id");
        dname = getIntent().getStringExtra("dr_name");
        dwelcome = getIntent().getStringExtra("dr_name");


        didTV.setText("ID No:"+did);
        dnameTV.setText("Name: "+dname);
        dwelcomeTV.setText(" "+dname);


    }
}


