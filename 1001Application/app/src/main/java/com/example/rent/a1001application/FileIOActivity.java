package com.example.rent.a1001application;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileIOActivity extends AppCompatActivity {

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_ioservice);

       editText = (EditText) findViewById(R.id.io_edit_text);
    }


    public void saveText(View view){

        String filename = "myText";
        String text = editText.getText().toString();

        FileOutputStream outputStream;

        try {
            outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
            outputStream.write(text.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void readText(View view){
        String FILENAME = "myText";

        try {
            InputStreamReader reader = new InputStreamReader(getApplicationContext().openFileInput(FILENAME));
            BufferedReader buf_reader = new BufferedReader(reader);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

}
