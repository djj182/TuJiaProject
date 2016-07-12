package com.dwz1676.tujiaproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.util.LruCache;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost.TabSpec;
import android.widget.Toast;

import com.dwz1676.tujiaproject.activities.LoginActivity;
import com.dwz1676.tujiaproject.fragments.AdFragment;
import com.dwz1676.tujiaproject.fragments.CharacteristicFragment;
import com.dwz1676.tujiaproject.fragments.FindFragment;
import com.dwz1676.tujiaproject.fragments.MyPageFragment;
import com.dwz1676.tujiaproject.utils.ParseJaonDta;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
// f5354121f8753537a1d5d005;jpush   appkey
    private FragmentTabHost tabHost;
    private int[] imageSelectorIds;
    private String[] menutabNames;
    private boolean loginState;
    private LruCache<String, Bitmap> mMemoryCache;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 界面控件实例的初始化
        // 获取到可用内存的最大值，使用内存超出这个值会引起OutOfMemory异常。
        // LruCache通过构造函数传入缓存值，以KB为单位。
        int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
        // 使用最大可用内存值的1/8作为缓存的大小。
        int cacheSize = maxMemory / 8;
        mMemoryCache = new LruCache<String, Bitmap>(cacheSize) {
            @SuppressLint("NewApi")
            @Override
            protected int sizeOf(String key, Bitmap bitmap) {
                // 重写此方法来衡量每张图片的大小，默认返回图片数量。
                return bitmap.getByteCount() / 1024;
            }
        };
        initWidegts();
        List title = ParseJaonDta.getCharacterData("title");
//        Toast.makeText(this,title.toString(),Toast.LENGTH_LONG).show();
        aboutFragmentTabHost();
    }

    public void addBitmapToMemoryCache(String key, Bitmap bitmap) {
        if (getBitmapFromMemCache(key) == null) {
            mMemoryCache.put(key, bitmap);
        }
    }

    public Bitmap getBitmapFromMemCache(String key) {
        return (Bitmap) mMemoryCache.get(key);
    }

    private void initWidegts() {
        tabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        imageSelectorIds = new int[]{R.drawable.homepage_selector,
                R.drawable.characteristic_selector, R.drawable.recommend_selector, R.drawable.find_selector,
                R.drawable.mypage_selector};
    }

    private void aboutFragmentTabHost() {
        List<Fragment> fragments = new LinkedList<>();
        Collections.addAll(fragments, new CharacteristicFragment(),
                new CharacteristicFragment(), new AdFragment(), new FindFragment(), new MyPageFragment());
        menutabNames = getResources().getStringArray(R.array.menutabNames);
        tabHost.setup(this, getSupportFragmentManager(), R.id.fl_container);
        for (int i = 0; i < menutabNames.length; i++) {

            TabSpec tabSpec = tabHost.newTabSpec(menutabNames[i]);
            tabSpec.setIndicator(getView(i, menutabNames[i]));
            tabHost.addTab(tabSpec, fragments.get(i).getClass(), null);
            tabHost.getTabWidget().getChildAt(i);
        }
    }

    private View getView(int i, String tabName) {
        View view = View.inflate(this, R.layout.menutab, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_menutab);
        imageView.setBackgroundResource(imageSelectorIds[i]);
        return view;
    }

    public void clickSettingButton(View view) {
        //        loginState=false 未登录
        int resId = view.getId();
        //点击之后跳转界面，最下面的三个按键
        if (resId == R.id.mypage_lend_room || resId == R.id.mypage_invite_friend_fanli || resId == R.id.mypage_tulifang) {
            Toast.makeText(this, "您点击了【我要出租房屋】", Toast.LENGTH_SHORT).show();
            Log.i("CLG","您点击了【我要出租房屋】");
        } else if (!loginState) {
            if (resId == R.id.mypage_unpaid || resId == R.id.mypage_wait_comment || resId == R.id.mypage_wait_check_in) {
                switchToLoginActivity(0);
            } else switchToLoginActivity(1);
        }
//
    }

    private void switchToLoginActivity(int thirdFlag) {
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        intent.putExtra("thirdFlag", thirdFlag);
        startActivity(intent);
    }
}
