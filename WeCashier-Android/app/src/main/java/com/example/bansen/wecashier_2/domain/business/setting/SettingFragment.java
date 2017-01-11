package com.example.bansen.wecashier_2.domain.business.setting;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.Loader;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bansen.wecashier_2.R;
import com.example.bansen.wecashier_2.base.BaseFragment;
import com.example.bansen.wecashier_2.base.PresentLoader;
import com.example.bansen.wecashier_2.base.PresenterFactory;
import com.example.bansen.wecashier_2.domain.business.setting.SettingContact.SettingViewImp;

import butterknife.ButterKnife;

/**
 * Created by bansen on 16/12/18.
 */

public class SettingFragment extends BaseFragment<SettingPresenter,SettingViewImp> implements SettingViewImp{


    @Override
    public Loader<SettingPresenter> onCreateLoader(int id, Bundle args) {
        return new PresentLoader<>(this.getContext(), new PresenterFactory<SettingPresenter>() {
            @Override
            public SettingPresenter crate() {
                return new SettingPresenter(new SettingModel());
            }
        });
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_setting;
    }

    @Override
    protected void initView(View view) {
        ButterKnife.bind(this,view);
    }

    @Override
    protected void initData() {
        Log.e("SettingFragment","initData");
    }
}
