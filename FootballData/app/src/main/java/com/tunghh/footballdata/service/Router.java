package com.tunghh.footballdata.service;

import com.tunghh.footballdata.model.POJO.Competition;
import com.tunghh.footballdata.model.POJO.Fixture;
import com.tunghh.footballdata.model.POJO.Table;
import com.tunghh.footballdata.model.POJO.Team;
import com.tunghh.footballdata.model.POJO.Team_Competition;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by TungHH on 8/22/2016.
 */
public interface Router {
    @GET("competitions/")
    Call<ArrayList<Competition>> getCompetitions(@Query("season") String season);

    @GET("competitions/{id}/teams")
    Call<Team_Competition> getTeams(@Path("id") int competitionId);

    @GET("competitions/{id}/leagueTable")
    Call<Table> getTable(@Path("id") int competitionId);

    @GET("competitions/{id}/leagueTable/")
    Call<Table> getTable(@Path("id") int competitionId, @Query("matchday") int mathcday);

    @GET("competitions/{id}/fixtures")
    Call<Fixture> getCompetitionFixtures(@Path("id") int competitionId);

    @GET("competitions/{id}/fixtures/")
    Call<Fixture> getCompetitionFixtures(@Path("id") int competitionId, @Query("matchday") int mathcday);

}
