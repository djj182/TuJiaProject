package com.dwz1676.tujiaproject.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by WeiYaFei on 2016/7/11.
 */
public class MyFragmentAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> mFragmentList;
    private FragmentManager mFragmentManager;

    public MyFragmentAdapter(FragmentManager fm) {
        super(fm);
        this.mFragmentManager = fm;
    }

    /**
     * Return the Fragment associated with a specified position.
     *
     * @param position
     */
    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    /**
     * Return the number of views available.
     */
    @Override
    public int getCount() {
        return mFragmentList.size();
    }
    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    public void setFragments(LinkedList<Fragment> mFragmentList) {
        if (this.mFragmentList != null) {
            FragmentTransaction ft = mFragmentManager.beginTransaction();
            for (Fragment f : this.mFragmentList) {
                ft.remove(f);
            }
            ft.commit();
            ft=null;
            mFragmentManager.executePendingTransactions();
        }
        this.mFragmentList = mFragmentList;
        notifyDataSetChanged();
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        Object obj = super.instantiateItem(container, position);
        return obj;
    }

}

