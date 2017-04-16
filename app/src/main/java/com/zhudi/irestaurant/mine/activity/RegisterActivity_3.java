package com.zhudi.irestaurant.mine.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

import com.zhudi.irestaurant.BaseActivity;
import com.zhudi.irestaurant.IActivity;
import com.zhudi.irestaurant.R;

/**
 * Created by zhudi on 2017/4/16.
 */
public class RegisterActivity_3 extends BaseActivity implements IActivity {
    Intent intent=new Intent();
    public TextView textview_retrieve_password_successfully;
    public TextView textview_ensure;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_4);
        initView();
        initData();
        initListener();
    }


    @Override
    public void initView() {
        textview_retrieve_password_successfully=$(R.id.textview_retrieve_password_successfully);
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
            goToOtherClass(intent,RegisterActivity_3.this,LoginActivity.class,-1);
        }
    };

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent keyEvent){
        if(keyCode==keyEvent.KEYCODE_BACK){
            goToOtherClass(intent,RegisterActivity_3.this,LoginActivity.class,-1);
        }
        return true;
    }
}

