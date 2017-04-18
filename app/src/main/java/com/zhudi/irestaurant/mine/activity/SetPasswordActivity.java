package com.zhudi.irestaurant.mine.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.zhudi.irestaurant.BaseActivity;
import com.zhudi.irestaurant.IActivity;
import com.zhudi.irestaurant.MainActivity;
import com.zhudi.irestaurant.R;

/**
 * Created by zhudi on 2017/4/18.
 */
public class SetPasswordActivity extends BaseActivity implements IActivity {
    private Intent intent=new Intent();
    public EditText edittext_please_input_old_password;
    public EditText edittext_please_input_new_password;
    public EditText edittext_please_input_new_password_again;
    public TextView textview_disensure;
    public TextView textview_ensure;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_password_second);
        initView();
        initData();
        initListener();
    }

    @Override
    public void initView() {
        edittext_please_input_old_password=$(R.id.edittext_please_input_old_password);
        edittext_please_input_new_password=$(R.id.edittext_please_input_new_password);
        edittext_please_input_new_password_again=$(R.id.edittext_please_input_new_password_again);
        textview_disensure=$(R.id.textview_disensure);
        textview_ensure=$(R.id.textview_ensure);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {
        textview_disensure.setOnClickListener(OnClickListener_disensure);
        textview_ensure.setOnClickListener(OnClickListener_ensure);
    }

    View.OnClickListener OnClickListener_disensure=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            goToOtherClass(intent,SetPasswordActivity.this,SetAccountNumberActivity.class,1);
        }
    };

    View.OnClickListener OnClickListener_ensure=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            goToOtherClass(intent,SetPasswordActivity.this,SetAccountNumberActivity.class,1);
        }
    };


    @Override
    public boolean onKeyDown(int KeyCode, KeyEvent keyEvent){
        if(KeyCode==keyEvent.KEYCODE_BACK){
            goToOtherClass(intent,SetPasswordActivity.this,SetAccountNumberActivity.class,1);
        }
        return true;
    }
}
