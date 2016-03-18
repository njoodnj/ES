package com.example.njood.es;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class securityGuard extends AppCompatActivity {

    Button bn;
    BluetoothAdapter b_adapter;
    int BLUETOOTH_REQUEST =1;
    EditText Refnum;
    String REfnum;
    Context ctx=this;
    String RID= null, NAME=null, REFNUM=null, NUMBER=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_security_guard);
        Refnum= (EditText) findViewById(R.id.refnum);

        bn = (Button) findViewById(R.id.button1);
        bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b_adapter = BluetoothAdapter.getDefaultAdapter();
                if (b_adapter == null) {
                    Toast.makeText(getBaseContext(), "no bluetooth adapter found", Toast.LENGTH_LONG).show();
                } else {
                    if (!b_adapter.isEnabled()) {
                        Intent i = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                        startActivityForResult(i, BLUETOOTH_REQUEST);

                    }
                    if (b_adapter.isEnabled()) {

                        startActivity(new Intent(securityGuard.this, scan.class));
                    }
                }
            }
        });
    }

    public void onActivityResult(int request_code, int result_code ,Intent data)

    {
        if(request_code== BLUETOOTH_REQUEST){

            if(result_code==RESULT_OK ){

                Toast.makeText(getBaseContext(),"bluetooth successfully turned on ", Toast.LENGTH_LONG).show();
            }
            if (result_code==RESULT_CANCELED)
            {
                Toast.makeText(getBaseContext(),"bluetooth TURN ON FAILED", Toast.LENGTH_LONG).show();
            }
        }

    }


    public void main_refnum(View v){
        REfnum =Refnum.getText().toString();
        BackGround b = new BackGround();
        b.execute(REfnum);
    }

    class BackGround extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... params) {
            String Refnum = params[0];
            String data="";
            int tmp;

            try {
                URL url = new URL("http://192.168.100.2/ES/refnum.php");
                String urlParams = "Refnum="+Refnum;

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
            String err=null;
            try {
                JSONObject root = new JSONObject(s);
                JSONObject user_data = root.getJSONObject("user_data");
                RID = user_data.getString("rid");
                NAME = user_data.getString("name");
                REFNUM = user_data.getString("Refnum");
                NUMBER = user_data.getString("Number");
            } catch (JSONException e) {
                e.printStackTrace();
                err = "Exception: "+e.getMessage();
            }

            Intent i = new Intent(ctx, refnum.class);
            i.putExtra("rid", RID);
            i.putExtra("name", NAME);
            i.putExtra("Refnum", REFNUM);
            i.putExtra("Number", NUMBER);
            i.putExtra("err", err);
            startActivity(i);

        }
    }


}
