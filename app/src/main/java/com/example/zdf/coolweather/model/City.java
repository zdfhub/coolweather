package com.example.zdf.coolweather.model;

/**
 * Created by zdf on 2016/11/17.
 */

public class City {
    private int id;
    private String cityName;
    private String cityCode;
    private int provinceId;

    public int getId() {
        return id;
    }

    public City(String cityName, int id, String cityCode, int provinceId) {
        this.cityName = cityName;
        this.id = id;
        this.cityCode = cityCode;
        this.provinceId = provinceId;
    }

    public City() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }
}
