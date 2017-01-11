package com.example.bansen.wecashier_2;

import android.app.Application;

import com.example.bansen.wecashier_2.DB.DaoManager;
import com.example.bansen.wecashier_2.bean.gen.DaoSession;

/**
 * Created by bansen on 16/12/17.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化数据库
        DaoManager.getInstance().init(this);
    }


    //当需要清楚内存时
    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }


}
