package com.alexander.multithreading;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFragments();
    }

    private void initFragments() {

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.firstCont, FirstFragment.newInstance())
                .add(R.id.secondCont, SecondFragment.newInstance())
                .add(R.id.thirdCont, ThirdFragment.newInstance())
                .commit();
    }
}
