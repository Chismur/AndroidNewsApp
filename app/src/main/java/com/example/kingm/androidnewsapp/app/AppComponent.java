package com.example.kingm.androidnewsapp.app;

import android.content.Context;

import com.example.kingm.androidnewsapp.app.module.ContextModule;
import com.example.kingm.androidnewsapp.app.module.HttpModule;
import com.example.kingm.androidnewsapp.app.module.InteractModule;
import com.example.kingm.androidnewsapp.interactor.NewsRepository;
import com.example.kingm.androidnewsapp.ui.gibdd.NewsActivity;
import com.example.kingm.androidnewsapp.ui.gibdd.NewsPresenter;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by kingm on 18.02.2018.
 */

@Singleton
@Component(modules = {
        InteractModule.class,
        ContextModule.class,
        HttpModule.class
})
public interface AppComponent {

    Context getContext();

    void inject(NewsRepository newsRepository);

    void inject(NewsActivity newsActivity);

    void inject(NewsPresenter newsPresenter);
}
