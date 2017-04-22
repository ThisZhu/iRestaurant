package com.zhudi.irestaurant.home.activity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.zhudi.irestaurant.BaseActivity;
import com.zhudi.irestaurant.IActivity;
import com.zhudi.irestaurant.MainActivity;
import com.zhudi.irestaurant.R;

/**
 * Created by zhudi on 2017/4/12.
 */
public class SeatChoose extends BaseActivity implements IActivity {
    Intent intent = new Intent();
    public TextView texview_back;
    public TextView textview_search_text;
    public ListView listview_seat;
    public ImageView icon_seat_cart;
    public TextView textview_seat_choose_count;
    public TextView textview_seat_prices;
    public TextView textview_next_step;
    public TextView textview_filter;
    public GridView gridview_seat_choose_details;
    public TextView textview_clear_cart;
    public ImageView icon_clear_cart;
    public boolean isInBackground;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        setContentView(R.layout.activity_choose_seat);
        super.onCreate(savedInstanceState);
        initView();
        initData();
        initListener();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(isInBackground)
        dimBackground(0.5f,1.0f);
        isInBackground=false;
    }

    @Override
    public void initView() {
        textview_search_text=$(R.id.textview_search_text);
        listview_seat=$(R.id.listview_seat);
        icon_seat_cart=$(R.id.icon_seat_cart);
        textview_seat_choose_count=$(R.id.textview_seat_choose_count);
        textview_seat_prices=$(R.id.textview_seat_prices);
        textview_next_step=$(R.id.textview_next_step);
        textview_filter=$(R.id.textview_filter);
        gridview_seat_choose_details=$(R.id.gridview_seat_choose_details);
        textview_clear_cart=$(R.id.textview_clear_cart);
        icon_clear_cart=$(R.id.icon_clear_cart);
        texview_back=$(R.id.texview_back);

    }

    @Override
    public void initData() {
        isInBackground=false;
    }

    @Override
    public void initListener() {
        texview_back.setOnClickListener(onClickListener_back);
        textview_next_step.setOnClickListener(onClickListener_next);
        textview_filter.setOnClickListener(onClickListener_filter);
    }

    View.OnClickListener onClickListener_back=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Log.w("activity finish","s");
            goToOtherClass(intent,SeatChoose.this,DateChoose.class,1);
        }
    };

    View.OnClickListener onClickListener_filter=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            goToOtherClass(intent,SeatChoose.this,SeatFilterActivity.class,2);
            dimBackground(1.0f,0.5f);
            isInBackground=true;
        }
    };

    View.OnClickListener onClickListener_next=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            goToOtherClass(intent,SeatChoose.this,SeatChooseEnsureActivity.class,-1);
        }
    };

    public void dimBackground(float from,float to){
        ValueAnimator valueAnimator=ValueAnimator.ofFloat(from,to);
        valueAnimator.setDuration(250);
        valueAnimator.addUpdateListener(animListener);
        valueAnimator.start();
    }

    ValueAnimator.AnimatorUpdateListener animListener=new ValueAnimator.AnimatorUpdateListener() {
        @Override
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            final Window window=getWindow();
            WindowManager.LayoutParams params=window.getAttributes();
            params.alpha=(Float)valueAnimator.getAnimatedValue();
            window.setAttributes(params);
        }
    };

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event){
        if(keyCode==event.KEYCODE_BACK){
            goToOtherClass(intent,SeatChoose.this,DateChoose.class,1);
        }
        return true;
    }
}
