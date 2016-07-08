package com.dwz1676.tujiaproject.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.dwz1676.tujiaproject.R;

/**
 * Created by Administrator on 2016/7/6.
 */
public class CharacteristicFragment extends Fragment implements View.OnClickListener {

    private View inflate;
    private LinearLayout mLinearLayout;
    private FrameLayout mFramLayout;
    private Fragment scrollViewFragment;

    public CharacteristicFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.character_fragment, null);
        mLinearLayout = (LinearLayout) view.findViewById(R.id.character_lltab);
        mFramLayout = (FrameLayout) view.findViewById(R.id.character_flvp_pic);
        scrollViewFragment = new ScrollViewFragment();
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
        FragmentManager fm = getActivity().getSupportFragmentManager();
        switch (v.getId()) {
            case R.id.character_tab1:
                FragmentTransaction transaction = fm.beginTransaction();
                transaction.replace(R.id.character_flvp_pic, scrollViewFragment);
                transaction.commit();
                break;
            case R.id.character_tab2:
                FragmentTransaction transaction2 = fm.beginTransaction();
                transaction2.replace(R.id.character_flvp_pic, scrollViewFragment);
                transaction2.commit();
                break;
            case R.id.character_tab3:
                FragmentTransaction transaction3 = fm.beginTransaction();
                transaction3.replace(R.id.character_flvp_pic, scrollViewFragment);
                transaction3.commit();
                break;
        }
    }
}
