package com.tunghh.footballdata.views;

import com.tunghh.footballdata.model.POJO.Table;

/**
 * Created by TungHH on 8/25/2016.
 */
public interface TableView {
    void updateUI(Table competitionTable);

    void showMsg(String message);
}
