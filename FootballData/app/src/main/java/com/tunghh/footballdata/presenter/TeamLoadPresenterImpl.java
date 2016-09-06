package com.tunghh.footballdata.presenter;

import com.tunghh.footballdata.model.POJO.Team_Competition;
import com.tunghh.footballdata.model.TeamLoader;
import com.tunghh.footballdata.model.TeamLoaderImpl;
import com.tunghh.footballdata.model.POJO.Team;
import com.tunghh.footballdata.views.TeamView;

import java.util.ArrayList;

/**
 * Created by TungHH on 8/25/2016.
 */
public class TeamLoadPresenterImpl implements  TeamLoadPresenter{

    TeamLoader teamLoader;
    TeamView view;

    public TeamLoadPresenterImpl(TeamView teamView){
        teamLoader = new TeamLoaderImpl(this);
        view = teamView;

    }
    @Override
    public void loadData(int competitionId) {
        teamLoader.loadTeams(competitionId);
    }


    @Override
    public void updateUI(Team_Competition competitions) {
        view.updateUI(competitions);
    }

    @Override
    public void showMsg(String message) {
        view.showMsg(message);
    }
}
