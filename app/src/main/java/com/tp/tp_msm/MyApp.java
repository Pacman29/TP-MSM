package com.tp.tp_msm;

import android.app.Application;
import android.content.Context;

/**
 * Created by pacman29 on 13.11.17.
 */

public class MyApp extends Application {

    private static Context context;

    public void onCreate() {
        super.onCreate();
        MyApp.context = getApplicationContext();
    }

    public static Context getAppContext() {
        return MyApp.context;
    }
}
