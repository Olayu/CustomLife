package com.customlife.app.activity.one;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.customlife.app.AppConfig;
import com.customlife.app.R;
import com.customlife.app.base.BaseFragmentActivity;
import com.customlife.app.utils.SPUtils;
import com.customlife.app.utils.one.FragmentController;

import org.xutils.view.annotation.ViewInject;

/**
 * Created by Zeng on 2016/11/26.
 */

public class MainActivity extends BaseFragmentActivity {

    private FragmentController controller;

    @ViewInject(R.id.rg_tab)
    private RadioGroup radioGroup;
    @ViewInject(R.id.rb_home)
    private RadioButton rb_home;
    @ViewInject(R.id.rb_vicinity)
    private RadioButton rb_vicinity;
    @ViewInject(R.id.rb_cart)
    private RadioButton rb_cart;
    @ViewInject(R.id.rb_user)
    private RadioButton rb_user;

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void initVariable() {
        SPUtils.put(this, AppConfig.MAIN_ACTIVITY, 1);
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        controller = FragmentController.getInstance(this, R.id.fl_content);
        controller.showFragment(0);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.rb_home:
                        controller.showFragment(0);
                        break;
                    case R.id.rb_vicinity:
                        controller.showFragment(1);
                        break;
                    case R.id.rb_cart:
                        controller.showFragment(2);
                        break;
                    case R.id.rb_user:
                        controller.showFragment(3);
                        break;
                }
            }
        });
        setDrawableTop();
    }

    public void setDrawableTop(){
        setDrawableTop(rb_home);
        setDrawableTop(rb_vicinity);
        setDrawableTop(rb_cart);
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
