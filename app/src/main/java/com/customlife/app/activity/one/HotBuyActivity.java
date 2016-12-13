package com.customlife.app.activity.one;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.customlife.app.R;
import com.customlife.app.adapter.HotBuyAdapter;
import com.customlife.app.base.BaseListActivity;
import com.customlife.app.bean.Bean;
import com.customlife.app.utils.ActionbarBuilder;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;

/**
 * Created by Zeng on 2016/12/12.
 */

public class HotBuyActivity extends BaseListActivity {
    @ViewInject(R.id.listview)
    private PullToRefreshListView mListView;
    private HotBuyAdapter adapter;
    private ArrayList<Bean> list;

    @Override
    protected void initVariable() {
        super.initVariable();
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        super.initViews(savedInstanceState);
        new ActionbarBuilder(this).setTitleText("超值热购")
                .setLeftImage(R.drawable.icon_actionbar_arrow_left)
                .setLeftOnCilckListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        finish();
                    }
                });
        adapter = new HotBuyAdapter(context, R.layout.item_hot_buy);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                showToast(""+l);
            }
        });
        list = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            list.add(new Bean());
        }
        adapter.setData(list);
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void loadData() {
        super.loadData();
    }
}
