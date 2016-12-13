package com.customlife.app.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.customlife.app.utils.ToastUtils;

import org.xutils.x;


/**
 * Created by Yolanda on 2016/10/5.
 */

public abstract class BaseFragment extends Fragment {
    private RequestManager mImgLoader;
    //    private UpdateListener listener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return x.view().inject(this, inflater, container);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initVariable();
        initViews(view);
        loadData();
    }

    protected void intent2Activity(Class<? extends Activity> tarActivity) {
        Intent intent = new Intent(getActivity(), tarActivity);
        startActivity(intent);
    }

    public synchronized RequestManager getImgLoader() {
        if (mImgLoader == null)
            mImgLoader = Glide.with(this);
        return mImgLoader;
    }

    protected void showToast(String msg) {
        ToastUtils.showToast(getContext(), msg, Toast.LENGTH_SHORT);
    }


    protected abstract void initVariable();

    protected abstract void initViews(View view);

    protected abstract void loadData();

}
