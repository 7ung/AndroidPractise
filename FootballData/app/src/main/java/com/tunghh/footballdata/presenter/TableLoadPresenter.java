package com.tunghh.footballdata.presenter;

import com.tunghh.footballdata.model.POJO.Table;

/**
 * Created by TungHH on 8/25/2016.
 */
public interface TableLoadPresenter {

    void loadTable(int competitionId);
    void loadTable(int competitionId, int matchday);
    void updateUI(Table body);

    void showMsg(String message);
}
