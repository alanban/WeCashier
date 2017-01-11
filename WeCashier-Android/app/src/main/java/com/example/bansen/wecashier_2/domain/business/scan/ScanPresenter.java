package com.example.bansen.wecashier_2.domain.business.scan;

import com.example.bansen.wecashier_2.base.BaseMvpPresenter;

/**
 * Created by bansen on 17/1/11.
 */

public class ScanPresenter extends BaseMvpPresenter<ScanContract.ScanViewImp> implements ScanContract.ScanPresenterImp {
    ScanModel scanModel;

    public ScanPresenter(ScanModel scanModel) {
        this.scanModel = scanModel;
    }
}
