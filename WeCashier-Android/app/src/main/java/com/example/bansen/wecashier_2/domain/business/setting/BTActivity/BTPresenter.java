package com.example.bansen.wecashier_2.domain.business.setting.BTActivity;

import com.example.bansen.wecashier_2.base.BaseMvpPresenter;

/**
 * Created by bansen on 16/12/18.
 */

public class BTPresenter extends BaseMvpPresenter<BTContatct.BTViewImp> implements BTContatct.BTPresenterImp {

    private BTModel btModel;

    public BTPresenter(BTModel btModel) {
        this.btModel = btModel;
    }
}
