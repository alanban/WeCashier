package com.example.bansen.wecashier_2.domain.business.setting;

import com.example.bansen.wecashier_2.base.BaseMvpPresenter;

/**
 * Created by bansen on 16/12/18.
 */

public class SettingPresenter extends BaseMvpPresenter<SettingContact.SettingViewImp> implements SettingContact.SettingPresenterImp {

    private SettingModel settingModel;

    public SettingPresenter(SettingModel settingModel) {
        this.settingModel = settingModel;
    }
}
