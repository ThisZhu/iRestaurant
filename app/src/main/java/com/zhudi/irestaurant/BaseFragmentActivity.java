package com.zhudi.irestaurant;

import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by zhudi on 2017/4/14.
 */
public class BaseFragmentActivity extends FragmentActivity{
    public <T extends View> T $(int id){
        return (T)findViewById(id);
    }

    public <T extends ViewGroup> T $$(int id, ViewGroup root){
        return (T) LayoutInflater.from(this).inflate(id, root);
    }

    public <T extends ViewGroup> T $1(int id){
        return (T)findViewById(id);
    }
}
