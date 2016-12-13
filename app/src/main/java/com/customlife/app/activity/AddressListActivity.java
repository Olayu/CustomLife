package com.customlife.app.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.customlife.app.R;
import com.customlife.app.base.BaseListActivity;
import com.customlife.app.utils.ActionbarBuilder;

import org.xutils.view.annotation.ViewInject;

/**
 * Created by Zeng on 2016/12/10.
 */

public class AddressListActivity extends BaseListActivity {
    @ViewInject(R.id.layout_address_add)
    private LinearLayout addLayout;

    @Override
    protected int getContentView() {
        return R.layout.activity_address_list;
    }

    @Override
    protected void initVariable() {
        super.initVariable();
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        super.initViews(savedInstanceState);
        new ActionbarBuilder(this).setTitleText("管理收货地址")
                .setLeftImage(R.drawable.icon_actionbar_arrow_left)
                .setLeftOnCilckListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        finish();
                    }
                });
        addLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent2Activity(AddressEditActivity.class);
            }
        });
    }

    @Override
    protected void loadData() {
        super.loadData();
    }
}
