package com.zhudi.irestaurant.home.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zhudi.irestaurant.BaseActivity;
import com.zhudi.irestaurant.IActivity;
import com.zhudi.irestaurant.MainActivity;
import com.zhudi.irestaurant.R;
import com.zhudi.irestaurant.home.fragment.HomeFragment;

/**
 * Created by zhudi on 2017/4/17.
 */
public class FoodChooseActivity extends BaseActivity implements IActivity {
    Intent intent=new Intent();
    public TextView texview_back;
    public TextView textview_search_text;
    public ListView listview_food;
    public ImageView icon_food_cart;
    public TextView textview_food_choose_count;
    public TextView textview_food_prices;
    public TextView textview_next_step;
    public RelativeLayout relativelayout_food_choose_details;
    public GridView gridview_food_choose_details;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        setContentView(R.layout.activity_choose_food);
        super.onCreate(savedInstanceState);
        initView();
        initData();
        initListener();
    }

    @Override
    public void initView() {
        texview_back=$(R.id.texview_back);
        textview_search_text=$(R.id.textview_search_text);
        listview_food=$(R.id.listview_food);
        icon_food_cart=$(R.id.icon_food_cart);
        textview_food_choose_count=$(R.id.textview_food_choose_count);
        textview_food_prices=$(R.id.textview_food_prices);
        textview_next_step=$(R.id.textview_next_step);
        relativelayout_food_choose_details=$(R.id.relativelayout_food_choose_details);
        gridview_food_choose_details=$(R.id.gridview_food_choose_details);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {
        texview_back.setOnClickListener(OnClickListener_back);
        textview_search_text.setOnClickListener(OnClickListener_search);
        icon_food_cart.setOnClickListener(OnClickListener_food_cart);
        textview_next_step.setOnClickListener(OnClickListener_next_step);
    }

    View.OnClickListener OnClickListener_back=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            goToOtherClass(intent,FoodChooseActivity.this, MainActivity.class,1);
        }
    };

    View.OnClickListener OnClickListener_search=new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };

    View.OnClickListener OnClickListener_food_cart=new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };

    View.OnClickListener OnClickListener_next_step=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            goToOtherClass(intent,FoodChooseActivity.this, FoodChooseEnsureActivity.class,-1);
        }
    };

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == event.KEYCODE_BACK) {
            goToOtherClass(intent,FoodChooseActivity.this, MainActivity.class,1);
        }
        return true;
    }
}
