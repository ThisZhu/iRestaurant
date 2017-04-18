package com.zhudi.irestaurant.mine.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.zhudi.irestaurant.CallBack;
import com.zhudi.irestaurant.IActivity;
import com.zhudi.irestaurant.R;
import com.zhudi.irestaurant.mine.activity.HelpActivity;
import com.zhudi.irestaurant.mine.activity.LoginActivity;
import com.zhudi.irestaurant.mine.activity.MyCollectionsActivity;
import com.zhudi.irestaurant.mine.activity.MyCouponActivity;
import com.zhudi.irestaurant.mine.activity.MyReviewActivity;
import com.zhudi.irestaurant.mine.activity.SetAccountNumberActivity;
import com.zhudi.irestaurant.mine.activity.SetUpActivity;
import com.zhudi.irestaurant.mine.view.CircleImageView;
import com.zhudi.irestaurant.BaseFragment;

/**
 * Created by zhudi on 2017/4/14.
 */
public class MineSignedFragment extends BaseFragment implements IActivity {
    Intent intent=new Intent();
    private CallBack callBack;
    public FrameLayout framelayout_beijing;
    public CircleImageView circleimageview_sign_in;
    public TextView textview_user_name;
    public TextView textview_user_description;
    public FrameLayout framelayout_coupon;
    public TextView icon_details_coupon;
    public FrameLayout framelayout_my_review;
    public FrameLayout framelayout_my_collection;
    public FrameLayout framelayout_help;
    public FrameLayout framelayout_set_up;
    public FrameLayout framelayout_share;
    public TextView textview_sign_out;

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
    public void  onAttach(Context context) {
        super.onAttach(context);
        callBack=(CallBack)context;
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
        framelayout_beijing=(FrameLayout)view.findViewById(R.id.framelayout_beijing) ;
        circleimageview_sign_in=(CircleImageView)view.findViewById(R.id.circleimageview_sign_in) ;
        textview_user_name=(TextView)view.findViewById(R.id.textview_user_name) ;
        textview_user_description=(TextView)view.findViewById(R.id.textview_user_description) ;
        framelayout_coupon=(FrameLayout)view.findViewById(R.id.framelayout_coupon) ;
        icon_details_coupon=(TextView)view.findViewById(R.id.icon_details_coupon) ;
        framelayout_my_review=(FrameLayout)view.findViewById(R.id.framelayout_my_review) ;
        framelayout_my_collection=(FrameLayout)view.findViewById(R.id.framelayout_my_collection) ;
        framelayout_help=(FrameLayout)view.findViewById(R.id.framelayout_help) ;
        framelayout_set_up=(FrameLayout)view.findViewById(R.id.framelayout_set_up) ;
        framelayout_share=(FrameLayout)view.findViewById(R.id.framelayout_share) ;
        textview_sign_out=(TextView)view.findViewById(R.id.textview_sign_out) ;
    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {
        circleimageview_sign_in.setOnClickListener(OnClickListener_sign_in);
        framelayout_coupon.setOnClickListener(OnClickListener_coupon);
        framelayout_my_review.setOnClickListener(OnClickListener_my_review);
        framelayout_my_collection.setOnClickListener(OnClickListener_my_collection);
        framelayout_help.setOnClickListener(OnClickListener_help);
        framelayout_set_up.setOnClickListener(OnClickListener__set_up);
        framelayout_share.setOnClickListener(OnClickListener_share);
        textview_sign_out.setOnClickListener(OnClickListener_sign_out);
    }

    View.OnClickListener OnClickListener_sign_in=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            goToOtherActivity(intent,getActivity(),SetAccountNumberActivity.class,-1);
        }
    };

    View.OnClickListener OnClickListener_coupon=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            goToOtherActivity(intent,getActivity(),MyCouponActivity.class,-1);
        }
    };

    View.OnClickListener OnClickListener_my_review=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            goToOtherActivity(intent,getActivity(),MyReviewActivity.class,-1);
        }
    };

    View.OnClickListener OnClickListener_my_collection=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            goToOtherActivity(intent,getActivity(),MyCollectionsActivity.class,-1);
        }
    };

    View.OnClickListener OnClickListener_help=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            goToOtherActivity(intent,getActivity(),HelpActivity.class,-1);
        }
    };

    View.OnClickListener OnClickListener__set_up=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            goToOtherActivity(intent,getActivity(),SetUpActivity.class,-1);
        }
    };

    View.OnClickListener OnClickListener_share=new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };

    View.OnClickListener OnClickListener_sign_out=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            SharedPreferences sharedPreferences=getActivity().getSharedPreferences("sign_flag", 0);
            SharedPreferences.Editor editor=sharedPreferences.edit();
            editor.putString("flag","no");
            editor.commit();
            goToOtherActivity(intent,getActivity(),LoginActivity.class,1);
        }
    };

}
