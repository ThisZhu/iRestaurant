package com.zhudi.irestaurant.home.fragment;

import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.zhudi.irestaurant.CallBack;
import com.zhudi.irestaurant.IActivity;
import com.zhudi.irestaurant.R;
import com.zhudi.irestaurant.home.activity.DateChoose;

/**
 * Created by zhudi on 2017/4/3.
 */
public class HomeFragment extends Fragment implements IActivity{
    private static HomeFragment fragment;
    private FrameLayout framelayout_seat_order;
    private FrameLayout framelayout_food_order;
    private FrameLayout framelayout_hot_review;
    private FrameLayout foryou1;
    private FrameLayout foryou2;
    private FrameLayout foryou3;
    private FrameLayout foryou4;
    private FrameLayout foryou5;
    private FrameLayout framelayout_discount;
    private FrameLayout framelayout_about_restaurant;
    private TabLayout tablayout_hot_fragment;
    private ViewPager viewpager_hot_fragment;

    public static HomeFragment getInstance(){
        if(fragment==null){
            fragment=new HomeFragment();
        }
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        Log.e("Home","onCreateView");
        View view=inflater.inflate(R.layout.fragment_home,container,false);
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
    public void onStart() {
        super.onStart();
        initListener();
    }


    @Override
    public  void onDestroyView() {
        super.onDestroyView();
        Log.e("Home","destroy");
    }

    @Override
    public void initView() {
    }

    public void initView(View view){
        framelayout_seat_order=(FrameLayout) view.findViewById(R.id.framelayout_seat_order);
        framelayout_food_order=(FrameLayout) view.findViewById(R.id.framelayout_food_order);
        framelayout_hot_review=(FrameLayout) view.findViewById(R.id.framelayout_hot_review);
        foryou1=(FrameLayout) view.findViewById(R.id.foryou1);
        foryou2=(FrameLayout) view.findViewById(R.id.foryou2);
        foryou3=(FrameLayout) view.findViewById(R.id.foryou3);
        foryou4=(FrameLayout) view.findViewById(R.id.foryou4);
        foryou5=(FrameLayout) view.findViewById(R.id.foryou5);
        framelayout_discount=(FrameLayout) view.findViewById(R.id.framelayout_discount);
        framelayout_about_restaurant=(FrameLayout) view.findViewById(R.id.framelayout_about_restaurant);
        tablayout_hot_fragment=(TabLayout) view.findViewById(R.id.tablayout_hot_fragment);
        viewpager_hot_fragment=(ViewPager) view.findViewById(R.id.viewpager_hot_fragment);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {
        framelayout_seat_order.setOnClickListener(onClickListener_seat);
    }

    View.OnClickListener onClickListener_seat=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent=new Intent();
            intent.setClass(getActivity(), DateChoose.class);
            getActivity().startActivity(intent);
            getActivity().overridePendingTransition(R.anim.start_to_left,R.anim.exit_no_change);
        }
    };

}
