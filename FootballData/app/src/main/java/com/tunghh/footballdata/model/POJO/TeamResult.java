package com.tunghh.footballdata.model.POJO;

import com.google.gson.annotations.SerializedName;

/**
 * Created by TungHH on 8/25/2016.
 */
public class TeamResult {

    @SerializedName("goals")
    protected int goals;

    @SerializedName("goalsAgainst")
    protected int goalsAgainst;

    @SerializedName("wins")
    protected int wins;

    @SerializedName("draws")
    protected int draws;

    @SerializedName("losses")
    protected int losses;

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getGoalsAgainst() {
        return goalsAgainst;
    }

    public void setGoalsAgainst(int goalsAgainst) {
        this.goalsAgainst = goalsAgainst;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getGoalDifference(){
        return getGoals() - getGoalsAgainst();
    }
}
