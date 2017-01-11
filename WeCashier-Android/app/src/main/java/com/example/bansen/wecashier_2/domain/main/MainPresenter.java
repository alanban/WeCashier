package com.example.bansen.wecashier_2.domain.main;

import com.example.bansen.wecashier_2.base.BaseMvpPresenter;
import com.example.bansen.wecashier_2.utills.Constants;

/**
 * Created by bansen on 16/12/17.
 */

public class MainPresenter extends BaseMvpPresenter<MainMvpContract.MainViewImp> implements MainMvpContract.MainPresenterImp{
    private MainModel mainModel;

    public MainPresenter(MainModel mainModel) {
        this.mainModel = mainModel;
    }


}
