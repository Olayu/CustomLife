package com.customlife.app.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.WindowManager;

import com.customlife.app.AppConfig;
import com.customlife.app.R;
import com.customlife.app.base.BaseActivity;
import com.customlife.app.utils.SPUtils;

import org.xutils.x;

public class SplashActivity extends BaseActivity {
    private static final int TIME = 1500;
    private static final int GO_HOME = 1001;
    private static final int GO_GUIDE = 1002;

    @Override
    protected int getContentView() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initVariable() {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case GO_HOME:
                    intent2MainActivity();
                    finish();
                    break;
                case GO_GUIDE:
                    intent2Activity(LoginActivity.class);
                    finish();
                    break;
            }
        }
    };

    @Override
    protected void initViews(Bundle savedInstanceState) {
        x.view().inject(this);
        boolean state = (boolean)SPUtils.get(this, AppConfig.LOGIN_STATE, false);
        if (state) {
        handler.sendEmptyMessageDelayed(GO_HOME, TIME);
        } else {
            handler.sendEmptyMessageDelayed(GO_GUIDE, TIME);
        }
    }

    public void intent2MainActivity() {
        int m = (int)SPUtils.get(this, AppConfig.MAIN_ACTIVITY, 1);
        switch (m){
            case 1:
                intent2Activity(com.customlife.app.activity.one.MainActivity.class);
                break;
            case 2:
                intent2Activity(com.customlife.app.activity.two.MainActivity.class);
                break;
            case 3:
                intent2Activity(com.customlife.app.activity.three.MainActivity.class);
                break;
        }
    }

    @Override
    protected void loadData() {

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return true;
    }
}
