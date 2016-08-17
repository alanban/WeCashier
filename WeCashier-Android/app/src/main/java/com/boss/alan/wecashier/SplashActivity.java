package com.boss.alan.wecashier;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by alan on 2016/8/17.
 */

/**
 * 启动activity
 * 实现效果上的app秒开
 * 1. 在style中设置一个背景  <item name="android:windowBackground">@drawable/splash_layer</item>
 * 2. 在这个启动 mainActivity
 * 3. finish 自己
 */

public class SplashActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this,MainActivity.class);
                startActivity(intent);
                SplashActivity.this.finish();
            }
        },1000);

    }
}
