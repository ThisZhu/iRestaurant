package com.zhudi.irestaurant;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Transition;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by zhudi on 2017/4/13.
 */
public class BaseActivity extends AppCompatActivity {
    public <T extends View> T $(int id){
        return (T)findViewById(id);
    }

    public <T extends ViewGroup> T $$(int id,ViewGroup root){
        return (T) LayoutInflater.from(this).inflate(id, root);
    }

    public <T extends ViewGroup> T $1(int id){
        return (T)findViewById(id);
    }

    /**
     * 跳转到其他activity
     * @param intent
     * @param activity
     * @param T
     * @param i 设置切换动画的参数
     */
    public void goToOtherClass(Intent intent,Activity activity, Class T,int i){
        if(i==-1) {
            intent.setClass(activity, T);
            activity.startActivity(intent);
            activity.overridePendingTransition(R.anim.start_to_left, R.anim.exit_no_change);
        }
        else if(i==1){
            intent.setClass(activity, T);
            activity.startActivity(intent);
            activity.overridePendingTransition(R.anim.start_to_right, R.anim.exit_no_change);
        }
        else if (i==2){
            intent.setClass(activity, T);
            activity.startActivity(intent);
            //不需要设置动画，为SeatFilterActivity打开专设，其动画在style中已经设置
            return;
        }
        else if(i==3){
            //不需要设置动画，为SeatFilterActivity退出专设，其动画在style中已经设置
        }
        else if(i==4){
            intent.setClass(activity, T);
            activity.startActivity(intent);
            activity.overridePendingTransition(R.anim.start_to_left, R.anim.exit_no_change);
            return;
        }
        activity.finish();
    }
}
