package com.example.rent.applicationlifecycle;

import android.os.Bundle;
import android.preference.PreferenceActivity;

/**
 * Created by RENT on 2017-01-10.
 */

public class UserSettingsActivity extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.settings);
    }
}
