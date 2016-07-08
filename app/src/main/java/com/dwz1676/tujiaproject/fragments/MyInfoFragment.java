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
public class MyInfoFragment extends Fragment {

    private View view;
    private ImageView imageview_setting;
    private ImageView imageview_setting1;

    public MyInfoFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_info_fragment,null);
        imageview_setting = (ImageView)view.findViewById(R.id.imageview_setting);
        imageview_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), MoreActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }


}
