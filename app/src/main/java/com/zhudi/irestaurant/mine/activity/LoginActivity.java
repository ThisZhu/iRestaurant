package com.zhudi.irestaurant.mine.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zhudi.irestaurant.BaseActivity;
import com.zhudi.irestaurant.IActivity;
import com.zhudi.irestaurant.MainActivity;
import com.zhudi.irestaurant.R;
import com.zhudi.irestaurant.mine.view.CircleImageView;

/**
 * Created by zhudi on 2017/4/16.
 */
public class LoginActivity extends BaseActivity implements IActivity {
    private Intent intent=new Intent();
    public RelativeLayout relativelayout_background;
    public TextView texview_back;
    public CircleImageView imageview_touxiang;
    public EditText edittext_please_input_phone;
    public EditText edittext_please_input_password;
    public TextView textview_login;
    public TextView textview_forget_password;
    public TextView textview_register;
    public TextView textview_quick_login;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        initData();
        initListener();
    }

    @Override
    public void initView() {
        relativelayout_background=$1(R.id.relativelayout_background);
        texview_back=$(R.id.texview_back);
        imageview_touxiang=$(R.id.imageview_touxiang);
        edittext_please_input_phone=$(R.id.edittext_please_input_phone);
        edittext_please_input_password=$(R.id.edittext_please_input_password);
        textview_login=$(R.id.textview_login);
        textview_forget_password=$(R.id.textview_forget_password);
        textview_register=$(R.id.textview_register);
        textview_quick_login=$(R.id.textview_quick_login);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {
        texview_back.setOnClickListener(onClickListener_back);
        textview_quick_login.setOnClickListener(onClickListener_quick_login);
        edittext_please_input_phone.setOnClickListener(OnClickListener_input_phone);
        edittext_please_input_password.setOnClickListener(OnClickListener_input_password);
        textview_login.setOnClickListener(OnClickListener_login);
        textview_forget_password.setOnClickListener(OnClickListener_forget_password);
        textview_register.setOnClickListener(OnClickListener_register);
    }

    View.OnClickListener onClickListener_back=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            goToOtherClass(intent,LoginActivity.this,MainActivity.class,1);
        }
    };

    View.OnClickListener onClickListener_quick_login=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            goToOtherClass(intent,LoginActivity.this,QuickLoginActivity.class,-1);
        }
    };

    View.OnClickListener OnClickListener_input_phone=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
        }
    };

    View.OnClickListener OnClickListener_input_password=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
        }
    };

    View.OnClickListener OnClickListener_login=new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };

    View.OnClickListener OnClickListener_forget_password=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            goToOtherClass(intent,LoginActivity.this,RetrievePasswordActivity_1.class,-1);
        }
    };

    View.OnClickListener OnClickListener_register=new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent keyEvent){
        if(keyCode==keyEvent.KEYCODE_BACK){
            goToOtherClass(intent,LoginActivity.this,MainActivity.class,1);
        }
        return true;
    }
}
