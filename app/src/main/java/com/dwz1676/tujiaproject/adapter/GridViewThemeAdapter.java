package com.dwz1676.tujiaproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.dwz1676.tujiaproject.R;
import java.util.List;


public class GridViewThemeAdapter extends BaseAdapter {
        private Context context;
        private List<Integer> data;

        public GridViewThemeAdapter(Context context, List<Integer> data) {
            super();
            this.context = context;
            this.data = data;
        }

        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public Object getItem(int position) {
            return data.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            if (convertView == null) {
                convertView = LayoutInflater.from(context).inflate(
                        R.layout.gridview_theme_item, null);
                holder = new ViewHolder();
                holder.iv = (ImageView) convertView
                        .findViewById(R.id.gridview_item_theme_iv);
                convertView.setTag(holder);// 如果convertView为空就 把holder赋值进去
            } else {
                holder = (ViewHolder) convertView.getTag();// 如果convertView不为空，那么就在convertView中getTag()拿出来
            }
            Integer current = data.get(position);
            holder.iv.setImageResource(current);
            return convertView;
        }

        static class ViewHolder {
            ImageView iv;
        }
    }

