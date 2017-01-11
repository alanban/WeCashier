package com.example.bansen.wecashier_2.domain.business.cashier;

import android.support.v4.view.PagerAdapter;
import android.view.View;

import com.example.bansen.wecashier_2.bean.entity.GOODS;
import com.example.bansen.wecashier_2.bean.entity.ORDER;

/**
 * Created by bansen on 16/12/18.
 */

public class CashierModel implements CashierContract.CashierModelImp {
    @Override
    public void saveOrder(ORDER order) {

    }

    @Override
    public GOODS findGood(String barcode) {
        return null;
    }

    @Override
    public GOODS findGoods(String barcode) {
        return null;
    }


}
