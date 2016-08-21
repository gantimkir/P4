package com.example.kirill.p4;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class ActivityPrefFour extends PreferenceActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // загружаем предпочтения из ресурсов
        addPreferencesFromResource(R.xml.pref_activity_four);
    }
}