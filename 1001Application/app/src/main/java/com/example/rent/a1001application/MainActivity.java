package com.example.rent.a1001application;

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


    public void goToAcc(View view){
        Intent i = new Intent(this,AccelerometerActivity.class);
        startActivity(i);
    }

    public void goToLightSensor(View view){
        Intent i = new Intent(this,LightSensorActivity.class);
        startActivity(i);
    }
    public void goToVibration(View view){
        Intent i = new Intent(this,VibrationActivity.class);
        startActivity(i);
    }

    public void goToFileIO(View view){
        Intent i = new Intent(this,FileIOActivity.class);
        startActivity(i);
    }

}
