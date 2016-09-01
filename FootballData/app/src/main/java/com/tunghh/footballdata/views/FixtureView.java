package com.tunghh.footballdata.views;

import com.tunghh.footballdata.model.POJO.Fixture;

/**
 * Created by TungHH on 8/30/2016.
 */
public interface FixtureView {

    void updateUI(Fixture fixtureMatch);

    void showMsg(String message);
}
