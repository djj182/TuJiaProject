package com.dwz1676.tujiaproject.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dwz1676.tujiaproject.R;

/**
 * Created by Administrator on 2016/7/6.
 */
public class ScrollViewFragment extends Fragment {

    private ImageView mImageView;
    private LinearLayout mDotLayout;
    private TextView mTextView;

    public ScrollViewFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View  view = inflater.inflate(R.layout.character_fragment2,null);
        intiViewPagerView(view);
        return view;
    }

    private void intiViewPagerView(View view) {
        view.findViewById(R.id.vp_loop_pic);
        mImageView = (ImageView) view.findViewById(R.id.iv_item_vp);
        mTextView = (TextView) view.findViewById(R.id.tv_vp_title);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }


}
