package com.customlife.app.api.remote;

import com.customlife.app.AppContext;
import com.customlife.app.api.ApiHttpClient;

/**
 * Created by zhangbin on 2016/10/15.
 */

public class Api {

    /**
     * 获取首页轮播图
     *
     * @param handler
     */
    public static void getImageList(ApiHttpClient.ApiHttpResponseHandler handler) {
        String url = "imagelist";
        new ApiHttpClient(AppContext.context()).post(url, handler);
    }

}
