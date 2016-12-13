package com.customlife.app.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.customlife.app.R;
import com.customlife.app.base.BaseActivity;
import com.customlife.app.utils.ActionbarBuilder;
import com.customlife.app.utils.TDevice;

import org.xutils.view.annotation.ViewInject;

/**
 * Created by Zeng on 2016/12/5.
 */

public class AboutActivity extends BaseActivity {
    @ViewInject(R.id.about_tv_version)
    private TextView versionTv;


    @Override
    protected int getContentView() {
        return R.layout.activity_about;
    }

    @Override
    protected void initVariable() {

    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        new ActionbarBuilder(this)
                .setTitleText("关于我们")
                .setLeftImage(R.drawable.icon_actionbar_arrow_left)
                .setLeftOnCilckListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        versionTv.setText("当前版本："+ TDevice.getVersionName());
    }

    @Override
    protected void loadData() {

    }
}
