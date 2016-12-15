package com.example.klivitam.coolweather.entry;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by klivitam on 2016/12/5.
 */

public class Weather {
    public String status;
    public Basic basic;
    public AQI aqi;
    public Now now;
    public Suggestion suggestion;
    @SerializedName("daily_forecast")
    public List<ForeCast> foreCastList;
}
