package com.dwz1676.tujiaproject.activities;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.dwz1676.tujiaproject.MainActivity;
import com.dwz1676.tujiaproject.R;
import com.dwz1676.tujiaproject.adapter.MyViewPagerAdapter;
import com.dwz1676.tujiaproject.common.CommonData;

import java.io.File;
import java.util.LinkedList;

/**
 * Created by Administrator on 2016/7/6.
 */
public class SplashActivity extends AppCompatActivity {
    private boolean firstLaunch;
    private int imageResId[] = new int[]{R.mipmap.guide_1, R.mipmap.guide_2, R.mipmap.guide_3};
    private LinkedList<View> viewList;
    private RadioGroup rg_dot_id;
    private ViewPager vp_wlecome;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createCatchFile(new File(CommonData.PICCACHE_DIR));
        createCatchFile(new File(CommonData.JSONCACHE_DIR));
        sharedPreferences = getSharedPreferences("tujia", MODE_PRIVATE);
        // 根据应用的使用情况，拦截界面
        boolean isUsed = sharedPreferences.getBoolean("isUsed", false);
        //判断是否为第一次启动，是，欢迎界面，否则，启动界面
        if (isUsed) {
            // ①若使用过，直接跳转到主界面
            setContentView(R.layout.activity_splash);
            //启动界面3秒后转至主界面
            switchToMainActivity();
        } else {
            // ②否则，继续当前的欢迎界面（第一次使用）
            setContentView(R.layout.activity_welcome);

            // 思路：
            // 1、找到关心的控件实例（ViewPager）
            initView();
            // 关于小圆点
//            aboutDots();
            // 关于ViewPager的操作
            aboutViewPager();
            // 将用户的使用信息，存储起来
            saveUseInfoToFile();

        }

    }

    private void initView() {
        vp_wlecome = (ViewPager) findViewById(R.id.vp_wlecome);
        rg_dot_id = (RadioGroup) findViewById(R.id.rg_dot_id);
    }

    private void switchToMainActivity() {
        new Thread() {
            @Override
            public void run() {
                SystemClock.sleep(1000);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        SplashActivity.this.startActivity(new Intent(
                                getApplicationContext(), MainActivity.class));
                        SplashActivity.this.finish();
                    }
                });
            }
        }.start();
    }

    /**
     * 将app应用的使用情况通过文件存储起来
     */
    private void saveUseInfoToFile() {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putBoolean("isUsed", true);
        edit.commit();
    }

    /**
     * 用途：关于ViewPager的操作
     */
    private void aboutViewPager() {
        // 2、准备数据源
        viewList = new LinkedList<>();
        for (int imageId : imageResId) {
            // 构建ImageView的对象
            ImageView iv = new ImageView(getApplicationContext());
            iv.setImageResource(imageId);
            // 将对象添加到数据源中
            viewList.add(iv);

        }
        // 将第三张图片对应的布局文件，添加到数据源中
        View lastPage = View.inflate(this, R.layout.last_page, null);
        View iv_tiyan_id = lastPage.findViewById(R.id.iv_tiyan_id);
//         给该控件添加监听器
        iv_tiyan_id.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // 点击后，跳转到主界面
                switchToMainActivity();
            }
        });

        viewList.add(lastPage);
        MyViewPagerAdapter mAdapter = new MyViewPagerAdapter(viewList);
        vp_wlecome.setAdapter(mAdapter);
//        vp_wlecome.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//
//            @Override
//            public void onPageSelected(int arg0) {
//                for (int i = 0; i < rg_dot_id.getChildCount(); i++) {
//                    ((RadioButton) rg_dot_id.getChildAt(i)).setChecked(false);
//                }
//                ((RadioButton) rg_dot_id.getChildAt(arg0)).setChecked(true);
//            }
//
//            @Override
//            public void onPageScrolled(int arg0, float arg1, int arg2) {
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int arg0) {
//            }
//        });
    }

    /**
     * 用途：添加菜单
     */
    private void aboutDots() {
        addChildToRadioGroup();
        rg_dot_id.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                for (int i = 0; i < imageResId.length; i++) {
                    if (rg_dot_id.getChildAt(i).getId() == checkedId)
                        vp_wlecome.setCurrentItem(i);
                }
            }
        });
    }

    private void addChildToRadioGroup() {
        rg_dot_id = (RadioGroup) findViewById(R.id.rg_dot_id);
        for (int i = 0; i < imageResId.length + 1; i++) {
            RadioButton child = new RadioButton(this);
            child.setGravity(Gravity.DISPLAY_CLIP_VERTICAL);
            child.setButtonDrawable(android.R.color.transparent);
            child.setBackgroundResource(R.drawable.dot_selector);
            rg_dot_id.addView(child);// 空指针
            if (i == 0)
                child.setChecked(true);
        }
    }

   private void  createCatchFile(File file){
       if(file.exists())
           return;
       if(!file.isDirectory()){
           file.mkdirs();
       }

    }

}