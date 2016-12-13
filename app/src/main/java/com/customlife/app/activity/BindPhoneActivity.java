package com.customlife.app.activity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.customlife.app.AppConfig;
import com.customlife.app.R;
import com.customlife.app.activity.one.MainActivity;
import com.customlife.app.base.BaseActivity;
import com.customlife.app.utils.ActionbarBuilder;
import com.customlife.app.utils.SPUtils;

import org.xutils.view.annotation.ViewInject;

/**
 * Created by Zeng on 2016/12/8.
 */

public class BindPhoneActivity extends BaseActivity {
    @ViewInject(R.id.edit_phone)
    private EditText edit_phone;
    @ViewInject(R.id.edit_code)
    private EditText edit_code;
    @ViewInject(R.id.tv_code)
    private TextView tv_code;
    @ViewInject(R.id.btn_commit)
    private TextView btn_commit;
    @ViewInject(R.id.tv_title)
    private TextView title;

    int second = 60;
    private Runnable mTicker;

    @Override
    protected int getContentView() {
        return R.layout.activity_login_phone;
    }

    @Override
    protected void onResume() {
        super.onResume();
        if ((boolean)SPUtils.get(this, AppConfig.LOGIN_STATE, false)){
            finish();
        }
    }

    @Override
    protected void initVariable() {
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        new ActionbarBuilder(this).setTitleText("登录")
                .setLeftImage(R.drawable.icon_actionbar_arrow_left)
                .setLeftOnCilckListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        finish();
                    }
                });
        title.setText("为了您的账户安全，请绑定手机号");
        btn_commit.setText("确认");
        tv_code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setButtonStatus();
            }
        });
        btn_commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SPUtils.put(context, AppConfig.LOGIN_STATE, true);
                intent2Activity(MainActivity.class);

            }
        });
    }


    /**
     * 改变按钮状态
     */
    public void setButtonStatus() {
        tv_code.setEnabled(false);
        final Handler mHandler = new Handler();
        mTicker = new Runnable() {
            public void run() {
                if (second > 0) {
                    tv_code.setText("重新获取(" + second + "s)");
                    mHandler.postDelayed(this, 1000);
                    second--;
                } else if (second == 0) {
                    tv_code.setEnabled(true);
                    tv_code.setText("重新获取");
                    second = 60;
                }

            }
        };
        mTicker.run();
    }

    @Override
    protected void loadData() {

    }
}
