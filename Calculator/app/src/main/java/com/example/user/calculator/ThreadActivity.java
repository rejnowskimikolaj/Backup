package com.example.user.calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class ThreadActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);
    }


    public void startService(View view){
        Log.d("start", "Service started");
        Intent intent = new Intent(this,TimerThread.class);
        startService(intent);
    }

    public void stopService(View view){
        Log.d("stop", "Service stopped");

        Intent intent = new Intent(this,TimerThread.class);
        stopService(intent);
    }
}
