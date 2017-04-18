package com.zhudi.irestaurant.mine.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.zhudi.irestaurant.BaseActivity;
import com.zhudi.irestaurant.IActivity;
import com.zhudi.irestaurant.MainActivity;
import com.zhudi.irestaurant.R;

/**
 * Created by zhudi on 2017/4/16.
 */
public class QuickLoginActivity extends BaseActivity implements IActivity {
    Intent intent=new Intent();
    public TextView texview_back;
    public EditText edittext_please_input_phone;
    public Button button_get_message_code;
    public EditText edittext_please_input_message_code;
    public TextView textview_login;
    public TextView textview_register;
    public TextView textview_password_login;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quick_login);
        initView();
        initData();
        initListener();
    }

    @Override
    public void initView() {
        texview_back=$(R.id.texview_back);
        edittext_please_input_phone=$(R.id.edittext_please_input_phone);
        button_get_message_code=$(R.id.button_get_message_code);
        edittext_please_input_message_code=$(R.id.edittext_please_input_message_code);
        textview_login=$(R.id.textview_login);
        textview_register=$(R.id.textview_register);
        textview_password_login=$(R.id.textview_password_login);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {
        texview_back.setOnClickListener(OnClickListener_back);
        edittext_please_input_phone.setOnClickListener(OnClickListener_input_phone);
        button_get_message_code.setOnClickListener(OnClickListener_get_message_code);
        edittext_please_input_message_code.setOnClickListener(OnClickListener_input_message_code);
        textview_login.setOnClickListener(OnClickListener_login);
        textview_register.setOnClickListener(OnClickListener_register);
        textview_password_login.setOnClickListener(OnClickListener_password_login);
    }

    View.OnClickListener OnClickListener_back=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            goToOtherClass(intent,QuickLoginActivity.this, MainActivity.class,1);
        }
    };

    View.OnClickListener OnClickListener_input_phone=new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };

    View.OnClickListener OnClickListener_get_message_code=new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };

    View.OnClickListener OnClickListener_input_message_code=new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };

    View.OnClickListener OnClickListener_login=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            SharedPreferences sharedPreferences=getSharedPreferences("sign_flag", 0);
            SharedPreferences.Editor editor=sharedPreferences.edit();
            editor.putString("flag","yes");
            editor.commit();
            goToOtherClass(intent,QuickLoginActivity.this, MainActivity.class,1);
        }
    };

    View.OnClickListener OnClickListener_register=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            goToOtherClass(intent,QuickLoginActivity .this,RegisterActivity_1.class,-1);
        }
    };

    View.OnClickListener OnClickListener_password_login=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            goToOtherClass(intent,QuickLoginActivity.this, LoginActivity.class,1);
        }
    };


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent keyEvent){
        if(keyCode==keyEvent.KEYCODE_BACK){
            goToOtherClass(intent,QuickLoginActivity.this,MainActivity.class,1);
        }
        return true;
    }
}
