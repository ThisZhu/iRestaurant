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
 * Created by zhudi on 2017/4/18.
 */
public class PayResultActivity extends BaseActivity implements IActivity {
    Intent intent=new Intent();
    public TextView textview_reult_success;
    public TextView textview_pay_notice;
    public TextView textview_ensure;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        setContentView(R.layout.activity_pay_result);
        super.onCreate(savedInstanceState);
        initView();
        initData();
        initListener();
    }

    @Override
    public void initView() {
        textview_reult_success=$(R.id.textview_reult_success);
        textview_pay_notice=$(R.id.textview_pay_notice);
        textview_ensure=$(R.id.textview_ensure);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {
        textview_ensure.setOnClickListener(OnClickListener_ensure);
    }

    View.OnClickListener OnClickListener_ensure=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            goToOtherClass(intent,PayResultActivity.this, MainActivity.class,1);
        }
    };

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == event.KEYCODE_BACK) {
            goToOtherClass(intent,PayResultActivity.this, MainActivity.class,1);
        }
        return true;
    };
}
