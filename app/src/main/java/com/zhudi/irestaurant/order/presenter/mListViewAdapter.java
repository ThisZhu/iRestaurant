package com.zhudi.irestaurant.order.presenter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by zhudi on 2017/4/18.
 */
public class mListViewAdapter extends BaseAdapter {
    private ArrayList<View> listview;

    public mListViewAdapter(ArrayList<View> listview){
        this.listview=listview;
    }

    @Override
    public int getCount() {
        return listview.size();
    }

    @Override
    public Object getItem(int i) {
        return listview.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view=listview.get(i);
        viewGroup.addView(view);
        return view;
    }
}
