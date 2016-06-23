package com.example.andrew.deathwatch20;

import android.os.Bundle;


public class MainActivity extends NavDrawer {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createActivityView();
        Skills skills = Skills.getInstance();
    }

}
