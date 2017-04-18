package com.zhudi.irestaurant.order.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.zhudi.irestaurant.BaseFragment;
import com.zhudi.irestaurant.IActivity;
import com.zhudi.irestaurant.R;
import com.zhudi.irestaurant.order.presenter.HistoryOrderItemPresenter;
import com.zhudi.irestaurant.order.presenter.mListViewAdapter;
import com.zhudi.irestaurant.order.presenter.mPagerAdapter;

import java.util.ArrayList;

/**
 * Created by zhudi on 2017/4/14.
 */
public class OrderFragment extends BaseFragment implements IActivity {
    public TabLayout tablayout_order_fragment;
    public ViewPager viewpager_order_fragment;
    private static OrderFragment orderFragment;
    public ArrayList<View> pagerView;
    public ArrayList<View> listView;
    private ArrayList<String> strings;
    public View view_order_now;
    public View view_order_history;
    public PagerAdapter adapter;
    public BaseAdapter baseAdapter;
    public View item_order_history;
    public ListView listview_order_history;

    public static OrderFragment getInstance(){
        if(orderFragment==null){
            orderFragment=new OrderFragment();
        }
        return orderFragment;
    }

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle savedInstanceState){
        View view=layoutInflater.inflate(R.layout.fragment_order,viewGroup,false);
        view_order_now=layoutInflater.inflate(R.layout.view_order_now,viewGroup,false);
        view_order_history=layoutInflater.inflate(R.layout.gridview_order_history,viewGroup,false);
        item_order_history=layoutInflater.inflate(R.layout.item_order_history,viewGroup,false);
        return view;
    }

    @Override
    public void onViewCreated(View view,Bundle savedInstanceState){
        Log.e("Order","onCreateView");
        super.onViewCreated(view,savedInstanceState);
        initView(view);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    /**
     * 当fragment对用户可见时调用，
     * 即此时才能处理点击按钮时间，此时view才能获取焦点
     */
    @Override
    public void onStart(){
        super.onStart();
        initListener();
    }


    @Override
    public  void onDestroyView() {
        super.onDestroyView();
        Log.e("Order","destroy");
    }

    @Override
    public void initView() {

    }

    public void initView(View view){
        tablayout_order_fragment=(TabLayout)view.findViewById(R.id.tablayout_order_fragment);
        viewpager_order_fragment=(ViewPager)view.findViewById(R.id.viewpager_order_fragment);

        pagerView=new ArrayList<>();
        strings=new ArrayList<>();
        pagerView.add(view_order_now);
        pagerView.add(view_order_history);
        strings.add("当前");
        strings.add("历史");
        adapter=new mPagerAdapter(pagerView,strings);
        viewpager_order_fragment.setAdapter(adapter);
        tablayout_order_fragment.setupWithViewPager(viewpager_order_fragment);
        viewpager_order_fragment.setOffscreenPageLimit(2);

        listView=new ArrayList<>();
        listview_order_history=(ListView)view_order_history.findViewById(R.id.listview_order_history);
        baseAdapter=new mListViewAdapter(listView);
        listview_order_history.setAdapter(baseAdapter);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {
    }

    /*class mAdapter extends PagerAdapter {
        private ArrayList<View> listView;
        private String[] title = {"当前", "历史"};
        private View linealayout;

        public mAdapter(ArrayList<View> listView){
            this.listView=listView;
        }

        public View getItem(int position) {
            return listView.get(position);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            linealayout=getItem(position);
            container.addView(linealayout);
            return linealayout;
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
            return title[position];
        }
    }*/


}
