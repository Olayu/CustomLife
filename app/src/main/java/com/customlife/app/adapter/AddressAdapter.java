package com.customlife.app.adapter;

import android.content.Context;

import com.customlife.app.R;
import com.customlife.app.base.CommonAdapter;
import com.customlife.app.base.ViewHolder;

/**
 * Created by Zeng on 2016/12/10.
 */

public class AddressAdapter extends CommonAdapter<String> {

    public AddressAdapter(Context context, int layoutId) {
        super(context, layoutId);
    }

    @Override
    public void convert(ViewHolder holder, String s) {
        holder.setText(R.id.tv_address,s);
    }
}
