package com.zhudi.irestaurant.mine.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhudi.irestaurant.BaseActivity;
import com.zhudi.irestaurant.IActivity;
import com.zhudi.irestaurant.MainActivity;
import com.zhudi.irestaurant.R;

/**
 * Created by zhudi on 2017/4/18.
 */
public class SetAccountNumberActivity extends BaseActivity implements IActivity {
    private Intent intent=new Intent();
    public ImageView imageview_set_head_portrait;
    public FrameLayout framelayout_set_head_portrait;
    public ImageView imageview_set_beijing;
    public FrameLayout framelayout_set_beijing;
    public EditText edittext_set_user_name_details;
    public EditText edittext_set_personalized_signature_details;
    public TextView textview_set_password_details;
    public TextView textview_disensure;
    public TextView textview_ensure;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_account_number);
        initView();
        initData();
        initListener();
    }

    @Override
    public void initView() {
        imageview_set_head_portrait=$(R.id.imageview_set_head_portrait);
        framelayout_set_head_portrait=$(R.id.framelayout_set_head_portrait);
        imageview_set_beijing=$(R.id.imageview_set_beijing);
        framelayout_set_beijing=$(R.id.framelayout_set_beijing);
        edittext_set_user_name_details=$(R.id.edittext_set_user_name_details);
        edittext_set_personalized_signature_details=$(R.id.edittext_set_personalized_signature_details);
        textview_set_password_details=$(R.id.textview_set_password_details);
        textview_disensure=$(R.id.textview_disensure);
        textview_ensure=$(R.id.textview_ensure);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {
        framelayout_set_head_portrait.setOnClickListener(OnClickListener_set_head_portrait);
        framelayout_set_beijing.setOnClickListener(OnClickListener_set_beijing);
        textview_set_password_details.setOnClickListener(OnClickListener_set_password_details);
        textview_disensure.setOnClickListener(OnClickListener_disensure);
        textview_ensure.setOnClickListener(OnClickListener_ensure);
    }

    View.OnClickListener OnClickListener_set_head_portrait=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
        }
    };

    View.OnClickListener OnClickListener_set_beijing=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
        }
    };

    View.OnClickListener OnClickListener_set_password_details=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            goToOtherClass(intent,SetAccountNumberActivity.this, SetPasswordActivity.class,-1);
        }
    };

    View.OnClickListener OnClickListener_disensure=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            goToOtherClass(intent,SetAccountNumberActivity.this, MainActivity.class,1);
        }
    };

    View.OnClickListener OnClickListener_ensure=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            goToOtherClass(intent,SetAccountNumberActivity.this, MainActivity.class,1);
        }
    };

    @Override
    public boolean onKeyDown(int KeyCode, KeyEvent keyEvent){
        if(KeyCode==keyEvent.KEYCODE_BACK){
            goToOtherClass(intent,SetAccountNumberActivity.this, MainActivity.class,1);
        }
        return true;
    }
}
