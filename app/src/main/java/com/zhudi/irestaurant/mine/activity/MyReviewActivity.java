package com.zhudi.irestaurant.mine.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.zhudi.irestaurant.BaseActivity;
import com.zhudi.irestaurant.IActivity;
import com.zhudi.irestaurant.MainActivity;
import com.zhudi.irestaurant.R;

/**
 * Created by zhudi on 2017/4/18.
 */
public class MyReviewActivity extends BaseActivity implements IActivity {
    private Intent intent=new Intent();
    public TextView texview_back;
    public ListView my_review;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_review);
        initView();
        initData();
        initListener();
    }

    @Override
    public void initView() {
        texview_back=$(R.id.texview_back);
        my_review=$(R.id.my_review);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {
        texview_back.setOnClickListener(OnClickListener_back);
    }


    View.OnClickListener OnClickListener_back=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            goToOtherClass(intent,MyReviewActivity.this, MainActivity.class,1);
        }
    };

    @Override
    public boolean onKeyDown(int KeyCode, KeyEvent keyEvent){
        if(KeyCode==keyEvent.KEYCODE_BACK){
            goToOtherClass(intent,MyReviewActivity.this, MainActivity.class,1);
        }
        return true;
    }
}
