package com.boss.alan.wecashier;

import android.app.FragmentTransaction;
import android.content.res.Resources;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.boss.alan.wecashier.base.BaseActivity;
import com.boss.alan.wecashier.base.common;
import com.boss.alan.wecashier.business.cashier.CashierFragment;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.Main_content_container)
    FrameLayout Container;

    @BindView(R.id.Main_Nav)
    NavigationView navigationView;

    @BindView(R.id.Main_Drawer)
    DrawerLayout drawerLayout;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindString(R.string.weCashier)
    String appName;

    private common.MAIN_PAGE CurrentPage;
    private FragmentManager fragmentManager;

    @Override
    public int setLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        toolbar.setTitleTextColor(ContextCompat.getColor(this,R.color.colorTextNormal));
        toolbar.setTitle(appName);
        setSupportActionBar(toolbar);
        /**
         * 设置 actionBar 左侧图标
         */
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        /*设置初始 页面  默认 收银界面*/
        setUpPage(common.MAIN_PAGE.PAGE_CASHIER);

        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    protected void initData() {
        fragmentManager = getSupportFragmentManager();
    }


    /**
     * set up the fragment
     *
     * @param page {@link com.boss.alan.wecashier.base.common.MAIN_PAGE}.
     */
    private void setUpPage(common.MAIN_PAGE page) {

        if (CurrentPage == null)
            this.CurrentPage = page;
        if (CurrentPage == page) {
            return;
        } else {
            this.CurrentPage = page;
        }

        switch (page) {
            case PAGE_CASHIER:
                replaceFragment(fragmentManager,R.id.Main_content_container,new CashierFragment());
                break;
            case PAGE_MANAGE:
                break;
            case PAGE_QUERY:
                break;
            case PAGE_OFFER:
                break;
            case PAGE_CHARTS:
                break;
            case PAGE_STOCK:
                break;
            case PAGE_SETTING:
                break;
        }
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {


        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    public void replaceFragment(FragmentManager fragmentManager,int layoutId,Fragment fragment){
        android.support.v4.app.FragmentTransaction transaction =fragmentManager.beginTransaction();
        transaction.replace(layoutId,fragment);
        transaction.commit();
    }
}
