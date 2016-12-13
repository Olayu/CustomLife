package com.customlife.app.activity;

import android.os.Bundle;
import android.view.View;

import com.customlife.app.R;
import com.customlife.app.base.BaseActivity;
import com.customlife.app.utils.ActionbarBuilder;

/**
 * Created by Zeng on 2016/12/6.
 */

public class SettingActivity extends BaseActivity {
    @Override
    protected int getContentView() {
        return R.layout.activity_setting;
    }

    @Override
    protected void initVariable() {

    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        new ActionbarBuilder(this).setTitleText("个人信息设置")
                .setLeftImage(R.drawable.icon_actionbar_arrow_left)
                .setLeftOnCilckListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        finish();
                    }
                })
        .setRightText("提交").setRightTextOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast("提交");
            }
        });
    }

    @Override
    protected void loadData() {

    }
}
