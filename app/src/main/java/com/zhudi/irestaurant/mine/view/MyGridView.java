package com.zhudi.irestaurant.mine.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Created by zhudi on 2017/4/9.
 */
public class MyGridView extends GridView{
    public MyGridView(Context context){
        super(context);
    }
    public MyGridView(Context context, AttributeSet attributeSet){
        super(context,attributeSet);
    }
    public MyGridView(Context context,AttributeSet attributeSet,int defStyle){
        super(context,attributeSet,defStyle);
    }
    @Override
    protected void onMeasure(int widthMeasureSpec,int heightMeasureSpec){
        int heightSpec;
        if(getLayoutParams().height==LayoutParams.WRAP_CONTENT){
            heightSpec=MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE>>2,MeasureSpec.AT_MOST);
        }
        else {
            heightSpec=heightMeasureSpec;
        }
        super.onMeasure(widthMeasureSpec,heightSpec);
    }
}
