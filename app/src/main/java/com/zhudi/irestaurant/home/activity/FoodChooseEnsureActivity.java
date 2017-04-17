package com.zhudi.irestaurant.home.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.zhudi.irestaurant.BaseActivity;
import com.zhudi.irestaurant.IActivity;
import com.zhudi.irestaurant.R;
import com.zhudi.irestaurant.home.fragment.HomeFragment;

/**
 * Created by zhudi on 2017/4/17.
 */
public class FoodChooseEnsureActivity extends BaseActivity implements IActivity {
    Intent intent=new Intent();
    public TextView texview_back;
    public ListView listview_order;
    public TextView textView_price2;
    public TextView textview_disensure;
    public TextView textview_submit;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        setContentView(R.layout.activity_choose_food_ensure);
        super.onCreate(savedInstanceState);
        initView();
        initData();
        initListener();
    }

    @Override
    public void initView() {
        texview_back=$(R.id.texview_back);
        listview_order=$(R.id.listview_order);
        textView_price2=$(R.id.textView_price2);
        textview_disensure=$(R.id.textview_disensure);
        textview_submit=$(R.id.textview_submit);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {
        texview_back.setOnClickListener(OnClickListener_back);
        textview_disensure.setOnClickListener(OnClickListener_disensure);
        textview_submit.setOnClickListener(OnClickListener_submit);
    }


    View.OnClickListener OnClickListener_back=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            goToOtherClass(intent,FoodChooseEnsureActivity.this, FoodChooseActivity.class,1);
        }
    };

    View.OnClickListener OnClickListener_disensure=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            goToOtherClass(intent,FoodChooseEnsureActivity.this, FoodChooseActivity.class,1);
        }
    };

    View.OnClickListener OnClickListener_submit=new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == event.KEYCODE_BACK) {
            goToOtherClass(intent,FoodChooseEnsureActivity.this, FoodChooseActivity.class,1);
        }
        return true;
    };
}
