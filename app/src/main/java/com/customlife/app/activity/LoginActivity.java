package com.customlife.app.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.customlife.app.AppConfig;
import com.customlife.app.R;
import com.customlife.app.base.BaseActivity;
import com.customlife.app.utils.SPUtils;

import org.xutils.view.annotation.ViewInject;

/**
 * Created by Zeng on 2016/12/8.
 */

public class LoginActivity extends BaseActivity {
    @ViewInject(R.id.layout_wx_login)
    private LinearLayout btn_wx;
    @ViewInject(R.id.layout_phone_login)
    private LinearLayout btn_phone;

    @Override
    protected void onResume() {
        super.onResume();
        if ((boolean)SPUtils.get(this, AppConfig.LOGIN_STATE, false)){
            finish();
        }
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_login;
    }

    @Override
    protected void initVariable() {

    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        btn_wx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent2Activity(BindPhoneActivity.class);
            }
        });
        btn_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent2Activity(LoginPhoneActivity.class);
            }
        });
    }

    @Override
    protected void loadData() {

    }
}
