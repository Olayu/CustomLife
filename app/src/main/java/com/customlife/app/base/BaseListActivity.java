package com.customlife.app.base;

import android.os.Bundle;

import com.customlife.app.R;

/**
 * Created by Zeng on 2016/12/6.
 */

public abstract class BaseListActivity extends BaseActivity {
    @Override
    protected int getContentView() {
        return R.layout.activity_base_list;
    }

    @Override
    protected void initVariable() {

    }

    @Override
    protected void initViews(Bundle savedInstanceState) {

    }

    @Override
    protected void loadData() {

    }

}
