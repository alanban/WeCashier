package com.example.bansen.wecashier_2.domain.business.manager;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.Loader;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.bansen.wecashier_2.R;
import com.example.bansen.wecashier_2.base.BaseFragment;
import com.example.bansen.wecashier_2.base.PresentLoader;
import com.example.bansen.wecashier_2.base.PresenterFactory;
import com.example.bansen.wecashier_2.domain.business.scan.ScanActivity;
import com.example.bansen.wecashier_2.utills.ToastUtil;
import com.example.bansen.wecashier_2.utills.rxbluetooth.RxBlueTooth;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by bansen on 16/12/18.
 */

public class ManagerFragemnt extends BaseFragment<ManagerPresenter,ManagerContract.ManagerViewImp> implements ManagerContract.ManagerViewImp{

    private View rootView;

    @BindView(R.id.scan)
    Button button;


    @Override
    protected void initData() {
        Log.e("ManagerFragment","initData");
    }

    @Override
    public Loader<ManagerPresenter> onCreateLoader(int id, Bundle args) {
        return new PresentLoader<>(this.getContext(), new PresenterFactory<ManagerPresenter>() {
            @Override
            public ManagerPresenter crate() {
                return new ManagerPresenter(new ManagerModel());
            }
        });
    }


    @Override
    protected int getLayout() {
        return R.layout.fragment_manager;
    }

    @Override
    protected void initView(View view) {
        ButterKnife.bind(this,view);
    }

    @Override
    public void onResume() {
        super.onResume();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                RxBlueTooth.getInstance(getActivity())
//                        .EnableDeviceBL()
//                        .observeDiscovery()
//                        .debounce(12, TimeUnit.SECONDS)
//                        .subscribeOn(Schedulers.io())
//                        .observeOn(AndroidSchedulers.mainThread())
//                        .subscribe(new Observer<String>() {
//                            @Override
//                            public void onSubscribe(Disposable d) {
//
//                            }
//
//                            @Override
//                            public void onNext(String s) {
//                                ToastUtil.getToastUtil(getContext()).MakeAShortToast(""+s);
//                            }
//
//                            @Override
//                            public void onError(Throwable e) {
//
//                            }
//
//                            @Override
//                            public void onComplete() {
//
//                            }
//                        });
                startActivity(new Intent(getActivity(), ScanActivity.class));

            }
        });
    }
}
