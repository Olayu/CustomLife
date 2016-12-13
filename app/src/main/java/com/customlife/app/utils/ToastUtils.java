package com.customlife.app.utils;


import android.content.Context;
import android.widget.Toast;

/**
 * Toast工具类
 * Created by Yolanda on 2016/10/5.
 */

public class ToastUtils {

    private static Toast mToast;

    public static void showToast(Context context, CharSequence text, int duration){
        if (mToast == null) {
            mToast = Toast.makeText(context, text, duration);
        } else {
            mToast.setText(text);
            mToast.setDuration(duration);
        }
        mToast.show();
    }
}