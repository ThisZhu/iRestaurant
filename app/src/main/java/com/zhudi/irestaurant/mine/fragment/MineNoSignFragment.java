package com.zhudi.irestaurant.mine.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zhudi.irestaurant.CallBack;
import com.zhudi.irestaurant.IActivity;
import com.zhudi.irestaurant.R;
import com.zhudi.irestaurant.mine.activity.LoginActivity;

/**
 * Created by zhudi on 2017/4/14.
 */
public class MineNoSignFragment extends Fragment implements IActivity {
    private static MineNoSignFragment mineNoSignFragment;
    private Intent intent=new Intent();
    public TextView textview_sign_register;
    CallBack callBack;

    public static MineNoSignFragment getInstance(){
        if(mineNoSignFragment==null)
            mineNoSignFragment=new MineNoSignFragment();
        return mineNoSignFragment;
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        callBack=(CallBack)context;
    }

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle savedInstanceState){
        Log.e("Mine","onCreateView");
        View view = layoutInflater.inflate(R.layout.fragment_no_sign, viewGroup, false);
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
    public  void onDestroyView() {
        super.onDestroyView();
        Log.e("Mine","destroy");
    }

    @Override
    public void initView() {

    }

    public void initView(View view){
        textview_sign_register=(TextView)view.findViewById(R.id.textview_sign_register);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {
        textview_sign_register.setOnClickListener(onClickListener_sign_rigster);
    }

    View.OnClickListener onClickListener_sign_rigster=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            callBack.changeFragment(true);
            intent.setClass(getActivity(), LoginActivity.class);
            getActivity().startActivity(intent);
            getActivity().overridePendingTransition(R.anim.start_to_left,R.anim.exit_no_change);
            getActivity().finish();
        }
    };
}
