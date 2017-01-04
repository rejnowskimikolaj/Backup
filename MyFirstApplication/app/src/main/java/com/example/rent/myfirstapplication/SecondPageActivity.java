package com.example.rent.myfirstapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



public class SecondPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_page);

        Intent intent = getIntent();
        String message = intent.getStringExtra(SDActivity.EXTRA_MESSAGE);
        TextView textView=new TextView(this);
        textView.setTextSize(40);
        textView.setText(message);

        ViewGroup layout = (ViewGroup) findViewById(R.id.activity_second_page);
        layout.addView(textView);
    }

    public void goBack(View view){
        Intent intent = new Intent(this, SDActivity.class);
        startActivity(intent);
    }
}
