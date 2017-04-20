package com.zhudi.irestaurant.net;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
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

    Thread thread_home=new Thread(new Runnable() {
        @Override
        public void run() {
            //先判断内存中是否有数据，再判断磁盘中是否有缓存，如果有，直接下一步，否则请求网络数据
            notifyChangeView(1);
            notifySaveToMemory();//如果不需要网络请求，直接跳过该步骤
            notifySaveToDisk();//如果不需要缓存到磁盘，直接跳过该步骤
        }
    });

    Thread thread_order=new Thread(new Runnable() {
        @Override
        public void run() {
            //先判断内存中是否有数据，再判断磁盘中是否有缓存，如果有，直接下一步，否则请求网络数据
            notifyChangeView(2);
            notifySaveToMemory();//如果不需要网络请求，直接跳过该步骤
            notifySaveToDisk();//如果不需要缓存到磁盘，直接跳过该步骤
        }
    });

    Thread thread_mine=new Thread(new Runnable() {
        @Override
        public void run() {
            //先判断内存中是否有数据，再判断磁盘中是否有缓存，如果有，直接下一步，否则请求网络数据
            notifyChangeView(3);
            notifySaveToMemory();//如果不需要网络请求，直接跳过该步骤
            notifySaveToDisk();//如果不需要缓存到磁盘，直接跳过该步骤
        }
    });

    public void notifyChangeView(int i){
        switch (i){
            case 1:
            {
                callBack1=(NetCallBack)HomeFragment.getInstance();
                if(callBack1!=null)
                    callBack1.changeView();
                break;
            }
            case 2:
            {
                callBack=(NetCallBack)OrderFragment.getInstance();
                if(callBack!=null)
                    callBack.changeView();
                Log.w("service", "running");
                break;
            }
            case 3:
            {
                break;
            }
            default:
                break;
        }
    }

    public void notifySaveToMemory(){}

    public void notifySaveToDisk(){}

    @Override
    public void changeFragment(boolean isSign) {
        Log.e("thread",String.valueOf(thread_home.isAlive()));
        thread_home.start();
        thread_order.start();
        thread_mine.start();
    }
}
