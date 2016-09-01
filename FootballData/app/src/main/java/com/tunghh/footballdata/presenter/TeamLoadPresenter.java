package com.tunghh.footballdata.presenter;

import com.tunghh.footballdata.model.POJO.Team;

import java.util.ArrayList;

/**
 * Created by TungHH on 8/25/2016.
 */
public interface TeamLoadPresenter {
    void loadData(int competitionId);

    void updateUI(ArrayList<Team> competitions);

    void showMsg(String message);
}
