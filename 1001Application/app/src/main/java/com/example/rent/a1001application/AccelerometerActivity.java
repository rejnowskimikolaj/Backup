package com.example.rent.a1001application;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class AccelerometerActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager mSensorManager;
    private Sensor mAcc;
    private TextView xTextview;
    private TextView yTextview;
    private TextView zTextview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accelerometer);

        xTextview=(TextView) findViewById(R.id.x_text_view);
        yTextview=(TextView) findViewById(R.id.y_text_view);
        zTextview=(TextView) findViewById(R.id.z_text_view);

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mAcc=mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        List<Sensor> deviceSensors = mSensorManager.getSensorList(Sensor.TYPE_ALL);

        for(Sensor s : deviceSensors){
            s.getStringType();

            Log.d("SENSOR", s.getName()+"  "+s.getStringType());
        }


    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

        if (sensorEvent.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {

            float x = sensorEvent.values[0];
            float y = sensorEvent.values[1];
            float z = sensorEvent.values[2];

            xTextview.setText(x+"");
            yTextview.setText(y+"");
            zTextview.setText(z+"");
           // Log.d("X:Y:Z:", x+":"+y+":"+z);

        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    protected void onResume() {
        super.onResume();

        mSensorManager.registerListener(this,mAcc, SensorManager.SENSOR_DELAY_NORMAL);

    }

    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }
}
