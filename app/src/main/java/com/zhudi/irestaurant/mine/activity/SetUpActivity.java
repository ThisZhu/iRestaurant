package com.zhudi.irestaurant.mine.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.zhudi.irestaurant.BaseActivity;
import com.zhudi.irestaurant.IActivity;
import com.zhudi.irestaurant.MainActivity;
import com.zhudi.irestaurant.R;

/**
 * Created by zhudi on 2017/4/18.
 */
public class SetUpActivity extends BaseActivity implements IActivity {
    private Intent intent=new Intent();
    public TextView texview_set_up;
    public FrameLayout framelayout_check;
    public Switch switch_button_notice_music;
    public Switch switch_button_boot;
    public FrameLayout framelayout_clear;
    public TextView textview_version;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_up);
        initView();
        initData();
        initListener();
    }

    @Override
    public void initView() {
        texview_set_up=$(R.id.texview_set_up);
        framelayout_check=$(R.id.framelayout_check);
        switch_button_notice_music=$(R.id.switch_button_notice_music);
        switch_button_boot=$(R.id.switch_button_boot);
        framelayout_clear=$(R.id.framelayout_clear);
        textview_version=$(R.id.textview_version);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {
        texview_set_up.setOnClickListener(OnClickListener_set_up);
        framelayout_check.setOnClickListener(OnClickListener_check);
        framelayout_clear.setOnClickListener(OnClickListener_clear);
    }


    View.OnClickListener OnClickListener_set_up=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            goToOtherClass(intent,SetUpActivity.this,MainActivity.class,1);
        }
    };


    View.OnClickListener OnClickListener_check=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            goToOtherClass(intent,SetUpActivity.this,CheckActivity.class,-1);
        }
    };

    View.OnClickListener OnClickListener_clear=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
        }
    };

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent keyEvent){
        if(keyCode==keyEvent.KEYCODE_BACK){
            goToOtherClass(intent,SetUpActivity.this,MainActivity.class,1);
        }
        return true;
    }
}
