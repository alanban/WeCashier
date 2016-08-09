package com.boss.alan.wecashier.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by alan on 2016/8/8.
 */
public abstract class BaseActivity extends AppCompatActivity {

    public abstract int setLayoutID();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayoutID());
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        initView();
        initData();
    }

    protected abstract void initData();

    protected abstract void initView();

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
