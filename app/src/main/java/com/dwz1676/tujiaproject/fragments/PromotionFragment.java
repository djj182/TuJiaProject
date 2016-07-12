package com.dwz1676.tujiaproject.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.dwz1676.tujiaproject.R;
import com.dwz1676.tujiaproject.adapter.MyProAdapter;
import com.dwz1676.tujiaproject.bean.City;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/6.
 */

public class PromotionFragment extends Fragment implements View.OnClickListener {

    private List<City> cities = new ArrayList<City>();
    private RecyclerView mRecyclerView;
    private MyProAdapter mProAdapter;
    private FragmentManager fm;
    private LinearLayout mLinearLayout;
    private FrameLayout mFramLayout;

    public PromotionFragment() {
    }

    @Override
    public void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        cities.add(new City("id", "title","url"));
        // 拿到RecyclerView
        mRecyclerView = (RecyclerView) mRecyclerView.findViewById(R.id.list);
        // 设置LinearLayoutManager
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        // 设置ItemAnimator
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        // 设置固定大小
        mRecyclerView.setHasFixedSize(true);
        // 初始化自定义的适配器
        mProAdapter = new MyProAdapter(getContext(), cities);
        // 为mRecyclerView设置适配器
        mRecyclerView.setAdapter(mProAdapter);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.character_fragment, null);
        fm = getActivity().getSupportFragmentManager();
        mLinearLayout = (LinearLayout) view.findViewById(R.id.character_lltab);
        mFramLayout = (FrameLayout) view.findViewById(R.id.character_flvp_pic);

        return view;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        for (int i = 0; i < mLinearLayout.getChildCount(); i++) {
            mLinearLayout.getChildAt(i).setOnClickListener(this);
        }
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onClick(View v) {

    }
}
