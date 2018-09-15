package com.example.fabia.lastfmtraineevalid.red;

import android.provider.ContactsContract;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    private static Retrofit retrofit;
    public static final String BASE_URL = "http://ws.audioscrobbler.com/2.0/";

    public static Retrofit getRetrofitInstance() {

        if (retrofit == null) {

            Retrofit.Builder builder = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());

            retrofit = builder.build();
        }
        return retrofit;
    }
}
