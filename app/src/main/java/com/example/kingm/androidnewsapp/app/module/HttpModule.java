package com.example.kingm.androidnewsapp.app.module;

import com.example.kingm.androidnewsapp.app.api.NewsService;
import com.example.kingm.androidnewsapp.utils.Const;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by kingm on 12.02.2018.
 */

@Module
public class HttpModule {

    @Provides
    @Singleton
    public Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(Const.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                //.addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    public NewsService provideApi(Retrofit retrofit) {
        return retrofit.create(NewsService.class);
    }
}

