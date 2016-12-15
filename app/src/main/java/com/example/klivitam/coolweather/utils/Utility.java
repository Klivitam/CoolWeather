package com.example.klivitam.coolweather.utils;

import android.text.TextUtils;
import android.util.Log;

import com.example.klivitam.coolweather.db.City;
import com.example.klivitam.coolweather.db.County;
import com.example.klivitam.coolweather.db.Province;
import com.example.klivitam.coolweather.entry.Weather;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by klivitam on 2016/12/5.
 */

public class Utility {
    public static boolean handleProvinceResponce(String responce){
        if(!TextUtils.isEmpty(responce)){
            try {
                JSONArray allProvince = new JSONArray(responce);
                for(int i = 0;i<allProvince.length();i++){
                    JSONObject provinceObject = allProvince.getJSONObject(i);
                    Province province = new Province();
                    province.setProvinceName(provinceObject.getString("name"));
                    province.setProvinceCode(provinceObject.getInt("id"));
                    province.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    public static boolean handleCityResponce(String responce,int provinceId){
        if(!TextUtils.isEmpty(responce)){
            try {
                Log.i("test", "handleCityResponce: "+responce);
                JSONArray allCities = new JSONArray(responce);
                for(int i = 0;i<allCities.length();i++){
                    JSONObject cityObject = allCities.getJSONObject(i);
                    City city = new City();
                    city.setCityName(cityObject.getString("name"));
                    city.setCityCode(cityObject.getInt("id"));
                    city.setProvinceId(provinceId);
                    city.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    public static boolean handleCountyResponce(String responce,int CityId){
        if(!TextUtils.isEmpty(responce)){
            try {
                JSONArray allCounties = new JSONArray(responce);
                for(int i = 0;i<allCounties.length();i++){
                    JSONObject countyObject = allCounties.getJSONObject(i);
                    County city = new County();
                    city.setCountyName(countyObject.getString("name"));
                    city.setWeatherId(countyObject.getString("weather_id"));
                    city.setCityId(CityId);
                    city.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    public static Weather handleWeatherResponse(String responce){
        try {
            JSONObject jsonObject = new JSONObject(responce);
            JSONArray jsonArray = jsonObject.getJSONArray("HeWeather");
            String weatherContent = jsonArray.getJSONObject(0).toString();
            return new Gson().fromJson(weatherContent,Weather.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

}
