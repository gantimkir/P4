package com.example.kirill.p4;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityFive extends AppCompatActivity {
    Snackbar snackbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                snackbar = Snackbar.make(view, "!!!", Snackbar.LENGTH_LONG).setAction("Action", snackbarOnClickListener);
                snackbar.setDuration(8000);
                View snackbarView=snackbar.getView();
                snackbar.setActionTextColor(Color.GREEN); // цвет текста у кнопки действия
                snackbarView.setBackgroundColor(Color.BLACK);
                TextView snackTextView=(TextView) snackbarView.findViewById(android.support.design.R.id.snackbar_text);
                snackTextView.setTextColor(Color.RED);
                snackbar.setCallback(new Snackbar.Callback() {
                    @Override
                    public void onDismissed(Snackbar snackbar, int event) {
                        // do some action on dismiss
                        Toast.makeText(getApplicationContext(), "My dismiss", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onShown(Snackbar snackbar) {
                        // do some action when snackbar is showed
                        Toast.makeText(getApplicationContext(), "Snackbar is showed", Toast.LENGTH_SHORT).show();
                    }
                });
                snackbar.show();
            }
        });
    }

    View.OnClickListener snackbarOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Toast.makeText(getApplicationContext(), "Молодец!", Toast.LENGTH_LONG).show();
        }
    };

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonDismiss:
                snackbar.dismiss();
                break;
        }
    }
}
