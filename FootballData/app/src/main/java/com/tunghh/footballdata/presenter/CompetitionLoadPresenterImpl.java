package com.tunghh.footballdata.presenter;

import com.tunghh.footballdata.model.CompetitionLoader;
import com.tunghh.footballdata.model.CompetitionLoaderImpl;
import com.tunghh.footballdata.model.POJO.Competition;
import com.tunghh.footballdata.views.CompetitionView;

import java.util.ArrayList;

/**
 * Created by TungHH on 8/24/2016.
 */
public class CompetitionLoadPresenterImpl implements CompetitionLoadPresenter {

    CompetitionLoader loader;
    CompetitionView competitionView;



    public CompetitionLoadPresenterImpl(CompetitionView view){
        loader = new CompetitionLoaderImpl(this);
        competitionView = view;
    }

    @Override
    public void loadData() {
        loader.loadCompetition("2016");
    }

    @Override
    public void updateUI(ArrayList<Competition> competitions) {
        competitionView.updateUI(competitions);
    }

    @Override
    public void showMsg(String message) {
        competitionView.showMsg(message);
    }

}
