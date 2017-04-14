package com.zhudi.irestaurant;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.zhudi.irestaurant.home.fragment.HomeFragment;
import com.zhudi.irestaurant.mine.fragment.MineNoSignFragment;
import com.zhudi.irestaurant.order.fragment.OrderFragment;

import java.util.ArrayList;

/**
 * Created by zhudi on 2017/4/14.
 */
public class MainActivity extends BaseFragmentActivity implements IActivity {
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
        arrayListFrag.add(HomeFragment.getInstance());
        arrayListFrag.add(OrderFragment.getInstance());
        arrayListFrag.add(MineNoSignFragment.getInstance());
        viewPager=$(R.id.viewpager);
        tabLayout=$(R.id.tablayout);
        adapter=new mFragmentAdapter(getSupportFragmentManager(),arrayListFrag);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {
    }

    class mFragmentAdapter extends FragmentPagerAdapter{
        private ArrayList<Fragment> frag;
        private String[] tabtitles={"首页","订单","我的"};

        public mFragmentAdapter(FragmentManager fragmentManager,ArrayList<Fragment> frag){
            super(fragmentManager);
            this.frag=frag;
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
        public CharSequence getPageTitle(int position){
            return tabtitles[position];
        }
    }


}
