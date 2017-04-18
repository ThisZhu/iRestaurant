package com.zhudi.irestaurant.home.fragment;

import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListView;

import com.zhudi.irestaurant.BaseActivity;
import com.zhudi.irestaurant.BaseFragment;
import com.zhudi.irestaurant.IActivity;
import com.zhudi.irestaurant.R;
import com.zhudi.irestaurant.home.activity.DateChoose;
import com.zhudi.irestaurant.home.activity.FoodChooseActivity;
import com.zhudi.irestaurant.home.activity.HotReviewActivity;
import com.zhudi.irestaurant.home.view.mScrollView;

import java.util.ArrayList;

/**
 * Created by zhudi on 2017/4/3.
 */
public class HomeFragment extends BaseFragment implements IActivity{
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
        linearLayout_guess_you_like=inflater.inflate(R.layout.listview_guess_you_like,container,false);
        linearLayout_my_colections_from_guess=inflater.inflate(R.layout.listview_my_collections_from_guess,container,false);
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
        listView.add(linearLayout_guess_you_like);
        listView.add(linearLayout_my_colections_from_guess);
        adapter=new mAdapter(listView);
        viewpager_hot_fragment.setAdapter(adapter);
        viewpager_hot_fragment.setOffscreenPageLimit(2);
        tablayout_hot_fragment.setupWithViewPager(viewpager_hot_fragment);
        tablayout_hot_fragment1.setupWithViewPager(viewpager_hot_fragment);
        scrollView.setView(tablayout_hot_fragment1);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {
        framelayout_seat_order.setOnClickListener(onClickListener_seat);
        framelayout_food_order.setOnClickListener(onClickListener_food);
        framelayout_hot_review.setOnClickListener(onClickListener_review);
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

    class mAdapter extends PagerAdapter{
        private ArrayList<View> listView;
        private String[] title = {"猜你喜欢", "我的收藏"};
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
            Log.e("CharSequence", String.valueOf(position));
            return title[position];
        }
    }

}
