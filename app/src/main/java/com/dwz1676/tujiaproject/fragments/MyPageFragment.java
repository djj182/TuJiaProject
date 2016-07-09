package com.dwz1676.tujiaproject.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.dwz1676.tujiaproject.R;
import com.dwz1676.tujiaproject.activities.MoreActivity;

/**
 * Created by Administrator on 2016/7/6.
 */
public class MyPageFragment extends Fragment implements View.OnClickListener {

    private View view;
    private ImageView imageview_setting;
    private ImageView imageview_setting1;
    private String url;
    public MyPageFragment() {
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mypagefragment, null);
        View setImageView = view.findViewById(R.id.mypage_head_setting);
        View newsImageView = view.findViewById(R.id.mypage_head_news);
        setImageView.setOnClickListener(this);
        newsImageView.setOnClickListener(this);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.mypage_head_setting:
                switchToMoreActivity ();
                break;
            case R.id.mypage_head_news:
                switchTewsActivity ();
                break;
            default:break;
        }
    }

    private void switchTewsActivity() {
        startActivity(new Intent(getActivity(), MoreActivity.class));
    }

    private void switchToMoreActivity() {
    }
}
