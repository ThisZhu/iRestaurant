package com.zhudi.irestaurant.net;

import android.app.Activity;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.zhudi.irestaurant.CallBack;
import com.zhudi.irestaurant.home.fragment.HomeFragment;
import com.zhudi.irestaurant.order.fragment.OrderFragment;

/**
 * Created by zhudi on 2017/4/19.
 */
public class NETService extends Service implements CallBack {
    NetCallBack callBack;
    NetCallBack callBack1;
    private static NETService netService;

    public static NETService getInstance(){
        if (netService==null)
            netService=new NETService();
        return netService;
    }

    public NETService(){
        super();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate(){
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent,flags,startId);
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
    }

    Thread thread=new Thread(new Runnable() {
        @Override
        public void run() {
            callBack=(NetCallBack)OrderFragment.getInstance();
            callBack1=(NetCallBack)HomeFragment.getInstance();
            if(callBack!=null) {
                callBack.changeView();
                Log.w("service", "running");
            }
            if(callBack1!=null){
                callBack1.changeView();
            }

        }
    });

    @Override
    public void changeFragment(boolean isSign) {
            Log.e("thread",String.valueOf(thread.isAlive()));
            thread.start();
    }
}
