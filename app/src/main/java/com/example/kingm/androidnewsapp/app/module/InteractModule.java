package com.example.kingm.androidnewsapp.app.module;

import com.example.kingm.androidnewsapp.interactor.GibddRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by kingm on 18.02.2018.
 */

@Module
public class InteractModule {

    @Provides
    @Singleton
    public GibddRepository provideGibddInteract() {
        return new GibddRepository();
    }
}