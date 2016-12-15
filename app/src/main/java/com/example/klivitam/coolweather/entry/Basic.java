package com.example.klivitam.coolweather.entry;

import com.google.gson.annotations.SerializedName;

/**
 * Created by klivitam on 2016/12/5.
 */

public class Basic {
    @SerializedName("city")
    public String cityName;
    @SerializedName("id")
    public String weatherId;
    public Update update;

    public class Update {
        @SerializedName("loc")
        public String updateTime;
    }
}
