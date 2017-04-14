package com.zhudi.irestaurant;

import android.content.DialogInterface;
import android.view.View;

/**
 * Created by zhudi on 2017/4/13.
 */
public interface IActivity {
    void initView();
    void initData();
    void initListener();

    class DiaListener implements DialogInterface.OnClickListener{
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    class ViewListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
        }
    }
}

