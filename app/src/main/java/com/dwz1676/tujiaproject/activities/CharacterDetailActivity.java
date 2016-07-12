package com.dwz1676.tujiaproject.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.DragEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.dwz1676.tujiaproject.R;
import com.dwz1676.tujiaproject.adapter.MyViewPagerAdapter;
import com.dwz1676.tujiaproject.bean.UnitBean;
import com.lidroid.xutils.BitmapUtils;

import java.io.Serializable;
import java.util.LinkedList;

/**
 * Created by Administrator on 2016/7/6.
 */
public class CharacterDetailActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private CollapsingToolbarLayout collapsingToolbar;
    private TextView testTextView;
    private ViewPager mViewPager;
    private LinkedList<View> imageViews;
    private MyViewPagerAdapter myAdapter;
    private Serializable itemfeature;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initView();
        getDataFromLastPage(this);
        aboutViewPager();
    }

    private void aboutViewPager() {
        imageViews = new LinkedList<>();
        mViewPager = (ViewPager) findViewById(R.id.vp_content_img_id);
        UnitBean unitsBean=(UnitBean) itemfeature;
        for(int i=0;i<unitsBean.getPictures().size();i++){
            ImageView img=new ImageView(this);
            img.setAdjustViewBounds(true);
            img.setScaleType(ImageView.ScaleType.FIT_CENTER);
            BitmapUtils bitmapUtils = new BitmapUtils(this);
            bitmapUtils.display(img, unitsBean.getPictures().get(i));
            imageViews.add(img);
        }
        myAdapter = new MyViewPagerAdapter(imageViews);

        mViewPager.setAdapter(myAdapter);
    }
    public void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        testTextView =(TextView) findViewById(R.id.tv_test);
        collapsingToolbar.setTitle("途家");
        collapsingToolbar.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                v.setFitsSystemWindows(true);
                return true;
            }
        });
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void getDataFromLastPage(AppCompatActivity activity){
        Intent intent = activity.getIntent();
        Bundle extra = intent.getBundleExtra("itemfeature");
        itemfeature= (Serializable) extra.get("itemfeature");
    }
}
