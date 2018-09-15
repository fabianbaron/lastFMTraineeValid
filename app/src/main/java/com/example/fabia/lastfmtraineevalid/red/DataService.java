package com.example.fabia.lastfmtraineevalid.red;

import android.view.Display;

import com.example.fabia.lastfmtraineevalid.model.Model;
import com.example.fabia.lastfmtraineevalid.model.TopArtistsList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DataService {

    @GET("?method=geo.gettopartists&format=json&api_key=829751643419a7128b7ada50de590067&country=spain")
    Call<Model> getTopartists();

}
