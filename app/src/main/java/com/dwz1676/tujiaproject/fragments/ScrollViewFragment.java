package com.dwz1676.tujiaproject.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.dwz1676.tujiaproject.R;
import com.dwz1676.tujiaproject.utils.ViewUtils;
import com.dwz1676.tujiaproject.adapter.MyAdapter;
import com.dwz1676.tujiaproject.adapter.MyViewPagerAdapter;
import com.dwz1676.tujiaproject.bean.RoomInfo;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/6.
 */
public class ScrollViewFragment extends Fragment {

    private LinearLayout mDotLayout;
    private ViewPager mViewPager;
    private ListView mListViewLeft;
    private ListView mListViewRight;
    private ImageView mVpImageView;
    private TextView mVpTitle;

    public ScrollViewFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.scrollviewfragment, null);
        intiViewPagerView(view);
        return view;
    }

    private void intiViewPagerView(View view) {
        mViewPager = (ViewPager) view.findViewById(R.id.vp_loop_pic);
        mDotLayout = (LinearLayout) view.findViewById(R.id.character_ll_dot);
        mListViewLeft = (ListView) view.findViewById(R.id.character_cardlistleft);
        mListViewRight = (ListView) view.findViewById(R.id.character_cardlistright);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        aboutViewPager1();
        aboutListVIew(mListViewLeft);
        aboutListVIew(mListViewRight);
        super.onActivityCreated(savedInstanceState);
    }

    private void aboutListVIew(ListView listView) {
        List<RoomInfo> dataList=new LinkedList<>();
        for(int i=0;i<20;i++){
            dataList.add(new RoomInfo());
        }
        ListAdapter adapterRight=new MyAdapter(getActivity().getApplicationContext(),dataList);
        listView.setAdapter(adapterRight);
        ViewUtils.setListViewHeightBasedOnChildren(listView);
    }


    private void aboutViewPager1() {
        List<View> viewList=new LinkedList<>();
        for(int i=0;i<mDotLayout.getChildCount();i++){
            viewList.add(getView());
        }
        PagerAdapter adapter = new MyViewPagerAdapter(viewList);
        mViewPager.setAdapter(adapter);
    }
    public View getView() {
        View view =View.inflate(getContext(), R.layout.vp_item, null);
        mVpImageView = (ImageView) view.findViewById(R.id.iv_item_vp);
        mVpTitle = (TextView) view.findViewById(R.id.tv_vp_title);
        mVpImageView.setImageResource(R.mipmap.ic_action_more);
        mVpTitle.setText("hunagying guanglng  ");
        return view;
    }
}
