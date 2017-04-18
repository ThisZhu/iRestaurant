package com.zhudi.irestaurant.order.presenter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by zhudi on 2017/4/18.
 */
public class mPagerAdapter extends PagerAdapter {
    private ArrayList<View> listView;
    private ArrayList<String> strings;

    public mPagerAdapter(ArrayList<View> listView,ArrayList<String> strings){
        this.listView=listView;
        this.strings=strings;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(listView.get(position));
        return listView.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(listView.get(position));
    }

    @Override
    public int getCount() {
        return listView.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return strings.get(position);
    }
}
