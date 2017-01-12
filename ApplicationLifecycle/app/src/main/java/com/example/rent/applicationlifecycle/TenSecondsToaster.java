package com.example.rent.applicationlifecycle;

import android.app.IntentService;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by RENT on 2017-01-09.
 */

public class TenSecondsToaster extends IntentService {



    public TenSecondsToaster( ){
        super(TenSecondsToaster.class.getName());
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        final Intent i=intent;

        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {

                Toast.makeText(getApplicationContext(), "started. message: "+i.getExtras().get(First.RETURN_MSG).toString(), Toast.LENGTH_LONG).show();
            }

        });

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getApplicationContext(), "stopped", Toast.LENGTH_LONG).show();
            }
        });

        Log.v("logTag", "TenSecondsToaster started: ");
    }
}
