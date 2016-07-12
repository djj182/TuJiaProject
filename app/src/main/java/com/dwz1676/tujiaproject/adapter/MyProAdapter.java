package com.dwz1676.tujiaproject.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dwz1676.tujiaproject.R;
import com.dwz1676.tujiaproject.bean.City;

import java.util.List;


public class MyProAdapter extends RecyclerView.Adapter<MyProAdapter.ViewHolder> {

    private List<City> cities;

    private Context mContext;
   ;

    public MyProAdapter(Context context, List<City> cities) {
        this.mContext = context;
        this.cities = cities;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        // 给ViewHolder设置布局文件
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.promotion_fragment_cardview, viewGroup, false);
        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(MyProAdapter.ViewHolder viewHolder, int i) {
        // 给ViewHolder设置元素
        City city = cities.get(i);
        viewHolder.mTextView.setText(city.getCityResourceId(mContext));
    }

    @Override
    public int getItemCount() {
        // 返回数据总数
        return cities == null ? 0 : cities.size();
    }

    // 重写的自定义ViewHolder
    public static class ViewHolder
            extends RecyclerView.ViewHolder {
        public TextView mTextView;

        public ImageView mImageView;

        public ViewHolder(View v) {
            super(v);
            mTextView = (TextView) v.findViewById(R.id.name);
            mImageView = (ImageView) v.findViewById(R.id.pic);
        }
    }
}

