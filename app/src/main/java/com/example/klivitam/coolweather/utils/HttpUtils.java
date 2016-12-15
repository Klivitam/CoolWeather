package com.example.klivitam.coolweather.utils;

import okhttp3.OkHttpClient;
import okhttp3.Request;


/**
 * Created by klivitam on 2016/12/5.
 */

public class HttpUtils {
    public static void sendOkHttpRequest(String address,okhttp3.Callback callback){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(address).build();
        client.newCall(request).enqueue(callback);
    }
}
