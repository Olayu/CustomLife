package com.customlife.app.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Created by Zeng on 2016/12/5.
 */

public class UserGridView extends GridView {
    public UserGridView(Context context) {
        super(context);
    }

    public UserGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public UserGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(
                Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
