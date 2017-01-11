package com.example.bansen.wecashier_2.domain.business.cashier;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.Loader;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.bansen.wecashier_2.R;
import com.example.bansen.wecashier_2.base.BaseFragment;
import com.example.bansen.wecashier_2.base.PresentLoader;
import com.example.bansen.wecashier_2.base.PresenterFactory;
import com.example.bansen.wecashier_2.bean.entity.ORDER;
import com.example.bansen.wecashier_2.domain.business.cashier.Order.OrderContract;
import com.example.bansen.wecashier_2.domain.business.cashier.Order.OrderFragment;
import com.example.bansen.wecashier_2.utills.Adapters.FragmentAdapter;
import com.example.bansen.wecashier_2.utills.rxbus.RxBus;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Consumer;

/**
 * Created by bansen on 16/12/18.
 *
 * 此页面为主页面
 * 代码主要为 tablayout和viewpager的相互调用
 * 需注意没有使用tabLayout.setupWithViewPager方法的原因：
 * 由于该方法造成的耦合使得在设置tab title时很麻烦，直接使用事件来相互select来的方便
 *
 *
 * rxJava的运用
 *
 */

public class CashierFragment extends BaseFragment<CashierPresenter, CashierContract.CashierViewImp> implements CashierContract.CashierViewImp, TabLayout.OnTabSelectedListener, ViewPager.OnPageChangeListener {

    private View rootView;

    private FragmentAdapter pagerAdapter;
    @BindView(R.id.cashier_order_container)
    ViewPager viewPager;
    @BindView(R.id.cashier_deleteOrder)
    Button Bt_deleteOrder;
    @BindView(R.id.cashier_createOrder)
    Button Bt_createOrder;
    @BindView(R.id.cashier_checkOut)
    Button Bt_checkOut;
    @BindView(R.id.cashier_tablayout)
    TabLayout tabLayout;

    //最多5个订单同时存在
    private int LimitPageSize = 5;

    @Override
    protected int getLayout() {
        return R.layout.fragment_cashier;
    }

    @Override
    protected void initView(View view) {
        Log.e("cashier","initview");
        ButterKnife.bind(this, view);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.setOnTabSelectedListener(this);
        viewPager.addOnPageChangeListener(this);
        viewPager.setOffscreenPageLimit(LimitPageSize);
        setUserVisibleHint(true);
    }


    @Override
    protected void initData() {
        Log.e("CashierFragment","initData");
        pagerAdapter = new FragmentAdapter(getFragmentManager(), tabLayout);
        OrderFragment defultOrder = new OrderFragment();
        defultOrder.setArguments(new Bundle());
        pagerAdapter.addPager(defultOrder);
        viewPager.setAdapter(pagerAdapter);
    }

    @Override
    public Loader<CashierPresenter> onCreateLoader(int id, Bundle args) {
        return new PresentLoader<>(this.getContext(), new PresenterFactory<CashierPresenter>() {
            @Override
            public CashierPresenter crate() {
                return new CashierPresenter(new CashierModel());
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void showOrderDailog() {
        //
        Observable<ORDER> orderDailogOb = Observable.create(new ObservableOnSubscribe<ORDER>() {
            @Override
            public void subscribe(ObservableEmitter<ORDER> e) throws Exception {

            }
        });
    }

    @Override
    public void newOrderPager() {

    }

    @Override
    public void removeOrderPager() {

    }

    /**
     * 删除订单
     */
    @OnClick(R.id.cashier_deleteOrder)
    void onDeleteClick() {
        presenter.deleteOrder();
        if (tabLayout.getTabCount()>1){
            int selectPosition = tabLayout.getSelectedTabPosition();
            tabLayout.removeTab(tabLayout.getTabAt(selectPosition));
            pagerAdapter.removePager(selectPosition);

        }
    }

    /**
     * 订单结账
     */
    @OnClick(R.id.cashier_checkOut)
    void onCheckOutClick() {
        presenter.checkOut();
    }

    /**
     * 挂起订单
     */
    @OnClick(R.id.cashier_createOrder)
    void onCreateClick() {
        if(pagerAdapter.getCount()<LimitPageSize){
            presenter.createOrder();
            OrderFragment newOrderFragment = new OrderFragment();
            newOrderFragment.setArguments(new Bundle());
            pagerAdapter.addPager(newOrderFragment);
        }else {
            Snackbar.make(getView(),"同时操作不能超过五个订单",Snackbar.LENGTH_SHORT).show();
        }
    }


    /**
     * 处理viewPager和tabLayout的点击事件
     * 强制刷新页面 将会从新执行该fragment的initData()方法 ／／放弃 要这么做 同时要做缓存数据，而使用greendao时还不知道是否可以在bean上做序列化
     * @param tab
     */
    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tabLayout.getSelectedTabPosition());
        //强制刷新
//        ((BaseFragment)pagerAdapter.getItem(tabLayout.getSelectedTabPosition())).prepareInitData(true);
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        tabLayout.getTabAt(position).select();
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
