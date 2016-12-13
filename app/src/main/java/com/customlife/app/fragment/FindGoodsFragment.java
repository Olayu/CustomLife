package com.customlife.app.fragment;

import android.view.View;

import com.customlife.app.R;
import com.customlife.app.base.BaseFragment;
import com.customlife.app.utils.ActionbarBuilder;

import org.xutils.view.annotation.ContentView;

/**
 * Created by Zeng on 2016/12/9.
 */
@ContentView(R.layout.fragment_find_goods)
public class FindGoodsFragment extends BaseFragment {
    @Override
    protected void initVariable() {

    }

    @Override
    protected void initViews(View view) {
        new ActionbarBuilder(view).setTitleText("集客找货");
    }

    @Override
    protected void loadData() {

    }
}
