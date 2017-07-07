package com.ansel.coountrynews;

import android.app.Application;
import android.content.Context;

/**
 * Created by Junguo.L on 2017/7/5.
 */

public class App extends Application {
    private static App instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static Context getInstance() {
        return instance;
    }
}
