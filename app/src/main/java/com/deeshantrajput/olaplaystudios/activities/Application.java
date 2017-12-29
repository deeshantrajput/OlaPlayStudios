package com.deeshantrajput.olaplaystudios.activities;

import android.content.Context;
import android.support.v7.app.AppCompatDelegate;
import android.widget.Toast;

public class Application extends android.app.Application{

    public static Application instance;
    public static int initNetWork;
    public static boolean LOOKING_FOR_PERMISSION = false;

    private String TAG = "OlaPlay";

    public Application(){ instance = this; }
    static { AppCompatDelegate.setCompatVectorFromResourcesEnabled(true); }

    public static Context getContext(){
        return instance.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

}
