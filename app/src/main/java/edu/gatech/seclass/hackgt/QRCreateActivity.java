package edu.gatech.seclass.hackgt;

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

public class QRCreateActivity extends AppCompatActivity {

    private EditText etInput;
    private Button btnCreateQr;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_create);

//        etInput = findViewById(R.id.etInput);
//        btnCreateQr = findViewById(R.id.btnCreate);
//        imageView = findViewById(R.id.imageView);

//        btnCreateQr.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View view) {
//                String text = etInput.getText().toString().trim();
//
//                if(text != null) {
//                    MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
//
//                    try {
//                        BitMatrix bitMatrix = multiFormatWriter.encode(text, BarcodeFormat.QR_CODE, 500,500);
//                        BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
//                        Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
//                        imageView.setImageBitmap(bitmap);
//                    } catch (WriterException e) {
//                        e.printStackTrace();
//                    }
//
//
//                }
//            }
//        });
    }
}
