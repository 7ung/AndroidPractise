package com.tunghh.footballdata.model.POJO;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Hồ Hoàng Tùng on 06/09/2016.
 *
 * Team of competition
 *
 * ex: http://api.football-data.org/v1/competitions/426/teams
 * http://api.football-data.org/v1/competitions/{competition_id}/teams
 */
public class Team_Competition {

    @SerializedName("count")
    private int count;

    @SerializedName("teams")
    private ArrayList<Team> teams;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public ArrayList<Team> getTeams() {
        return teams;
    }

    public void setTeams(ArrayList<Team> teams) {
        this.teams = teams;
    }
}
