package com.tunghh.footballdata.presenter;

import com.tunghh.footballdata.model.TableLoader;
import com.tunghh.footballdata.model.TableLoaderImpl;
import com.tunghh.footballdata.model.POJO.Table;
import com.tunghh.footballdata.views.TableView;

/**
 * Created by TungHH on 8/25/2016.
 */
public class TableLoadPresenterImpl implements TableLoadPresenter {

    private TableView view;
    private TableLoader loader;
    public TableLoadPresenterImpl(TableView tableView){
        view = tableView;
        loader = new TableLoaderImpl(this);
    }

    @Override
    public void loadTable(int competitionId) {
        loader.loadTable(competitionId);
    }

    @Override
    public void loadTable(int competitionId, int matchday) {
        loader.loadTable(competitionId, matchday);
    }

    @Override
    public void updateUI(Table competitionTable) {
        view.updateUI(competitionTable);
    }

    @Override
    public void showMsg(String message) {
        view.showMsg(message);
    }
}
