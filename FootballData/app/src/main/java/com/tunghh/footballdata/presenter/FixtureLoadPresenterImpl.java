package com.tunghh.footballdata.presenter;

import com.tunghh.footballdata.model.FixtureLoader;
import com.tunghh.footballdata.model.FixtureLoaderImpl;
import com.tunghh.footballdata.model.POJO.Fixture;
import com.tunghh.footballdata.views.FixtureView;

/**
 * Created by TungHH on 8/30/2016.
 */
public class FixtureLoadPresenterImpl implements FixtureLoadPresenter {

    FixtureView view;
    FixtureLoader loader;

    public FixtureLoadPresenterImpl(FixtureView fixtureView){
        view = fixtureView;
        loader = new FixtureLoaderImpl(this);
    }

    @Override
    public void loadFixtures(int competitionId) {
        loader.loadFixture(competitionId);
    }

    @Override
    public void loadFixtures(int competitionId, int matchday) {
        loader.loadFixture(competitionId, matchday);
    }

    @Override
    public void updateUI(Fixture fixtureMatch) {
        view.updateUI(fixtureMatch);
    }

    @Override
    public void showMsg(String message) {
        view.showMsg(message);
        view.showMsg(message);

    }
}
