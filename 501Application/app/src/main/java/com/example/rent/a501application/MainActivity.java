package com.example.rent.a501application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToZad4(View view){
        Intent intent = new Intent(this, Zad4Activity.class);
        startActivity(intent);
    }

    public void goToZad5(View view){
        Intent intent = new Intent(this, Zad5Activity.class);
        startActivity(intent);
    }

    public void goToZad6(View view){
        Intent intent = new Intent(this, Zad6Activity.class);
        startActivity(intent);
    }
}
