package com.example.user.personapp;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

public class MainActivity extends Activity {

    Switch sortingSwitch;
    Button generateButton;
    PersonListFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (findViewById(R.id.main_frame_layout) != null) {

            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null) {
                return;
            }
        }

         fragment = new PersonListFragment();
        getFragmentManager().beginTransaction()
                .add(R.id.main_frame_layout, fragment).commit();

         sortingSwitch = (Switch)findViewById(R.id.main_sorting_switch);
        sortingSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
               fragment.changeSorting(b);
            }
        });

        generateButton = (Button) findViewById(R.id.main_generate_button);

        generateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment.generateNewPeople();
            }
        });

    }




}
