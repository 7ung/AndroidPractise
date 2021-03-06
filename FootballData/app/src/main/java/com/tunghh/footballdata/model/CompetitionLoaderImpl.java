package com.tunghh.footballdata.model;

import com.tunghh.footballdata.service.Router;
import com.tunghh.footballdata.service.Constants;
import com.tunghh.footballdata.model.POJO.Competition;
import com.tunghh.footballdata.presenter.CompetitionLoadPresenter;

import java.net.UnknownHostException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by TungHH on 8/24/2016.
 */
public class CompetitionLoaderImpl
        implements CompetitionLoader, Callback<ArrayList<Competition>> {

    CompetitionLoadPresenter presenter;

    public CompetitionLoaderImpl(CompetitionLoadPresenter competitionLoadPresenter){
        presenter = competitionLoadPresenter;
    }

    @Override
    public void loadCompetition(String season) {
        Router api = Constants.createService(Router.class);
        Call<ArrayList<Competition>> call =  api.getCompetitions(season);
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<ArrayList<Competition>> call, Response<ArrayList<Competition>> response) {
        if (response.isSuccessful()){
            presenter.updateUI(response.body());
        }else{
            presenter.showMsg(response.message());
        }
    }

    @Override
    public void onFailure(Call<ArrayList<Competition>> call, Throwable t) {
        if (t instanceof UnknownHostException){
            presenter.showMsg("Connection Failed");
        }else{
            presenter.showMsg(t.getMessage());
        }
    }
}
