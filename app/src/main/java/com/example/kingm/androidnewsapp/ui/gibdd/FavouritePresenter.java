package com.example.kingm.androidnewsapp.ui.gibdd;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.kingm.androidnewsapp.model.GibddSource;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by kingm on 23.02.2018.
 */

@InjectViewState
public class FavouritePresenter extends MvpPresenter<NewsView> {

    public void getFavouritesFromDb() {
        getViewState().showResult(findListFromDb());
    }

    public void clickedFavourite(GibddSource source) {
        deleteFavourite(findIdFromDB(source.getIdFromJson()));
    }

    private List<GibddSource> findListFromDb() {
        return GibddSource.listAll(GibddSource.class);
    }

    private Long findIdFromDB(Long idFromJson) {
        return GibddSource.find(GibddSource.class, "ID_FROM_JSON = ?", String.valueOf(idFromJson)).get(0).getId();
    }

    private void deleteFavourite(Long id) {
        GibddSource source = GibddSource.findById(GibddSource.class, id);
        source.delete();

    }


}
