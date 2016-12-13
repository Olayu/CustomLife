package com.customlife.app.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.customlife.app.R;
import com.customlife.app.base.CommonAdapter;
import com.customlife.app.base.ViewHolder;
import com.customlife.app.bean.Bean;

/**
 * Created by Zeng on 2016/12/12.
 */

public class DayCrazyAdapter extends CommonAdapter<Bean> {

    public DayCrazyAdapter(Context context, int layoutId) {
        super(context, layoutId);
    }

    @Override
    public void convert(ViewHolder holder, Bean bean) {
        TextView tv_original_price = holder.getView(R.id.tv_market_price);
        tv_original_price.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        ImageView cartImg = holder.getView(R.id.img_cart);
        cartImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast("功能尚未实现");
            }
        });
    }
}
