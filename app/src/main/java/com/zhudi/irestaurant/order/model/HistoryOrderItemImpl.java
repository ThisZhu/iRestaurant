package com.zhudi.irestaurant.order.model;

import com.zhudi.irestaurant.order.bean.FoodBean;
import com.zhudi.irestaurant.order.bean.HistoryOrdeItemBean;

import java.util.ArrayList;

/**
 * Created by zhudi on 2017/4/18.
 */
public class HistoryOrderItemImpl implements IHistoryOrderItem {
    private String seat_count;
    private String date;
    private int people_count;
    private String food_first_name;
    private int food_first_count;
    private float price1;
    private float price2;
    private ArrayList<String> seat_counts;
    private ArrayList<FoodBean> foods;

    @Override
    public void setHistoryOrderItemBean(String seat_count, String date,int people_count,String food_first_name,
                                        int food_first_count,float price1,float price2,
                                        ArrayList<String> seat_counts,ArrayList<FoodBean> foods) {
        this.seat_count=seat_count;
        this.date=date;
        this.people_count=people_count;
        this.food_first_name=food_first_name;
        this.food_first_count=food_first_count;
        this.price1=price1;
        this.price2=price2;
        this.seat_counts=seat_counts;
        this.foods=foods;
    }

    @Override
    public HistoryOrdeItemBean getHistoryOrderItemBean() {
        return HistoryOrdeItemBean.getHistoryOrdeItemBeanInstance();
    }
}
