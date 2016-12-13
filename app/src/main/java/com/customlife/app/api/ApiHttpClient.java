package com.customlife.app.api;

import android.content.Context;

import com.customlife.app.AppConfig;
import com.customlife.app.utils.TextUtil;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.PersistentCookieStore;
import com.loopj.android.http.RequestParams;

import org.xutils.common.util.LogUtil;

import cz.msebera.android.httpclient.Header;

/**
 * Created by zhangbin on 2016/10/13.
 */

public class ApiHttpClient {
    private Context context;

    public ApiHttpClient(Context context) {
        this.context = context;
    }

    public void post(String url, RequestParams params,
                     final ApiHttpResponseHandler handler) {
        PersistentCookieStore myCookieStore = new PersistentCookieStore(context);
        AsyncHttpClient client = new AsyncHttpClient();
        /** 设置Cookie **/
        client.setCookieStore(myCookieStore);
        /** post请求 **/
        client.post(AppConfig.URL + url, params, new AsyncHttpResponseHandler() {

            /** 成功回调 **/
            @Override
            public void onSuccess(int statusCode, Header[] headers,
                                  byte[] responseBody) {
                String body = TextUtil.decode(new String(responseBody));
                LogUtil.i("Response---->" + body);
                handler.onSuccess(statusCode, headers, body);
            }

            /** 失败回调 **/
            @Override
            public void onFailure(int statusCode, Header[] headers,
                                  byte[] responseBody, Throwable error) {

                handler.onFailure(statusCode, headers, responseBody, error);

            }

        });
    }


    public void post(String url,
                     final ApiHttpResponseHandler handler) {
        PersistentCookieStore myCookieStore = new PersistentCookieStore(context);
        AsyncHttpClient client = new AsyncHttpClient();
        /** 设置Cookie **/
        client.setCookieStore(myCookieStore);
        /** post请求 **/
        client.post(AppConfig.URL + url, new AsyncHttpResponseHandler() {

            /** 成功回调 **/
            @Override
            public void onSuccess(int statusCode, Header[] headers,
                                  byte[] responseBody) {
                String body = TextUtil.decode(new String(responseBody));
                LogUtil.i("Response---->" + body);
                handler.onSuccess(statusCode, headers, body);
            }

            /** 失败回调 **/
            @Override
            public void onFailure(int statusCode, Header[] headers,
                                  byte[] responseBody, Throwable error) {

                handler.onFailure(statusCode, headers, responseBody, error);

            }

        });
    }

    public interface ApiHttpResponseHandler {
        void onSuccess(int statusCode, Header[] headers,
                       String responseBody);

        void onFailure(int statusCode, Header[] headers,
                       byte[] responseBody, Throwable error);

    }
}
