package com.example.zdf.coolweather.model;

/**
 * Created by zdf on 2016/11/17.
 */

public class Province {
    private int id;

    public Province(int id, String provinceName, String provinceCode) {
        this.id = id;
        this.provinceName = provinceName;
        this.provinceCode = provinceCode;
    }

    public Province() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    private String provinceName;
    private String provinceCode;
}
