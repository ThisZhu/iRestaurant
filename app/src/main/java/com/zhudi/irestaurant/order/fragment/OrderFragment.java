package com.zhudi.irestaurant.order.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zhudi.irestaurant.IActivity;
import com.zhudi.irestaurant.R;

/**
 * Created by zhudi on 2017/4/14.
 */
public class OrderFragment extends Fragment implements IActivity {
    private TextView textvie_my_order;
    private TabLayout tablayout_order_fragment;
    private ViewPager viewpager_order_fragment;
    private static OrderFragment orderFragment;
    public static OrderFragment getInstance(){
        if(orderFragment==null){
            orderFragment=new OrderFragment();
        }
        return orderFragment;
    }

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle savedInstanceState){
        View view=layoutInflater.inflate(R.layout.fragment_order,viewGroup,false);
        return view;
    }

    @Override
    public void onViewCreated(View view,Bundle savedInstanceState){
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
    public void initView() {

    }

    public void initView(View view){
        textvie_my_order=(TextView)view.findViewById(R.id.textvie_my_order);
        tablayout_order_fragment=(TabLayout)view.findViewById(R.id.tablayout_order_fragment);
        viewpager_order_fragment=(ViewPager)view.findViewById(R.id.viewpager_order_fragment);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {
    }
}
