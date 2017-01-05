package com.example.rent.a501application;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Zad6Activity extends AppCompatActivity {

    private EditText firstName;
    private EditText lastName;
    private DatePicker date;
    private TextView age;
    private CheckBox status;
    private Spinner gender;
    private EditText wifeOrHusband;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zad6);

        firstName = (EditText) findViewById(R.id.first_name_edit_text);
        lastName = (EditText) findViewById(R.id.last_name_edit_text);
        date = (DatePicker) findViewById(R.id.dateOfBirth);
        age = (TextView) findViewById(R.id.textview_age);
        status = (CheckBox) findViewById(R.id.checkbox_status);
        gender = (Spinner) findViewById(R.id.gender_spinner);
        wifeOrHusband = (EditText) findViewById(R.id.edittext_malzonek);

        date.init(1992,9,1, new DatePicker.OnDateChangedListener(){
            @Override
            public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
                
            }
        });

        wifeOrHusband.setEnabled(false);
        status.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                wifeOrHusband.setEnabled(!b);
            }
        });


    }
    public void send(View view){



    }


}
