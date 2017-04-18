package com.zhudi.irestaurant.order.bean;

/**
 * Created by zhudi on 2017/4/18.
 */
public class FoodBean {
    private String food_name;
    private int food_count;
    public void setFood_name(String food_name){
        this.food_name=food_name;
    }

    public String getFood_name(){
        return food_name;
    }

    public void setFood_count(int food_count){
        this.food_count=food_count;
    }

    public int getFood_count(){
        return food_count;
    }
}