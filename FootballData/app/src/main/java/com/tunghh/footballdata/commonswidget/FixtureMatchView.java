package com.tunghh.footballdata.commonswidget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tunghh.footballdata.R;
import com.tunghh.footballdata.model.POJO.FixtureMatch;

/**
 * Created by TungHH on 8/31/2016.
 */
public class FixtureMatchView extends LinearLayout{


    private View root;

    private TextView tvHomeName;
    private TextView tvAwayName;
    private TextView tvHomeScore;
    private TextView tvAwayScore;
    private TextView tvOddHome;
    private TextView tvOddDraw;
    private TextView tvOddAway;

    public FixtureMatchView(Context context, FixtureMatch fixtureMatch) {
        super(context);
        root = LayoutInflater.from(context).inflate(R.layout.fixture_listview_item, this, true);

        tvHomeName = (TextView) root.findViewById(R.id.home_name);
        tvAwayName = (TextView) root.findViewById(R.id.away_name);
        tvHomeScore = (TextView) root.findViewById(R.id.score_home);
        tvAwayScore = (TextView) root.findViewById(R.id.score_away);
        tvOddHome = (TextView) root.findViewById(R.id.odd_home);
        tvOddDraw = (TextView) root.findViewById(R.id.odd_draw);
        tvOddAway = (TextView) root.findViewById(R.id.odd_away);

        tvHomeName.setText(fixtureMatch.getHomeTeam());
        tvAwayName.setText(fixtureMatch.getAwayTeam());

        tvHomeScore.setText(String.valueOf(fixtureMatch.getResult().homeGoal));
        tvAwayScore.setText(String.valueOf(fixtureMatch.getResult().awayGoal));

        if (fixtureMatch.getOdds() != null) {
            tvOddHome.setText(String.valueOf(fixtureMatch.getOdds().homeWin));
            tvOddDraw.setText(String.valueOf(fixtureMatch.getOdds().draw));
            tvOddAway.setText(String.valueOf(fixtureMatch.getOdds().awayWin));
        }else{
            tvOddHome.setText("?");
            tvOddDraw.setText("?");
            tvOddAway.setText("?");
        }
    }

    @Override
    public View getRootView(){
        return root;
    }
}
