package com.zhudi.irestaurant.home.bean;

import java.io.Serializable;

/**
 * Created by zhudi on 2017/4/11.
 */
public class PickerBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private String showConetnt;
    private String showId;
    public String getShowConetnt() {
        return showConetnt;
    }

    public String getShowId() {
        return showId;
    }

    public PickerBean(String showConetnt, String showId) {
        super();
        this.showConetnt = showConetnt;
        this.showId = showId;
    }

    public PickerBean() {
        super();
    }
}
