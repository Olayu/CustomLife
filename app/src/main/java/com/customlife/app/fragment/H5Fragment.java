package com.customlife.app.fragment;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.customlife.app.R;
import com.customlife.app.base.BaseFragment;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

/**
 * Created by Zeng on 2016/12/7.
 */
@ContentView(R.layout.fragment_h5)
public class H5Fragment extends BaseFragment {

    @ViewInject(R.id.webview)
    private WebView mWebView;
    private AlertDialog alertDialog;
    private ProgressDialog progressBar;

    @Override
    protected void initVariable() {

    }

    @Override
    protected void initViews(View view) {
        progressBar = ProgressDialog.show(getActivity(), null, "正在加载...");
        WebSettings settings = mWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setCacheMode(WebSettings.LOAD_DEFAULT);
        mWebView.loadUrl("file:///android_asset/jike.html");
        alertDialog = new AlertDialog.Builder(getActivity()).create();
        mWebView.setWebViewClient(new MyWebViewClient());
        mWebView.setVerticalScrollBarEnabled(false);

    }

    class MyWebViewClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            if (progressBar.isShowing()) {
                progressBar.dismiss();
            }
        }

        @Override
        public void onReceivedError(WebView view, int errorCode,
                                    String description, String failingUrl) {
            showToast("网页加载出错！");
            alertDialog.setTitle("ERROR");
            alertDialog.setMessage(description);
            alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // TODO Auto-generated method stub
                }
            });
            alertDialog.show();
        }
    }

    @Override
    protected void loadData() {

    }
}
