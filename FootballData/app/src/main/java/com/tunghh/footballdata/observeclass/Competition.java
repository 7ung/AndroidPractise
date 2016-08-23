package com.tunghh.footballdata.observeclass;

import com.google.gson.annotations.SerializedName;

/**
 * Created by TungHH on 8/22/2016.
 */
public class Competition {

    @SerializedName("id")
    private int id;

    @SerializedName("caption")
    private String caption;

    @SerializedName("league")
    private String league;

    @SerializedName("year")
    private int year;

    @SerializedName("numberOfTeams")
    private int teams;

    @SerializedName("numberOfGames")
    private int games;

    @SerializedName("lastUpdated")
    private String lastUpdated;

    @SerializedName("teams")
    private String teams_link;

    @SerializedName("leagueTable")
    private String table_link;

    @SerializedName("fixtures")
    private String fixtures_link;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getTeams() {
        return teams;
    }

    public void setTeams(int teams) {
        this.teams = teams;
    }

    public int getGames() {
        return games;
    }

    public void setGames(int games) {
        this.games = games;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getTeamsLink() {
        return teams_link;
    }

    public void setTeamsLink(String teams_link) {
        this.teams_link = teams_link;
    }

    public String getTableLink() {
        return table_link;
    }

    public void setTableLink(String table_link) {
        this.table_link = table_link;
    }

    public String getFixturesLink() {
        return fixtures_link;
    }

    public void setFixturesLink(String fixtures_link) {
        this.fixtures_link = fixtures_link;
    }
}
