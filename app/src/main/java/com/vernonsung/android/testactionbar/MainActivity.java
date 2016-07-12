package com.vernonsung.android.testactionbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar)findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        // Fragment
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction().add(R.id.frameMain, new OneFragment()).commit();
        }
    }
}
