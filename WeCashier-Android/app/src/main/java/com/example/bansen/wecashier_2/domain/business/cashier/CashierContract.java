package com.example.bansen.wecashier_2.domain.business.cashier;

import com.example.bansen.wecashier_2.base.BaseMvpViewImp;
import com.example.bansen.wecashier_2.bean.entity.GOODS;
import com.example.bansen.wecashier_2.bean.entity.ORDER;

/**
 * Created by bansen on 16/12/18.
 */

public class CashierContract {
    interface CashierViewImp extends BaseMvpViewImp{
        void showOrderDailog();
        void newOrderPager();
        void removeOrderPager();
    }
    interface CashierPresenterImp {
        void createOrder();
        void deleteOrder();
        void checkOut();
    }
    interface CashierModelImp{
        void saveOrder(ORDER order);
        GOODS findGood(String barcode);
        GOODS findGoods(String barcode);
    }
}
