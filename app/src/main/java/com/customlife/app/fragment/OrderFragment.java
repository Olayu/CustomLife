package com.customlife.app.fragment;

import android.view.View;

import com.customlife.app.R;
import com.customlife.app.adapter.OrderAdapter;
import com.customlife.app.base.BaseListFragment;
import com.customlife.app.bean.Order;

import java.util.ArrayList;

/**
 * 订单
 * Created by Zeng on 2016/12/7.
 */
public class OrderFragment extends BaseListFragment {

    private OrderAdapter mAdapter;

    @Override
    protected void initVariable() {
        super.initVariable();
    }

    @Override
    protected void initViews(View view) {
        super.initViews(view);
        mAdapter = new OrderAdapter(getActivity(), R.layout.item_order);
        mListView.setAdapter(mAdapter);
        ArrayList<Order> arrayList = new ArrayList<>();
        for (int i=0;i<8;i++){
            arrayList.add(new Order());
        }
        mAdapter.setData(arrayList);
    }

    @Override
    protected void loadData() {
        super.loadData();
    }
}
