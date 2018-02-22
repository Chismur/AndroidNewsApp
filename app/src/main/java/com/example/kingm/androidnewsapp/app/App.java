package com.example.kingm.androidnewsapp.app;

import android.app.Application;
import com.example.kingm.androidnewsapp.app.module.ContextModule;
import com.example.kingm.androidnewsapp.app.module.HttpModule;
import com.orm.SugarApp;

public class App extends SugarApp {

    public static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initAppComponent();
    }

    public void initAppComponent() {
        appComponent = DaggerAppComponent
                .builder()
                .contextModule(new ContextModule(this))
                .httpModule(new HttpModule())
                .build();
    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }
}
