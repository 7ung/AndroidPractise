package com.tunghh.footballdata.commonswidget;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.tunghh.footballdata.commons.widget.CardViewLeague;
import com.tunghh.footballdata.observeclass.Competition;

import java.util.ArrayList;

/**
 * Created by TungHH on 8/23/2016.
 */
public class LeagueRecyclerViewAdapter extends RecyclerView.Adapter<LeagueRecyclerViewAdapter.ViewHolder> {

    ArrayList<Competition> mCompetitions = new ArrayList<>();
    public static class ViewHolder extends RecyclerView.ViewHolder {

        public CardViewLeague cardViewLeague;

        public ViewHolder(CardViewLeague itemView) {
            super(itemView);
            cardViewLeague = itemView;
        }
    }

    public LeagueRecyclerViewAdapter(ArrayList<Competition> competitions){
        mCompetitions.addAll(competitions);
    }

    @Override
    public LeagueRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardViewLeague v = new CardViewLeague(parent.getContext());
        parent.addView(v);
        return new LeagueRecyclerViewAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(LeagueRecyclerViewAdapter.ViewHolder holder, int position) {
        holder.cardViewLeague.setLeague(mCompetitions.get(position));
    }

    @Override
    public int getItemCount() {
        return mCompetitions.size();
    }
}
