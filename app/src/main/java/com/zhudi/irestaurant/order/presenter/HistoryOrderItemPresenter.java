package com.zhudi.irestaurant.order.presenter;

import android.content.Context;
import android.view.View;

import com.zhudi.irestaurant.order.bean.HistoryOrdeItemBean;
import com.zhudi.irestaurant.order.fragment.OrderFragment;
import com.zhudi.irestaurant.order.model.IHistoryOrderItem;

/**
 * Created by zhudi on 2017/4/18.
 */
public class HistoryOrderItemPresenter  {
    public HistoryOrdeItemBean historyOrdeItemBean=HistoryOrdeItemBean.getHistoryOrdeItemBeanInstance();
    IHistoryOrderItem iHistoryOrderItem;
    private View view;
    private Context context;
    private OrderFragment orderFragment;
    public HistoryOrderItemPresenter(Context context,OrderFragment orderFragment){
        this.context=context;
        this.orderFragment=orderFragment;
    }
    public void changeListView(){

    }
}
