package com.boss.alan.wecashier.base;

/**
 * Created by alan on 2016/8/8.
 */
public interface BaseView<T extends BasePresenter> {
    void setPresenter(T presenter);
}
