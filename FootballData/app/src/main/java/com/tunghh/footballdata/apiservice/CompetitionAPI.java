package com.tunghh.footballdata.apiservice;

import com.tunghh.footballdata.observeclass.Competition;
import com.tunghh.footballdata.observeclass.Team;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by TungHH on 8/22/2016.
 */
public interface CompetitionAPI {
    @GET("competitions/")
    Call<ArrayList<Competition>> getCompetitions(@Query("season") String season);

    @GET("competitions/{id}/teams")
    Call<ArrayList<Team>> getTeams(@Path("id") int competitionId);
}
