package com.customlife.app.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.customlife.app.R;
import com.handmark.pulltorefresh.library.LoadingLayoutBase;
import com.nineoldandroids.view.ViewHelper;

/**
 * Created by Zeng on 2016/11/28.
 */

public class JingDongHeaderLayout extends LoadingLayoutBase {

    private FrameLayout mInnerLayout;
    private TextView mHeaderText;
    private TextView mSubHeaderText;
    private ImageView mGoodsImage;
    private ImageView mPersonImage;

    private String mPullLabel;
    private String mRefreshingLabel;
    private String mReleaseLabel;
    private AnimationDrawable animP;

    public JingDongHeaderLayout(Context context) {
        super(context);

        LayoutInflater.from(context).inflate(R.layout.jingdong_header_loadinglayout, this);

        mInnerLayout = (FrameLayout) findViewById(R.id.fl_inner);
        mHeaderText = (TextView) mInnerLayout.findViewById(R.id.pull_to_refresh_text);
        mSubHeaderText = (TextView) mInnerLayout.findViewById(R.id.pull_to_refresh_sub_text);
        mGoodsImage = (ImageView) mInnerLayout.findViewById(R.id.pull_to_refresh_goods);
        mPersonImage = (ImageView) mInnerLayout.findViewById(R.id.pull_to_refresh_people);

        LayoutParams lp = (LayoutParams) mInnerLayout.getLayoutParams();
        lp.gravity = Gravity.BOTTOM;

        // Load in labels
        mPullLabel = context.getString(R.string.jingdong_pull_label);
        mRefreshingLabel = context.getString(R.string.jingdong_refreshing_label);
        mReleaseLabel = context.getString(R.string.jingdong_release_label);

        reset();
    }


    /**
     * get the LoadingLayout height or width
     *
     * @return size
     */
    @Override
    public int getContentSize() {
        return mInnerLayout.getHeight();
    }

    /**
     * Call when the widget begins to slide
     */
    @Override
    public void pullToRefresh() {
        mSubHeaderText.setText(mPullLabel);
    }

    /**
     * Call when the LoadingLayout is fully displayed
     */
    @Override
    public void releaseToRefresh() {
        mSubHeaderText.setText(mReleaseLabel);
    }

    /**
     * Call when the LoadingLayout is sliding
     *
     * @param scaleOfLayout scaleOfLayout
     */
    @Override
    public void onPull(float scaleOfLayout) {
        scaleOfLayout = scaleOfLayout > 1.0f ? 1.0f : scaleOfLayout;

        if (mGoodsImage.getVisibility() != View.VISIBLE) {
            mGoodsImage.setVisibility(View.VISIBLE);
        }

        //透明度动画
        ObjectAnimator animAlphaP = ObjectAnimator.ofFloat(mPersonImage, "alpha", -1, 1).setDuration(300);
        animAlphaP.setCurrentPlayTime((long) (scaleOfLayout * 300));
        ObjectAnimator animAlphaG = ObjectAnimator.ofFloat(mGoodsImage, "alpha", -1, 1).setDuration(300);
        animAlphaG.setCurrentPlayTime((long) (scaleOfLayout * 300));

        //缩放动画
        ViewHelper.setPivotX(mPersonImage, 0);  // 设置中心点
        ViewHelper.setPivotY(mPersonImage, 0);
        ObjectAnimator animPX = ObjectAnimator.ofFloat(mPersonImage, "scaleX", 0, 1).setDuration(300);
        animPX.setCurrentPlayTime((long) (scaleOfLayout * 300));
        ObjectAnimator animPY = ObjectAnimator.ofFloat(mPersonImage, "scaleY", 0, 1).setDuration(300);
        animPY.setCurrentPlayTime((long) (scaleOfLayout * 300));

        ViewHelper.setPivotX(mGoodsImage, mGoodsImage.getMeasuredWidth());
        ObjectAnimator animGX = ObjectAnimator.ofFloat(mGoodsImage, "scaleX", 0, 1).setDuration(300);
        animGX.setCurrentPlayTime((long) (scaleOfLayout * 300));
        ObjectAnimator animGY = ObjectAnimator.ofFloat(mGoodsImage, "scaleY", 0, 1).setDuration(300);
        animGY.setCurrentPlayTime((long) (scaleOfLayout * 300));
    }

    /**
     * Call when the LoadingLayout is fully displayed and the widget has released.
     * Used to prompt the user loading data
     */
    @Override
    public void refreshing() {
        mSubHeaderText.setText(mRefreshingLabel);

        if (animP == null) {
            mPersonImage.setImageResource(R.drawable.refreshing_anim);
            animP = (AnimationDrawable) mPersonImage.getDrawable();
        }
        animP.start();
        if (mGoodsImage.getVisibility() == View.VISIBLE) {
            mGoodsImage.setVisibility(View.INVISIBLE);
        }
    }

    /**
     * Call when the data has loaded
     */
    @Override
    public void reset() {
        if (animP != null) {
            animP.stop();
            animP = null;
        }
        mPersonImage.setImageResource(R.mipmap.app_refresh_people_0);
        if (mGoodsImage.getVisibility() == View.VISIBLE) {
            mGoodsImage.setVisibility(View.INVISIBLE);
        }

    }

    /**
     * Set Text to show when the Widget is being Pulled
     * <code>setPullLabel(releaseLabel, Mode.BOTH)</code>
     *
     * @param pullLabel - CharSequence to display
     */
    @Override
    public void setPullLabel(CharSequence pullLabel) {
        mPullLabel = String.valueOf(pullLabel);
    }

    /**
     * Set Text to show when the Widget is refreshing
     * <code>setRefreshingLabel(releaseLabel, Mode.BOTH)</code>
     *
     * @param refreshingLabel - CharSequence to display
     */
    @Override
    public void setRefreshingLabel(CharSequence refreshingLabel) {
        mRefreshingLabel = String.valueOf(refreshingLabel);
    }

    /**
     * Set Text to show when the Widget is being pulled, and will refresh when
     * released. This is the same as calling
     * <code>setReleaseLabel(releaseLabel, Mode.BOTH)</code>
     *
     * @param releaseLabel - CharSequence to display
     */
    @Override
    public void setReleaseLabel(CharSequence releaseLabel) {
        mReleaseLabel = String.valueOf(releaseLabel);
    }
}
