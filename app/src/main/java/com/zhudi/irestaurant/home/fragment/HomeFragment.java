package com.zhudi.irestaurant.home.fragment;

import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;

import com.zhudi.irestaurant.BaseFragment;
import com.zhudi.irestaurant.IActivity;
import com.zhudi.irestaurant.R;
import com.zhudi.irestaurant.home.activity.DateChoose;
import com.zhudi.irestaurant.home.activity.FoodChooseActivity;
import com.zhudi.irestaurant.home.activity.HotReviewActivity;
import com.zhudi.irestaurant.home.presenter.AutoPagerAdapter;
import com.zhudi.irestaurant.home.view.mScrollView;
import com.zhudi.irestaurant.net.NetCallBack;
import com.zhudi.irestaurant.order.presenter.mPagerAdapter;

import java.util.ArrayList;

/**
 * Created by zhudi on 2017/4/3.
 */
public class HomeFragment extends BaseFragment implements IActivity,NetCallBack{
    Intent intent=new Intent();
    private static HomeFragment fragment;
    public FrameLayout framelayout_seat_order;
    public FrameLayout framelayout_food_order;
    public FrameLayout framelayout_hot_review;
    public FrameLayout foryou1;
    public FrameLayout foryou2;
    public FrameLayout foryou3;
    public FrameLayout foryou4;
    public FrameLayout foryou5;
    public FrameLayout framelayout_discount;
    public FrameLayout framelayout_about_restaurant;
    public TabLayout tablayout_hot_fragment;
    public TabLayout tablayout_hot_fragment1;
    public ViewPager viewpager_hot_fragment;
    public mScrollView scrollView;
    private PagerAdapter adapter;
    private ListView listview_guess_you_like;
    private ListView listview_my_colections_from_guess;
    private View linearLayout_guess_you_like;
    private View linearLayout_my_colections_from_guess;
    private ArrayList<View> listView;
    private ArrayList<String> strings;

    public ViewPager viewpager_home;
    public View view_home_page_1,view_home_page_2,view_home_page_3;
    public ImageView icon_1,icon_2,icon_3;
    private ArrayList<View> mView;
    private PagerAdapter home_adapter;
    private int flag;
    private boolean thread_flag;

    public static HomeFragment getInstance(){
        if(fragment==null){
            fragment=new HomeFragment();
        }
        return fragment;
    }

    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg){
           changeIcon(msg.what);
        }

    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        Log.e("Home","onCreateView");
        View view=inflater.inflate(R.layout.fragment_home,container,false);
        linearLayout_guess_you_like=inflater.inflate(R.layout.listview_guess_you_like,container,false);
        linearLayout_my_colections_from_guess=inflater.inflate(R.layout.listview_my_collections_from_guess,container,false);
        view_home_page_1=inflater.inflate(R.layout.view_home_page_1,container,false);
        view_home_page_2=inflater.inflate(R.layout.view_home_page_2,container,false);
        view_home_page_3=inflater.inflate(R.layout.view_home_page_3,container,false);
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
        thread_flag=false;
    }

    @Override
    public void initView() {
    }

    public void initView(View view){
        scrollView=(mScrollView)view.findViewById(R.id.sc);
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
        tablayout_hot_fragment1=(TabLayout) view.findViewById(R.id.tablayout_hot_fragment1);
        viewpager_hot_fragment=(ViewPager) view.findViewById(R.id.viewpager_hot_fragment);
        listView=new ArrayList<>();
        strings=new ArrayList<>();
        strings.add("猜你喜欢");
        strings.add("我的收藏");
        listView.add(linearLayout_guess_you_like);
        listView.add(linearLayout_my_colections_from_guess);
        adapter=new mPagerAdapter(listView,strings);
        viewpager_hot_fragment.setAdapter(adapter);
        viewpager_hot_fragment.setOffscreenPageLimit(2);
        tablayout_hot_fragment.setupWithViewPager(viewpager_hot_fragment);
        tablayout_hot_fragment1.setupWithViewPager(viewpager_hot_fragment);
        scrollView.setView(tablayout_hot_fragment1);

        viewpager_home=(ViewPager)view.findViewById(R.id.viewpager_home);
        icon_1=(ImageView)view.findViewById(R.id.icon_1);
        icon_2=(ImageView)view.findViewById(R.id.icon_2);
        icon_3=(ImageView)view.findViewById(R.id.icon_3);
        mView=new ArrayList<>();
        mView.add(view_home_page_1);
        mView.add(view_home_page_2);
        mView.add(view_home_page_3);
        home_adapter=new AutoPagerAdapter(mView);
        viewpager_home.setAdapter(home_adapter);
        viewpager_home.setOffscreenPageLimit(3);
    }

    @Override
    public void initData() {
        flag=0;
        thread_flag=true;
    }

    @Override
    public void initListener() {
        framelayout_seat_order.setOnClickListener(onClickListener_seat);
        framelayout_food_order.setOnClickListener(onClickListener_food);
        framelayout_hot_review.setOnClickListener(onClickListener_review);
        viewpager_home.addOnPageChangeListener(onPageChangeListener);
        if(!threadAudoPagerView.isAlive())
            threadAudoPagerView.start();
    }

    View.OnClickListener onClickListener_seat=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            goToOtherActivity(intent,getActivity(),DateChoose.class,-1);
        }
    };

    View.OnClickListener onClickListener_food=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            goToOtherActivity(intent,getActivity(),FoodChooseActivity.class,-1);
        }
    };

    View.OnClickListener onClickListener_review=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            goToOtherActivity(intent,getActivity(),HotReviewActivity.class,-1);
        }
    };

    ViewPager.OnPageChangeListener onPageChangeListener=new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            flag=position;
            senMessageToHandler(flag);
        }

        @Override
        public void onPageScrollStateChanged(int state) {
        }
    };

    @Override
    public void changeView() {
    }

    Thread threadAudoPagerView=new Thread(new Runnable() {
        @Override
        public void run() {
            while (thread_flag) {
                try {
                    Thread.sleep(2000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                setCurrentPagerView(flag);
                if(flag>=2)
                    flag=-1;
                ++flag;
            }
        }
    });

    public void setCurrentPagerView(int flag){
        if(flag==0) {
            viewpager_home.setCurrentItem(flag, false);
        }
        else {
            viewpager_home.setCurrentItem(flag, true);
        }
    }

    public void senMessageToHandler(int flag){
        Message message=new Message();
        message.what=flag;
        handler.sendMessage(message);
    }

    public void changeIcon(int i){
        icon_3.setImageResource(R.drawable.shape_corner_circular_white);
        icon_2.setImageResource(R.drawable.shape_corner_circular_white);
        icon_1.setImageResource(R.drawable.shape_corner_circular_white);
        switch (i){
            case 0:
                icon_1.setImageResource(R.drawable.shape_corner_circular_orangered);
                break;
            case 1:
                icon_2.setImageResource(R.drawable.shape_corner_circular_orangered);
                break;
            case 2:
                icon_3.setImageResource(R.drawable.shape_corner_circular_orangered);
                break;
            default:
                break;
        }
    }
}
