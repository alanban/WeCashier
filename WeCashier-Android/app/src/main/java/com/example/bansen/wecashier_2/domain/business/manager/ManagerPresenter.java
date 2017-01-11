package com.example.bansen.wecashier_2.domain.business.manager;

import com.example.bansen.wecashier_2.base.BaseMvpPresenter;

/**
 * Created by bansen on 16/12/18.
 */

public class ManagerPresenter extends BaseMvpPresenter<ManagerContract.ManagerViewImp> implements ManagerContract.ManagerPresenterImp {
    private ManagerModel managerModel;

    public ManagerPresenter(ManagerModel managerModel) {
        this.managerModel = managerModel;
    }
}
