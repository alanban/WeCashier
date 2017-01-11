package com.example.bansen.wecashier_2.domain.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.Loader;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.bansen.wecashier_2.R;
import com.example.bansen.wecashier_2.base.BaseActivity;
import com.example.bansen.wecashier_2.base.PresentLoader;
import com.example.bansen.wecashier_2.base.PresenterFactory;
import com.example.bansen.wecashier_2.domain.business.cashier.CashierFragment;
import com.example.bansen.wecashier_2.domain.business.manager.ManagerFragemnt;
import com.example.bansen.wecashier_2.domain.business.setting.SettingFragment;

public class MainActivity extends BaseActivity<MainPresenter, MainMvpContract.MainViewImp> implements MainMvpContract.MainViewImp, View.OnClickListener, BottomNavigationBar.OnTabSelectedListener {
    private String TAG = "MainActivity";

    private int CurrentSelectPosition = 0;

    private static int FIRST = 0;
    private static int SECOND = 1;
    private static int THIRD = 2;

    private Fragment[] fragments;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null){
            initFragment();
        }else {
            fragments[FIRST] = getSupportFragmentManager().getFragments().get(FIRST);
            fragments[SECOND] = getSupportFragmentManager().getFragments().get(SECOND);
            fragments[THIRD] = getSupportFragmentManager().getFragments().get(THIRD);
        }
    }

    @Override
    protected void initData() {
    }


    @Override
    protected void initView() {



    }


    @Override
    public Loader<MainPresenter> onCreateLoader(int id, Bundle args) {
        return new PresentLoader<>(this, new PresenterFactory<MainPresenter>() {
            @Override
            public MainPresenter crate() {
                return new MainPresenter(new MainModel());
            }
        });
    }


    public void initFragment() {
        fragments = new Fragment[3];
        fragments[FIRST] = new CashierFragment();
        fragments[FIRST].setArguments(new Bundle());
        fragments[SECOND] = new ManagerFragemnt();
        fragments[SECOND].setArguments(new Bundle());
        fragments[THIRD] = new SettingFragment();
        fragments[THIRD].setArguments(new Bundle());

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.main_fragment_container, fragments[FIRST],CashierFragment.class.getName());
        fragmentTransaction.show(fragments[FIRST]);
        fragmentTransaction.add(R.id.main_fragment_container, fragments[SECOND],ManagerFragemnt.class.getName());
        fragmentTransaction.hide(fragments[SECOND]);
        fragmentTransaction.add(R.id.main_fragment_container, fragments[THIRD],SettingFragment.class.getName());
        fragmentTransaction.hide(fragments[THIRD]);
        fragmentTransaction.commit();

        BottomNavigationBar mBottomBar = (BottomNavigationBar) findViewById(R.id.main_bottom_navigation_bar);

        mBottomBar
                .addItem(new BottomNavigationItem(R.drawable.ic_cashier_24dp, "收银"))
                .addItem(new BottomNavigationItem(R.drawable.ic_manager_24dp, "管理"))
                .addItem(new BottomNavigationItem(R.drawable.ic_settings_black_24dp, "设置"))
                .initialise();
        mBottomBar.setTabSelectedListener(this);
    }

    @Override
    public void onClick(View view) {

    }


    @Override
    public void onTabSelected(int position) {
        if (presenter.isAttachView()) {
            if (position == CurrentSelectPosition) {
                return;
            }

            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

            switch (position) {
                case 0:
                    fragmentTransaction.show(fragments[FIRST]).hide(fragments[SECOND]).hide(fragments[THIRD]);
                    CurrentSelectPosition = FIRST;
                    break;
                case 1:
                    fragmentTransaction.show(fragments[SECOND]).hide(fragments[THIRD]).hide(fragments[FIRST]);
                    CurrentSelectPosition = SECOND;
                    break;
                case 2:
                    fragmentTransaction.show(fragments[THIRD]).hide(fragments[FIRST]).hide(fragments[SECOND]);
                    CurrentSelectPosition = THIRD;
                    break;
            }
            fragmentTransaction.commit();
        }
    }

    @Override
    public void onTabUnselected(int position) {
        //配置信息中设置页面缓存时间 一段时间后清除页面
    }

    @Override
    public void onTabReselected(int position) {

    }
}
