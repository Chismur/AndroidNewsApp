package com.example.kingm.androidnewsapp.app.api;

import com.example.kingm.androidnewsapp.model.GibddSource;
import com.example.kingm.androidnewsapp.model.GibddWeb;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by kingm on 07.02.2018.
 */

public interface NewsService {

    @GET("api/json/getKBK/")
    Call<List<GibddSource>> getSource();
}
