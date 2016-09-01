package com.tunghh.footballdata.commonswidget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.tunghh.footballdata.R;
import com.tunghh.footballdata.model.POJO.Fixture;
import com.tunghh.footballdata.model.POJO.FixtureMatch;
import com.tunghh.footballdata.presenter.FixtureLoadPresenter;
import com.tunghh.footballdata.presenter.FixtureLoadPresenterImpl;
import com.tunghh.footballdata.views.FixtureView;

/**
 * Created by TungHH on 8/31/2016.
 */
public class FixtureMatchday extends LinearLayout implements FixtureView {

    private TextView tvTitle;
    private TextView tvDate;
    private View root;

    private int mCompetitionId;
    private int mMatchday;

    private FixtureLoadPresenter presenter;
    private Fixture fixture;
    private ViewGroup listMatch;

    public FixtureMatchday(Context context, int competitionId, int matchday) {
        super(context);
        mCompetitionId = competitionId;
        mMatchday = matchday;

        root = LayoutInflater.from(context).inflate(R.layout.fixture_matchday, this, true);
        tvTitle = (TextView) root.findViewById(R.id.title);
        tvTitle.setText("Match day " + matchday );

        listMatch = (ViewGroup) findViewById(R.id.list_match);

        presenter = new FixtureLoadPresenterImpl(this);
        presenter.loadFixtures(competitionId, matchday);

    }

    @Override
    public View getRootView(){
        return root;
    }

    @Override
    public void updateUI(Fixture fixtureMatch) {
        fixture = fixtureMatch;

        if (fixtureMatch.getFixture().isEmpty() == false) {
            for (FixtureMatch match : fixtureMatch.getFixture()) {
                FixtureMatchView fixtureMatchView =
                        new FixtureMatchView(this.getContext(), match);
                listMatch.addView(fixtureMatchView.getRootView());
            }
            ((ViewGroup)this.getParent())
                    .addView(new FixtureMatchday(
                            this.getContext(),
                            mCompetitionId,
                            mMatchday + 1));
        }
    }

    @Override
    public void showMsg(String message) {
        Toast.makeText(this.getContext(), message, Toast.LENGTH_LONG).show();
    }


}
