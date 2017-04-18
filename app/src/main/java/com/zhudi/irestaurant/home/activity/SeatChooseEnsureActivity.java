package com.zhudi.irestaurant.home.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

import com.zhudi.irestaurant.BaseActivity;
import com.zhudi.irestaurant.IActivity;
import com.zhudi.irestaurant.R;

/**
 * Created by zhudi on 2017/4/18.
 */
public class SeatChooseEnsureActivity extends BaseActivity implements IActivity {
    Intent intent=new Intent();
    public TextView texview_back;
    public TextView textView_seat_count;
    public TextView textView_date_details_now;
    public TextView textView_price2;
    public TextView textview_disensure;
    public TextView textview_submit;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        setContentView(R.layout.activity_choose_seat_ensure);
        super.onCreate(savedInstanceState);
        initView();
        initData();
        initListener();
    }

    @Override
    public void initView() {
        texview_back=$(R.id.texview_back);
        textView_seat_count=$(R.id.textView_seat_count);
        textView_date_details_now=$(R.id.textView_date_details_now);
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
            goToOtherClass(intent,SeatChooseEnsureActivity.this,SeatChoose.class,1);
        }
    };

    View.OnClickListener OnClickListener_disensure=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            goToOtherClass(intent,SeatChooseEnsureActivity.this,SeatChoose.class,1);
        }
    };

    View.OnClickListener OnClickListener_submit=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            goToOtherClass(intent,SeatChooseEnsureActivity.this,PayResultActivity.class,-1);
        }
    };

    @Override
    public boolean onKeyDown(int KeyCode, KeyEvent keyEvent){
        if(KeyCode==keyEvent.KEYCODE_BACK){
            goToOtherClass(intent,SeatChooseEnsureActivity.this,SeatChoose.class,1);
        }
        return true;
    }
}
