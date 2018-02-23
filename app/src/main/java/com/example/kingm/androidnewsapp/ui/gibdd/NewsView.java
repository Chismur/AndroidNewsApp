package com.example.kingm.androidnewsapp.ui.gibdd;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.example.kingm.androidnewsapp.model.GibddSource;

import java.util.List;

/**
 * Created by kingm on 18.02.2018.
 */

@StateStrategyType(AddToEndSingleStrategy.class)
public interface NewsView extends MvpView {

    void showResult(List<GibddSource> list);
    void changeFavourite(int position);
    void showToast(String message);
}
