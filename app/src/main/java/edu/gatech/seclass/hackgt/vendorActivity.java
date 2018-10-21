package edu.gatech.seclass.hackgt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class vendorActivity extends AppCompatActivity {

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



        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
