package com.zhudi.irestaurant.home.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.zhudi.irestaurant.home.bean.PickerBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by zhudi on 2017/4/11.
 */
public class PickerScrollView extends View{
    public static final String TAG = "PickerView";
    /**
     * text之间间距和minTextSize之比
     */
    public static final float MARGIN_ALPHA = 2.8f;
    /**
     * 自动回滚到中间的速度
     */
    public static final float SPEED = 2;
    private List<PickerBean> mDataList;
    /**
     * 选中的位置，这个位置是mDataList的中心位置，一直不变
     */
    private int mCurrentSelected;
    private Paint mPaint;
    private float mMaxTextSize = 20;
    private float mMinTextSize = 10;
    private float mMaxTextAlpha = 255;
    private float mMinTextAlpha = 120;
    private int mColorText = 0x333333;
    private int mViewHeight;
    private int mViewWidth;
    private float mLastDownY;
    /**
     * 滑动的距离
     */
    private float moveLen = 0;
    private boolean isInit = false;
    private onSelectListener mSelectListener;
    private Timer timer;
    private MyTimerTask mTask;
    Handler updateHandler=new Handler(){
        @Override
        public void handleMessage(Message msg){
            if(Math.abs(moveLen)<SPEED){
                moveLen=0;
                if(mTask!=null){
                    mTask.cancel();
                    mTask=null;
                    performSelect();
                }
            } else {
                moveLen=moveLen-moveLen/Math.abs(moveLen)*SPEED;
            }
            //刷新View
            invalidate();
        }
    };

    public PickerScrollView(Context context) {
        super(context);
        init();
    }

    public PickerScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public void setData(List<PickerBean> datas) {
        mDataList = datas;
        mCurrentSelected = datas.size() / 2;
        invalidate();
    }

    private void performSelect() {
        if (mSelectListener != null)
            mSelectListener.onSelect(mDataList.get(mCurrentSelected));
    }

    /**
     * 选择选中的item的index
     *
     * @param selected
     */
    public void setSelected(int selected) {
        mCurrentSelected = selected;
        int distance = mDataList.size() / 2 - mCurrentSelected;
        if (distance < 0)
            for (int i = 0; i < -distance; i++) {
                moveHeadToTail();
                mCurrentSelected--;
            }
        else if (distance > 0)
            for (int i = 0; i < distance; i++) {
                moveTailToHead();
                mCurrentSelected++;
            }
        invalidate();
    }

    /**
     * 选择选中的内容
     *
     * @param mSelectItem
     */
    public void setSelected(String mSelectItem) {
        for (int i = 0; i < mDataList.size(); i++)
            if (mDataList.get(i).equals(mSelectItem)) {
                setSelected(i);
                break;
            }
    }

    public void setOnSelectListener(onSelectListener listener) {
        mSelectListener = listener;
    }

    private void moveHeadToTail() {
        PickerBean head = mDataList.get(0);
        mDataList.remove(0);
        mDataList.add(head);
    }

    private void moveTailToHead() {
        PickerBean tail = mDataList.get(mDataList.size() - 1);
        mDataList.remove(mDataList.size() - 1);
        mDataList.add(0, tail);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mViewHeight = getMeasuredHeight();
        mViewWidth = getMeasuredWidth();
        // 按照View的高度计算字体大小
        mMaxTextSize = mViewHeight / 8.0f;
        mMinTextSize = mMaxTextSize / 2f;
        isInit = true;
        invalidate();
    }

    private void init() {
        timer = new Timer();
        mDataList = new ArrayList<PickerBean>();
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setTextAlign(Paint.Align.CENTER);
        mPaint.setColor(mColorText);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 根据index绘制view
        if (isInit)
            drawData(canvas);
    }

