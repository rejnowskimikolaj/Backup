package com.example.rent.a1001application;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class LightSensorActivity extends AppCompatActivity {


    private  TextView lightTextView;
    private LightSensor lightSensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light_sensor);
       lightTextView = (TextView) findViewById(R.id.light_sensor_text_field);

        this.lightSensor = new LightSensor();


    }

    @Override
    protected void onResume() {
        lightSensor.register();
        super.onResume();
    }

    @Override
    protected void onPause() {
        lightSensor.unRegister();
        super.onPause();
    }

    public class LightSensor implements SensorEventListener{

        private SensorManager mSensorManager;
        private Sensor mLight;


        public LightSensor(){
            mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
            mLight=mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

        }

        public void register(){
            mSensorManager.registerListener(this,mLight,SensorManager.SENSOR_DELAY_NORMAL);
        }

        public void unRegister(){
            mSensorManager.unregisterListener(this);
        }
        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {

            if (sensorEvent.sensor.getType() == Sensor.TYPE_LIGHT) {
                float v = sensorEvent.values[0];
                lightTextView.setText(v+"");
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {

        }
    }

}
