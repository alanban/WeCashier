package com.example.bansen.wecashier_2.utills.Adapters;

import android.content.res.Resources;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.widget.TableLayout;

import com.example.bansen.wecashier_2.R;
import com.example.bansen.wecashier_2.domain.business.cashier.Order.OrderFragment;
import com.example.bansen.wecashier_2.utills.StringUtil;

import java.util.ArrayList;
import java.util.List;

import timber.log.Timber;

/**
 * Created by bansen on 16/12/21.
 */

public class FragmentAdapter extends FragmentStatePagerAdapter {

    private ArrayList<Fragment> pagers;
    private TabLayout tab;

    public FragmentAdapter(FragmentManager fm) {
        super(fm);
        pagers = new ArrayList<>();
    }
    public FragmentAdapter(FragmentManager fm, ArrayList<Fragment> list) {
        super(fm);
        pagers = list;
    }

    public FragmentAdapter(FragmentManager fm, ArrayList<Fragment> list, TabLayout t) {
        super(fm);
        pagers = list;
        tab = t;
    }

    public FragmentAdapter(FragmentManager fm, TabLayout t) {
        super(fm);
        pagers = new ArrayList<>();
        tab = t;
    }

    public void addPager(OrderFragment o) {
        pagers.add(o);
        notifyDataSetChanged();
        if (tab != null) {
            tab.addTab(tab.newTab().setText(R.string.order_title),true);
        }


    }

    public void addPager(OrderFragment o, int position) {
        pagers.add(position, o);
        notifyDataSetChanged();
        if (tab!=null) {
            tab.addTab(tab.newTab().setText(R.string.order_title),true);
        }
    }

    public void removePager(int position) {
        pagers.remove(position);
        notifyDataSetChanged();

    }

    @Override
    public Fragment getItem(int position) {
        return pagers.get(position);
    }

    @Override
    public int getCount() {
        return pagers.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return super.isViewFromObject(view, object);
    }
}
