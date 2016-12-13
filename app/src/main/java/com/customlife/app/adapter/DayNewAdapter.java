package com.customlife.app.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.customlife.app.R;
import com.customlife.app.base.CommonAdapter;
import com.customlife.app.base.ViewHolder;
import com.customlife.app.bean.Bean;
import com.customlife.app.utils.TDevice;

/**
 * Created by Zeng on 2016/12/12.
 */
public class DayNewAdapter extends CommonAdapter<Bean> {

    public DayNewAdapter(Context context, int layoutId) {
        super(context, layoutId);
    }

    @Override
    public void convert(ViewHolder holder, Bean bean) {
        ImageView goodsImg = holder.getView(R.id.img_goods);
        int width = (int) (TDevice.getScreenWidth() - TDevice.dp2px(64)) / 2;
        goodsImg.setLayoutParams(new LinearLayout.LayoutParams(width, width));
    }
}
