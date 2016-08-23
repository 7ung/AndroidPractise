package com.tunghh.footballdata.apiservice;

import com.tunghh.footballdata.observeclass.Competition;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by TungHH on 8/22/2016.
 */
public interface CompetitionAPI {
    @GET("competitions/{season}")
    Call<List<Competition>> getCompetitions(@Path("season") String season);

}
