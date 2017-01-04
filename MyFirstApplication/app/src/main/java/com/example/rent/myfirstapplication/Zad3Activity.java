package com.example.rent.myfirstapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class Zad3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zad3);




    }

    public void displayText(View view){
        TextView textView = new TextView(this);
        textView.setText("Jakis text");
        ViewGroup layout = (ViewGroup) findViewById(R.id.activity_zad3);
        layout.addView(textView);

    }

    public void displayButton(View view){
        Button button = new Button(this);
        button.setText("Nowy button!");
        ViewGroup layout = (ViewGroup) findViewById(R.id.activity_zad3);
        layout.addView(button);

    }
    public void goBack(View view){
        Intent intent = new Intent(this, SDActivity.class);
        startActivity(intent);
    }
}
