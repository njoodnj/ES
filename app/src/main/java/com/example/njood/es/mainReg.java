package com.example.njood.es;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class mainReg extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_reg);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }
    public  void resReg(View view){
        Intent i = new Intent(getApplicationContext(),Register.class);
        startActivity(i);}
    public  void depReg(View view){
        Intent i = new Intent(getApplicationContext(),depregister.class);
        startActivity(i);}
    public  void log(View view){
        Intent i = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(i);}
}
