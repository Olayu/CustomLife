package com.customlife.app.utils;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.customlife.app.R;

/**
 * Created by Yolanda on 2016/10/6.
 */

public class ActionbarBuilder {
    private View view;
    private TextView titleTv;
    private TextView leftTv;
    private TextView rightTv;
    private TextView lineTv;
    private ImageView leftImg;
    private ImageView rightImg;

    public ActionbarBuilder(Activity context) {
        view = context.findViewById(R.id.rl_actionbar);
        titleTv = (TextView) view.findViewById(R.id.actionbar_tv_title);
        leftTv = (TextView) view.findViewById(R.id.actionbar_tv_left);
        rightTv = (TextView) view.findViewById(R.id.actionbar_tv_right);
        lineTv = (TextView) view.findViewById(R.id.tv_line);
        leftImg = (ImageView) view.findViewById(R.id.actionbar_img_left);
        rightImg = (ImageView) view.findViewById(R.id.actionbar_img_right);
    }

    public ActionbarBuilder(View context) {
        view = context.findViewById(R.id.rl_actionbar);
        titleTv = (TextView) view.findViewById(R.id.actionbar_tv_title);
        leftTv = (TextView) view.findViewById(R.id.actionbar_tv_left);
        rightTv = (TextView) view.findViewById(R.id.actionbar_tv_right);
        lineTv = (TextView) view.findViewById(R.id.tv_line);
        leftImg = (ImageView) view.findViewById(R.id.actionbar_img_left);
        rightImg = (ImageView) view.findViewById(R.id.actionbar_img_right);
    }

    public View getView(){
        return view;
    }

    //title
    public ActionbarBuilder setTitleBgRes(int resId) {
        titleTv.setBackgroundResource(resId);
        return this;
    }

    public ActionbarBuilder setTitleText(String str) {
        titleTv.setVisibility(TextUtils.isEmpty(str) ? View.GONE : View.VISIBLE);
        titleTv.setText(str);
        return this;
    }

    //left
    public ActionbarBuilder setLeftImage(int resId) {
        leftImg.setVisibility(resId > 0 ? View.VISIBLE : View.GONE);
        leftImg.setImageResource(resId);
        return this;
    }

    public ActionbarBuilder setLeftText(String str) {
        leftTv.setVisibility(TextUtils.isEmpty(str) ? View.GONE : View.VISIBLE);
        leftTv.setText(str);
        return this;
    }

    public ActionbarBuilder setLeftOnCilckListener(View.OnClickListener listener) {
        if (leftImg.getVisibility() == View.VISIBLE) {
            leftImg.setOnClickListener(listener);
        } else if (leftTv.getVisibility() == View.VISIBLE) {
            leftTv.setOnClickListener(listener);
        }
        return this;
    }

    //right
    public ActionbarBuilder setRightImage(int resId) {
        rightImg.setVisibility(resId > 0 ? View.VISIBLE : View.GONE);
        rightImg.setImageResource(resId);
        return this;
    }

    public ActionbarBuilder setRightText(String str) {
        rightTv.setVisibility(TextUtils.isEmpty(str) ? View.GONE : View.VISIBLE);
        rightTv.setText(str);
        return this;
    }

    public ActionbarBuilder setLine() {
        lineTv.setVisibility(View.VISIBLE);
        return this;
    }

    public ActionbarBuilder setRightOnCilckListener(View.OnClickListener listener) {
        if (rightImg.getVisibility() == View.VISIBLE) {
            rightImg.setOnClickListener(listener);
        }
        return this;
    }

    public ActionbarBuilder setRightTextOnClickListener(View.OnClickListener listener) {
        if (rightTv.getVisibility() == View.VISIBLE) {
            rightTv.setOnClickListener(listener);
        }
        return this;
    }


}
