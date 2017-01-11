package com.example.bansen.wecashier_2.domain.business.cashier;

import com.example.bansen.wecashier_2.base.BaseMvpPresenter;

/**
 * Created by bansen on 16/12/18.
 */

public class CashierPresenter extends BaseMvpPresenter<CashierContract.CashierViewImp> implements CashierContract.CashierPresenterImp{
    private CashierModel cashierModel ;

    public CashierPresenter(CashierModel cashierModel) {
        this.cashierModel = cashierModel;
    }

    @Override
    public void createOrder() {

    }

    @Override
    public void deleteOrder() {

    }

    @Override
    public void checkOut() {

    }


}
