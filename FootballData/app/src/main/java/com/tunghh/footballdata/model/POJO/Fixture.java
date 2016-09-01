package com.tunghh.footballdata.model.POJO;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by TungHH on 8/30/2016.
 */
public class Fixture {

    @SerializedName("fixtures")
    private ArrayList<FixtureMatch> fixture;

    public ArrayList<FixtureMatch> getFixture(){
        return fixture;
    }
}
