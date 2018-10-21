package edu.gatech.seclass.hackgt;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class billActivity extends AppCompatActivity {

    public String transactionId;

    private class GetUrlContentTask extends AsyncTask<String, Integer, String> {
        protected String doInBackground(String... urls) {
            try {
                URL url = new URL(urls[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
//            connection.setDoOutput(true);
//            connection.setConnectTimeout(5000);
//            connection.setReadTimeout(5000);
                if(urls[0].substring(7,14).equals("gateway")){
                    connection.setRequestProperty("Content-Type", "application/json");
                    connection.setRequestProperty("Accept", "application/json");
                    connection.setRequestProperty("nep-application-key", "8a0084a165d712fd01668f74057f0069");
                    connection.setRequestProperty("nep-organization", "ncr-market");
                    connection.setRequestProperty("nep-enterprise-unit", "7c54465e9f5344598276ec1f941f5a3c");
                    connection.setRequestProperty("nep-service-version", "2.2.1:2");
                    connection.setRequestProperty("Authorization", "Basic YWNjdDp0ZWFtNUB0ZWFtNXNlcnZpY2V1c2VyOm5jcnBhc3N3b3Jk");
                }
                connection.connect();
                BufferedReader rd = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String content = "", line;
                while ((line = rd.readLine()) != null) {
                    content += line + "\n";
                }
                return content;
            }
            catch(Exception E){
                return E.toString();
            }
        }

        protected void onProgressUpdate(Integer... progress) {
        }
        @Override
        protected void onPostExecute(String result) {
            // this is executed on the main thread after the process is over
            // update your UI here
            Log.d("-----------","Payment successful");

        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);

        Intent previousActivity = getIntent();
        String msg = previousActivity.getStringExtra(QRScanActivity2.EXTRA_MESSAGE);
        String[] split1 = msg.split("\\+");
        String transId = split1[0];
        String total = split1[1];


        TextView tv = (TextView) findViewById(R.id.billText);
        tv.setText("Your total is: " + total);

        transactionId = transId;
    }

    public void payMethod(View view){



        EditText tip = (EditText)findViewById(R.id.tip);
        String strTip = tip.getText().toString();
        EditText split = (EditText) findViewById(R.id.split);
        String strSplit = split.getText().toString();
        if(strSplit.length() < 1){
            strSplit = "10";
        }
//        payTransaction/<transID>/<amtpaid>/<tip>
        new GetUrlContentTask().execute("https://frozen-dawn-65177.herokuapp.com/payTransaction/"+transactionId + "/" + strSplit + "/" + strTip);
//        Intent intent = new Intent(this, MainActivity.class);
//        startActivity(intent);
    }
}
