package com.zhudi.irestaurant.home.bean;

import android.media.Image;

/**
 * Created by zhudi on 2017/4/3.
 */
public class ImageBean {
    private String title;
    private String description;
    private String url;
    public void setTitle(String title){
        this.title=title;
    }
    public  void setDescription(String description){
        this.description=description;
    }
    public void setUrl(String url){
        this.url=url;
    }
    public String getTitle(){
        return title;
    }
    public String getDescription(){
        return description;
    }
    public String getUrl(){
        return url;
    }
}
