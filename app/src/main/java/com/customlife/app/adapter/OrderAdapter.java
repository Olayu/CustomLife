package com.customlife.app.adapter;

import android.content.Context;

import com.customlife.app.base.CommonAdapter;
import com.customlife.app.base.ViewHolder;
import com.customlife.app.bean.Order;

/**
 * Created by Zeng on 2016/12/7.
 */

public class OrderAdapter extends CommonAdapter<Order> {

    public OrderAdapter(Context context, int layoutId) {
        super(context, layoutId);
    }

    @Override
    public void convert(ViewHolder holder, Order order) {

    }
}
