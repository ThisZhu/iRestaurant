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
    public TextView texview_register3;
    public TextView edittext_please_input_new_password;
    public TextView edittext_please_input_new_password_again;
    public TextView textview_next_step;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_3);
        initView();
        initData();
        initListener();
    }


    @Override
    public void initView() {
        texview_register3=$(R.id.texview_register3);
        edittext_please_input_new_password=$(R.id.edittext_please_input_new_password);
        edittext_please_input_new_password_again=$(R.id.edittext_please_input_new_password_again);
        textview_next_step=$(R.id.textview_next_step);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {
        texview_register3.setOnClickListener(OnClickListener_register3);
        textview_next_step.setOnClickListener(OnClickListener_next_step);
    }

    View.OnClickListener OnClickListener_register3=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            goToOtherClass(intent,RegisterActivity_3.this,RegisterActivity_2.class,1);
        }
    };

    View.OnClickListener OnClickListener_next_step=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            goToOtherClass(intent,RegisterActivity_3.this,RegisterActivity_4.class,-1);
        }
    };

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent keyEvent){
        if(keyCode==keyEvent.KEYCODE_BACK){
            goToOtherClass(intent,RegisterActivity_3.this,RegisterActivity_2.class,1);
        }
        return true;
    }
}

