package com.example.kirill.p4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ActivityFour extends AppCompatActivity {
    private static final String KEY_COUNT = "COUNT";
    private int mCount=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four);
        TextView textViewOrientationCounter=(TextView) findViewById(R.id.textViewOrientationCounter);
        if (savedInstanceState!=null){
            mCount=savedInstanceState.getInt(KEY_COUNT);
            mCount++;
            textViewOrientationCounter.setText(Integer.toString(mCount));
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_COUNT,mCount);
    }
}
