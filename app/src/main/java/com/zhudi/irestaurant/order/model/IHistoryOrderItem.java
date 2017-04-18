package com.zhudi.irestaurant.order.model;

import com.zhudi.irestaurant.order.bean.FoodBean;
import com.zhudi.irestaurant.order.bean.HistoryOrdeItemBean;

import java.util.ArrayList;

/**
 * Created by zhudi on 2017/4/18.
 */
public interface IHistoryOrderItem {
    void setHistoryOrderItemBean(String seat_count, String date, int people_count, String food_first_name,
                                 int food_first_count, float price1, float price2,
                                 ArrayList<String> seat_counts, ArrayList<FoodBean> foods);
    HistoryOrdeItemBean getHistoryOrderItemBean();
}
