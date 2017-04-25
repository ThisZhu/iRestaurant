package com.zhudi.irestaurant.mine.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhudi.irestaurant.BaseActivity;
import com.zhudi.irestaurant.IActivity;
import com.zhudi.irestaurant.MainActivity;
import com.zhudi.irestaurant.R;
import com.zhudi.irestaurant.mine.bean.AccountNumberBean;
import com.zhudi.irestaurant.net.NetCallBack;

/**
 * Created by zhudi on 2017/4/18.
 */
public class SetAccountNumberActivity extends BaseActivity implements IActivity {
    private Intent intent=new Intent();
    private  Bitmap bitmaphead;
    private  Bitmap bitmapbeijing;
    public ImageView imageview_set_head_portrait;
    public FrameLayout framelayout_set_head_portrait;
    public ImageView imageview_set_beijing;
    public FrameLayout framelayout_set_beijing;
    public EditText edittext_set_user_name_details;
    public EditText edittext_set_personalized_signature_details;
    public TextView textview_set_password_details;
    public TextView textview_disensure;
    public TextView textview_ensure;
    private AccountNumberBean accountNumberBean=AccountNumberBean.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_account_number);
        initView();
        initData();
        initListener();
        thread.start();//开启子线程获取数据
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.w("start","start");
        changeImage();
        changeData();
    }

    @Override
    public void initView() {
        imageview_set_head_portrait=$(R.id.imageview_set_head_portrait);
        framelayout_set_head_portrait=$(R.id.framelayout_set_head_portrait);
        imageview_set_beijing=$(R.id.imageview_set_beijing);
        framelayout_set_beijing=$(R.id.framelayout_set_beijing);
        edittext_set_user_name_details=$(R.id.edittext_set_user_name_details);
        edittext_set_personalized_signature_details=$(R.id.edittext_set_personalized_signature_details);
        textview_set_password_details=$(R.id.textview_set_password_details);
        textview_disensure=$(R.id.textview_disensure);
        textview_ensure=$(R.id.textview_ensure);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {
        framelayout_set_head_portrait.setOnClickListener(OnClickListener_set_head_portrait);
        framelayout_set_beijing.setOnClickListener(OnClickListener_set_beijing);
        textview_set_password_details.setOnClickListener(OnClickListener_set_password_details);
        textview_disensure.setOnClickListener(OnClickListener_disensure);
        textview_ensure.setOnClickListener(OnClickListener_ensure);
    }

    public void changeImage(){
        if(accountNumberBean.getreHeadBitmap()!=null) {
            Log.w("reHeadBitmap","reHeadBitmap");
            bitmaphead= accountNumberBean.getreHeadBitmap();
        }
        else {
            Log.w("HeadBitmap","HeadBitmap");
            bitmaphead = accountNumberBean.getHeadBitmap();
        }
        if(accountNumberBean.getreBeijingBitmap()!=null){
            bitmapbeijing=accountNumberBean.getreBeijingBitmap();
        }
        else {
            bitmapbeijing=accountNumberBean.getBeijingBitmap();
        }
        imageview_set_head_portrait.setImageBitmap(bitmaphead);
        imageview_set_beijing.setImageBitmap(bitmapbeijing);
    }

    public void changeData(){
        if(accountNumberBean.getreUserName()!=null){
            String username=accountNumberBean.getreUserName();
            edittext_set_user_name_details.setText(username);
        }
        else {
            String username=accountNumberBean.getUserName();
            edittext_set_user_name_details.setText(username);
        }
        if(accountNumberBean.getreWord()!=null){
            String word=accountNumberBean.getreWord();
            edittext_set_personalized_signature_details.setText(word);
        }
        else {
            String word=accountNumberBean.getWord();
            edittext_set_personalized_signature_details.setText(word);
        }
    }

    public void saveState(){
        accountNumberBean.setreUserName(edittext_set_user_name_details.getText().toString());
        accountNumberBean.setreWord(edittext_set_personalized_signature_details.getText().toString());
    }

    View.OnClickListener OnClickListener_set_head_portrait=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            saveState();
            intent.putExtra("name","head");
            goToOtherClass(intent,SetAccountNumberActivity.this, ChooseHeadPortraitActivity.class,4);
        }
    };

    View.OnClickListener OnClickListener_set_beijing=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            saveState();
            intent.putExtra("name","beijing");
            goToOtherClass(intent,SetAccountNumberActivity.this, ChooseHeadPortraitActivity.class,4);
        }
    };

    View.OnClickListener OnClickListener_set_password_details=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            saveState();
            goToOtherClass(intent,SetAccountNumberActivity.this, SetPasswordActivity.class,-1);
        }
    };

    View.OnClickListener OnClickListener_disensure=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            clearReBean();
            goToOtherClass(intent,SetAccountNumberActivity.this, MainActivity.class,1);
        }
    };

    View.OnClickListener OnClickListener_ensure=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            commitChange();
            goToOtherClass(intent,SetAccountNumberActivity.this, MainActivity.class,1);
        }
    };

    @Override
    public boolean onKeyDown(int KeyCode, KeyEvent keyEvent){
        if(KeyCode==keyEvent.KEYCODE_BACK){
            clearReBean();
            goToOtherClass(intent,SetAccountNumberActivity.this, MainActivity.class,1);
        }
        return true;
    }

    /**
     * 清除预存的数据
     */
    public void clearReBean(){
        accountNumberBean.setreHeadBitmap(null);
        accountNumberBean.setreBeijingBitmap(null);
        accountNumberBean.setreUserName(null);
        accountNumberBean.setreWord(null);
    }

    /**
     * 上传前的准备工作
     */
    public void commitChange(){
        saveState();
        accountNumberBean.setHeadBitmap(accountNumberBean.getreHeadBitmap());
        accountNumberBean.setBeijingBitmap(accountNumberBean.getreBeijingBitmap());
        accountNumberBean.setUserName(accountNumberBean.getreUserName());
        accountNumberBean.setWord(accountNumberBean.getreWord());
        clearReBean();
        commitChangeToServer();
    }

    /**
     * 上传设置的数据到服务器
     */
    public void commitChangeToServer(){

    }

    /**
     * 开启子线程请求服务器数据
     */
    Thread thread=new Thread(new Runnable() {
        @Override
        public void run() {
            if(accountNumberBean.getWord()==null||accountNumberBean.getUserName()==null||
                    accountNumberBean.getBeijingBitmap()==null||accountNumberBean.getHeadBitmap()==null) {
                getDataFromServer();
                setHeadBitmap(null);
                setBeijingBitmap(null);
                setUserName(null);
                setWord(null);
            }
        }
    });

    public void getDataFromServer(){

    }

    public void setHeadBitmap(Bitmap bitmap){
        if(bitmap!=null)
            accountNumberBean.setHeadBitmap(bitmap);
    }

    public void setBeijingBitmap(Bitmap bitmap){
        if(bitmap!=null)
            accountNumberBean.setBeijingBitmap(bitmap);
    }

    public void setUserName(String string){
        if(string!=null)
            accountNumberBean.setUserName(string);
    }

    public void setWord(String string){
        if(string!=null)
            accountNumberBean.setWord(string);
    }
}
