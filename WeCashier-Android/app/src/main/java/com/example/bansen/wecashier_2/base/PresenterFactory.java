package com.example.bansen.wecashier_2.base;

/**
 * Created by bansen on 16/12/17.
 */

public interface PresenterFactory<p extends BaseMvpPresenter> {
    p crate();
}
