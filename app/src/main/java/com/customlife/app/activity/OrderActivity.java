package com.customlife.app.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.customlife.app.R;
import com.customlife.app.base.BaseActivity;
import com.customlife.app.base.BaseFragment;
import com.customlife.app.fragment.OrderFragment;
import com.customlife.app.utils.ActionbarBuilder;

import java.util.ArrayList;

/**
 * 订单中心
 * Created by Zeng on 2016/12/7.
 */

public class OrderActivity extends BaseActivity {
    private ViewPager pager;
    private TabLayout tabLayout;
    private String[] title;
    private ArrayList<BaseFragment> fragments;
    @Override
    protected int getContentView() {
        return R.layout.fragmentactivity_base;
    }

    @Override
    protected void initVariable() {

    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        new ActionbarBuilder(this).setTitleText("订单中心")
                .setLeftImage(R.drawable.icon_actionbar_arrow_left)
                .setLeftOnCilckListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        finish();
                    }
                });
        title = getResources().getStringArray(R.array.order);
        pager = (ViewPager) findViewById(R.id.pager);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);

        FragmentPagerAdapter adapter = new TabLayoutAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);
        pager.setOffscreenPageLimit(2);
        tabLayout.setupWithViewPager(pager);
        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        fragments =  new ArrayList<>();
        fragments.add(new OrderFragment());
        fragments.add(new OrderFragment());
        fragments.add(new OrderFragment());
        fragments.add(new OrderFragment());
        fragments.add(new OrderFragment());
    }

    /**
     * ViewPager适配器
     *
     * @author len
     */
    class TabLayoutAdapter extends FragmentPagerAdapter {
        public TabLayoutAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            //新建一个Fragment来展示ViewPager item的内容，并传递参数

            return fragments.get(position);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return title[position % title.length];
        }

        @Override
        public int getCount() {
            return title.length;
        }
    }
    @Override
    protected void loadData() {

    }
}
