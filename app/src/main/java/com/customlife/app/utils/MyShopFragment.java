package com.customlife.app.utils;

import android.view.View;
import android.widget.LinearLayout;

import com.customlife.app.R;
import com.customlife.app.base.BaseFragment;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

/**
 * Created by Zeng on 2016/12/9.
 */
@ContentView(R.layout.fragment_my_shop)
public class MyShopFragment extends BaseFragment {
    @ViewInject(R.id.layout_delivery)
    private LinearLayout deliveryLayout;
    @ViewInject(R.id.layout_record)
    private LinearLayout recordLayout;
    @Override
    protected void initVariable() {

    }

    @Override
    protected void initViews(View view) {
        deliveryLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast("付货");
            }
        });
        recordLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast("记录");
            }
        });
    }

    @Override
    protected void loadData() {

    }
}
