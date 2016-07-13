package com.vernonsung.android.testactionbar;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity
                       implements OneFragment.OneFragmentListener,
                                  TwoFragment.TwoFragmentListener {

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

    /**
     * OneFragment.OneFragmentListener
     * TwoFragment.TwoFragmentListener
     */
    @Override
    public void changeFragment() {
        Fragment fragment = getFragmentManager().findFragmentById(R.id.frameMain);
        if (fragment instanceof OneFragment) {
            getFragmentManager().beginTransaction().replace(R.id.frameMain, new TwoFragment()).commit();
        } else if (fragment instanceof TwoFragment) {
            getFragmentManager().beginTransaction().replace(R.id.frameMain, new OneFragment()).commit();
        }
    }
}
