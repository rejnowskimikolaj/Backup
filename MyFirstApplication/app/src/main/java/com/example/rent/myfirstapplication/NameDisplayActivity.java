package com.example.rent.myfirstapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class NameDisplayActivity extends AppCompatActivity {

    private int clickCounter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_display);
        this.clickCounter=0;
    }


    public void displayName(View view){
        this.clickCounter++;

        TextView textView = (TextView) findViewById(R.id.name_text_view);
        String text = textView.getText().toString();
        if(text.equals("")){
            TextView textView2 = (TextView) findViewById(R.id.name_text_view);
            textView2.setText("Mikolaj");
        }

        else{
            TextView textView2 = (TextView) findViewById(R.id.last_name_text_view);
            textView2.setText("Rejnowski");
        }

//        if(clickCounter==1) {
//            TextView textView = (TextView) findViewById(R.id.name_text_view);
//            textView.setText("Mikolaj");
//        }

//        else  {
//            TextView textView = (TextView) findViewById(R.id.last_name_text_view);
//            textView.setText("Rejnowski");
//        }


    }
    public void goBack(View view){
        Intent intent = new Intent(this, SDActivity.class);
        startActivity(intent);
    }
}
