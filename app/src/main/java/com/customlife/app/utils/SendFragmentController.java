package com.customlife.app.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.customlife.app.base.BaseFragment;
import com.customlife.app.fragment.one.HomeFragment;

import java.util.ArrayList;

/**
 * Created by Yolanda on 2016/10/5.
 */

public class SendFragmentController {

    private int containerId;
    private FragmentManager fm;
    private ArrayList<BaseFragment> fragments;
    private static SendFragmentController controller;

    public static SendFragmentController getInstance(BaseFragment fragment, int containerId) {
        if (controller == null) {
            controller = new SendFragmentController(fragment, containerId);
        }
        return controller;
    }

    private SendFragmentController(BaseFragment fragment, int containerId) {
        this.containerId = containerId;
        fm = fragment.getFragmentManager();
        initFragment();
    }

    /**
     * 初始化Fragment
     */
    private void initFragment() {
        fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new HomeFragment());
        fragments.add(new HomeFragment());

        FragmentTransaction ft = fm.beginTransaction();
        for (BaseFragment fragment : fragments) {
            ft.add(containerId, fragment);
        }
        ft.commit();
    }

    /**
     * 显示Fragment
     *
     * @param position
     */
    public void showFragment(int position) {
        BaseFragment fragment = fragments.get(position);
        FragmentTransaction ft = fm.beginTransaction();

        hideFragments(ft);
        ft.show(fragment);
        ft.commit();
    }


    /**
     * 隐藏Fragment
     *
     * @param ft
     */
    public void hideFragments(FragmentTransaction ft) {
        for (Fragment fragment : fragments
                ) {
            if (fragment != null) {
                ft.hide(fragment);
            }
        }
    }

    /**
     * 销毁FragmentController类
     */
    public static void onDestroy() {
        controller = null;
    }

    /**
     * 获取Fragment
     *
     * @param position
     * @return
     */
    public Fragment getFragment(int position) {
        return fragments.get(position);
    }

}
