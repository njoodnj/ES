package com.example.njood.es;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class User_Home extends Activity {


    String id , name, password , email, address, welcome;
    TextView idTV ,nameTV, emailTV , addressTV, welcomeTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__home);




        idTV = (TextView) findViewById(R.id.home_id);
        nameTV = (TextView) findViewById(R.id.home_name);
        emailTV = (TextView) findViewById(R.id.home_email);
        addressTV = (TextView) findViewById(R.id.home_address);
        welcomeTV = (TextView) findViewById(R.id.welcomename);

        id = getIntent().getStringExtra("r_id");
        name = getIntent().getStringExtra("r_name");
        password = getIntent().getStringExtra("r_password");
        email = getIntent().getStringExtra("r_email");
        address = getIntent().getStringExtra("r_address");
        welcome = getIntent().getStringExtra("r_name");


        idTV.setText("ID No:"+id);
        nameTV.setText("Name: "+name);
        emailTV.setText("Email:"+email);
        addressTV.setText("Address:"+address);
        welcomeTV.setText(" "+name);

    }
    public  void logout(View view){
        SharedPreferences sharedpreferences = getSharedPreferences(MainActivity.MyPREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(id, "");
        editor.putString(password, "");
        editor.putString(name, "");
        editor.putString(email, "");
        editor.putString(address, "");
        editor.commit();
        Intent intent = new Intent(User_Home.this, MainActivity.class);
        startActivity(intent);



    }

}


