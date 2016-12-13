package com.customlife.app.activity.two;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.customlife.app.AppConfig;
import com.customlife.app.R;
import com.customlife.app.base.BaseFragmentActivity;
import com.customlife.app.utils.SPUtils;
import com.customlife.app.utils.two.FragmentController;

import org.xutils.view.annotation.ViewInject;

/**
 * 集客首页
 * Created by Zeng on 2016/11/26.
 */

public class MainActivity extends BaseFragmentActivity {

    private FragmentController controller;

    @ViewInject(R.id.rg_tab)
    private RadioGroup radioGroup;
    @ViewInject(R.id.rb_search)
    private RadioButton rb_search;
    @ViewInject(R.id.rb_money)
    private RadioButton rb_money;
    @ViewInject(R.id.rb_user)
    private RadioButton rb_user;

    @Override
    protected int getContentView() {
        return R.layout.activity_main_two;
    }

    @Override
    protected void initVariable() {
        SPUtils.put(this, AppConfig.MAIN_ACTIVITY, 2);
    }
    @Override
    protected void initViews(Bundle savedInstanceState) {
        controller = FragmentController.getInstance(this, R.id.fl_content);
        controller.showFragment(0);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.rb_search:
                        controller.showFragment(0);
                        break;
                    case R.id.rb_money:
                        controller.showFragment(1);
                        break;
                    case R.id.rb_user:
                        controller.showFragment(2);
                        break;
                }
            }
        });
        setDrawableTop();
    }

    public void setDrawableTop(){
        setDrawableTop(rb_search);
        setDrawableTop(rb_money);
        setDrawableTop(rb_user);
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        FragmentController.onDestroy();
    }
}
