package com.example.njood.es;

import android.os.Bundle;

import android.view.View;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import android.widget.EditText;

import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;


public class inv2 extends Activity {
    EditText name,r_rid ,/* , v_date num_of_invites,v_email*/  Number ;
    String visitor_name, visit_date, number_of_invites, visitor_email, rid;
    Context ctx =this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inv2);


        name = (EditText) findViewById(R.id.visitorname);
        Number = (EditText) findViewById(R.id.numberofinvites);
        /*v_date = (EditText) findViewById(R.id.date);
        num_of_invites = (EditText) findViewById(R.id.numberofinvites);
        v_email = (EditText) findViewById(R.id.Email);
        r_rid= (EditText) findViewById(R.id.rid);*/

    }

    public void confirm (View v) {


        visitor_name = name.getText().toString();
       /* visit_date = v_date.getText().toString();*/
        number_of_invites = Number.getText().toString();
       /* visitor_email = v_email.getText().toString();*/
        rid= r_rid.getText().toString();

        if( r_rid.getText().toString().length() == 0 ){
            r_rid.setError("Resident ID is required!");}
        if( name.getText().toString().length() == 0 ){
            name.setError( "Name is required!" );}
       /* if( v_date.getText().toString().length() == 0 ){
            v_date.setError( "date is required!" );}*/
        if( Number.getText().toString().length() == 0 ){
            Number.setError( "number of invites is required" );}
        /*if( v_email.getText().toString().length() == 0 ){
            v_email.setError( "Email is required!" );}*/


        else {

            BackGround b = new BackGround();
            b.execute( visitor_name/* visit_date*/, number_of_invites /*visitor_email*/);
            startActivity(new Intent(this, inv2.class));
        }}

    class BackGround extends AsyncTask<String, String, String> {


        @Override
        protected String doInBackground(String... params) {

            String rid = params[0];
            String visitor_name = params[1];
          /*  String visit_date = params[2];*/
            String number_of_invites = params[3];
          /*  String visitor_email = params[4];*/
            String data="";
            int tmp;




            try {
                URL url = new URL("http://192.168.100.13/ES/invite.php");

                String urlParams = "rid ="+rid+"$visitor_name="+visitor_name+"&visit_date="+visit_date+"&number_of_invites="+number_of_invites+"&visitor_email="+visitor_email;

                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setDoOutput(true);
                OutputStream os = httpURLConnection.getOutputStream();
                os.write(urlParams.getBytes());
                os.flush();
                os.close();
                InputStream is = httpURLConnection.getInputStream();
                while((tmp=is.read())!=-1){
                    data+= (char)tmp;
                }
                is.close();
                httpURLConnection.disconnect();

                return data;

            } catch (MalformedURLException e) {
                e.printStackTrace();
                return "Exception: "+e.getMessage();
            } catch (IOException e) {
                e.printStackTrace();
                return "Exception: "+e.getMessage();
            }
        }

        @Override
        protected void onPostExecute(String s) {
            if(s.equals("")){
                s="Data saved successfully.";
            }

            Toast.makeText(ctx, s, Toast.LENGTH_LONG).show();
        }


    }

}


