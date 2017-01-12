package com.example.rent.applicationlifecycle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class First extends AppCompatActivity {

    public static   String RETURN_MSG = "return_msg";
    private TextView ipTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        ipTextView=(TextView) findViewById(R.id.activity_first_ip);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.settings,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        Toast.makeText(getApplicationContext(), "on activity", Toast.LENGTH_SHORT).show();

        if (data != null && data.hasExtra("ip")) {
            ipTextView.setText(data.getStringExtra("ip"));
            //ipTextView.setText("ip");
        }
        super.onActivityResult(requestCode,resultCode,data);
    }

    @Override
    protected void onResume() {

        super.onResume();
    }

    public void goToSecond(View view){

        Intent intent = new Intent(this, SecondActivity.class);
        EditText text = (EditText) findViewById(R.id.activity_first_edit_text);
        String message = text.getText().toString();
        intent.putExtra(RETURN_MSG,message);
        startActivity(intent);
    }

    public void goToJsonActivity(View view){
        Intent intent = new Intent(getApplicationContext(),JsonActivity.class);
        startActivityForResult(intent,1);
    }

    @Override
    public void onActivityReenter(int resultCode, Intent data) {

        super.onActivityReenter(resultCode, data);
    }
}
