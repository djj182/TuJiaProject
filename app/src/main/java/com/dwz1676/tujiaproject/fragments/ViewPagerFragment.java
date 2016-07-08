package com.dwz1676.tujiaproject.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dwz1676.tujiaproject.R;

/**
 * Created by Administrator on 2016/7/8.
 */
public class ViewPagerFragment extends Fragment {

    private ImageView mImageView;
    private TextView mVpTitle;
    private View view;

    public ViewPagerFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.vp_item, null);
        mImageView = (ImageView) view.findViewById(R.id.iv_item_vp);
        mVpTitle = (TextView) view.findViewById(R.id.tv_vp_title);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mImageView.setImageResource(R.mipmap.ic_launcher);
        mVpTitle.setText("hunagying guangling sanya ");
    }
}
