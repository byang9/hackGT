package edu.gatech.seclass.hackgt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class billActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);

        Intent previousActivity = getIntent();
        String msg = previousActivity.getStringExtra(QRScanActivity2.EXTRA_MESSAGE);

        TextView tv = (TextView) findViewById(R.id.billText);
        tv.setText(msg);
    }

    public void payMethod(View view){

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