    private void drawData(Canvas canvas) {
        // 先绘制选中的text再往上往下绘制其余的text
        float scale = parabola(mViewHeight / 4.0f, moveLen);
        float size = (mMaxTextSize - mMinTextSize) * scale + mMinTextSize;
        mPaint.setTextSize(size);
        mPaint.setAlpha((int) ((mMaxTextAlpha - mMinTextAlpha) * scale + mMinTextAlpha));
        // text居中绘制，注意baseline的计算才能达到居中，y值是text中心坐标
        float x = (float) (mViewWidth / 2.0);
        float y = (float) (mViewHeight / 2.0 + moveLen);
        Paint.FontMetricsInt fmi = mPaint.getFontMetricsInt();
        float baseline = (float) (y - (fmi.bottom / 2.0 + fmi.top / 2.0));
        int indexs = mCurrentSelected;
        String textData = mDataList.get(indexs).getShowConetnt();
        canvas.drawText(textData, x, baseline, mPaint);
        // 绘制上方data
        for (int i = 1; (mCurrentSelected - i) >= 0; i++) {
            drawOtherText(canvas, i, -1);
        }
        // 绘制下方data
        for (int i = 1; (mCurrentSelected + i) < mDataList.size(); i++) {
            drawOtherText(canvas, i, 1);
        }
    }

    /**
     * @param canvas
     * @param position
     *            距离mCurrentSelected的差值
     * @param type
     *            1表示向下绘制，-1表示向上绘制
     */
    private void drawOtherText(Canvas canvas, int position, int type) {
        float d = (float) (MARGIN_ALPHA * mMinTextSize * position + type
                * moveLen);
        float scale = parabola(mViewHeight / 4.0f, d);
        float size = (mMaxTextSize - mMinTextSize) * scale + mMinTextSize;
        mPaint.setTextSize(size);
        mPaint.setAlpha((int) ((mMaxTextAlpha - mMinTextAlpha) * scale + mMinTextAlpha));
        float y = (float) (mViewHeight / 2.0 + type * d);
        Paint.FontMetricsInt fmi = mPaint.getFontMetricsInt();
        float baseline = (float) (y - (fmi.bottom / 2.0 + fmi.top / 2.0));
        int indexs = mCurrentSelected + type * position;
        String textData = mDataList.get(indexs).getShowConetnt();
        canvas.drawText(textData, (float) (mViewWidth / 2.0), baseline, mPaint);
    }

    /**
     * 抛物线
     *
     * @param zero
     *            零点坐标
     * @param x
     *            偏移量
     * @return scale
     */
    private float parabola(float zero, float x) {
        float f = (float) (1 - Math.pow(x / zero, 2));
        return f < 0 ? 0 : f;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
                doDown(event);
                break;
            case MotionEvent.ACTION_MOVE:
                doMove(event);
                break;
            case MotionEvent.ACTION_UP:
                doUp(event);
                break;
        }
        return true;
    }

    private void doDown(MotionEvent event) {
        if (mTask != null) {
            mTask.cancel();
            mTask = null;
        }
        mLastDownY = event.getY();
    }

    private void doMove(MotionEvent event) {
        moveLen += (event.getY() - mLastDownY);
        if (moveLen > MARGIN_ALPHA * mMinTextSize / 2) {
            // 往下滑超过离开距离
            moveTailToHead();
            moveLen = MARGIN_ALPHA * mMinTextSize;
        } else if (moveLen < -MARGIN_ALPHA * mMinTextSize / 2) {
            // 往上滑超过离开距离
            moveHeadToTail();
            moveLen = MARGIN_ALPHA * mMinTextSize;
        }
        mLastDownY = event.getY();
        invalidate();
    }

    private void doUp(MotionEvent event) {
        // 抬起手后mCurrentSelected的位置由当前位置move到中间选中位置
        if (Math.abs(moveLen) < 0.0001) {
            moveLen = 0;
            return;
        }
        if (mTask != null) {
            mTask.cancel();
            mTask = null;
        }
        mTask = new MyTimerTask(updateHandler);
        timer.schedule(mTask, 0, 10);
    }

    class MyTimerTask extends TimerTask {
        Handler handler;

        public MyTimerTask(Handler handler) {
            this.handler = handler;
        }

        @Override
        public void run() {
            handler.sendMessage(handler.obtainMessage());
        }

    }

    public interface onSelectListener {
        void onSelect(PickerBean pickers);
    }
}

