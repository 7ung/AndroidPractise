package com.tunghh.footballdata.views;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.tunghh.footballdata.R;
import com.tunghh.footballdata.commonswidget.TeamItem;
import com.tunghh.footballdata.model.POJO.Team;
import com.tunghh.footballdata.model.POJO.Team_Competition;
import com.tunghh.footballdata.presenter.TeamLoadPresenter;
import com.tunghh.footballdata.presenter.TeamLoadPresenterImpl;

import java.util.ArrayList;

public class TeamsActivity extends BaseActivity implements TeamView {

    private int mCompetitionId;
    private String mCompetitionName;

    private static final String COMPETITION_ID = "competition_id";
    private static final String COMPETITION_NAME = "competition_name";

    private ViewGroup mListTeams;
    private TextView mTitle;

    private TeamLoadPresenter iPresenter;

    public static void create(Context context, int competitionId, String competitionName){
        Intent intent = new Intent(context, TeamsActivity.class);
        intent.putExtra(COMPETITION_ID, competitionId);
        intent.putExtra(COMPETITION_NAME, competitionName);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    int getContentView() {
        return R.layout.activity_teams;
    }

    @Override
    void initLayout() {
        Bundle bundle = getIntent().getExtras();
        mCompetitionId = bundle.getInt(COMPETITION_ID, 0);
        mCompetitionName = bundle.getString(COMPETITION_NAME, "");

        mTitle = (TextView) findViewById(R.id.tv_title);
        mListTeams = (ViewGroup) findViewById(R.id.layout_container);
        mTitle.setText(mCompetitionName);
    }

    @Override
    protected void onResume(){
        super.onResume();
        iPresenter = new TeamLoadPresenterImpl(this);
        iPresenter.loadData(mCompetitionId);
    }

    @Override
    public void updateUI(Team_Competition competitions) {
        for (Team team : competitions.getTeams()) {
            TeamItem teamItem = new TeamItem(this);
            teamItem.setTeam(team);
            mListTeams.addView(teamItem);
        }
    }
}
