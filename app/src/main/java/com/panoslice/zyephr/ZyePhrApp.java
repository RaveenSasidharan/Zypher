package com.panoslice.zyephr;

import android.app.Application;

import com.panoslice.zyephr.di.component.AppComponent;
import com.panoslice.zyephr.di.component.DaggerAppComponent;
import com.panoslice.zyephr.utils.AppLogger;

public class ZyePhrApp extends Application {

    public AppComponent appComponent;



    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .application(this)
                .build();

        appComponent.inject(this);

        AppLogger.init();

    }
}
