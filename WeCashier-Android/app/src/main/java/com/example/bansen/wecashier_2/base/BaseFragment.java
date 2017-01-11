package com.example.bansen.wecashier_2.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.jetbrains.annotations.Nullable;

import butterknife.ButterKnife;

/**
 * Created by bansen on 16/12/17.
 *
 * 现在很多app使用模块单 Activity多 fragment 来进行框架设计
 * 如 知乎 ，微信等
 *
 * 在使用FragmentManager 时和 事务时
 *
 * 需注意
 *
 ｀ 1、getActivity()空指针
 ｀2、异常：Can not perform this action after onSaveInstanceState
 ｀3、Fragment重叠异常-----正确使用hide、show的姿势
 ｀4、Fragment嵌套的那些坑
 ｀5、未必靠谱的出栈方法remove()
 ｀6、多个Fragment同时出栈的深坑BUG
 ｀7、Fragment转场动画
 ` 8、使用viewpager配合使用lazyload，需注意第一个默认页面需要手动setUserVisibleHint(true)
 ｀9、使用load维护 presenter声明周期
 ｀10、重写了一些方法用于恢复状态 需注意fragment必须setrgument()
 */

public abstract class BaseFragment<P extends BaseMvpPresenter<V>,V extends BaseMvpViewImp>  extends Fragment implements BaseMvpViewImp,LoaderManager.LoaderCallbacks<P> {

    private final int BASE_LODER_ID = 1000;//loader的id值
    private ProgressDialog progressDialog;//登录进度条
    protected  P presenter;
    protected  Bundle savedState;
    private String KEY_SAVE="FRAGMENT_STORE_KEY_"+this.getClass().toString();

    protected boolean isViewInitiated;
    protected boolean isVisibleToUser;
    protected boolean isDataInitiated;


    @android.support.annotation.Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @android.support.annotation.Nullable ViewGroup container, @android.support.annotation.Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayout(),container,false);
        initView(view);
        return view;
    }

    /**
     * 注意 fragment 中应该在这里注册 loader
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(@android.support.annotation.Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        progressDialog = new ProgressDialog(this.getActivity());//实例化progressDialog
        getLoaderManager().initLoader(BASE_LODER_ID,null,this);//初始化loader

        if (!restoreStateFromArguments()) {
            // 当restore的bundle中无数据时，判断为第一次启动
            isViewInitiated = true;
            prepareInitData(false);
            onFirstTimeLaunched();
        }

    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        this.isVisibleToUser = isVisibleToUser;
        prepareInitData(false);
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.attachView((V)this);//presenter与view断开连接

    }

    /**
     *
     * @param forceUpdate 是否强制刷新
     */
    public void prepareInitData(boolean forceUpdate){
        if(isVisibleToUser&&isViewInitiated&&(!isDataInitiated||forceUpdate)){
            initData();
            isDataInitiated = true;
        }
    }

    protected abstract @LayoutRes int getLayout();

    protected abstract void initView(View view);


    protected abstract void initData();



    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void showLoading(String msg) {
        progressDialog.setMessage(msg);//设置进度条加载内容
        if (! progressDialog.isShowing())//如果进度条没有显示
            progressDialog.show();//显示进度条
    }

    @Override
    public void hideLoading() {
        if (progressDialog.isShowing())
            progressDialog.dismiss();
    }

    @Override
    public void showErr(String err) {
        Toast.makeText(this.getActivity(), err, Toast.LENGTH_SHORT).show();
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
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        saveStateToArguments();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        saveStateToArguments();
    }

    @Override
    public void onDestroy() {
        presenter.detachView();
        super.onDestroy();
    }

    protected void onFirstTimeLaunched() {

    }

    /**
     * 保存一个bundle道argument中
     * key为 key_save
     * bundle 为成员变量 savebundle
     * 该bundle在这里初始化
     */
    private void saveStateToArguments() {
        if (getView() != null)
            savedState = saveState();
        if (savedState != null) {
            Bundle b = getArguments();
            b.putBundle(KEY_SAVE, savedState);
        }
    }

    /**
     *  取出缓存的bundle
     *  调用方法onRestoreState（）
     * @return
     */

    private boolean restoreStateFromArguments() {
        Bundle b = getArguments();
        if (b == null)
            return false;
        savedState = b.getBundle(KEY_SAVE);
        if (savedState != null) {
            restoreState();
            return true;
        }
        return false;
    }

    /**
     *
     */
    private void restoreState() {
        if (savedState != null) {
            onRestoreState(savedState);
        }
    }

    /**
     * 恢复数据时的回调
     * @param savedInstanceState
     */
    protected void onRestoreState(Bundle savedInstanceState) {

    }

    /**
     *
     * @return
     */
    private Bundle saveState() {
        Bundle state = new Bundle();
        onSaveState(state);
        return state;
    }

    /**
     * 保存数据时的回调
     * @param outState
     */
    protected void onSaveState(Bundle outState) {

    }
}
