package com.zhudi.irestaurant.home.bean;

import java.io.Serializable;

/**
 * Created by zhudi on 2017/4/11.
 */
public class PickerBean  {
    private String showConetnt;

    private String flag;

    private String timedetail;

    private String peoplecount;

    private static  PickerBean pickerBean=null;

    public static PickerBean getInstance()
    {
        if(pickerBean==null)
        {
            pickerBean=new PickerBean();
        }
        return pickerBean;
    }

    public PickerBean()
    {
        super();
    }

    public void setShowConetnt(String showConetnt)
    {
        this.showConetnt=showConetnt;
    }

    public String getShowConetnt()
    {
        return showConetnt;
    }

    public void setFlag(String flag){this.flag=flag;}

    public String getFlag(){return flag;}

    public void setTimedetail(String timedetail){this.timedetail=timedetail;}

    public String getTimedetail(){return timedetail;}

    public void setPeoplecount(String peoplecount){this.peoplecount=peoplecount;}

    public String getPeoplecount(){return peoplecount;}
}
