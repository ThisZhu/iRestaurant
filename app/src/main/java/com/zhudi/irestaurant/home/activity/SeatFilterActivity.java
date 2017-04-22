package com.zhudi.irestaurant.home.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

import com.zhudi.irestaurant.BaseActivity;
import com.zhudi.irestaurant.IActivity;
import com.zhudi.irestaurant.MainActivity;
import com.zhudi.irestaurant.R;

/**
 * Created by zhudi on 2017/4/22.
 */
public class SeatFilterActivity extends BaseActivity implements IActivity {
    Intent intent=new Intent();
    public TextView textview_filter_seat_where_1;
    public TextView textview_filter_seat_where_2;
    public TextView textview_filter_seat_where_3;
    public TextView textview_filter_seat_where_4;
    public TextView textview_filter_seat_people_1;
    public TextView textview_filter_seat_people_2;
    public TextView textview_filter_seat_people_3;
    public TextView textview_filter_seat_people_4;
    public TextView textview_filter_seat_people_5;
    public TextView textview_filter_seat_people_6;
    public TextView textview_filter_seat_people_7;
    public TextView textview_filter_seat_people_8;
    public TextView filter_seat_box_1;
    public TextView filter_seat_box_2;
    public TextView filter_seat_box_3;
    public TextView filter_seat_box_4;
    public TextView filter_seat_box_5;
    public TextView textview_filter_seat_type_1;
    public TextView textview_filter_seat_type_2;
    public TextView textview_disensure;
    public TextView textview_ensure;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        setContentView(R.layout.activity_filter_seat);
        super.onCreate(savedInstanceState);
        initView();
        initData();
        initListener();
    }

    @Override
    public void initView() {
        textview_filter_seat_where_1=$(R.id.textview_filter_seat_where_1);
        textview_filter_seat_where_2=$(R.id.textview_filter_seat_where_2);
        textview_filter_seat_where_3=$(R.id.textview_filter_seat_where_3);
        textview_filter_seat_where_4=$(R.id.textview_filter_seat_where_4);
        textview_filter_seat_people_1=$(R.id.textview_filter_seat_people_1);
        textview_filter_seat_people_2=$(R.id.textview_filter_seat_people_2);
        textview_filter_seat_people_3=$(R.id.textview_filter_seat_people_3);
        textview_filter_seat_people_4=$(R.id.textview_filter_seat_people_4);
        textview_filter_seat_people_5=$(R.id.textview_filter_seat_people_5);
        textview_filter_seat_people_6=$(R.id.textview_filter_seat_people_6);
        textview_filter_seat_people_7=$(R.id.textview_filter_seat_people_7);
        textview_filter_seat_people_8=$(R.id.textview_filter_seat_people_8);
        filter_seat_box_1=$(R.id.filter_seat_box_1);
        filter_seat_box_2=$(R.id.filter_seat_box_2);
        filter_seat_box_3=$(R.id.filter_seat_box_3);
        filter_seat_box_4=$(R.id.filter_seat_box_4);
        filter_seat_box_5=$(R.id.filter_seat_box_5);
        textview_filter_seat_type_1=$(R.id.textview_filter_seat_type_1);
        textview_filter_seat_type_2=$(R.id.textview_filter_seat_type_2);
        textview_disensure=$(R.id.textview_disensure);
        textview_ensure=$(R.id.textview_ensure);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {
        textview_filter_seat_where_1.setOnClickListener(OnClickListener_seat_where_1);
        textview_filter_seat_where_2.setOnClickListener(OnClickListener_seat_where_2);
        textview_filter_seat_where_3.setOnClickListener(OnClickListener_seat_where_3);
        textview_filter_seat_where_4.setOnClickListener(OnClickListener_seat_where_4);
        textview_filter_seat_people_1.setOnClickListener(OnClickListener_seat_people_1);
        textview_filter_seat_people_2.setOnClickListener(OnClickListener_seat_people_2);
        textview_filter_seat_people_3.setOnClickListener(OnClickListener_seat_people_3);
        textview_filter_seat_people_4.setOnClickListener(OnClickListener_seat_people_4);
        textview_filter_seat_people_5.setOnClickListener(OnClickListener_seat_people_5);
        textview_filter_seat_people_6.setOnClickListener(OnClickListener_seat_people_6);
        textview_filter_seat_people_7.setOnClickListener(OnClickListener_seat_people_7);
        textview_filter_seat_people_8.setOnClickListener(OnClickListener_seat_people_8);
        filter_seat_box_1.setOnClickListener(OnClickListener_seat_box_1);
        filter_seat_box_2.setOnClickListener(OnClickListener_seat_box_2);
        filter_seat_box_3.setOnClickListener(OnClickListener_seat_box_3);
        filter_seat_box_4.setOnClickListener(OnClickListener_seat_box_4);
        filter_seat_box_5.setOnClickListener(OnClickListener_seat_box_5);
        textview_filter_seat_type_1.setOnClickListener(OnClickListener_seat_type_1);
        textview_filter_seat_type_2.setOnClickListener(OnClickListener_seat_type_2);
        textview_disensure.setOnClickListener(OnClickListener_disensure);
        textview_ensure.setOnClickListener(OnClickListener_ensure);
    }

    View.OnClickListener OnClickListener_seat_where_1=new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };

    View.OnClickListener OnClickListener_seat_where_2=new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };

    View.OnClickListener OnClickListener_seat_where_3=new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };

    View.OnClickListener OnClickListener_seat_where_4=new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };

    View.OnClickListener OnClickListener_seat_people_1=new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };

    View.OnClickListener OnClickListener_seat_people_2=new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };

    View.OnClickListener OnClickListener_seat_people_3=new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };

    View.OnClickListener OnClickListener_seat_people_4=new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };

    View.OnClickListener OnClickListener_seat_people_5=new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };

    View.OnClickListener OnClickListener_seat_people_6=new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };

    View.OnClickListener OnClickListener_seat_people_7=new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };

    View.OnClickListener OnClickListener_seat_people_8=new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };

    View.OnClickListener OnClickListener_seat_box_1=new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };

    View.OnClickListener OnClickListener_seat_box_2=new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };

    View.OnClickListener OnClickListener_seat_box_3=new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };

    View.OnClickListener OnClickListener_seat_box_4=new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };

    View.OnClickListener OnClickListener_seat_box_5=new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };

    View.OnClickListener OnClickListener_seat_type_1=new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };

    View.OnClickListener OnClickListener_seat_type_2=new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };

    View.OnClickListener OnClickListener_disensure=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            goToOtherClass(intent,SeatFilterActivity.this,SeatChoose.class,3);
        }
    };

    View.OnClickListener OnClickListener_ensure=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
        }
    };

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == event.KEYCODE_BACK) {
            goToOtherClass(intent,SeatFilterActivity.this, SeatChoose.class,3);
        }
        return true;
    }
}
