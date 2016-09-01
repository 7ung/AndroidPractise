package com.tunghh.footballdata.model;

/**
 * Created by TungHH on 8/25/2016.
 */
public interface TableLoader {
    void loadTable(int competitionId);
    void loadTable(int competitionId, int matchday);
}
