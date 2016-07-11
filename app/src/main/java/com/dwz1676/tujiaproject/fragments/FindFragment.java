package com.dwz1676.tujiaproject.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.dwz1676.tujiaproject.R;
import com.dwz1676.tujiaproject.adapter.MyFragmentStatePagerAdapter;
import com.dwz1676.tujiaproject.view.IndicatorImageButton;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrator on 2016/7/6.
 */
public class FindFragment extends Fragment {
    private View view;
    private ViewPager mViewPager;
    private RadioGroup mRadioGroup;
    private IndicatorImageButton mImageButton;
    private String modelName;

    private FragmentStatePagerAdapter adapter;

    public FindFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        //从宿主接收传递过来的参数值
//        Bundle contentFromActivity = getArguments();
//        modelName = contentFromActivity.getString("modelName");

        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.findfragment, null);
        initWidgets();
//        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//
//            }
//        });
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        //关于ViewPager的操作
//        aboutViewPager();
//
//        //关于TabPageIndicator的操作
//        aboutIndicatorImageButton();

        super.onActivityCreated(savedInstanceState);
    }

    private void aboutIndicatorImageButton() {

    }

    private void aboutViewPager() {
        //准备数据源
        final List<Fragment> fragmentList = new ArrayList<>();
        for (int i = 0; i < mRadioGroup.getChildCount(); i++) {
            //往ViewPager里面加入ListFragment,每个Fragment都带有一个具有下拉刷新效果的ListView
            Fragment f1 = new ListFragment();
            Bundle bundle = new Bundle();
            bundle.putString("name", i + "");
            f1.setArguments(bundle);
            fragmentList.add(f1);
        }
        //准备适配器
        adapter = new MyFragmentStatePagerAdapter(getActivity().getSupportFragmentManager(),fragmentList);

        mViewPager.setAdapter(adapter);

    }

    private void initWidgets() {
        mRadioGroup = (RadioGroup) view.findViewById(R.id.rg_id);
        mImageButton = (IndicatorImageButton) view.findViewById(R.id.right_menu_id);
        mViewPager = (ViewPager) view.findViewById(R.id.discovery_viewpager_id);
    }
}
