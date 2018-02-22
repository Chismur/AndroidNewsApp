package com.example.kingm.androidnewsapp.ui.gibdd;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.kingm.androidnewsapp.app.App;
import com.example.kingm.androidnewsapp.interactor.NewsRepository;
import com.example.kingm.androidnewsapp.model.GibddSource;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by kingm on 18.02.2018.
 */

@InjectViewState
public class NewsPresenter extends MvpPresenter<NewsView> {

    @Inject
    NewsRepository newsRepository;

    public NewsPresenter() {
        App.getAppComponent().inject(this);
    }


    public void getRequestNews() {
        newsRepository.getRequest().enqueue(new Callback<List<GibddSource>>() {
            @Override
            public void onResponse(Call<List<GibddSource>> call, Response<List<GibddSource>> response) {
                if (response.isSuccessful()) {
                    getViewState().showResult(response.body());
                    // getViewState().showResult(response.);
                }
            }

            @Override
            public void onFailure(Call<List<GibddSource>> call, Throwable t) {
                getViewState().showToast(t.getMessage());
            }
        });
    }

    public void clickedFavourite(GibddSource source) {
        ////////////////////////////
        source.setIdFromJson(source.getId());
        source.setId(null);
        ////////////////////////////
        if (source.isFavourite()) {
            deleteFavourite(findIdFromDB(source.getIdFromJson()));
        } else {
            saveFavourite(source);
        }
        source.changeFavourite();
    }

    public void saveFavourite(GibddSource source) {
        source.save();
    }

    public Long findIdFromDB(Long idFromJson) {
        return GibddSource.findById(GibddSource.class, idFromJson).getId();
    }

    public void deleteFavourite(Long id) {
        GibddSource source = GibddSource.findById(GibddSource.class, id);
        Log.e("DEL_SOURCE", String.valueOf(id));
        source.delete();
    }

    public List<GibddSource> getListFromDB() {
        return GibddSource.listAll(GibddSource.class);
    }

    public void showDataFromDB() {
        List<GibddSource> gibddSources = GibddSource.listAll(GibddSource.class);
        getViewState().showResult(gibddSources);
    }
}
