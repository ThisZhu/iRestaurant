package com.zhudi.irestaurant.mine.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhudi.irestaurant.BaseActivity;
import com.zhudi.irestaurant.IActivity;
import com.zhudi.irestaurant.MainActivity;
import com.zhudi.irestaurant.R;

/**
 * Created by zhudi on 2017/4/16.
 */
public class RetrievePasswordActivity_1 extends BaseActivity implements IActivity{
    Intent intent=new Intent();
    public TextView texview_retrieve_password;
    public EditText edittext_please_input_phone;
    public EditText edittext_please_input_code;
    public ImageView imageView_code;
    public Button button_next_one;
    public TextView textview_next_step;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve_password_1);
        initView();
        initData();
        initListener();
    }

    @Override
    public void initView() {
        texview_retrieve_password=$(R.id.texview_retrieve_password);
        edittext_please_input_phone=$(R.id.edittext_please_input_phone);
        edittext_please_input_code=$(R.id.edittext_please_input_code);
        imageView_code=$(R.id.imageView_code);
        button_next_one=$(R.id.button_next_one);
        textview_next_step=$(R.id.textview_next_step);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {
        texview_retrieve_password.setOnClickListener(OnClickListener_retrieve_password);
        edittext_please_input_phone.setOnClickListener(OnClickListener_input_phone);
        edittext_please_input_code.setOnClickListener(OnClickListener_input_code);
        button_next_one.setOnClickListener(OnClickListener_next_one);
        textview_next_step.setOnClickListener(OnClickListener_next_step);
    }

    View.OnClickListener OnClickListener_retrieve_password=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            goToOtherClass(intent,RetrievePasswordActivity_1.this, LoginActivity.class,1);
        }
    };

    View.OnClickListener OnClickListener_input_phone=new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };

    View.OnClickListener OnClickListener_input_code=new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };

    View.OnClickListener OnClickListener_next_one=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
        }
    };

    View.OnClickListener OnClickListener_next_step=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            goToOtherClass(intent,RetrievePasswordActivity_1.this,RetrievePasswordActivity_2.class,-1);
        }
    };

    @Override
    public boolean onKeyDown(int KeyCode, KeyEvent keyEvent){
        if(KeyCode==keyEvent.KEYCODE_BACK){
            goToOtherClass(intent,RetrievePasswordActivity_1.this,LoginActivity.class,1);
        }
        return true;
    }
}
