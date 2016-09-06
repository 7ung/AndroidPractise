package com.tunghh.footballdata.presenter;

import com.tunghh.footballdata.model.POJO.Team;
import com.tunghh.footballdata.model.POJO.Team_Competition;

import java.util.ArrayList;

/**
 * Created by TungHH on 8/25/2016.
 */
public interface TeamLoadPresenter {
    void loadData(int competitionId);

    void updateUI(Team_Competition competitions);

    void showMsg(String message);
}
