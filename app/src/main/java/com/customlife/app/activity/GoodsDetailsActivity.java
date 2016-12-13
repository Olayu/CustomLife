package com.customlife.app.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.customlife.app.AppConfig;
import com.customlife.app.R;
import com.customlife.app.api.ApiHttpClient;
import com.customlife.app.api.remote.Api;
import com.customlife.app.base.BaseActivity;
import com.customlife.app.bean.ADInfo;
import com.customlife.app.bean.Ad;
import com.customlife.app.bean.Banner;
import com.customlife.app.utils.ActionbarBuilder;
import com.customlife.app.widget.ViewGoodsHeader;
import com.google.gson.Gson;

import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

/**
 * Created by Zeng on 2016/12/13.
 */

public class GoodsDetailsActivity extends BaseActivity {
    @ViewInject(R.id.btn_minus)
    private RelativeLayout minusBtn;
    @ViewInject(R.id.btn_add)
    private RelativeLayout addBtn;
    @ViewInject(R.id.btn_add_to_cart)
    private ImageView addToCartBtn;
    @ViewInject(R.id.vp_goods)
    private ViewGoodsHeader header;
//    @ViewInject(R.id.vp_goods)
//    private GoodsImageCycleView header;

    private List<Banner> list;

    @Override
    protected int getContentView() {
        return R.layout.activity_goods_details;
    }

    @Override
    protected void initVariable() {

    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        new ActionbarBuilder(this).setTitleText("商品详情")
                .setLeftImage(R.drawable.icon_actionbar_arrow_left)
                .setLeftOnCilckListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        finish();
                    }
                })
        .setRightImage(R.drawable.icon_share)
        .setRightOnCilckListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast("分享");
            }
        });

        addToCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast("功能尚未实现");
            }
        });

        minusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast("减");
            }
        });
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast("加");
            }
        });
    }


    /**
     * 获取banner
     */
    public void getImageList() {
        list = new ArrayList<>();
        Api.getImageList(new ApiHttpClient.ApiHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseBody) {
                Ad ad = new Gson().fromJson(responseBody, Ad.class);
                ArrayList<String> ads = ad.getImg_list().getAndroid();
                AppConfig.AD_INFOS = new ArrayList<>();
                ArrayList<ADInfo>adInfos = new ArrayList<ADInfo>();
                for (String s : ads) {
                    ADInfo adInfo = new ADInfo();
                    adInfo.setContent(s);
                    adInfo.setUrl(s);
                    Banner banner = new Banner();
                    banner.setImg(s);
                    banner.setName(s);
                    list.add(banner);

                }
//                header.setImageResources(adInfos, mAdCycleViewListener);
                header.initData(getImgLoader(), list);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                showToast("服务器连接失败");
            }
        });
    }
    @Override
    protected void loadData() {
        getImageList();
    }
}
