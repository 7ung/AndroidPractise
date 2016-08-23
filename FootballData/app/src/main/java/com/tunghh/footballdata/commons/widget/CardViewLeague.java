package com.tunghh.footballdata.commons.widget;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.tunghh.footballdata.R;
import com.tunghh.footballdata.observeclass.Competition;

/**
 * Created by TungHH on 8/23/2016.
 */
public class CardViewLeague extends CardView{

    private Competition mLeague;
    private TextView tvLeagueName;
    private TextView tvNumberTeams;
    private TextView tvNumberMatches;

    private Button btnFixture;
    private Button btnTeams;
    private Button btnTable;

    public CardViewLeague(Context context) {
        super(context);
        initLayout(context);
    }

    public CardViewLeague(Context context, AttributeSet attrs) {
        super(context, attrs);
        initLayout(context);

    }

    public CardViewLeague(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initLayout(context);

    }

    private void initLayout(Context context) {
        View v = LayoutInflater.from(context).inflate(R.layout.cardview_league,this, true);
        tvLeagueName = (TextView) v.findViewById(R.id.tv_league_name);
        tvNumberTeams = (TextView) v.findViewById(R.id.tv_teams);
        tvNumberMatches = (TextView) v.findViewById(R.id.tv_matches);

        btnFixture = (Button) v.findViewById(R.id.btn_fixture);
        btnTeams = (Button) v.findViewById(R.id.btn_teams);
        btnTable = (Button) v.findViewById(R.id.btn_table);

        btnFixture.setOnClickListener(fixtureClick);
        btnTeams.setOnClickListener(teamsClick);
        btnTable.setOnClickListener(tableClick);


    }

    public void setCompetition(Competition league){
        this.setLeague(league);
    }

    public Competition getLeague() {
        return mLeague;
    }

    public void setLeague(Competition league) {
        this.mLeague = league;
        tvLeagueName.setText(league.getCaption());
        tvNumberMatches.setText("Number of matches: " + league.getGames());
        tvNumberTeams.setText("Number of teams: " + league.getTeams());
    }

    OnClickListener fixtureClick = new OnClickListener() {
        @Override
        public void onClick(View view) {
            Log.d("", "fixtureClick");
        }
    };
    OnClickListener teamsClick = new OnClickListener() {
        @Override
        public void onClick(View view) {
            Log.d("", "teamsClick");
        }
    };
    OnClickListener tableClick = new OnClickListener() {
        @Override
        public void onClick(View view) {
            Log.d("", "tableClick");
        }
    };
}
