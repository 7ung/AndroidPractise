package com.tunghh.footballdata.model;

import com.tunghh.footballdata.apiservice.CompetitionAPI;
import com.tunghh.footballdata.commons.APIConstants;
import com.tunghh.footballdata.observeclass.Team;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by TungHH on 8/24/2016.
 */
public class TeamLoaderImpl implements TeamLoader, Callback<ArrayList<Team>> {

    @Override
    public void onResponse(Call<ArrayList<Team>> call, Response<ArrayList<Team>> response) {
        //// TODO: 8/24/2016

    }

    @Override
    public void onFailure(Call<ArrayList<Team>> call, Throwable t) {
        //// TODO: 8/24/2016
    }

    @Override
    public void loadTeams(int competitionId) {
        CompetitionAPI api = APIConstants.createService(CompetitionAPI.class);
        Call<ArrayList<Team>> call =  api.getTeams(competitionId);
        call.enqueue(this);
    }
}
