package com.example.klivitam.coolweather.entry;

import com.google.gson.annotations.SerializedName;

/**
 * Created by klivitam on 2016/12/5.
 */

public class ForeCast {
    public String date;
    @SerializedName("tmp")
    public Temperature temperature;

    @SerializedName("cond")
    public More more;

    public class Temperature {
        public String max;
        public String min;
    }

    public class More {
        @SerializedName("txt_d")
        public String info;
    }
}
