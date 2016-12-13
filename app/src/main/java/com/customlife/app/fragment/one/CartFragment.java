package com.customlife.app.fragment.one;

import android.view.View;

import com.customlife.app.R;
import com.customlife.app.base.BaseFragment;
import com.customlife.app.utils.ActionbarBuilder;

import org.xutils.view.annotation.ContentView;

/**
 * 购物车
 * <p>
 * Created by Zeng on 2016/11/26.
 */

@ContentView(R.layout.fragment_cart)
public class CartFragment extends BaseFragment {

    @Override
    protected void initVariable() {

    }

    @Override
    protected void initViews(View view) {
        new ActionbarBuilder(view).setTitleText("购物车").setRightText("编辑").setRightTextOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast("编辑");
            }
        });
    }

    @Override
    protected void loadData() {

    }
}
