package com.example.rent.a501application;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Zad5Activity extends AppCompatActivity  {

    private int number;
    List<String> spinnerArray =  new ArrayList<String>();
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zad5);

        Random rd = new Random();

        this.number=rd.nextInt(11);

        for(int i=0;i<10;i++){
            spinnerArray.add(i+"");
        }


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, spinnerArray);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner= (Spinner) findViewById(R.id.zad5_spinner);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();

                Toast.makeText(adapterView.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();

                TextView result = (TextView) findViewById(R.id.result_textview);
                result.setTextColor(getResources().getColor(R.color.red));

                String resultText;
                if(item.equals(number+"")){
                    resultText = "Well done!";
                    result.setTextColor(getResources().getColor(R.color.green));
                }

                else resultText="Try again";


                result.setText(resultText);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }

    public void guess(View view){
        EditText editText= (EditText) findViewById(R.id.zad5_number_field);

        int answer = Integer.parseInt(editText.getText().toString());

        TextView result = (TextView) findViewById(R.id.result_textview);
        result.setTextColor(getResources().getColor(R.color.red));

        String resultText;
        if(answer==number){
            resultText = "Well done!";
            result.setTextColor(getResources().getColor(R.color.green));
        }

        else resultText="Try again";


        result.setText(resultText);
    }

    public void spinnerGuess(View view){
        Toast.makeText(this, "clicked",Toast.LENGTH_LONG).show();

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();

                Toast.makeText(adapterView.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }


}
