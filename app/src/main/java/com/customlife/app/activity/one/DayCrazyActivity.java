package com.customlife.app.activity.one;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.customlife.app.R;
import com.customlife.app.adapter.DayCrazyAdapter;
import com.customlife.app.base.BaseListActivity;
import com.customlife.app.bean.Bean;
import com.customlife.app.utils.ActionbarBuilder;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;

/**
 * Created by Zeng on 2016/12/6.
 */

public class DayCrazyActivity extends BaseListActivity {
    @ViewInject(R.id.listview)
    private PullToRefreshListView mListView;

    private DayCrazyAdapter dayCrazyAdapter;
    private ArrayList<Bean> dayCrazyList;

    @Override
    protected void initVariable() {
        super.initVariable();
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        super.initViews(savedInstanceState);
        new ActionbarBuilder(this).setTitleText("每日疯抢")
                .setLeftImage(R.drawable.icon_actionbar_arrow_left)
                .setLeftOnCilckListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        finish();
                    }
                });
        dayCrazyAdapter = new DayCrazyAdapter(context, R.layout.item_day_crazy);
        mListView.setAdapter(dayCrazyAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                showToast(""+l);
            }
        });
        dayCrazyList = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            dayCrazyList.add(new Bean());
        }
        dayCrazyAdapter.setData(dayCrazyList);
        dayCrazyAdapter.notifyDataSetChanged();
    }

    @Override
    protected void loadData() {
        super.loadData();
    }

}
