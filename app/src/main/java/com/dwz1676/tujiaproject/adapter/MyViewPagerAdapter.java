/**
 * 
 */
package com.dwz1676.tujiaproject.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;


public class MyViewPagerAdapter extends PagerAdapter {
	private List<View> viewList;

	public MyViewPagerAdapter(List<View> viewList) {
		super();
		this.viewList = viewList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.support.v4.view.PagerAdapter#getCount()
	 */
	@Override
	public int getCount() {

		return viewList.size();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * android.support.v4.view.PagerAdapter#isViewFromObject(android.view.View,
	 * java.lang.Object)
	 */
	@Override
	public boolean isViewFromObject(View view, Object object) {

		return view == object;
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		View view = viewList.get(position);

		container.addView(view);

		return view;
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView((View) object);
	}

}
