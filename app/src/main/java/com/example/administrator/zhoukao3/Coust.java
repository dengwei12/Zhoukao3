package com.example.administrator.zhoukao3;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;


public class Coust extends FrameLayout{
    //定义一个ViewDragHelper参数
    private ViewDragHelper vdh;
    //定义两个View布局
    private View mView1,mView2;
    //构造
    public Coust(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        //写入一个方法
        initView();
    }
    //设置宽高的方法
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    private void initView() {
        //实例化ViewDragHelper
        vdh =ViewDragHelper.create(this,new ViewDragHelper.Callback(){

            //给出判断
            @Override
            public boolean tryCaptureView(View child, int pointerId) {
                return child ==mView1||child==mView2;
            }
            //设置高
            @Override
            public int clampViewPositionVertical(View child, int top, int dy) {
                return top;
            }
            //设置宽
            @Override
            public int clampViewPositionHorizontal(View child, int left, int dx) {
                return left;
            }
        });
    }

    //显示布局
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mView1 =getChildAt(0);
        mView2 =getChildAt(1);
    }

    //下面两个是布局能拖动的方法
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        vdh.processTouchEvent(event);
        return true;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return vdh.shouldInterceptTouchEvent(ev);
    }
}
