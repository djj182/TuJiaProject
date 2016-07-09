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

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/6.
 */
public class CharacteristicFragment extends Fragment implements View.OnClickListener {

    private View inflate;
    private LinearLayout mLinearLayout;
    private FrameLayout mFramLayout;
    private Fragment scrollViewFragment;
    private FragmentManager fm;
    private String[] urlStr=new String[3];
    private List<Fragment> fragments;

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
        fm = getActivity().getSupportFragmentManager();
        mLinearLayout = (LinearLayout) view.findViewById(R.id.character_lltab);
        mFramLayout = (FrameLayout) view.findViewById(R.id.character_flvp_pic);
        fragments = new LinkedList<>();
        for(int i=0;i<3;i++){
            Fragment myFragment=new ScrollViewFragment();
            Bundle args=new Bundle();
            args.putString(urlStr[i],urlStr[0]);
            fragments.add(myFragment);
        }
        replaceContainerView(fragments.get(0));
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
        switch (v.getId()) {
            case R.id.character_tab1:
                replaceContainerView(fragments.get(0));
                break;
            case R.id.character_tab2:
                replaceContainerView(fragments.get(1));
                break;
            case R.id.character_tab3:
                replaceContainerView(fragments.get(2));
                break;
        }
    }

    /**
     * @param fragment
     */
    private void replaceContainerView(Fragment fragment) {

        FragmentTransaction transaction3 = fm.beginTransaction();
        transaction3.replace(R.id.character_flvp_pic, fragment);
        transaction3.commit();
    }
}
