package com.tunghh.footballdata.observeclass;

import com.google.gson.annotations.SerializedName;

/**
 * Created by TungHH on 8/24/2016.
 */
public class Team {

    @SerializedName("name")
    private String name;

    @SerializedName("code")
    private String code;

    @SerializedName("shortName")
    private String shortName;

    @SerializedName("squadMarketValue")
    private String value;

    @SerializedName("crestUrl")
    private String thumbnail;

    private Links _href;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getFixturesLink(){
        return _href.fixtures.link;
    }

    public String getPlayersLink(){
        return _href.players.link;
    }

    public class Links{

        @SerializedName("fixtures")
        public Link fixtures;

        @SerializedName("players")
        public Link players;
    }
}
