package com.customlife.app.base;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Toast;

import com.customlife.app.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zeng on 2016/11/9.
 *
 * @param <T>
 */
public abstract class CommonAdapter<T> extends BaseAdapter {

    protected Context mContext;

    protected List<T> mDatas;
    //    protected LayoutInflater mInflater;
    protected int layoutId;

    public CommonAdapter(Context context, int layoutId) {
        this.mContext = context;
//        mInflater = LayoutInflater.from(context);
        this.mDatas = new ArrayList<>();
        this.layoutId = layoutId;
    }

    public void setData(List<T> data) {
        this.mDatas = data;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        if (mDatas == null) {
            return 0;
        }
        return mDatas.size();
    }

    @Override
    public T getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void onDataChange(List<T> data) {
        this.mDatas = data;
        this.notifyDataSetChanged();
    }

    public List<T> getmDatas() {
        return mDatas;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = ViewHolder.get(mContext, convertView, parent, layoutId, position);
        convert(holder, mDatas.get(position));
        return holder.getConvertView();
    }

    public abstract void convert(ViewHolder holder, T t);

    protected void showToast(String msg) {
        ToastUtils.showToast(mContext, msg, Toast.LENGTH_SHORT);
    }
}
