package com.customlife.app.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.customlife.app.AppManager;
import com.customlife.app.R;
import com.customlife.app.activity.one.MainActivity;
import com.customlife.app.base.BaseActivity;

import org.xutils.view.annotation.ViewInject;

/**
 * 选择身份
 * Created by Zeng on 2016/12/9.
 */

public class SelectRoleActivity extends BaseActivity {
    @ViewInject(R.id.role_layout_pyg)
    private LinearLayout pygLayout;
    @ViewInject(R.id.role_layout_jk)
    private LinearLayout jkLayout;
    @ViewInject(R.id.role_layout_shch)
    private LinearLayout shchLayout;
    @ViewInject(R.id.role_layout_random)
    private LinearLayout randomLayout;
    @Override
    protected int getContentView() {
        return R.layout.activity_select_role;
    }

    @Override
    protected void initVariable() {

    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        pygLayout.setOnClickListener(onClickListener);
        jkLayout.setOnClickListener(onClickListener);
        shchLayout.setOnClickListener(onClickListener);
        randomLayout.setOnClickListener(onClickListener);
    }

   View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            AppManager.getAppManager().finishAllActivity();
            switch (view.getId()){
                case R.id.role_layout_pyg:
                    intent2Activity(MainActivity.class);
                    break;
                case R.id.role_layout_jk:
                    intent2Activity(com.customlife.app.activity.two.MainActivity.class);
                    break;
                case R.id.role_layout_shch:
                    intent2Activity(com.customlife.app.activity.three.MainActivity.class);
                    break;
                case R.id.role_layout_random:
                    intent2Activity(MainActivity.class);
                    break;
            }
            finish();
        }
    };

    @Override
    protected void loadData() {

    }
}
