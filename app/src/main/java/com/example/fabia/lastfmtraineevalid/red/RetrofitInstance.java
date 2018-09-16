package com.example.fabia.lastfmtraineevalid.red;

import android.provider.ContactsContract;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    private static Retrofit retrofit;
    public static final String BASE_URL = "http://ws.audioscrobbler.com/2.0/";
    public static final String METHOD = "geo.gettopartists";
    public static final String FORMAT = "json";
    public static final String API_KEY = "829751643419a7128b7ada50de590067";

    public static Retrofit getRetrofitInstance() {

        if (retrofit == null) {

            OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
            okHttpClientBuilder.addInterceptor(interceptor);

            Retrofit.Builder builder = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClientBuilder.build());

            retrofit = builder.build();
        }
        return retrofit;
    }
}
