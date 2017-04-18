package com.zhudi.irestaurant.order.presenter;

import android.content.Context;

import com.zhudi.irestaurant.order.bean.HistoryOrdeItemBean;
import com.zhudi.irestaurant.order.model.HistoryOrderItemModel;

/**
 * Created by zhudi on 2017/4/18.
 */
public class HistoryOrderItemPresenter implements HistoryOrderItemModel {
    public HistoryOrdeItemBean historyOrdeItemBean=HistoryOrdeItemBean.getHistoryOrdeItemBeanInstance();
    private Context context;
    public HistoryOrderItemPresenter(Context context){
        this.context=context;
    }

    @Override
    public void setHistoryOrderItemBean() {

    }

    @Override
    public HistoryOrdeItemBean getHistoryOrderItemBean() {
        return historyOrdeItemBean;
    }
}
