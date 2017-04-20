package com.zhudi.irestaurant.mine.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.zhudi.irestaurant.BaseFragment;
import com.zhudi.irestaurant.CallBack;
import com.zhudi.irestaurant.IActivity;
import com.zhudi.irestaurant.R;
import com.zhudi.irestaurant.mine.activity.HelpActivity;
import com.zhudi.irestaurant.mine.activity.LoginActivity;
import com.zhudi.irestaurant.mine.activity.SetUpActivity;
import com.zhudi.irestaurant.net.NETService;
import com.zhudi.irestaurant.net.NetCallBack;

/**
 * Created by zhudi on 2017/4/14.
 */
public class MineNoSignFragment extends BaseFragment implements IActivity {
    private static MineNoSignFragment mineNoSignFragment;
    private Intent intent=new Intent();
    public TextView textview_sign_register;
    public FrameLayout framelayout_help;
    public FrameLayout framelayout_set_up;
    public FrameLayout framelayout_share;
    private CallBack callBack;

    public static MineNoSignFragment getInstance(){
        if(mineNoSignFragment==null)
            mineNoSignFragment=new MineNoSignFragment();
        return mineNoSignFragment;
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
        framelayout_help=(FrameLayout) view.findViewById(R.id.framelayout_help);
        framelayout_set_up=(FrameLayout)view.findViewById(R.id.framelayout_set_up);
        framelayout_share=(FrameLayout)view.findViewById(R.id.framelayout_share);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {
        textview_sign_register.setOnClickListener(onClickListener_sign_rigster);
        framelayout_help.setOnClickListener(onClickListener_help);
        framelayout_set_up.setOnClickListener(onClickListener_set_up);
        framelayout_share.setOnClickListener(onClickListener_share);
    }

    View.OnClickListener onClickListener_sign_rigster=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            goToOtherActivity(intent,getActivity(),LoginActivity.class,-1);
        }
    };

    View.OnClickListener onClickListener_help=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            goToOtherActivity(intent,getActivity(),HelpActivity.class,-1);
        }
    };

    View.OnClickListener onClickListener_set_up=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            goToOtherActivity(intent,getActivity(),SetUpActivity.class,-1);
        }
    };

    View.OnClickListener onClickListener_share=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Log.e("thread","sss");
            intent.setClass(getActivity(),NETService.class);
            getActivity().startService(intent);
            callBack=(CallBack)NETService.getInstance();
            callBack.changeFragment(true);
        }
    };
}
