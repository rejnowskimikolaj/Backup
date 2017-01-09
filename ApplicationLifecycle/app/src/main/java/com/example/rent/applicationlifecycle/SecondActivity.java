package com.example.rent.applicationlifecycle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView textView = (TextView)findViewById(R.id.activity_second_text_view);
        Bundle extras = getIntent().getExtras();
        if(extras != null){
           String result = extras.getString(First.RETURN_MSG);
            textView.setText(result);
        }

        Intent i = new Intent(SecondActivity.this, TenSecondsToaster.class);
        i.putExtra(First.RETURN_MSG,extras.getString(First.RETURN_MSG));
        TenSecondsToaster toaster = new TenSecondsToaster();
        startService(i);

    }

    public void goToFirst(View view){
        Intent intent = new Intent(this, First.class);
        startActivity(intent);
    }


}
