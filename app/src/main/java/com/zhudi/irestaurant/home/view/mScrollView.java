package com.zhudi.irestaurant.home.view;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ScrollView;
import com.zhudi.irestaurant.R;
/**
 * Created by zhudi on 2017/4/17.
 */
public class mScrollView extends ScrollView {
    TabLayout tabLayout;
    TabLayout tabLayout1;

    public mScrollView(Context context) {
        super(context);
    }

    public mScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public mScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec,heightMeasureSpec);
        initView();
    }

    private void initView(){
        tabLayout=(TabLayout)findViewById(R.id.tablayout_hot_fragment);
    }

    public void setView(TabLayout tabLayout1){
        this.tabLayout1=tabLayout1;
    }

    @Override
    public void computeScroll() {
        if(getScrollY()>=tabLayout.getTop()&&!tabLayout1.isShown()){
            tabLayout1.setVisibility(VISIBLE);
        }else if(getScrollY()<tabLayout.getTop()&&tabLayout1.isShown()){
            tabLayout1.setVisibility(GONE);
        }
        super.computeScroll();
    }
    }
