package com.example.bansen.wecashier_2.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import org.jetbrains.annotations.Nullable;


/**
 * Created by bansen on 16/12/17.
 *
 *  当手机状态改变时 如旋转屏幕，等操作会造成 activity重启
 *  使用官方提供的loader框架 来创建presenter 和维护生命周期
 *
 * google 官方todomvp例子中认为Fragement和Activity相比更像是MVP中的的View层，刚好可以满足MVP的View层的要求，Activity则作为最高指挥官用来创建和联系View和Presenter。
 * Fragment在平板或者屏幕上有多个View时更有优势
 * Activity只作为创建和联系View和PresenterView而存在，将Fragment作为显示UI而存在。Activity主指挥，Fragment主显示。这也是谷歌的sample中的一贯做法。
 *
 * 使用了butterKnife注入框架
 *
 */

public abstract class BaseActivity<P extends BaseMvpPresenter<V>, V extends BaseMvpViewImp> extends AppCompatActivity implements BaseMvpViewImp, LoaderManager.LoaderCallbacks<P> {

    private final int BASE_LODER_ID = 1000;//loader的id值
    private ProgressDialog progressDialog;//登录进度条
    protected P presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        progressDialog = new ProgressDialog(this);//实例化progressDialog
        getSupportLoaderManager().initLoader(BASE_LODER_ID, null, this);//初始化loader


    }

    @Override
    protected void onResume() {
        super.onResume();
        initData();
    }

    protected abstract void initData();

    protected abstract void initView();


    @Override
    public void onStart() {
        super.onStart();
        presenter.attachView((V) this);//presenter与view连接
        initView();
    }

    @Override
    public void showLoading(String msg) {
        progressDialog.setMessage(msg);//设置进度条加载内容
        if (!progressDialog.isShowing())//如果进度条没有显示
            progressDialog.show();//显示进度条
    }

    @Override
    public void hideLoading() {
        if (progressDialog.isShowing())
            progressDialog.dismiss();
    }

    @Override
    public void showErr(String err) {
        Toast.makeText(this, err, Toast.LENGTH_SHORT).show();
    }


    @Override
    public Loader<P> onCreateLoader(int id, Bundle args) {
        return null;
    }

    @Override
    public void onLoadFinished(Loader<P> loader, P data) {
        presenter = data;
    }

    @Override
    public void onLoaderReset(Loader<P> loader) {
        presenter = null;
    }

    @Override
    public void onDestroy() {
        presenter.detachView();
        super.onDestroy();
    }
}
