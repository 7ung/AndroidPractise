package com.tunghh.footballdata.presenter;

import com.tunghh.footballdata.model.POJO.Competition;

import java.util.ArrayList;

/**
 * Created by TungHH on 8/24/2016.
 */
public interface CompetitionLoadPresenter {

    void loadData();

    void updateUI(ArrayList<Competition> competitions);

    void showMsg(String message);
}
