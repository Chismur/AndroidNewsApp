package com.example.kingm.androidnewsapp.interactor;

import com.example.kingm.androidnewsapp.app.App;
import com.example.kingm.androidnewsapp.app.api.NewsService;
import com.example.kingm.androidnewsapp.model.GibddSource;
import com.example.kingm.androidnewsapp.model.GibddWeb;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;

/**
 * Created by kingm on 18.02.2018.
 */

public class NewsRepository {

    @Inject
    NewsService newsService;

    public NewsRepository() {
        App.getAppComponent().inject(this);
    }

    public Call<List<GibddSource>> getRequest(){
        return newsService.getSource();
    }
}
