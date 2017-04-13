package com.zhudi.irestaurant.home.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.zhudi.irestaurant.R;
import com.zhudi.irestaurant.home.bean.PickerBean;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zhudi on 2017/4/11.
 */
public class DateChoose extends Activity {
    private CalendarView calendarView;
    private TextView textview_seat_select_date;
    private TextView textview_seat_select_date_show;
    private TextView textview_seat_select_people;
    private TextView textview_seat_select_people_show;
    private TextView textview_next_step;
    private String[] Ltime=new String[]{"中午","下午"};;
    private String[] Stime1=new String[]{"10:30","11:00","11:30","12:00","12:30","13:00","13:30"};
    private String[] Stime2=new String[]{"17:30","18:00","18:30","19:00","19:30","20:00","20:30"};
    private AlertDialog alertDialog;
    private AlertDialog alertDialog1;
    private AlertDialog alertDialog2;
    private AlertDialog alertDialog3;
    private AlertDialog alertDialog4;
    private EditText editText;
    private PickerBean pickerBean=PickerBean.getInstance();
    Handler handler= new Handler(){
        @Override
        public void handleMessage(Message msg){
            super.handleMessage(msg);
            String date=PickerBean.getInstance().getShowConetnt();
            Log.w("date1",date+":::"+ getSysNowDate());
        }

    };
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_date);
        initView();
        ititData();
        initListener();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        handler.removeCallbacksAndMessages(null);
    }
    public void initView(){
        final FrameLayout frameLayout=(FrameLayout) LayoutInflater.from(this).inflate(R.layout.view_calendar,null);
        calendarView=(CalendarView)frameLayout.findViewById(R.id.calenderview) ;
        editText=(EditText)LayoutInflater.from(this).inflate(R.layout.view_seat_choose_edit,null);
        textview_seat_select_date=(TextView)findViewById(R.id.textview_seat_select_date);
        textview_seat_select_date_show=(TextView)findViewById(R.id.textview_seat_select_date_show);
        textview_seat_select_people=(TextView)findViewById(R.id.textview_seat_select_people);
        textview_seat_select_people_show=(TextView)findViewById(R.id.textview_seat_select_people_show);
        textview_next_step=(TextView)findViewById(R.id.textview_next_step);
        textview_seat_select_date_show.setText(getSysNowDate()+ "，下午，18:00");
        alertDialog=new AlertDialog.Builder(DateChoose.this).setCancelable(false).create();
        alertDialog.setView(frameLayout);
        alertDialog1=new AlertDialog.Builder(DateChoose.this).setCancelable(false).setSingleChoiceItems(Ltime,1,onClickListener5).create();
        alertDialog2=new AlertDialog.Builder(DateChoose.this).setCancelable(false).setSingleChoiceItems(Stime1,1,onClickListener6).create();
        alertDialog3=new AlertDialog.Builder(DateChoose.this).setCancelable(false).setSingleChoiceItems(Stime2,1,onClickListener7).create();
        alertDialog4=new AlertDialog.Builder(DateChoose.this).setCancelable(false).create();
        alertDialog4.setTitle("请输入人数");
        alertDialog4.setView(editText);
    }

    public void ititData(){
        calendarView.setMinDate(System.currentTimeMillis());
        pickerBean.setShowConetnt(getSysNowDate());
        pickerBean.setFlag(Ltime[1]);
        pickerBean.setTimedetail(Stime2[1]);
        pickerBean.setPeoplecount("10人");
    }

    public void initListener(){
        calendarView.setOnDateChangeListener(onDateChangeListener);
        textview_seat_select_date.setOnClickListener(onClickListenerbutton1);
        textview_seat_select_people.setOnClickListener(onClickListenerbutton2);
        textview_next_step.setOnClickListener(onClickListenerbutton3);
        alertDialog.setButton2("取消",onClickListener);
        alertDialog.setButton("确定",onClickListener0);
        alertDialog1.setButton2("取消",onClickListener);
        alertDialog1.setButton("确定",onClickListener2);
        alertDialog2.setButton2("取消",onClickListener);
        alertDialog2.setButton("确定",onClickListener4);
        alertDialog3.setButton2("取消",onClickListener);
        alertDialog3.setButton("确定",onClickListener9);
        alertDialog4.setButton2("取消",onClickListener);
        alertDialog4.setButton("确定",onClickListener10);
    }

    public String getSysNowDate(){
        Date nowdate=new Date(System.currentTimeMillis());
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy年MM月dd日");
        String FormatNowdate=simpleDateFormat.format(nowdate);
        return FormatNowdate;
    }

    public void setFlag(int i){
        PickerBean.getInstance().setFlag(Ltime[i]);
    }

    public void setTimedetail(int i){
        if(PickerBean.getInstance().getFlag().equals(Ltime[0]))
        pickerBean.setTimedetail(Stime1[i]);
        pickerBean.setTimedetail(Stime2[i]);
    }

    public void changeTimeShow(){
        String date=pickerBean.getShowConetnt()+"，"+pickerBean.getFlag()+"，"+pickerBean.getTimedetail();
        textview_seat_select_date_show.setText(date);
    }

    CalendarView.OnDateChangeListener onDateChangeListener=new CalendarView.OnDateChangeListener(){
        @Override
        public void onSelectedDayChange(CalendarView calendarView, int year, int month, int day) {
            ++month;
            String date=year+"年"+month+"月"+day+"日";
            Log.w("date",date);
            PickerBean.getInstance().setShowConetnt(date);
            Message msg = new Message();
            handler.sendMessage(msg);
        }
    };

    View.OnClickListener onClickListenerbutton1=new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            alertDialog.show();
        }
    };

    View.OnClickListener onClickListenerbutton2=new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            alertDialog4.show();
        }
    };

    View.OnClickListener onClickListenerbutton3=new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            Intent intent=new Intent();
            intent.setClass(DateChoose.this,SeatChoose.class);
            DateChoose.this.finish();
            DateChoose.this.startActivity(intent);
            overridePendingTransition(R.anim.start_to_left,R.anim.exit_no_change);
        }
    };

    /**
     * 日期控件的取消事件
     */
    DialogInterface.OnClickListener onClickListener=new DialogInterface.OnClickListener(){
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {

        }
    };

    /**
     * 日期控件的确定事件
     */
    DialogInterface.OnClickListener onClickListener0=new DialogInterface.OnClickListener(){
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            alertDialog1.show();
        }
    };

    /**
     * 中午下午选择控件的确定事件
     */
    DialogInterface.OnClickListener onClickListener2=new DialogInterface.OnClickListener(){
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            Log.w("flag",PickerBean.getInstance().getFlag());
            if( PickerBean.getInstance().getFlag().equals(Ltime[0])){
                alertDialog2.show();
            }else {
                alertDialog3.show();
            }
        }
    };

    /**
     * 中午对应具体时间点选择控件的确定事件
     */
    DialogInterface.OnClickListener onClickListener4=new DialogInterface.OnClickListener(){
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            changeTimeShow();
        }
    };

    /**
     * 中午下午选择控件的item选择事件
     */
    DialogInterface.OnClickListener onClickListener5=new DialogInterface.OnClickListener(){
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            Log.w("i", String.valueOf(i));
            setFlag(i);
        }
    };


    /**
     * 中午具体时间点选择控件的item选择事件
     */
    DialogInterface.OnClickListener onClickListener6=new DialogInterface.OnClickListener(){
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            setTimedetail(i);
        }
    };

    /**
     * 下午具体时间点选择控件的item选择事件
     */
    DialogInterface.OnClickListener onClickListener7=new DialogInterface.OnClickListener(){
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            setTimedetail(i);
        }
    };

    /**
     * 下午对应具体时间点选择控件的确定事件
     */
    DialogInterface.OnClickListener onClickListener9=new DialogInterface.OnClickListener(){
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            changeTimeShow();
        }
    };

    /**
     * 人数输入控件的确定事件
     */
    DialogInterface.OnClickListener onClickListener10=new DialogInterface.OnClickListener(){
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            if(!editText.getText().toString().equals("")&&editText.getText()!=null) {
                pickerBean.setPeoplecount(editText.getText().toString());
                textview_seat_select_people_show.setText(pickerBean.getPeoplecount() + "人");
            }
        }
    };


}
