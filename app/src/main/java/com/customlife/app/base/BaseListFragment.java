package com.customlife.app.base;

import android.view.View;

import com.customlife.app.R;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

/**
 * Created by Zeng on 2016/12/7.
 */
@ContentView(R.layout.fragment_base_list)
public class BaseListFragment extends BaseFragment {
    @ViewInject(R.id.listview)
    protected PullToRefreshListView mListView;

    @Override
    protected void initVariable() {

    }

    @Override
    protected void initViews(View view) {

    }

    @Override
    protected void loadData() {

    }
}
