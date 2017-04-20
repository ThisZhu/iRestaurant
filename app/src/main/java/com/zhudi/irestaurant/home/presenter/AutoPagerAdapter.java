package com.zhudi.irestaurant.home.presenter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by zhudi on 2017/4/20.
 */
public class AutoPagerAdapter extends PagerAdapter {
    private ArrayList<View> listView;

    public AutoPagerAdapter(ArrayList<View> listView){
        this.listView=listView;
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
}
