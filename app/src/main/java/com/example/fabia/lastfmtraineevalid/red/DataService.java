package com.example.fabia.lastfmtraineevalid.red;

import android.view.Display;

import com.example.fabia.lastfmtraineevalid.model.Model;
import com.example.fabia.lastfmtraineevalid.model.TopArtistsList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface DataService {

    @GET("?")
    Call<Model> getTopArtistsQuery(
            @Query("method") String method,
            @Query("format") String format,
            @Query("api_key") String apiKey,
            @Query("country") String country,
            @Query("page") String page
    );

}
