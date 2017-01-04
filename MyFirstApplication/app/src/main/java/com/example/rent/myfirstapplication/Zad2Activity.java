package com.example.rent.myfirstapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Zad2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zad2);
    }

    public void displayText(View view){

        EditText editText = (EditText)findViewById(R.id.zad4_editText);
        String text = editText.getText().toString();
        TextView textView = (TextView) findViewById(R.id.zad2_textView);
        textView.setText(text.toString());

    }

    public void goBack(View view){
        Intent intent = new Intent(this, SDActivity.class);
        startActivity(intent);
    }
}
