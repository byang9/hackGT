package edu.gatech.seclass.hackgt;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class vendorActivity extends AppCompatActivity {

    public String restOut = "";

    private class GetUrlContentTask extends AsyncTask<String, Integer, String> {
        protected String doInBackground(String... urls) {
            try {
                URL url = new URL(urls[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
//            connection.setDoOutput(true);
//            connection.setConnectTimeout(5000);
//            connection.setReadTimeout(5000);
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
//            TextView hid = (TextView) findViewById(R.id.hiddenText1);
//            hid.setText(result);
            restOut = result;
            Log.d("--------------",result);

        }

    }

    public static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    public HashMap<String,String> hm = new HashMap<String,String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendor);

        List<String> spinnerArray = new ArrayList<String>();
        spinnerArray.add("Organic Maple & Onion Baked Beans");
        spinnerArray.add("Instant Mashed Potato");
        ArrayAdapter<String> quizOptions = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,spinnerArray);
        quizOptions.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Set up the spinner
        Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner1.setAdapter(quizOptions);
        Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
        spinner2.setAdapter(quizOptions);
        Spinner spinner3 = (Spinner) findViewById(R.id.spinner3);
        spinner3.setAdapter(quizOptions);

        //Add to hashmap
        hm.put("Organic Maple & Onion Baked Beans","2116");
        hm.put("Instant Mashed Potato","5661");
    }

    public void generateMethod(View view){
        String[] items = new String[3];
        Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
        items[0] = spinner1.getSelectedItem().toString();
        Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
        items[1] = spinner2.getSelectedItem().toString();
        Spinner spinner3 = (Spinner) findViewById(R.id.spinner3);
        items[2] = spinner3.getSelectedItem().toString();

        String transactionId = "12" + "+" + items[0] + "+" + items[1] + "+" + items[2];
        final String ttg = "------------------";

        //*****Get it to find the price for each item****
        new GetUrlContentTask().execute("https://frozen-dawn-65177.herokuapp.com/test");


        Log.d("Hello","World");
        Log.d("Hello",restOut);

        Intent intent = new Intent(this, QRCreateActivity.class);
        intent.putExtra(EXTRA_MESSAGE, transactionId);
        startActivity(intent);
    }
}
