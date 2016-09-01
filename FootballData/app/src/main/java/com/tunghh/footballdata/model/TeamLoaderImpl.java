package com.tunghh.footballdata.model;

import com.tunghh.footballdata.service.Router;
import com.tunghh.footballdata.service.Constants;
import com.tunghh.footballdata.model.POJO.Team;
import com.tunghh.footballdata.presenter.TeamLoadPresenter;

import java.net.UnknownHostException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by TungHH on 8/24/2016.
 */
public class TeamLoaderImpl implements TeamLoader, Callback<ArrayList<Team>> {

    TeamLoadPresenter presenter;

    public TeamLoaderImpl(TeamLoadPresenter teamLoadPresenter){
        presenter = teamLoadPresenter;
    }

    @Override
    public void onResponse(Call<ArrayList<Team>> call, Response<ArrayList<Team>> response) {
        if (response.isSuccessful()){
            presenter.updateUI(response.body());
        }else{
            presenter.showMsg(response.message());
        }
    }

    @Override
    public void onFailure(Call<ArrayList<Team>> call, Throwable t) {
        if (t instanceof UnknownHostException){
            presenter.showMsg("Connection Failed");
        }else{
            presenter.showMsg("Unknown Error");
        }
    }

    @Override
    public void loadTeams(int competitionId) {
        Router api = Constants.createService(Router.class);
        Call<ArrayList<Team>> call =  api.getTeams(competitionId);
        call.enqueue(this);
    }
}
