package com.tunghh.footballdata.presenter;

import com.tunghh.footballdata.model.POJO.Fixture;

/**
 * Created by TungHH on 8/30/2016.
 */
public interface FixtureLoadPresenter {
    void loadFixtures(int competitionId);
    void loadFixtures(int competitionId, int matchday);
    void updateUI(Fixture fixtureMatch);

    void showMsg(String message);
}
