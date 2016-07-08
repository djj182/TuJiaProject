package com.dwz1676.tujiaproject.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.dwz1676.tujiaproject.R;
import com.dwz1676.tujiaproject.bean.RoomInfo;

import java.util.List;


public class MyAdapter extends BaseAdapter {
    private List<RoomInfo> mDataList;
    final int TYPE_1 = 1;
    final int TYPE_2 = 2;
    final int TYPE_3 = 3;
    LayoutInflater inflater;
    String[] imageStrings;
    private Context context;
    private Bitmap[] bitmaps;

    public MyAdapter(Context context, List<RoomInfo> dataList) {
        this.setContext(context);
        this.mDataList = dataList;
        inflater = LayoutInflater.from(context);
    }

    public void refresh(List<RoomInfo> RoomInfos) {
        this.mDataList = RoomInfos;
        notifyDataSetChanged();
    }

    public List<RoomInfo> getmDataList() {
        return mDataList;
    }

    public void setmDataList(List<RoomInfo> mDataList) {
        this.mDataList = mDataList;
    }

    @Override
    public int getItemViewType(int position) {

        RoomInfo item = (RoomInfo) getItem(position);
        if (imageStrings != null) {

            if (imageStrings.length == 1)
                return TYPE_1;
            else {
                return TYPE_1;
            }
        }
        return TYPE_1;
    }

    @Override
    public int getViewTypeCount() {
        return 3;
    }

    @Override
    public int getCount() {
        return mDataList.size();
    }

    @Override
    public Object getItem(int position) {
        return mDataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int viewType = getItemViewType(position);
        Log.i("AXC", viewType + "" + position);
        ViewHolder1 vh1 = null;
        ViewHolder2 vh2 = null;
        if (convertView == null) {
            switch (viewType) {
                case TYPE_1:
                    View view1 = inflater.inflate(R.layout.list_item, parent, false);
                    convertView = view1;
                    TextView infoTextView = (TextView) view1
                            .findViewById(R.id.list_item_tv_info);
                    TextView tagTextView = (TextView) view1
                            .findViewById(R.id.list_item_tag);
                    ImageView imageView = (ImageView) view1
                            .findViewById(R.id.list_item_iv);
                    vh1 = new ViewHolder1();
                    vh1.infoTextView = infoTextView;
                    vh1.tagTextView = tagTextView;
                    vh1.imageView = imageView;
                    convertView.setTag(vh1);
                    break;
                case TYPE_2:
                    break;

            }
        } else {
            switch (viewType) {
                case TYPE_1:
                    vh1 = (ViewHolder1) convertView.getTag();
                    break;
                case TYPE_2:
                    break;
            }

        }

        switch (viewType) {
            case TYPE_1:

                vh1.infoTextView.setText("dddddddddddddd");
                vh1.tagTextView.setText("酒店公寓");
                vh1.imageView.setImageResource(R.mipmap.ic_launcher);
                break;
            case TYPE_2:

                break;
        }
        return convertView;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    private final class ViewHolder1 {
        TextView infoTextView;
        TextView tagTextView;
        ImageView imageView;
    }

    private final class ViewHolder2 {
        TextView title;
        TextView brief;
        TextView commentnum;
        ImageView image1;
        ImageView image2;
        ImageView image3;
    }
}
