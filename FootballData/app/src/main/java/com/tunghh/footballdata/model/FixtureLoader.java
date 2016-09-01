package com.tunghh.footballdata.model;

/**
 * Created by TungHH on 8/30/2016.
 */
public interface FixtureLoader {
    void loadFixture(int competitionId);
    void loadFixture(int competitionId, int matchday);
}
