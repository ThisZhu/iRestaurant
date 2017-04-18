package com.zhudi.irestaurant;

import android.app.Activity;
import android.content.Intent;

/**
 * Created by zhudi on 2017/4/18.
 */
public class BaseFragment extends android.support.v4.app.Fragment {
    public void goToOtherActivity(Intent intent, Activity activity, Class T, int i){
        intent.setClass(activity, T);
        activity.startActivity(intent);
        if(i==-1) {
            activity.overridePendingTransition(R.anim.start_to_left, R.anim.exit_no_change);
        }
        else if(i==1){
            activity.overridePendingTransition(R.anim.start_to_right, R.anim.exit_no_change);
        }
        activity.finish();
    }
}
