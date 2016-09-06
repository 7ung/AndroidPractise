package com.tunghh.footballdata.views;

import com.tunghh.footballdata.model.POJO.Team;
import com.tunghh.footballdata.model.POJO.Team_Competition;

import java.util.ArrayList;

/**
 * Created by TungHH on 8/25/2016.
 */
public interface TeamView {
    void showMsg(String message);

    void updateUI(Team_Competition competitions);
}
