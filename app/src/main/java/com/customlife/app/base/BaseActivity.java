package com.customlife.app.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.customlife.app.utils.ToastUtils;

import org.xutils.x;

/**
 * Created by Zeng on 2016/11/24.
 */

public abstract class BaseActivity extends AppCompatActivity {
    protected Context context;
    private Activity aty;
    private RequestManager mImgLoader;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        context = this;
        aty = this;

        initVariable();
        x.view().inject(this);
        initViews(savedInstanceState);
        loadData();
    }


    public synchronized RequestManager getImgLoader() {
        if (mImgLoader == null)
            mImgLoader = Glide.with(this);
        return mImgLoader;
    }    protected void intent2Activity(Class <? extends Activity> tarActivity){
        Intent intent = new Intent(this, tarActivity);
        startActivity(intent);
    }
    protected void showToast(String msg){
        ToastUtils.showToast(this, msg, Toast.LENGTH_SHORT);
    }
    protected abstract int getContentView();
    protected abstract void initVariable();
    protected abstract void initViews(Bundle savedInstanceState);
    protected abstract void loadData();
    
}
