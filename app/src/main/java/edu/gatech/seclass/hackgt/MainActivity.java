package edu.gatech.seclass.hackgt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void loginMethod(View view){
        Intent intent = new Intent(this, homeActivity.class);
        startActivity(intent);
    }

    public void vendorMethod(View view){
        Intent intent = new Intent(this, vendorActivity.class);
        startActivity(intent);
    }

    public void jamesMethod(View view){
        Intent intent = new Intent(this, QRCreateActivity.class);
        startActivity(intent);
    }

    public void qrScanMethod(View view){
        Intent intent = new Intent(this, QRScanActivity2.class);
        startActivity(intent);
    }
}
