package com.dwz1676.tujiaproject.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;


import com.dwz1676.tujiaproject.R;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/6.
 */
public class ThemeFragment extends Fragment implements View.OnClickListener {

    private LinearLayout mLinearLayout;
    private FrameLayout mFramLayout;
    private Fragment scrollViewFragment;
    private FragmentTabHost tabhost;
    private FragmentManager fm;
    private String[] urlStr = new String[5];
    private List<Fragment> fragmentList;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        aboutFragmentTabHost();
    }

    /**
     * 界面控件实例的初始化
     */
    private void aboutFragmentTabHost() {

        // 步骤：
        // ①点击tabHost中每个标签，所要展现的内容，对应的控件，要指定
        tabhost.setup(getActivity(), getActivity().getSupportFragmentManager(), R.id.fl_container_id);

        // ②动态向tabHost添加子标签(循环添加)
        String[] themetabNames = getResources().getStringArray(R.array.themeTabNames);

        for (int i = 0; i < themetabNames.length; i++) {
            // a)构建子标签的实例
            String themetabName = themetabNames[i];
            TextView tv = (TextView) tabhost.getTabWidget().getChildAt(i).findViewById(android.R.id.title);
            TabHost.TabSpec newTabSpec = tabhost.newTabSpec(themetabName);

            // c）添加到tabHost
            Bundle args = new Bundle();
            args.putString("content", themetabName);
            tabhost.addTab(newTabSpec, ThemeFragment.class, args);
            tv.setTextColor(this.getResources().getColorStateList(
                    R.color.orange));
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.theme_fragment, null);
        fm = getActivity().getSupportFragmentManager();
        mLinearLayout = (LinearLayout) view.findViewById(R.id.theme_lltab);
        mFramLayout = (FrameLayout) view.findViewById(R.id.fl_container_id);

        fragmentList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            Fragment myFragment = new ScrollViewFragment();
            Bundle args = new Bundle();
            args.putString(urlStr[i], urlStr[0]);
            fragmentList.add(myFragment);
        }

        replaceContainerView(fragmentList.get(0));
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        for (int i = 0; i < mLinearLayout.getChildCount(); i++) {
            mLinearLayout.getChildAt(i).setOnClickListener(this);
        }
        super.onActivityCreated(savedInstanceState);
    }


    /**
     * @param fragment
     */
    private void replaceContainerView(Fragment fragment) {

        FragmentTransaction transaction3 = fm.beginTransaction();
        transaction3.replace(R.id.fl_container_id, fragment);
        transaction3.commit();
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.theme_newest:
                // 当点击了消息tab时，选中第1个tab
                replaceContainerView(fragmentList.get(0));
                break;
            case R.id.theme_tab2:
                // 当点击了联系人tab时，选中第2个tab
                replaceContainerView(fragmentList.get(1));
                break;
            case R.id.theme_tab3:
                // 当点击了动态tab时，选中第3个tab
                replaceContainerView(fragmentList.get(2));
                break;
            case R.id.theme_tab4:
                // 当点击了设置tab时，选中第4个tab
                replaceContainerView(fragmentList.get(3));
            case R.id.theme_tab5:
                // 当点击了设置tab时，选中第4个tab
                replaceContainerView(fragmentList.get(4));
                break;
            default:
                break;

        }
    }

}
