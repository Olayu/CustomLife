package com.customlife.app.utils.three;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.customlife.app.base.BaseFragment;
import com.customlife.app.fragment.FindGoodsFragment;
import com.customlife.app.fragment.ProfitFragment;
import com.customlife.app.fragment.one.UserFragment;
import com.customlife.app.utils.MyShopFragment;

import java.util.ArrayList;

/**
 * Created by Yolanda on 2016/10/5.
 */

public class FragmentController {

    private int containerId;
    private FragmentManager fm;
    private ArrayList<BaseFragment> fragments;
    private static FragmentController controller;
    private Activity aty;
    private boolean status;

    public static FragmentController getInstance(FragmentActivity aty, int containerId) {
        if (controller == null) {
            controller = new FragmentController(aty, containerId);
        }
        return controller;
    }

    private FragmentController(FragmentActivity aty, int containerId) {
        this.containerId = containerId;
        fm = aty.getSupportFragmentManager();
        this.aty = aty;
        initFragment();
    }

    /**
     * 初始化Fragment
     */
    private void initFragment() {
        fragments = new ArrayList<>();
        fragments.add(new MyShopFragment());
        fragments.add(new ProfitFragment());
        fragments.add(new FindGoodsFragment());
        fragments.add(new UserFragment());

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
