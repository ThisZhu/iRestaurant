package com.zhudi.irestaurant.mine.bean;

import android.graphics.Bitmap;

/**
 * Created by zhudi on 2017/4/25.
 */
public class AccountNumberBean {
    private Bitmap HeadBitmap;
    private Bitmap reHeadBitmap;
    private Bitmap BeijingBitmap;
    private Bitmap reBeijingBitmap;
    private String UserName;
    private String reUserName;
    private String AccountNumber;
    private String Word;
    private String reWord;
    private static AccountNumberBean accountNumberBean;

    public static AccountNumberBean getInstance(){
        if(accountNumberBean==null){
            accountNumberBean=new AccountNumberBean();
        }
        return accountNumberBean;
    }

    public void setHeadBitmap(Bitmap HeadBitmap){
        this.HeadBitmap=HeadBitmap;
    }

    public Bitmap getHeadBitmap(){
        return HeadBitmap;
    }

    public void setreHeadBitmap(Bitmap reHeadBitmap){
        this.reHeadBitmap=reHeadBitmap;
    }

    public Bitmap getreHeadBitmap(){
        return reHeadBitmap;
    }

    public void setBeijingBitmap(Bitmap BeijingBitmap){
        this.BeijingBitmap=BeijingBitmap;
    }

    public Bitmap getBeijingBitmap(){
        return BeijingBitmap;
    }

    public void setreBeijingBitmap(Bitmap reBeijingBitmap){
        this.reBeijingBitmap=reBeijingBitmap;
    }

    public Bitmap getreBeijingBitmap(){
        return reBeijingBitmap;
    }


    public void setUserName(String UserName){
        this.UserName=UserName;
    }

    public String getUserName(){
        return UserName;
    }

    public void setreUserName(String reUserName){
        this.reUserName=reUserName;
    }

    public String getreUserName(){
        return reUserName;
    }

    public void setAccountNumber(String AccountNumber){
        this.AccountNumber=AccountNumber;
    }

    public String getAccountNumber(){
        return AccountNumber;
    }

    public void setWord(String Word){
        this.Word=Word;
    }

    public String getWord(){
        return Word;
    }

    public void setreWord(String reWord){
        this.reWord=reWord;
    }

    public String getreWord(){
        return reWord;
    }
}
