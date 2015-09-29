package com.coolweather.app.util;

/**
 * Created by wyu on 2015/9/29.
 */
public interface HttpCallbackListener {

    void onFinish(String response);

    void onError(Exception e);
}
