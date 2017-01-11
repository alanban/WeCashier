package com.example.bansen.wecashier_2.base;

/**
 * Created by bansen on 16/12/17.
 */

public interface BaseMvpViewImp {
    /**
     * 显示进度条
     * @param msg   进度条加载内容
     */
    void showLoading(String msg);
    /**
     * 隐藏进度条
     */
    void hideLoading();
    /**
     * 显示加载错误
     * @param err 错误内容
     */
    void showErr(String err);

}
