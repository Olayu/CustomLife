package com.customlife.app;

import android.content.Context;

import com.customlife.app.base.BaseApplication;

/**
 * Created by Zeng on 2016/11/27.
 */

public class AppContext extends BaseApplication {
    public static Context getContext(){
        return context();
    }
}
