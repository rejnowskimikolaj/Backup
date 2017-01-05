package com.example.user.calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onSumClick(View view){
        EditText e1 = (EditText) findViewById(R.id.number1);
        EditText e2 = (EditText) findViewById(R.id.number2);
        TextView result = (TextView) findViewById(R.id.result);
        double n1 = Double.parseDouble(e1.getText().toString());
        double n2 = Double.parseDouble(e2.getText().toString());
        double res = n1+n2;
        result.setText(Double.toString(res));
    }

    public void onSubstractClick(View view){
        EditText e1 = (EditText) findViewById(R.id.number1);
        EditText e2 = (EditText) findViewById(R.id.number2);
        TextView result = (TextView) findViewById(R.id.result);
        double n1 = Double.parseDouble(e1.getText().toString());
        double n2 = Double.parseDouble(e2.getText().toString());
        double res = n1-n2;
        result.setText(Double.toString(res));
    }

    public void onMultiplyClick(View view){
        EditText e1 = (EditText) findViewById(R.id.number1);
        EditText e2 = (EditText) findViewById(R.id.number2);
        TextView result = (TextView) findViewById(R.id.result);
        double n1 = Double.parseDouble(e1.getText().toString());
        double n2 = Double.parseDouble(e2.getText().toString());
        double res = n1*n2;
        result.setText(Double.toString(res));
    }

    public void onDivideClick(View view){
        EditText e1 = (EditText) findViewById(R.id.number1);
        EditText e2 = (EditText) findViewById(R.id.number2);
        TextView result = (TextView) findViewById(R.id.result);
        double n1 = Double.parseDouble(e1.getText().toString());
        double n2 = Double.parseDouble(e2.getText().toString());
        double res = n1/n2;
        result.setText(Double.toString(res));
    }

    public void goToServiceActivity(View view){
        Intent intent = new Intent(this,ThreadActivity.class);
        startActivity(intent);
    }
}
