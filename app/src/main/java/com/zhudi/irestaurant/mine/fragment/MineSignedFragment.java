package com.zhudi.irestaurant.mine.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zhudi.irestaurant.IActivity;
import com.zhudi.irestaurant.R;

/**
 * Created by zhudi on 2017/4/14.
 */
public class MineSignedFragment extends Fragment implements IActivity {
    private static MineSignedFragment mineSignedFragment;

    public static MineSignedFragment getInstance(){
        if (mineSignedFragment==null)
            mineSignedFragment=new MineSignedFragment();
        return mineSignedFragment;
    }

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle savedInstanceState){
        View view=layoutInflater.inflate(R.layout.fragment_sign_in,viewGroup,false);
        return view;
    }

    @Override
    public void onViewCreated(View view,Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);
        initView(view);
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    /**
     * 当fragment对用户可见时调用，
     * 即此时才能处理点击按钮时间，此时view才能获取焦点
     */
    @Override
    public void onStart(){
        super.onStart();
        initListener();
    }

    @Override
    public void initView() {

    }

    public void initView(View view) {

    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {

    }
}
