package com.zhudi.irestaurant.mine.activity;

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
 * Created by zhudi on 2017/4/16.
 */
public class RetrievePasswordActivity_4 extends BaseActivity implements IActivity {
    Intent intent=new Intent();
    public TextView texview_retrieve_password;
    public TextView textview_retrieve_password_successfully;
    public TextView textview_ensure;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve_password_4);
        initView();
        initData();
        initListener();
    }

    @Override
    public void initView() {
        texview_retrieve_password=$(R.id.texview_retrieve_password);
        textview_retrieve_password_successfully=$(R.id.textview_retrieve_password_successfully);
        textview_ensure=$(R.id.textview_ensure);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {
        texview_retrieve_password.setOnClickListener(OnClickListener_retrieve_password);
        textview_retrieve_password_successfully.setOnClickListener(OnClickListener_successfully);
        textview_ensure.setOnClickListener(OnClickListener_ensure);
    }

    View.OnClickListener OnClickListener_retrieve_password=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            goToOtherClass(intent,RetrievePasswordActivity_4.this,RetrievePasswordActivity_3.class,1);
        }
    };

    View.OnClickListener OnClickListener_successfully=new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };

    View.OnClickListener OnClickListener_ensure=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            goToOtherClass(intent,RetrievePasswordActivity_4.this,LoginActivity.class,-1);
        }
    };

    @Override
    public boolean onKeyDown(int KeyCode, KeyEvent keyEvent){
        if(KeyCode==keyEvent.KEYCODE_BACK){
            goToOtherClass(intent,RetrievePasswordActivity_4.this,RetrievePasswordActivity_3.class,1);
        }
        return true;
    }
}