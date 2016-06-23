package com.example.andrew.deathwatch20;

import android.app.Application;
import android.content.Context;

/**
 * I have no idea what this does. Makes the application context static?
 * Created by Andrew on 6/10/2016.
 */
public class MyApplication extends Application {

    private static Context context;

    public void onCreate() {
        super.onCreate();
        MyApplication.context = getApplicationContext();
    }

    public static Context getAppContext() {
        return MyApplication.context;
    }
}
