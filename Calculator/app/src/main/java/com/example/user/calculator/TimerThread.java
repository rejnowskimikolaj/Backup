package com.example.user.calculator;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import java.sql.Time;

/**
 * Created by User on 2017-01-05.
 */

public class TimerThread extends Service {

    final class TheThread implements Runnable{
        int serviceID;

        public TheThread(int serviceID){
            this.serviceID=serviceID;
        }


        @Override
        public void run() {

            synchronized (this){
                try {
                    wait(7000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                stopSelf(this.serviceID);
            }
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        Log.d("stop", "onDestroy");

        Toast.makeText(TimerThread.this,"Service stopped.",Toast.LENGTH_SHORT).show();

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(TimerThread.this,"Service started.",Toast.LENGTH_SHORT).show();
        Log.d("start", "onStartCommand");


      Thread thread = new Thread(new TheThread(startId));
       thread.start();

        return START_STICKY;
    }
}
