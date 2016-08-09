package com.boss.alan.wecashier.business.cashier;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.widget.TextView;

import com.boss.alan.wecashier.R;
import com.boss.alan.wecashier.base.BaseFragment;

import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.OnClick;

/**
 * Created by alan on 2016/8/8.
 */
public class CashierFragment extends BaseFragment {


    @BindView(R.id.cashier_TabLayout)
    TabLayout tabLayout;
    @BindView(R.id.cashier_ViewPager)
    ViewPager viewPager;
    @BindViews({R.id.cashier_bt_delete,R.id.cashier_bt_check_out,R.id.cashier_bt_hang_up})
    List<TextView> textViews;

    @Override
    public int getLayoutID() {
        return R.layout.fragment_cashier;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @OnClick({ R.id.cashier_bt_delete, R.id.cashier_bt_check_out, R.id.cashier_bt_hang_up })
    public void pickDoor(TextView bt) {
        int id = bt.getId();
        switch (id){
            case R.id.cashier_bt_delete:
                break;
            case R.id.cashier_bt_check_out:
                break;
            case R.id.cashier_bt_hang_up:
                break;
        }
    }

}
