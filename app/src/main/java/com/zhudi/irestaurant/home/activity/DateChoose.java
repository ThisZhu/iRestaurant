package com.zhudi.irestaurant.home.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.zhudi.irestaurant.R;
import com.zhudi.irestaurant.home.bean.PickerBean;
import com.zhudi.irestaurant.home.view.PickerScrollView;

import java.util.ArrayList;

/**
 * Created by zhudi on 2017/4/11.
 */
public class DateChoose extends Activity {
    private PickerScrollView pickerScrollView_1;
    private PickerScrollView pickerScrollView_2;
    private String[] id_1;
    private String[] id_2;
    private String[] name_1;
    private String[] name_2;
    private String[] name_3;
    private ArrayList<PickerBean> arrayList_1;
    private ArrayList<PickerBean> arrayList_2;
    private String SelectedTime_1_Id;
    private String SelectedTime_2_Id;
    private String SelectedTime_1_Content;
    private String SelectedTime_2_Content;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_date);
        initView();
        initData();
        initListener();
    }

    public void initView(){
        pickerScrollView_1=(PickerScrollView)findViewById(R.id.pickerview_1);
        pickerScrollView_2=(PickerScrollView)findViewById(R.id.pickerview_2);
    }

    public void initData(){
        arrayList_1=new ArrayList<PickerBean>();
        arrayList_2=new ArrayList<PickerBean>();
        id_1=new String[]{"1","2"};
        id_2=new String[]{"1","2","3"};
        name_1=new String[]{"中午","下午"};
        name_2=new String[]{"11:30","12:00","12:30"};
        name_3=new String[]{"6:00","7:00","8:00"};
        for (int i=0;i<name_1.length;i++){
            arrayList_1.add(new PickerBean(name_1[i],id_1[i]));
        }
        for (int i=0;i<name_2.length;i++){
            arrayList_2.add(new PickerBean(name_2[i],id_2[i]));
        }
        pickerScrollView_1.setData(arrayList_1);
        pickerScrollView_2.setData(arrayList_2);
        pickerScrollView_1.setSelected(0);
        pickerScrollView_2.setSelected(0);

    }

    public void initListener(){
        pickerScrollView_1.setOnSelectListener(onSelectListener_1);
    }

    PickerScrollView.onSelectListener onSelectListener_1=new PickerScrollView.onSelectListener() {
        @Override
        public void onSelect(PickerBean pickers) {
            if(pickers.getShowId().equals("1")) {
                changePickerScrollView_2(1);
                Log.w("getShowConetnt",pickers.getShowConetnt());
            }else {
                changePickerScrollView_2(2);
            }
        }
    };

    public void changePickerScrollView_2(int time){
        if(time==1){
            arrayList_2.clear();
            for (int i=0;i<name_2.length;i++){
                arrayList_2.add(new PickerBean(name_2[i],id_2[i]));
            }
            pickerScrollView_2.setData(arrayList_2);
            pickerScrollView_2.setSelected(0);
        }
        else {
            arrayList_2.clear();
            for (int i=0;i<name_3.length;i++){
                arrayList_2.add(new PickerBean(name_3[i],id_2[i]));
            }
            pickerScrollView_2.setData(arrayList_2);
            pickerScrollView_2.setSelected(0);
        }
    }
}
