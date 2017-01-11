package com.example.bansen.wecashier_2.domain.business.setting.BTActivity;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.v4.content.Loader;

import com.example.bansen.wecashier_2.base.BaseActivity;
import com.example.bansen.wecashier_2.base.BaseMvpViewImp;
import com.example.bansen.wecashier_2.base.PresentLoader;
import com.example.bansen.wecashier_2.base.PresenterFactory;

import org.jetbrains.annotations.Nullable;

/**
 * Created by bansen on 16/12/18.
 */

public  class BTActivity extends BaseActivity<BTPresenter,BTContatct.BTViewImp> implements BaseMvpViewImp {



    @Override
    public Loader<BTPresenter> onCreateLoader(int id, Bundle args) {
        return new PresentLoader<>(this, new PresenterFactory<BTPresenter>() {
            @Override
            public BTPresenter crate() {
                return new BTPresenter(new BTModel());
            }
        });
    }



    @CallSuper
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        initView();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }


}
