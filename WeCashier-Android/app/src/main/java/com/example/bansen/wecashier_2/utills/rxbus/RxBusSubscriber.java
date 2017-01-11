package com.example.bansen.wecashier_2.utills.rxbus;

import org.reactivestreams.Subscriber;

/**
 * 为RxBus使用的Subscriber, 主要提供next事件的try,catch
 * <p>
 * Created by YoKeyword on 16/7/20.
 */
public abstract class RxBusSubscriber<T extends Object> implements Subscriber<T> {


    @Override
    public void onNext(T t) {
        try {
            onEvent(t);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onComplete() {

    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
    }

    protected abstract void onEvent(T t);
}
