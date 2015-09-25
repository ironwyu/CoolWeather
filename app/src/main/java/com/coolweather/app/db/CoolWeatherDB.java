package com.coolweather.app.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.coolweather.app.model.Province;

/**
 * Created by wyu on 2015/9/25.
 */
public class CoolWeatherDB {

    private static final String DB_NAME = "cool_weather";

    private static final int VERSION = 1;

    private SQLiteDatabase db;

    private static CoolWeatherDB instance;

    private CoolWeatherDB(Context context) {
        CoolWeatherOpenHelper dbhelper = new CoolWeatherOpenHelper(context, DB_NAME, null, VERSION);
        db = dbhelper.getWritableDatabase();
    }

    public synchronized static CoolWeatherDB getInstance(Context context) {
        if (instance == null) {
            instance = new CoolWeatherDB(context);
        }
        return instance;
    }

    public void saveProvince(Province province) {
        if (province == null) {
            return;
        }
        ContentValues values = new ContentValues();
        values.put("province_name", province.getProvinceName());
        values.put("province_code", province.getProvinceCode());
        db.insert("Province", null, values);
    }

}
