package com.example.bansen.wecashier_2.domain.business.cashier.Order;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.content.Loader;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bansen.wecashier_2.R;
import com.example.bansen.wecashier_2.base.BaseFragment;
import com.example.bansen.wecashier_2.base.BaseMvpPresenter;
import com.example.bansen.wecashier_2.base.PresentLoader;
import com.example.bansen.wecashier_2.base.PresenterFactory;
import com.example.bansen.wecashier_2.bean.entity.GOODS;
import com.example.bansen.wecashier_2.bean.entity.ORDER;
import com.example.bansen.wecashier_2.utills.BusAction;
import com.example.bansen.wecashier_2.utills.rxbus.RxBus;
import com.hwangjr.rxbus.annotation.Subscribe;
import com.hwangjr.rxbus.annotation.Tag;
import com.hwangjr.rxbus.thread.EventThread;

import org.jetbrains.annotations.Nullable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import static android.view.View.VISIBLE;

/**
 * Created by bansen on 16/12/21.
 */

public class OrderFragment extends BaseFragment<OrderPresenter,OrderContract.OrderViewImp> implements OrderContract.OrderViewImp {

    private OrderAdapter orderAdapter;

    @BindView(R.id.order_recycleView)
    RecyclerView recyclerView;

    private Context mContext;

    Disposable disposable;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }



    @Override
    public Loader onCreateLoader(int id, Bundle args) {
        return new PresentLoader(this.getContext(), new PresenterFactory() {
            @Override
            public BaseMvpPresenter crate() {
                return new OrderPresenter(new OrderModel());
            }
        });
    }



    @Override
    protected int getLayout() {
        return R.layout.fragment_order;
    }

    @Override
    protected void initView(View view) {
        Log.e("order","initview");
        ButterKnife.bind(this,view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }


    @Override
    protected void initData() {
        Log.e("order","initData"+this);
        orderAdapter = new OrderAdapter();
        recyclerView.setAdapter(orderAdapter);

        //订阅 添加商品事件
        disposable =RxBus.getDefault().toObservable(OrderContract.OrderItemEvent.class)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<OrderContract.OrderItemEvent>() {
                    @Override
                    public void accept(OrderContract.OrderItemEvent orderItemEvent) throws Exception {

                        if(orderItemEvent.getmType()== OrderContract.OrderItemEvent.type.TYPE_ADD){
                            orderAdapter.addData(new GOODS());
                            recyclerView.scrollToPosition(orderItemEvent.getPosition()+1);
                        }

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
    }

    public Observable<Boolean> addGood(GOODS goods){
        return Observable.create(new ObservableOnSubscribe<Boolean>() {
            @Override
            public void subscribe(ObservableEmitter<Boolean> e) throws Exception {
                e.onNext(true);
                //出错
                e.onError(new Throwable("添加商品失败"));
            }
        });
    }

    public Observable<ORDER> checkOut(){
        return Observable.just(new ORDER());
    }


    @Override
    public void addGoodToList(GOODS goods) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(disposable!=null)
            disposable.dispose();
    }
}
