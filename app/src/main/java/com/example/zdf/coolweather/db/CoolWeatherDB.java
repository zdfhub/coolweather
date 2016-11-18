package com.example.zdf.coolweather.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.zdf.coolweather.model.City;
import com.example.zdf.coolweather.model.County;
import com.example.zdf.coolweather.model.Province;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zdf on 2016/11/17.
 */

public class CoolWeatherDB {
    public static final String DB_NAME = "cool_weather";
    public static final int VERSION = 1;
    private static CoolWeatherDB coolWeatherDB;

    private SQLiteDatabase db;

    private CoolWeatherDB(Context context){
        CoolWeatherOpenHelper dbHelper = new CoolWeatherOpenHelper(context,DB_NAME, null, VERSION);
        db = dbHelper.getWritableDatabase();
    }
    public synchronized static CoolWeatherDB getInstance(Context context){
        if(coolWeatherDB==null){
            coolWeatherDB=new CoolWeatherDB(context);
        }
        return coolWeatherDB;
    }
    public void saveProvince(Province province) {
        if (province != null) {
            ContentValues values = new ContentValues();
            values.put("province_name", province.getProvinceName());
            values.put("province_code", province.getProvinceCode());
            db.insert("Province", null, values);
        }
    }

    public List<Province>  loadProvinces(){
        List<Province> list=new ArrayList<Province>();
        String getAllProvince="select * from province";

        Cursor cursor=db.query("Province",null,null,null,null,null,null);
        cursor=db.rawQuery(getAllProvince,null);
        while(cursor.moveToNext()){
            Province province=new Province();
            province.setId(cursor.getInt(cursor.getColumnIndex("id")));
            province.setProvinceName(cursor.getString(cursor.getColumnIndex("province_name")));
            province.setProvinceCode(cursor.getString(cursor.getColumnIndex("province_code")));
            list.add(province);
        }
        return  list;
    }
    public void saveCity(City city) {
        if (city != null) {
            ContentValues values = new ContentValues();
            values.put("city_name", city.getCityName());
            values.put("city_code", city.getCityCode());
            values.put("province_id", city.getProvinceId());
            db.insert("City", null, values);
        }
    }
public List<City> loadCities(int provinceId){
    List<City> list=new ArrayList<City>();
    String getCitiesSQL="select * from city where province_id=?";
    Cursor cursor=db.rawQuery(getCitiesSQL,new String[]{String.valueOf(provinceId)});
    while(cursor.moveToNext()){
        City city=new City();
        city.setId(cursor.getInt(cursor.getColumnIndex("id")));
        city.setCityName(cursor.getString(cursor.getColumnIndex("city_name")));
        city.setCityCode(cursor.getString(cursor.getColumnIndex("city_code")));
        city.setProvinceId(provinceId);
        list.add(city);
        }
        return list;
    }
    public void saveCounty(County county) {
        if (county != null) {
            ContentValues values = new ContentValues();
            values.put("county_name", county.getCountyName());
            values.put("county_code", county.getCountyCode());
            values.put("city_id", county.getCityId());
            db.insert("County", null, values);
            }
    }
    public List<County> loadCounties(int cityId){
        List<County> list=new ArrayList<County>();
        String getCountiesSQL="select * from county where city_id=?";
        Cursor cursor=db.rawQuery(getCountiesSQL,new String[]{String.valueOf(cityId)});
        while(cursor.moveToNext()){
            County county=new County();
            county.setId(cursor.getInt(cursor.getColumnIndex("id")));
            county.setCountyName(cursor.getString(cursor.getColumnIndex("county_name")));
            county.setCountyCode(cursor.getString(cursor.getColumnIndex("county_code")));
            county.setCityId(cityId);
            list.add(county);
        }

        return list;
    }






}
