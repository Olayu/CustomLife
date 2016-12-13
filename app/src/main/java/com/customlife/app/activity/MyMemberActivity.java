package com.customlife.app.activity;

import android.os.Bundle;
import android.view.View;

import com.customlife.app.R;
import com.customlife.app.base.BaseActivity;
import com.customlife.app.utils.ActionbarBuilder;

/**
 * Created by Zeng on 2016/12/7.
 */

public class MyMemberActivity extends BaseActivity {
    @Override
    protected int getContentView() {
        return R.layout.activity_my_member;
    }

    @Override
    protected void initVariable() {

    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        new ActionbarBuilder(this).setTitleText("我的会员")
                .setLeftImage(R.drawable.icon_actionbar_arrow_left)
                .setLeftOnCilckListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        finish();
                    }
                })
                .setRightText("会员权益")
                .setRightTextOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        intent2Activity(MemberRightActivity.class);
                    }
                });
    }

    @Override
    protected void loadData() {

    }
}
