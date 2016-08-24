package com.tunghh.footballdata.commons.widget;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.tunghh.footballdata.R;
import com.tunghh.footballdata.observeclass.Competition;

import java.util.Random;

/**
 * Created by TungHH on 8/23/2016.
 */
public class CardViewLeague extends CardView{

    private static final int[] BACKGROUND_SOURCE = {
            R.drawable.champion_league,
            R.drawable.default_league,
            R.drawable.europa_leauge,
            R.drawable.la_liga,
            R.drawable.worldcup
    };

    private Competition mLeague;
    private TextView tvLeagueName;
    private TextView tvNumberTeams;
    private TextView tvNumberMatches;
    private ImageView ivThumbnail;

    private Button btnFixture;
    private Button btnTeams;
    private Button btnTable;

    private View expandableDetail;
    int expandableHeight = -1;

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
        ivThumbnail = (ImageView) v.findViewById(R.id.thumbnail);

        expandableDetail = (View) v.findViewById(R.id.detail);

        btnFixture.setOnClickListener(fixtureClick);
        btnTeams.setOnClickListener(teamsClick);
        btnTable.setOnClickListener(tableClick);

        randomBackground();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (expandableHeight == -1) {
            expandableHeight = expandableDetail.getMeasuredHeight();
            AnimationHelper.collapse(expandableDetail, expandableHeight);
        }
    }


    private void randomBackground() {
        int rd = new Random().nextInt(BACKGROUND_SOURCE.length);
        ivThumbnail.setImageResource(BACKGROUND_SOURCE[rd]);
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
            toggleVisibility(expandableDetail);

        }
    };
    OnClickListener tableClick = new OnClickListener() {
        @Override
        public void onClick(View view) {
            Log.d("", "tableClick");
        }
    };

    public void toggleVisibility(View v){
        if (v.isShown()){
            AnimationHelper.collapse(v, expandableHeight);
        }else {
            AnimationHelper.expand(v, expandableHeight);
        }
    }

}
