package com.zhudi.irestaurant;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
}
