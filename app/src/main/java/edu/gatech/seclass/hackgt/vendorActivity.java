package edu.gatech.seclass.hackgt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class vendorActivity extends AppCompatActivity {

    public static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendor);

        List<String> spinnerArray = new ArrayList<String>();
        spinnerArray.add("Apple");
        spinnerArray.add("Bannana");
        ArrayAdapter<String> quizOptions = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,spinnerArray);
        quizOptions.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Set up the spinner
        Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner1.setAdapter(quizOptions);
        Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
        spinner2.setAdapter(quizOptions);
        Spinner spinner3 = (Spinner) findViewById(R.id.spinner3);
        spinner3.setAdapter(quizOptions);
    }

    public void generateMethod(View view){
        Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
        String item1 = spinner1.getSelectedItem().toString();
        Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
        String item2 = spinner2.getSelectedItem().toString();
        Spinner spinner3 = (Spinner) findViewById(R.id.spinner3);
        String item3 = spinner3.getSelectedItem().toString();

        String transactionId = "12" + "+" + item1 + "+" + item2 + "+" + item3;
        String ttg = "------------------";
        try {
            URL url = new URL("http://gateway-staging.ncrcloud.com/catalog/item-prices/7770/1");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Accept", "application/json");
            con.setRequestProperty("nep-application-key", "8a0084a165d712fd01668f74057f0069");
            con.setRequestProperty("nep-organization", "ncr-market");
            con.setRequestProperty("nep-enterprise-unit", "7c54465e9f5344598276ec1f941f5a3c");
            con.setRequestProperty("nep-service-version", "2.2.1:2");
            con.setRequestProperty("Authorization", "Basic YWNjdDp0ZWFtNUB0ZWFtNXNlcnZpY2V1c2VyOm5jcnBhc3N3b3Jk");
            Log.d(ttg,"Part 1");
            con.connect();
            Log.d(ttg,"Part 2");
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();

            Log.d(ttg,content.toString());
        }
        catch(Exception E){
            Log.d("======================",E.toString());
        }

        Log.d("Hello","World");

        Intent intent = new Intent(this, QRCreateActivity.class);
        intent.putExtra(EXTRA_MESSAGE, transactionId);
        startActivity(intent);
    }
}
