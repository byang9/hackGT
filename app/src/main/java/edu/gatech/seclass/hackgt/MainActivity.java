package edu.gatech.seclass.hackgt;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

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
        Intent intent = new Intent(this, qrScanActivity.class);
        startActivity(intent);
    }
}
