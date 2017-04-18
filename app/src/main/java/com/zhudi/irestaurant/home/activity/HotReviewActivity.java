package com.zhudi.irestaurant.home.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.zhudi.irestaurant.BaseActivity;
import com.zhudi.irestaurant.IActivity;
import com.zhudi.irestaurant.MainActivity;
import com.zhudi.irestaurant.R;

/**
 * Created by zhudi on 2017/4/18.
 */
public class HotReviewActivity extends BaseActivity implements IActivity{
    Intent intent=new Intent();
    public TextView texview_back;
    public TextView textvew_review_peoples;
    public RatingBar ratingbar;
    public TextView textview_total;
    public TextView textview_good_reviews;
    public TextView textview_bad_reviews;
    public TextView textview_photo_reviews;
    public ListView listview_review;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        setContentView(R.layout.activity_hot_review);
        super.onCreate(savedInstanceState);
        initView();
        initData();
        initListener();
    }

    @Override
    public void initView() {
        texview_back=$(R.id.texview_back);
        textvew_review_peoples=$(R.id.textvew_review_peoples);
        ratingbar=$(R.id.ratingbar);
        textview_total=$(R.id.textview_total);
        textview_good_reviews=$(R.id.textview_good_reviews);
        textview_bad_reviews=$(R.id.textview_bad_reviews);
        textview_photo_reviews=$(R.id.textview_photo_reviews);
        listview_review=$(R.id.listview_review);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {
        texview_back.setOnClickListener(OnClickListener_back);
        textview_total.setOnClickListener(OnClickListener_total);
        textview_good_reviews.setOnClickListener(OnClickListener_good_reviews);
        textview_bad_reviews.setOnClickListener(OnClickListener_bad_reviews);
        textview_photo_reviews.setOnClickListener(OnClickListener_photo_reviews);
    }


    View.OnClickListener OnClickListener_back=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            goToOtherClass(intent,HotReviewActivity.this, MainActivity.class,1);
        }
    };


    View.OnClickListener OnClickListener_total=new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };


    View.OnClickListener OnClickListener_good_reviews=new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };


    View.OnClickListener OnClickListener_bad_reviews=new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };


    View.OnClickListener OnClickListener_photo_reviews=new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == event.KEYCODE_BACK) {
            goToOtherClass(intent,HotReviewActivity.this, MainActivity.class,1);
        }
        return true;
    }
}
