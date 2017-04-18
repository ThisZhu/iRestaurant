package com.zhudi.irestaurant.home.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
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
    TextView texview_back;
    TextView textview_search_text;
    ListView listview_seat;
    ImageView icon_seat_cart;
    TextView textview_seat_choose_count;
    TextView textview_seat_prices;
    TextView textview_next_step;
    TextView textview_filter;
    GridView gridview_seat_choose_details;
    TextView textview_clear_cart;
    ImageView icon_clear_cart;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        setContentView(R.layout.activity_choose_seat);
        super.onCreate(savedInstanceState);
        initView();
        initData();
        initListener();
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

    }

    @Override
    public void initListener() {
        texview_back.setOnClickListener(onClickListener_back);
        textview_next_step.setOnClickListener(onClickListener_next);
    }

    View.OnClickListener onClickListener_back=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Log.w("activity finish","s");
            goToOtherClass(intent,SeatChoose.this,DateChoose.class,1);
        }
    };

    View.OnClickListener onClickListener_next=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            goToOtherClass(intent,SeatChoose.this,SeatChooseEnsureActivity.class,-1);
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
