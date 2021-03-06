package com.dwz1676.tujiaproject.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.dwz1676.tujiaproject.R;
import com.dwz1676.tujiaproject.activities.CharacterDetailActivity;
import com.dwz1676.tujiaproject.adapter.MyAdapter;
import com.dwz1676.tujiaproject.adapter.MyViewPagerAdapter;
import com.dwz1676.tujiaproject.bean.HotUnitsBean;
import com.dwz1676.tujiaproject.bean.UnitBean;
import com.dwz1676.tujiaproject.utils.ParseJaonDta;
import com.dwz1676.tujiaproject.utils.ViewUtils;
import com.lidroid.xutils.BitmapUtils;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/6.
 */
public class ScrollViewFragment extends Fragment {

    private RadioGroup mDotLayout;
    private ViewPager mViewPager;
    private ListView mListViewLeft;
    private ListView mListViewRight;
    private ImageView mVpImageView;
    private TextView mVpTitle;
    private List<View> viewList;
    private MyViewPagerAdapter mAdapter;
    private List viewpagers;
    private ListAdapter adapter;

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

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        aboutViewPager();
        aboutMenu();
        aboutListVIew(mListViewLeft);
        aboutListVIew(mListViewRight);
        super.onActivityCreated(savedInstanceState);
    }

    /**
     * 用途：初始化界面实例
     */
    private void intiViewPagerView(View view) {
        mViewPager = (ViewPager) view.findViewById(R.id.vp_loop_pic);
        mDotLayout = (RadioGroup) view.findViewById(R.id.character_ll_dot);
        mListViewLeft = (ListView) view.findViewById(R.id.character_cardlistleft);
        mListViewRight = (ListView) view.findViewById(R.id.character_cardlistright);
    }


    private void aboutListVIew(ListView listView) {
        List<UnitBean> dataListAll = ParseJaonDta.getCharacterData("listview");
        List<UnitBean> dataList = new LinkedList<>();
        for (int i = 0; i < dataListAll.size(); i++) {
            if (listView.getId()==R.id.character_cardlistleft&& (i % 2 == 0))
                dataList.add( dataListAll.get(i));
            else if (listView.getId()==R.id.character_cardlistright && i % 2 != 0) {
                dataList.add(dataListAll.get(i));
            }
        }
        adapter = new MyAdapter(getActivity().getApplicationContext(), dataList);
        listView.setAdapter(adapter);
        ViewUtils.setListViewHeightBasedOnChildren(listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Serializable item = (UnitBean) adapter.getItem(position);
                switchCharacterDetailActivity(item);
            }
        });
    }

    private void switchCharacterDetailActivity(Serializable item) {

        Intent intent = new Intent(getActivity(), CharacterDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("itemfeature", item);
        intent.putExtra("itemfeature", bundle);
        startActivity(intent);
    }

    /**
     * 用途：关于ViewPager的操作
     */
    private void aboutViewPager() {
        viewpagers = ParseJaonDta.getCharacterData("viewpager");
        viewList = new LinkedList<>();
        for (int i = 0; i < viewpagers.size(); i++) {
            viewList.add(getView(i));
        }
        PagerAdapter adapter = new MyViewPagerAdapter(viewList);
        mViewPager.requestDisallowInterceptTouchEvent(true);
        mViewPager.setAdapter(adapter);
        //
        mAdapter = new MyViewPagerAdapter(viewList);
        mViewPager.setAdapter(mAdapter);
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < viewpagers.size(); i++) {
                    ((RadioButton) mDotLayout.getChildAt(i)).setChecked(false);
                }
                ((RadioButton) mDotLayout.getChildAt(position)).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    public View getView(int i) {
        final View view = View.inflate(getContext(), R.layout.vp_item, null);
        ImageView mVpImageView = (ImageView) view.findViewById(R.id.iv_item_vp);
        TextView mVpTitle = (TextView) view.findViewById(R.id.tv_vp_title);
        HotUnitsBean hotUnitsBean = (HotUnitsBean) viewpagers.get(i);
        BitmapUtils bitmapUtils = new BitmapUtils(getActivity());
        bitmapUtils.display(mVpImageView, hotUnitsBean.getDefaultPicture());
        mVpTitle.setText(hotUnitsBean.getUnitName());
        mVpImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int itemId = mViewPager.getCurrentItem();
                Serializable item = (UnitBean) adapter.getItem(itemId);
                switchCharacterDetailActivity(item);
            }
        });
        return view;
    }

    /**
     * 用途：添加菜单
     */

    private void aboutMenu() {
        addChildToRadioGroup();
        mDotLayout.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                for (int i = 0; i < viewpagers.size(); i++) {
                    if (mDotLayout.getChildAt(i).getId() == checkedId)
                        mViewPager.setCurrentItem(i);
                }
            }
        });
    }

    private void addChildToRadioGroup() {
        for (int i = 0; i < viewpagers.size(); i++) {
            RadioButton child = new RadioButton(getActivity());
            child.setButtonDrawable(android.R.color.transparent);
            child.setBackgroundResource(R.drawable.dot_selector);
            mDotLayout.addView(child);// 空指针
            if (i == 0)
                child.setChecked(true);
        }
    }
}
