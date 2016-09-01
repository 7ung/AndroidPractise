package com.tunghh.footballdata.commonswidget;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.tunghh.footballdata.R;
import com.tunghh.footballdata.model.POJO.Competition;
import com.tunghh.footballdata.model.POJO.Table;
import com.tunghh.footballdata.presenter.TableLoadPresenter;
import com.tunghh.footballdata.presenter.TableLoadPresenterImpl;
import com.tunghh.footballdata.views.FixtureActivity;
import com.tunghh.footballdata.views.TableView;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by TungHH on 8/23/2016.
 */
public class CardViewLeague extends CardView implements TableView{

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
    private Button btnStanding;

    private View expandableDetail;
    private int expandableHeight = -1;

    private TableLoadPresenter presenter;
    private LinearLayout lvtTeamTable;

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
        btnStanding = (Button) v.findViewById(R.id.btn_standing);
        ivThumbnail = (ImageView) v.findViewById(R.id.thumbnail);

        expandableDetail = (View) v.findViewById(R.id.detail);
        lvtTeamTable = (LinearLayout) v.findViewById(R.id.lv_teams);

        btnFixture.setOnClickListener(fixtureClick);
        btnTeams.setOnClickListener(teamsClick);
        btnTable.setOnClickListener(tableClick);
        btnStanding.setOnClickListener(standingClick);
        randomBackground();

        presenter = new TableLoadPresenterImpl(this);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//        if (expandableHeight == -1) {
//            if (lvtTeamTable.getChildCount() != 0) {
//                expandableHeight = lvtTeamTable.getMeasuredHeight();
//                //AnimationHelper.collapse(lvtTeamTable, expandableHeight);
//            }
//        }
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
            FixtureActivity.create(getContext(), getLeague().getId());
        }
    };
    OnClickListener teamsClick = new OnClickListener() {
        @Override
        public void onClick(View view) {
            Log.d("", "teamsClick");
            //toggleVisibility(expandableDetail);

        }
    };
    OnClickListener tableClick = new OnClickListener() {
        @Override
        public void onClick(View view) {
            Log.d("", "tableClick");
        }
    };
    OnClickListener standingClick = new OnClickListener() {
        @Override
        public void onClick(View view) {
            if (lvtTeamTable.getChildCount() == 0){
                presenter.loadTable(getLeague().getId());
            }else{
                toggleVisibility(lvtTeamTable);
            }
        }
    };
    public void toggleVisibility(View v){
        if (v.isShown()){
            //AnimationHelper.collapse(v, expandableHeight);
            AnimationHelper.sildeUp(this.getContext(), v);
        }else {
            //AnimationHelper.expand(v, expandableHeight);
            AnimationHelper.sildeDown(this.getContext(), v);
        }
    }

    @Override
    public void updateUI(Table competitionTable) {
        // todo: hiển thị 4 đội đầu BXH
        ArrayList<Table.Standing> topFour = new ArrayList<>(4);
        topFour.addAll(competitionTable.getStanding().subList(0, 4));
        for (Table.Standing std : topFour) {
            View v = LayoutInflater.from(this.getContext())
                    .inflate(R.layout.shortstanding_listview_item, null, true);
            ((TextView) v.findViewById(R.id.list_item_primary_text)).setText(std.getTeamName());
            String format = "W-D-L: {0}-{1}-{2} ({3})";
            format = TextUtils.replace(format,
                        new String[]{"{0}", "{1}", "{2}", "{3}"},
                        new String[] {
                            String.valueOf(std.getWins()),
                            String.valueOf(std.getDraws()),
                            String.valueOf(std.getLosses()),
                            String.valueOf(std.getPoints())
                        }).toString();
            ((TextView) v.findViewById(R.id.list_item_secondary_text)).setText(format);
            Picasso.with(this.getContext())
                    .load(std.getThumbnail())
                    .into(((ImageView) v.findViewById(R.id.imgView_thumbnail)));
            lvtTeamTable.addView(v);
        }
        lvtTeamTable.setVisibility(GONE);
        toggleVisibility(lvtTeamTable);
        //lvtTeamTable.setVisibility(GONE);
        //lvtTeamTable.requestLayout();
        //expandableHeight = lvtTeamTable.getMeasuredHeight();
        //toggleVisibility(lvtTeamTable);

//        lvtTeamTable.setAdapter(new CompetitionTableListViewAdapter(
//                this.getContext(),
//                topFour));
        //toggleVisibility(lvtTeamTable);
    }

    @Override
    public void showMsg(String message) {
        Toast.makeText(this.getContext(), message, Toast.LENGTH_LONG).show();
    }
}
