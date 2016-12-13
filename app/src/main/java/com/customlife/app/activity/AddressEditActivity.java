package com.customlife.app.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.customlife.app.R;
import com.customlife.app.base.BaseActivity;
import com.customlife.app.utils.ActionbarBuilder;

/**
 * Created by Zeng on 2016/12/10.
 */

public class AddressEditActivity extends BaseActivity {
    private String title = "";

    @Override
    protected int getContentView() {
        return R.layout.activity_address_edit;
    }

    @Override
    protected void initVariable() {
        Intent in = getIntent();
        if (in.getIntExtra("type", 0) == 0) {
            title = "新建收货地址";
        }else{
            title = "编辑收货地址";
        }
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        new ActionbarBuilder(this).setTitleText(title)
        .setLeftImage(R.drawable.icon_actionbar_arrow_left)
        .setLeftOnCilckListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected void loadData() {

    }
}
