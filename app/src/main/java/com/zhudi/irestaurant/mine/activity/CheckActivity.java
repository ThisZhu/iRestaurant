package com.zhudi.irestaurant.mine.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.zhudi.irestaurant.BaseActivity;
import com.zhudi.irestaurant.IActivity;
import com.zhudi.irestaurant.MainActivity;
import com.zhudi.irestaurant.R;

/**
 * Created by zhudi on 2017/4/18.
 */
public class CheckActivity extends BaseActivity implements IActivity {
    private Intent intent=new Intent();
    public RelativeLayout relativelayout_waiting_check;
    public ProgressBar progressbar_waiting_check;
    public RelativeLayout relativelayout_check_finish_1;
    public TextView textview_ensure_1;
    public RelativeLayout relativelayout_check_finish_2;
    public TextView textview_disensure;
    public TextView textview_ensure_2;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wating_check);
        initView();
        initData();
        initListener();
    }

    @Override
    public void initView() {
        relativelayout_waiting_check=$(R.id.relativelayout_waiting_check);
        progressbar_waiting_check=$(R.id.progressbar_waiting_check);
        relativelayout_check_finish_1=$(R.id.relativelayout_check_finish_1);
        textview_ensure_1=$(R.id.textview_ensure_1);
        relativelayout_check_finish_2=$(R.id.relativelayout_check_finish_2);
        textview_disensure=$(R.id.textview_disensure);
        textview_ensure_2=$(R.id.textview_ensure_2);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {
        textview_ensure_1.setOnClickListener(OnClickListener_ensure_1);
        textview_disensure.setOnClickListener(OnClickListener_disensure);
        textview_ensure_2.setOnClickListener(OnClickListener_ensure_2);
    }


    View.OnClickListener OnClickListener_ensure_1=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            goToOtherClass(intent,CheckActivity.this,SetUpActivity.class,1);
        }
    };


    View.OnClickListener OnClickListener_disensure=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            goToOtherClass(intent,CheckActivity.this,SetUpActivity.class,1);
        }
    };

    View.OnClickListener OnClickListener_ensure_2=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            goToOtherClass(intent,CheckActivity.this,SetUpActivity.class,1);
        }
    };

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent keyEvent){
        if(keyCode==keyEvent.KEYCODE_BACK){
            goToOtherClass(intent,CheckActivity.this,SetUpActivity.class,1);
        }
        return true;
    }
}

