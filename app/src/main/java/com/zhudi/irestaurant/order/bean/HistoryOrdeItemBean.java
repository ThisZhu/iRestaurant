package com.zhudi.irestaurant.order.bean;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by zhudi on 2017/4/18.
 */
public class HistoryOrdeItemBean {
    private String seat_count;
    private String date;
    private int people_count;
    private String food_first_name;
    private int food_first_count;
    private float price1;
    private float price2;
    private ArrayList<String> seat_counts;
    private ArrayList<Food> foods;
    private static HistoryOrdeItemBean historyOrdeItemBean;

    public static HistoryOrdeItemBean getHistoryOrdeItemBeanInstance(){
        if(historyOrdeItemBean==null){
            historyOrdeItemBean=new HistoryOrdeItemBean();
        }
        return historyOrdeItemBean;
    }

    public void setSeat_count(String seat_count){
        this.seat_count=seat_count;
    }

    public String getSeat_count(){
        return seat_count;
    }

    public void setDate(String date){
        this.date=date;
    }

    public String getDate(){
        return date;
    }

    public void setPeople_count(int people_count){
        this.people_count=people_count;
    }

    public int getPeople_count(){
        return people_count;
    }

    public void setFood_first_name(String food_first_name){
        this.food_first_name=food_first_name;
    }

    public String getFood_first_name(){
        return food_first_name;
    }

    public void setFood_first_count(int food_first_count){
        this.food_first_count=food_first_count;
    }

    public int getFood_first_count(){
        return food_first_count;
    }

    public void setPrice1(float price1){
        this.price1=price1;
    }

    public float getPrice1(){
        return price1;
    }

    public void setPrice2(float price2){
        this.price2=price2;
    }

    public float getPrice2(){
        return price2;
    }

    public void setSeat_counts(ArrayList<String> seat_counts){
        this.seat_counts=seat_counts;
    }

    public ArrayList<String> getSeat_counts(){
        return seat_counts;
    }

    public void setFoods(ArrayList<Food> foods){
        this.foods=foods;
    }

    public ArrayList<Food> getFoods(){
        return foods;
    }

    class Food {
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


}
