package com.tunghh.footballdata.model;

import com.tunghh.footballdata.service.Router;
import com.tunghh.footballdata.service.Constants;
import com.tunghh.footballdata.model.POJO.Table;
import com.tunghh.footballdata.presenter.TableLoadPresenter;

import java.net.UnknownHostException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by TungHH on 8/25/2016.
 */
public class TableLoaderImpl implements TableLoader, Callback<Table> {

    private TableLoadPresenter presenter;

    public TableLoaderImpl(TableLoadPresenter tableLoadPresenter){
        presenter = tableLoadPresenter;
    }

    @Override
    public void loadTable(int competitionId) {
        Router api = Constants.createService(Router.class);
        Call<Table> call =  api.getTable(competitionId);
        call.enqueue(this);
    }

    @Override
    public void loadTable(int competitionId, int matchday) {
        Router api = Constants.createService(Router.class);
        Call<Table> call =  api.getTable(competitionId, matchday);
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<Table> call, Response<Table> response) {
        if (response.isSuccessful()){
            presenter.updateUI(response.body());
        }else{
            presenter.showMsg(response.message());
        }
    }

    @Override
    public void onFailure(Call<Table> call, Throwable t) {
        if (t instanceof UnknownHostException){
            presenter.showMsg("Connection Failed");
        }else{
            presenter.showMsg("Unknown Error");
        }
    }
}
