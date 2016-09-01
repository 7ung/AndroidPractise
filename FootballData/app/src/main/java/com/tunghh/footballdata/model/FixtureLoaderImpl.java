package com.tunghh.footballdata.model;

import com.tunghh.footballdata.model.POJO.Fixture;
import com.tunghh.footballdata.presenter.FixtureLoadPresenter;
import com.tunghh.footballdata.service.Constants;
import com.tunghh.footballdata.service.Router;

import java.net.UnknownHostException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by TungHH on 8/30/2016.
 */
public class FixtureLoaderImpl implements FixtureLoader, Callback<Fixture> {

    FixtureLoadPresenter presenter;

    public FixtureLoaderImpl(FixtureLoadPresenter fixtureLoadPresenter){
        presenter = fixtureLoadPresenter;
    }
    @Override
    public void loadFixture(int competitionId) {
        Router api = Constants.createService(Router.class);
        api.getCompetitionFixtures(competitionId).enqueue(this);

    }

    @Override
    public void loadFixture(int competitionId, int matchday) {
        Router api = Constants.createService(Router.class);
        api.getCompetitionFixtures(competitionId, matchday).enqueue(this);
    }

    @Override
    public void onResponse(Call<Fixture> call, Response<Fixture> response) {
        if (response.isSuccessful()){
            presenter.updateUI(response.body());
        }else{
            presenter.showMsg(response.message());
        }
    }

    @Override
    public void onFailure(Call<Fixture> call, Throwable t) {
        if (t instanceof UnknownHostException){
            presenter.showMsg("Connection Failed");
        }else{
            presenter.showMsg("Unknown Error");
        }
    }
}
