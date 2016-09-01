package com.tunghh.footballdata.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by TungHH on 8/22/2016.
 */
public class Constants {
    public static final String HOMEPAGE = "http://api.football-data.org";
    public static final String VERSION = "v1";

    public static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(HOMEPAGE + "/" + VERSION + "/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static <T> T createService(Class<T> apiClass){
        return retrofit.create(apiClass);
    }
}
