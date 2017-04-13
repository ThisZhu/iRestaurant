package com.zhudi.irestaurant.home.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by zhudi on 2017/4/13.
 */
public class BaseActivity extends Activity {
    public <T extends View> T $(int id){
        return (T)findViewById(id);
    }

    public <T extends ViewGroup> T $$(int id,ViewGroup root){
        return (T) LayoutInflater.from(this).inflate(id, root);
    }
}
