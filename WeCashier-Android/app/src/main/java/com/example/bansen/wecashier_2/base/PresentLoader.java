package com.example.bansen.wecashier_2.base;

import android.content.Context;
import android.support.v4.content.Loader;

/**
 * Created by bansen on 16/12/17.
 *
 * Loader
 *
 * 详解
 *
 *
 * a、生命周期
 *
 *  1.active ：活动状态：
 *       started ：启动状态；
 *       stopped ：停止状态，有可能再次启动。
 *   2.inactive ：非活动状态：
 *       abandoned ：废弃状态，废弃后过段时间也会重置；
 *       reseted ：重置状态，表示该 Loader 已经完全被销毁重用了。
 * b、onStartLoading
 *
 *   如果 Activity 执行 onStart 方法， Loader 会执行此方法，此时 Loader 处于 started 状态下， Loader 应该监听数据源的变化，并将变化的新数据发送给客户端。 这个时候有两种情况：
 *
 *   已经存在 Loader 所要加载对象实例，应该调用 deliverResult() 方法，触发 onLoadFinished() 回调的执行，从而客户端可以从该回调中轻松获取数据。
 *   如果没有的话，则先触发 onCreateLoader() 回调创建 Loader ，再调用 forceLoad() 方法，去促使它去加载，加载后再调用 deliverResult() 方法，回调 onLoadFinished() 。
 *c、onStopLoading
 *
 *  当 Activity/Fragment 执行 onStop() 方法时， Loader 会调用此方法，此时 Loader 处于 stopped 状态下。而且当 Activity/Fragment 处于 stopped 状态时，所有的 Loader 也会被置于 stopped 状态。
 *
 *  此时应该继续监听数据的变化，但是如果数据有变化应该先存起来，等重新 start 的时候再发送给客户端更新 UI 。
 *
 *d、onReset
 *
 *  abandoned状态暂时略过，来看 onReset 这个方法。它会在 Activity/Fragment 销毁时调用（主动调用 destroyLoader() 也可）。触发 onLoaderReset() 回调，并重新创建 Loader ，后续步骤类似 onStartLoading() 。
 *
 *
 */

public class PresentLoader<P extends BaseMvpPresenter> extends Loader<P> {
    private  final PresenterFactory<P>  factory;
    private P presenter;
    public PresentLoader(Context context, PresenterFactory<P> factory) {
        super(context);
        this.factory = factory;
    }
    /**
     * 在Activity的onStart()调用之后
     *
     * 当presenter已经存在是 调用deliverResult使loaderManager调用对应绑定监听者的{@link android.support.v4.app.LoaderManager.LoaderCallbacks}onLoadFinished方法
     */
    @Override
    protected void onStartLoading() {
        if(presenter != null){
            deliverResult(presenter);

        }
        forceLoad();
    }
    /**
     * 在调用forceLoad()方法后自动调用，我们在这个方法中创建Presenter并返回它。
     */
    @Override
    protected void onForceLoad() {
        presenter = factory.crate();//创建presenter
        deliverResult(presenter);
    }
    /**
     * 会在Loader被销毁之前调用，我们可以在这里告知Presenter以终止某些操作或进行清理工作。
     */
    @Override
    protected void onReset() {
        presenter = null;
    }
}
