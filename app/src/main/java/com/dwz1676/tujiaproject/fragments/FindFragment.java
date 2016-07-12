package com.dwz1676.tujiaproject.fragments;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.dwz1676.tujiaproject.R;
import com.dwz1676.tujiaproject.activities.LoginActivity;
import com.dwz1676.tujiaproject.adapter.MyFragmentAdapter;
import com.dwz1676.tujiaproject.view.IndicatorImageButton;

import java.util.LinkedList;
import java.util.List;


/**
 * Created by Administrator on 2016/7/6.
 */
public class FindFragment extends Fragment {
    private View view;
    private ViewPager mViewPager;
    private RadioGroup mRadioGroup;
    private LinearLayout mLinearLayout;
    private IndicatorImageButton mImageButton;
    private String mtabName;// 宿主传递过来的标签名

    private FragmentStatePagerAdapter mAdapter;
    private RadioButton mRadioButton;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        //从宿主接收传递过来的参数值
        Bundle contentFromActivity = getArguments();
        mtabName = contentFromActivity.getString("tabName");

        mRadioButton.setChecked(true);
        mViewPager.setCurrentItem(0);
        initWidgets();
        //关于ViewPager的操作
        aboutViewPager();

        aboutIndicatorImageButton();
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.find_fragment, container, false);

        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radiobtn_theme_id:
                        mViewPager.setCurrentItem(0);
                        break;
                    case R.id.radiobtn_promotion_id:
                        mViewPager.setCurrentItem(1);
                        break;
                    default:
                        break;
                }
                mViewPager.setCurrentItem(checkedId);
            }
        });
        return view;
    }


    /**
     * ViewPager切换Fragment,RadioGroup做相应变化
     */
    private class myOnPageChangeListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            switch (position) {
                case 0:
                    mRadioGroup.check(R.id.radiobtn_theme_id);
                    break;
                case 1:
                    mRadioGroup.check(R.id.radiobtn_promotion_id);
                    break;
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        for (int i = 0; i < mLinearLayout.getChildCount(); i++) {
            mLinearLayout.getChildAt(i).setOnClickListener((View.OnClickListener) this);
        }
        super.onActivityCreated(savedInstanceState);
    }


    private void aboutIndicatorImageButton() {
        mImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (view.getId()) {
                    case R.id.right_menu_id:
                        showPopuDialog();
                        break;
                    default:
                        break;
                }
            }
        });
    }

    private void showPopuDialog() {
        // 思路：
        // 1、AlertDialog提示对话框Builder构建器实例的构建
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setPositiveButton("订单", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent mIntent =  new Intent(getActivity(),LoginActivity.class);
                startActivity(mIntent);
            }
        });

        // 3、显示对话框
        builder.show();

    }

    private void aboutViewPager() {
        //准备数据源
        final List<Fragment> mFragmentList = new LinkedList<>();
        for (int i = 0; i < mRadioGroup.getChildCount(); i++) {
            //往ViewPager里面加入ListFragment,每个Fragment都带有一个具有下拉刷新效果的ListView
            Fragment fragment = new ListFragment();
            Bundle bundle = new Bundle();
            //打开一个新的界面
            bundle.putString("name", i + "");
            fragment.setArguments(bundle);
            mFragmentList.add(fragment);
        }
        //准备适配器
        mAdapter = new MyFragmentAdapter(getActivity().getSupportFragmentManager());
        mViewPager.setAdapter(mAdapter);
    }

    private void initWidgets() {
        mLinearLayout = (LinearLayout) view.findViewById(R.id.ll_find_container_id);
        mRadioGroup = (RadioGroup) view.findViewById(R.id.mRadioGroup);
        mRadioButton = (RadioButton) view.findViewById(R.id.radiobtn_theme_id);
        mImageButton = (IndicatorImageButton) view.findViewById(R.id.right_menu_id);
        mViewPager = (ViewPager) view.findViewById(R.id.discovery_viewpager_id);
    }

}
