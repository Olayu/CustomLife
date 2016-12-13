package com.customlife.app.base;

import android.content.pm.ActivityInfo;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.widget.RadioButton;
import android.widget.Toast;

import com.customlife.app.AppManager;
import com.customlife.app.utils.TDevice;
import com.customlife.app.utils.ToastUtils;

import org.xutils.x;

/**
 * Created by Zeng on 2016/11/26.
 */

public abstract class BaseFragmentActivity extends FragmentActivity {

    private long firstTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppManager.getAppManager().addActivity(this);
        setContentView(getContentView());
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        x.view().inject(this);
        initVariable();
        initViews(savedInstanceState);
        loadData();
    }

    protected void setDrawableTop(RadioButton rb) {
        int i = (int) TDevice.dp2px(20);
        Drawable drawable = rb.getCompoundDrawables()[1];
        drawable.setBounds(0, 0, i, i);
        rb.setCompoundDrawables(null, drawable, null, null);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppManager.getAppManager().finishActivity(this);
    }

    protected abstract int getContentView();

    protected abstract void initVariable();

    protected abstract void initViews(Bundle savedInstanceState);

    protected abstract void loadData();

    protected void showToast(String msg) {
        ToastUtils.showToast(this, msg, Toast.LENGTH_SHORT);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if (System.currentTimeMillis() - firstTime > 2000) {
//                Toast.makeText(BaseFragmentActivity.this,"再按一次退出程序--->onKeyDown",Toast.LENGTH_SHORT).show();
                showToast("再次点击退出程序");
                firstTime = System.currentTimeMillis();
            } else {
                finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
