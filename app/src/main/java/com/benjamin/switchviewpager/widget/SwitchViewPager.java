package com.benjamin.switchviewpager.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * 项目： MyApplication
 * 包名： jbwl.myapplication.widget
 * 作者： chenbin 时间： 2017/2/14 14 39 .
 */


/**
 * 带开关的的viewpager
 */
public class SwitchViewPager extends ViewPager {
    private boolean isScrollable = true;//是否可滑动

    public SwitchViewPager(Context context) {
        super(context);
    }

    public SwitchViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public boolean isScrollable() {
        return isScrollable;
    }

    public void setScrollable(boolean scrollable) {
        isScrollable = scrollable;
    }


    @Override
    public boolean onTouchEvent(MotionEvent arg0) {
        if (isScrollable())
            return super.onTouchEvent(arg0);
        else
            return false;

    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent arg0) {
        if (isScrollable())
            return super.onInterceptTouchEvent(arg0);
        else
            return false;

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int viewHeight = 0;
        View childView = getChildAt(getCurrentItem());
        if (childView != null) {
            childView.measure(widthMeasureSpec, MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
            viewHeight = childView.getMeasuredHeight();
            heightMeasureSpec = MeasureSpec.makeMeasureSpec(viewHeight, MeasureSpec.EXACTLY);
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
    /**
     * int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
     * super.onMeasure(widthMeasureSpec, expandSpec);
     */
}
