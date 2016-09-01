package com.tunghh.footballdata.model.POJO;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by TungHH on 8/25/2016.
 *
 * Example link:
 * http://api.football-data.org/v1/competitions/397/leagueTable/?matchday=37
 * http://api.football-data.org/v1/competitions/{competition_id}/leagueTable/[?matchday={matchday_number}]
 */
public class Table{

    @SerializedName("standing")
    private ArrayList<Standing> standing;

    @SerializedName("standings")
    private ArrayList<GroupStanding> groupStanding;

    @SerializedName("leagueCaption")
    private String leagueCaption;

    public ArrayList<Standing> getStanding() {
        return standing;
    }

    public void setStanding(ArrayList<Standing> standing) {
        this.standing = standing;
    }

    public class Standing extends TeamResult {

        @SerializedName("position")
        private int position;

        @SerializedName("teamName")
        private String teamName;

        @SerializedName("crestURI")
        private String thumbnail;

        @SerializedName("playedGames")
        private int played;

        @SerializedName("points")
        private int points;

        @SerializedName("goalDifference")
        private int goalDifference;

        @SerializedName("home")
        private TeamResult home;

        @SerializedName("away")
        private TeamResult away;

        public int getPosition() {
            return position;
        }

        public void setPosition(int position) {
            this.position = position;
        }

        public String getTeamName() {
            return teamName;
        }

        public void setTeamName(String teamName) {
            this.teamName = teamName;
        }

        public String getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }

        public int getPlayed() {
            return played;
        }

        public void setPlayed(int played) {
            this.played = played;
        }

        public int getPoints() {
            return points;
        }

        public void setPoints(int points) {
            this.points = points;
        }

        @Override
        public int getGoalDifference() {
            return goalDifference;
        }

        public void setGoalDifference(int goalDifference) {
            this.goalDifference = goalDifference;
        }

        public TeamResult getHome() {
            return home;
        }

        public void setHome(TeamResult home) {
            this.home = home;
        }

        public TeamResult getAway() {
            return away;
        }

        public void setAway(TeamResult away) {
            this.away = away;
        }
    }

    public class GroupStanding{

        @SerializedName("group")
        private String group;

        @SerializedName("rank")
        private String rank;

        @SerializedName("team")
        private String team;

        @SerializedName("teamId")
        private int teamId;

        @SerializedName("playedGames")
        private int playedGames;

        @SerializedName("crestURI")
        private String thumbnail;

        @SerializedName("points")
        private int points;

        @SerializedName("goals")
        private int goals;

        @SerializedName("goalsAgainst")
        private int goalsAgainst;

        @SerializedName("goalDifference")
        private int goalDifference;

        public String getGroup() {
            return group;
        }

        public void setGroup(String group) {
            this.group = group;
        }

        public String getRank() {
            return rank;
        }

        public void setRank(String rank) {
            this.rank = rank;
        }

        public String getTeam() {
            return team;
        }

        public void setTeam(String team) {
            this.team = team;
        }

        public int getTeamId() {
            return teamId;
        }

        public void setTeamId(int teamId) {
            this.teamId = teamId;
        }

        public int getPlayedGames() {
            return playedGames;
        }

        public void setPlayedGames(int playedGames) {
            this.playedGames = playedGames;
        }

        public String getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }

        public int getPoints() {
            return points;
        }

        public void setPoints(int points) {
            this.points = points;
        }

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

        public int getGoalDifference() {
            return goalDifference;
        }

        public void setGoalDifference(int goalDifference) {
            this.goalDifference = goalDifference;
        }
    }

}
