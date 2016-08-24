package com.tunghh.footballdata.views;

import com.tunghh.footballdata.observeclass.Competition;

import java.util.ArrayList;

/**
 * Created by TungHH on 8/24/2016.
 */
public interface CompetitionView {
    void showMsg(String message);

    void updateUI(ArrayList<Competition> competitions);
}
