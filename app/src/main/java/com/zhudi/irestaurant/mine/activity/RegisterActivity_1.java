package com.zhudi.irestaurant.mine.activity;

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

/**
 * Created by zhudi on 2017/4/16.
 */
public class RegisterActivity_1 extends BaseActivity implements IActivity {
    Intent intent=new Intent();
    public RelativeLayout relativelayout_back;
    public EditText edittext_please_input_phone;
    public TextView textview_next_step;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_1);
        initView();
        initData();
        initListener();
    }


    @Override
    public void initView() {
        relativelayout_back=$(R.id.relativelayout_back);
        edittext_please_input_phone=$(R.id.edittext_please_input_phone);
        textview_next_step=$(R.id.textview_next_step);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {
        relativelayout_back.setOnClickListener(OnClickListener_back);
        edittext_please_input_phone.setOnClickListener(OnClickListener_input_phone);
        textview_next_step.setOnClickListener(OnClickListener_next_step);
    }

    View.OnClickListener OnClickListener_back=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            goToOtherClass(intent,RegisterActivity_1.this,LoginActivity.class,1);
        }
    };

    View.OnClickListener OnClickListener_input_phone=new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };

    View.OnClickListener OnClickListener_next_step=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            goToOtherClass(intent,RegisterActivity_1.this,RegisterActivity_2.class,-1);
        }
    };

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent keyEvent){
        if(keyCode==keyEvent.KEYCODE_BACK){
            goToOtherClass(intent,RegisterActivity_1.this,LoginActivity.class,1);
        }
        return true;
    }
}

