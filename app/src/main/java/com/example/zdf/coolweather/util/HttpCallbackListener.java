package com.example.zdf.coolweather.util;

/**
 * Created by zdf on 2016/11/18.
 */

public interface HttpCallbackListener {
    void onFinish(String response);
    void onError(Exception e);
}
