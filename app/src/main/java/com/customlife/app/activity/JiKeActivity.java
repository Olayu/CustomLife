package com.customlife.app.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.customlife.app.R;
import com.customlife.app.base.BaseActivity;
import com.customlife.app.utils.ActionbarBuilder;
import com.customlife.app.utils.TextUtil;

import org.xutils.view.annotation.ViewInject;

/**
 * Created by Zeng on 2016/12/7.
 */

public class JiKeActivity extends BaseActivity {
    @ViewInject(R.id.tv_value)
    private TextView valueTv;
    @Override
    protected int getContentView() {
        return R.layout.activity_jike;
    }

    @Override
    protected void initVariable() {

    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        new ActionbarBuilder(this).setTitleText("集客模式").setLeftImage(R.drawable.icon_actionbar_arrow_left).setLeftOnCilckListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        valueTv.setText(TextUtil.readFromRaw(R.raw.jike));
    }

    @Override
    protected void loadData() {

    }
}
