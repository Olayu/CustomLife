package com.customlife.app.adapter;

import android.content.Context;
import android.graphics.Color;
import android.widget.TextView;

import com.customlife.app.R;
import com.customlife.app.base.CommonAdapter;
import com.customlife.app.base.ViewHolder;
import com.customlife.app.bean.MenuBean;

import cz.msebera.android.httpclient.util.TextUtils;

/**
 * Created by Zeng on 2016/11/27.
 */

public class MenuAdapter extends CommonAdapter<MenuBean> {


    public MenuAdapter(Context context, int layoutId) {
        super(context, layoutId);
    }

    @Override
    public void convert(ViewHolder holder, MenuBean menuBean) {
        TextView textView = holder.getView(R.id.menu_tv);
        textView.setText(menuBean.getMenu());
        if (!TextUtils.isEmpty(menuBean.getTextColor())) {
            textView.setTextColor(Color.parseColor(menuBean.getTextColor()));
        }
        if (menuBean.getImage() != 0) {
            holder.setImageResource(R.id.menu_img, menuBean.getImage());
        }
    }

}
