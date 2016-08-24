package com.tunghh.footballdata.views;


import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.tunghh.footballdata.R;
import com.tunghh.footballdata.commonswidget.LeagueRecyclerViewAdapter;
import com.tunghh.footballdata.observeclass.Competition;
import com.tunghh.footballdata.presenter.CompetitionLoadPresenter;
import com.tunghh.footballdata.presenter.CompetitionLoadPresenterImpl;

import java.util.ArrayList;

public class CompetitionFragment extends Fragment
    implements CompetitionView{


    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;

    private static ArrayList<Competition> competitions = new ArrayList<>();

    CompetitionLoadPresenter presenter;
    public CompetitionFragment() {
        // Required empty public constructor
/*        Competition c1 = new Competition();
        c1.setCaption("Primier league 2016");
        c1.setTeams(20);
        c1.setGames(380);

        Competition c2 = new Competition();
        c2.setCaption("Primier league 2017");
        c2.setTeams(22);
        c2.setGames(320);

        Competition c3 = new Competition();
        c3.setCaption("La liga 2017");
        c3.setTeams(18);
        c3.setGames(300);

        competitions.add(c1);
        competitions.add(c2);
        competitions.add(c3);*/
        presenter = new CompetitionLoadPresenterImpl(this);

    }

    public static CompetitionFragment newInstance() {
        CompetitionFragment fragment = new CompetitionFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }

    }

    @Override
    public void onResume(){
        super.onResume();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_competition, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.rv_cards_league);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager(layoutManager);

//        adapter = new LeagueRecyclerViewAdapter(competitions);
//        recyclerView.setAdapter(adapter);

        recyclerView.addItemDecoration(new VerticalSpaceItemDecoration(8));
        presenter.loadData();

        return v;
    }

    @Override
    public void showMsg(String message) {
        Toast.makeText(this.getContext(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void updateUI(ArrayList<Competition> competitions) {
        adapter = new LeagueRecyclerViewAdapter(competitions);
        recyclerView.setAdapter(adapter);
        recyclerView.invalidate();
    }

    public class VerticalSpaceItemDecoration extends RecyclerView.ItemDecoration {

        private final int mVerticalSpaceHeight;

        public VerticalSpaceItemDecoration(int mVerticalSpaceHeight) {
            this.mVerticalSpaceHeight =(int)( mVerticalSpaceHeight *
                    CompetitionFragment.this.getContext().getResources().getDisplayMetrics().density);
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
                                   RecyclerView.State state) {
            outRect.bottom = mVerticalSpaceHeight;
        }
    }
}
