package com.tunghh.footballdata.commonswidget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.tunghh.footballdata.R;
import com.tunghh.footballdata.model.POJO.Team;

/**
 * Created by Hồ Hoàng Tùng on 07/09/2016.
 */
public class TeamItem extends LinearLayout {

    private Team mTeam;
    private TextView mTeamNameTv;
    private TextView mCodeTv;
    private TextView mValueTv;

    private ImageButton mPlayersBtn;
    private ImageButton mFixtureBtn;

    public TeamItem(Context context) {
        super(context);
        initLayout(context);
    }

    public TeamItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        initLayout(context);
    }

    public TeamItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initLayout(context);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public TeamItem(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initLayout(context);
    }

    private void initLayout(Context context) {
        LayoutInflater.from(context).inflate(R.layout.team_listview_item, this, true);
        mTeamNameTv = (TextView) findViewById(R.id.tv_primary_text);
        mCodeTv = (TextView) findViewById(R.id.tv_secondary_text_1);
        mValueTv = (TextView) findViewById(R.id.tv_secondary_text_2);

        mPlayersBtn = (ImageButton) findViewById(R.id.ib_players);
        mFixtureBtn = (ImageButton) findViewById(R.id.ib_fixture);
    }

    public void setTeam(@NonNull Team team){
        mTeam = team;
        mTeamNameTv.setText(mTeam.getShortName());
        mCodeTv.setText(mTeam.getCode());
        mValueTv.setText(mTeam.getValue());

        Picasso.with(this.getContext())
                .load(team.getThumbnail())
                .into(((ImageView) findViewById(R.id.iv_logo)));
    }


}
