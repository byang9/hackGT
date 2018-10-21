package edu.gatech.seclass.hackgt;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;


public class QRCreateActivity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_create);

        imageView = (ImageView) findViewById(R.id.imageView);
        // Get the Intent that started this activity and extract the string
        String delim = "\\+";
        Intent previousActivity = getIntent();
        String[] msg = previousActivity.getStringExtra(vendorActivity.EXTRA_MESSAGE).split(delim);

        TextView ri1 = (TextView) findViewById(R.id.receiptItem1);
        TextView ri2 = (TextView) findViewById(R.id.receiptItem2);
        TextView ri3 = (TextView) findViewById(R.id.receiptItem3);
        ri1.setText(msg[1]);
        ri2.setText(msg[2]);
        ri3.setText(msg[3]);


        String transactionId = msg[0];
        String text = transactionId.trim();

        if (text != null) {
            MultiFormatWriter multiFormatWriter = new MultiFormatWriter();

            try {
                BitMatrix bitMatrix = multiFormatWriter.encode(text, BarcodeFormat.QR_CODE, 1440, 1440);
                BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
                imageView.setImageBitmap(bitmap);
            } catch (WriterException e) {
                e.printStackTrace();
            }
        }
    }
}
