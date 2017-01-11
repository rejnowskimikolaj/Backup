package com.example.rent.bankingactivity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends Activity implements MasterFragment.FragmentChangeable {

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

        BlankFragment fragment = new BlankFragment();
        getFragmentManager().beginTransaction()
                .add(R.id.main_frame_layout, fragment).commit();
        }

    public void changeDetailFragment(int i){



        if(i==MasterFragment.DEPOSIT){
            DepositFragment fragment = new DepositFragment();
            getFragmentManager().beginTransaction()
                    .replace(R.id.main_frame_layout, fragment).commit();
        }

        else{
            CalculatorFragment fragment = new CalculatorFragment();
            getFragmentManager().beginTransaction()
                    .replace(R.id.main_frame_layout, fragment).commit();
        }
    }
}
