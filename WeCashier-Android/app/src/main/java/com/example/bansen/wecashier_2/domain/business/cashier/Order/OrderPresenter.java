package com.example.bansen.wecashier_2.domain.business.cashier.Order;

import com.example.bansen.wecashier_2.base.BaseMvpPresenter;

/**
 * Created by bansen on 16/12/21.
 */

public class OrderPresenter extends BaseMvpPresenter<OrderContract.OrderViewImp> implements OrderContract.OrderPresenterImp {
    private OrderModel orderModel;

    public OrderPresenter(OrderModel orderModel) {
        this.orderModel = orderModel;
    }


    @Override
    public void addGood() {

    }
}
