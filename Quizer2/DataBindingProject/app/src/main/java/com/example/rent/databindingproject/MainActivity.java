package com.example.rent.databindingproject;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rent.databindingproject.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    Button clearButton;
    Button addButton;
    Student maciek;
    Student student;
    ListView studentListView;
    LinearLayout studentContainer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final ActivityMainBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        maciek = new Student("Maciek","Mackowski",22);
        binding.setMaciek(maciek);

        studentContainer = (LinearLayout) findViewById(R.id.student_container);


        student = new Student("","",18);
        binding.setStudent(student);

        clearButton = (Button) findViewById(R.id.clearButton) ;
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                maciek.setFirstName("");
                maciek.setLastName("");
            }
        });

        addButton = (Button) findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            TextView tv = new TextView(getApplicationContext());

                tv.setText(student.getFirstName());

                Toast.makeText(getApplicationContext(),student.getFirstName(),Toast.LENGTH_SHORT).show();
                studentContainer.addView(tv);
            }
        });



    }
}
