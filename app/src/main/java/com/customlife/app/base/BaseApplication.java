package com.customlife.app.base;

import android.app.Application;
import android.content.Context;

import org.xutils.x;

/**
 * Created by Zeng on 2016/11/27.
 */

public class BaseApplication extends Application {

    static Context _context;
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(true);
        _context = getApplicationContext();
    }


    public static synchronized BaseApplication context() {
        return (BaseApplication) _context;
    }
}
