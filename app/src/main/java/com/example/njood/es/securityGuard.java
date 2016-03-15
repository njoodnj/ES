package com.example.njood.es;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class securityGuard extends AppCompatActivity {

    Button bn;
    BluetoothAdapter b_adapter;
    int BLUETOOTH_REQUEST =1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_security_guard);

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

}
