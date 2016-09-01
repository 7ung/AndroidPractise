package com.tunghh.footballdata.views;

import com.tunghh.footballdata.model.POJO.Team;

import java.util.ArrayList;

/**
 * Created by TungHH on 8/25/2016.
 */
public interface TeamView {
    void showMsg(String message);

    void updateUI(ArrayList<Team> competitions);
}
