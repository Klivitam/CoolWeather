package com.example.klivitam.coolweather.entry;

import com.google.gson.annotations.SerializedName;

/**
 * Created by klivitam on 2016/12/5.
 */

public class Now {
    @SerializedName("tmp")
    public String temperature;
    @SerializedName("cond")
    public More more;

    public class More {
        @SerializedName("txt")
        public String info;
    }
}
