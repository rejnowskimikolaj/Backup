package com.example.rent.a1001application;

import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class VibrationActivity extends AppCompatActivity {

    private Vibrator vibrator ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vibration);

        vibrator = (Vibrator)getSystemService(VIBRATOR_SERVICE);


    }


    public void vibrate(View view){
        vibrator.vibrate(3000);
    }


}
