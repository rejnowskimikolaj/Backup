package com.example.rent.myfirstapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SDActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.example.rent.myfirstapplication.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sd);
    }

    public void goTo(View view ){
        Intent intent = new Intent(this, SecondPageActivity.class);
        EditText editText = (EditText) findViewById(R.id.text_add);
        String message  = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE,message);
        startActivity(intent);

    }

    public void goToNameDisplayer(View view ){
        Intent intent = new Intent(this, NameDisplayActivity.class);
        startActivity(intent);

    }

    public void goToZad2Activity(View view ){
        Intent intent = new Intent(this, Zad2Activity.class);
        startActivity(intent);

    }

    public void goToZad3Activity(View view ){
        Intent intent = new Intent(this, Zad3Activity.class);
        startActivity(intent);

    }
}
