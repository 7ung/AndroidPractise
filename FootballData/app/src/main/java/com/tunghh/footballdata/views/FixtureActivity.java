package com.tunghh.footballdata.views;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.Toast;

import com.tunghh.footballdata.R;
import com.tunghh.footballdata.commonswidget.FixtureMatchday;
import com.tunghh.footballdata.model.POJO.Fixture;

public class FixtureActivity extends AppCompatActivity implements FixtureView {

    private static final String COMPETITION_BUNDLE = "competition_id";

    private ViewGroup listFixture;

    public static void create(Context context, int competitionId){
        Intent intent = new Intent(context, FixtureActivity.class);
        intent.putExtra(COMPETITION_BUNDLE, competitionId);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fixture);

        Bundle bundle = getIntent().getExtras();
        int competition_id = bundle.getInt(COMPETITION_BUNDLE);

        listFixture = (ViewGroup) findViewById(R.id.list_matchday);
        FixtureMatchday fixtureMatchday = new FixtureMatchday(this, competition_id, 1);
        listFixture.addView(fixtureMatchday.getRootView());
    }

    @Override
    public void updateUI(Fixture fixtureMatch) {

    }

    @Override
    public void showMsg(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();

    }
}
