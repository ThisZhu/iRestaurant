package com.zhudi.irestaurant;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.ViewGroup;

import com.zhudi.irestaurant.home.fragment.HomeFragment;
import com.zhudi.irestaurant.mine.fragment.MineNoSignFragment;
import com.zhudi.irestaurant.mine.fragment.MineSignedFragment;
import com.zhudi.irestaurant.order.fragment.OrderFragment;

import java.util.ArrayList;

/**
 * Created by zhudi on 2017/4/14.
 */
public class MainActivity extends BaseFragmentActivity implements IActivity,CallBack {
    private ArrayList<Fragment> arrayListFrag;
    private ViewPager viewPager;
    private mFragmentAdapter adapter;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        initListener();
    }
    @Override
    public void initView() {
        arrayListFrag=new ArrayList<>();
        arrayListFrag.add(0,HomeFragment.getInstance());
        arrayListFrag.add(1,OrderFragment.getInstance());
        arrayListFrag.add(2,MineNoSignFragment.getInstance());
        viewPager=$(R.id.viewpager);
        tabLayout=$(R.id.tablayout);
        adapter=new mFragmentAdapter(getSupportFragmentManager(),arrayListFrag);
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(3);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {
    }

    @Override
    public void changeFragment(boolean isSign) {

    }

    class mFragmentAdapter extends FragmentPagerAdapter {
        private ArrayList<Fragment> frag;
        private String[] tabtitles = {"首页", "订单", "我的"};

        public mFragmentAdapter(FragmentManager fragmentManager, ArrayList<Fragment> frag) {
            super(fragmentManager);
            this.frag = frag;
        }

        @Override
        public Fragment getItem(int position) {
            return frag.get(position);
        }

        @Override
        public int getCount() {
            return frag.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            Log.e("CharSequence", String.valueOf(position));
            return tabtitles[position];
        }

        @Override
        public void notifyDataSetChanged() {
            super.notifyDataSetChanged();
            Log.e("notifyDataSetChanged", "notifyDataSetChanged");
        }

    }
}
