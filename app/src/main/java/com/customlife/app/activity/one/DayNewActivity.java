package com.customlife.app.activity.one;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.customlife.app.R;
import com.customlife.app.adapter.DayNewAdapter;
import com.customlife.app.base.BaseActivity;
import com.customlife.app.bean.Bean;
import com.customlife.app.utils.ActionbarBuilder;
import com.handmark.pulltorefresh.library.PullToRefreshGridView;

import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;

/**
 * Created by Zeng on 2016/12/12.
 */

public class DayNewActivity extends BaseActivity {
    @ViewInject(R.id.gridview)
    private PullToRefreshGridView mGridView;

    private DayNewAdapter dayNewAdapter;
    private ArrayList<Bean> list;

    @Override
    protected int getContentView() {
        return R.layout.activity_day_new;
    }

    @Override
    protected void initVariable() {

    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        new ActionbarBuilder(this).setTitleText("今日新品")
                .setLeftImage(R.drawable.icon_actionbar_arrow_left)
                .setLeftOnCilckListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        finish();
                    }
                });
        dayNewAdapter = new DayNewAdapter(context, R.layout.item_activity_day_new);
        mGridView.setAdapter(dayNewAdapter);
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                showToast(""+l);
            }
        });
        list = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            list.add(new Bean());
        }
        dayNewAdapter.setData(list);
        dayNewAdapter.notifyDataSetChanged();
    }

    @Override
    protected void loadData() {

    }
}
