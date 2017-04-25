package com.zhudi.irestaurant.mine.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

import com.zhudi.irestaurant.BaseActivity;
import com.zhudi.irestaurant.IActivity;
import com.zhudi.irestaurant.R;
import com.zhudi.irestaurant.mine.bean.AccountNumberBean;
import com.zhudi.irestaurant.net.NetCallBack;

import java.io.File;

/**
 * Created by zhudi on 2017/4/25.
 */
public class ChooseHeadPortraitActivity extends BaseActivity implements IActivity {
    private Intent intent=new Intent();
    public TextView text_camera;
    public TextView text_photo;
    public TextView text_disensure;
    private  int CAMERA_REQUEST=1;
    private  int PHOTO_REQUEST=2;
    private  int PHOTO_CLIP = 3;
    private String name;
    private AccountNumberBean accountNumberBean=AccountNumberBean.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_head_portrait);
        initView();
        initData();
        initListener();
        intent=this.getIntent();
        name=intent.getStringExtra("name");
        Log.w("name",name);
    }


    @Override
    public void initView() {
        text_camera=$(R.id.text_camera);
        text_photo=$(R.id.text_photo);
        text_disensure=$(R.id.text_disensure);
    }

    @Override
    public void initData() {
    }

    @Override
    public void initListener() {
        text_camera.setOnClickListener(OnClickListener_camera);
        text_photo.setOnClickListener(OnClickListener_photo);
        text_disensure.setOnClickListener(OnClickListener_disensure);
    }

    View.OnClickListener OnClickListener_camera=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            getImageFromCamera();
        }
    };

    View.OnClickListener OnClickListener_photo=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            getImageFromPhoto();
        }
    };

    public void getImageFromCamera(){
        intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(
                new File(Environment.getExternalStorageDirectory(),"headportrait.jpg")));
        startActivityForResult(intent, CAMERA_REQUEST);
    }

    public void getImageFromPhoto(){
        intent = new Intent(Intent.ACTION_PICK, null);
        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,"image/*");
        startActivityForResult(intent,PHOTO_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==CAMERA_REQUEST&&resultCode==-1){
            //表示拍照成功,剪裁图片
            Log.w("camera","success");
            //Environment.getExternalStorageDirectory()获取sdcard路径，
            // new File只是在内存中创建File文件映射对象,而并不会在硬盘中创建文件
            File file=new File(Environment.getExternalStorageDirectory(),"headportrait.jpg");
            if(file.exists())
                photoClip(Uri.fromFile(file));
        }
        else if(requestCode==PHOTO_REQUEST&&data!=null)
            photoClip(data.getData());
        else if(requestCode==PHOTO_CLIP&&data!=null){
            Bundle bundle=data.getExtras();
            if(bundle!=null){
                dealWithImage(bundle);
            }
        }
    }

    public void dealWithImage(Bundle bundle){
        Bitmap bitmap=bundle.getParcelable("data");
        if(name.equals("head")) {
            Log.w("head","start");
            accountNumberBean.setreHeadBitmap(bitmap);
        }else if(name.equals("beijing")){
            accountNumberBean.setreBeijingBitmap(bitmap);
        }
        this.finish();
    }

    public void photoClip(Uri uri){
        Log.w("readcameraphoto","success");
        intent=new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri,"image/*");
        intent.putExtra("crop", "true");
        if(name.equals("head")) {
            intent.putExtra("aspectX", 1);
            intent.putExtra("aspectY", 1);
            intent.putExtra("outputX", 160);
            intent.putExtra("outputY", 160);
        }else if(name.equals("beijing")){
            intent.putExtra("aspectX", 16);
            intent.putExtra("aspectY", 9);
            intent.putExtra("outputX", 160);
            intent.putExtra("outputY", 90);
        }
        intent.putExtra("return-data", true);
        startActivityForResult(intent, PHOTO_CLIP);
    }

    View.OnClickListener OnClickListener_disensure=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            goToOtherClass(intent,ChooseHeadPortraitActivity.this, SetAccountNumberActivity.class,1);
        }
    };

    @Override
    public boolean onKeyDown(int KeyCode, KeyEvent keyEvent){
        if(KeyCode==keyEvent.KEYCODE_BACK){
            goToOtherClass(intent,ChooseHeadPortraitActivity.this, SetAccountNumberActivity.class,1);
        }
        return true;
    }
}
