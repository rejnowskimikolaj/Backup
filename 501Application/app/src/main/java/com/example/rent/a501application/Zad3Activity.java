package com.example.rent.a501application;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

public class Zad3Activity extends AppCompatActivity {

    private LinearLayout linear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zad3);

        linear = (LinearLayout) findViewById(R.id.linear_layout_zad3);

    }
}
