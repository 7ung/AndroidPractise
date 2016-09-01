package com.tunghh.footballdata.model.POJO;

import com.google.gson.annotations.SerializedName;

/**
 * Created by TungHH on 8/30/2016.
 *
 * Example Link:
 * http://api.football-data.org/v1/competitions/426/fixtures/?matchday=1
 * http://api.football-data.org/v1/competitions/{competitionId}/fixtures/[?matchday=matchday_number]
 */
public class FixtureMatch {

    @SerializedName("date")
    private String date;

    @SerializedName("status")
    private String status;

    @SerializedName("matchday")
    private String matchday;

    @SerializedName("homeTeamName")
    private String homeTeam;

    @SerializedName("awayTeamName")
    private String awayTeam;

    @SerializedName("result")
    private Result result;

    @SerializedName("odds")
    private Odds odds;

    @SerializedName("_links")
    private Links _href;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMatchday() {
        return matchday;
    }

    public void setMatchday(String matchday) {
        this.matchday = matchday;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public String getFixtureId(){
        return getIdFromLink(_href.self.link);
    }

    public String getCompetitionId(){
        return getIdFromLink(_href.competition.link);
    }

    public String getHomeTeamId(){
        return getIdFromLink(_href.homeTeam.link);
    }

    public String getAwayTeamId(){
        return getIdFromLink(_href.awayTeam.link);
    }

    public String getIdFromLink(String link){
        return link.copyValueOf(link.toCharArray(),
                link.lastIndexOf("/") + 1,
                link.length() - 1);
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public Odds getOdds() {
        return odds;
    }

    public void setOdds(Odds odds) {
        this.odds = odds;
    }

    public class Links{

        @SerializedName("self")
        public Link self;

        @SerializedName("competition")
        public Link competition;

        @SerializedName("homeTeam")
        public Link homeTeam;

        @SerializedName("awayTeam")
        public Link awayTeam;
    }

    public class Result{
        @SerializedName("goalsHomeTeam")
        public int homeGoal;

        @SerializedName("goalsAwayTeam")
        public int awayGoal;
    }

    public class Odds{
        @SerializedName("homeWin")
        public float homeWin;

        @SerializedName("draw")
        public float draw;

        @SerializedName("awayWin")
        public float awayWin;
    }


}
