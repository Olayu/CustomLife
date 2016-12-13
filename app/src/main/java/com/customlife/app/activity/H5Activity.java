package com.customlife.app.activity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.customlife.app.R;
import com.customlife.app.base.BaseActivity;
import com.customlife.app.utils.ActionbarBuilder;

import org.xutils.view.annotation.ViewInject;

/**
 * Created by Zeng on 2016/12/7.
 */

public class H5Activity extends BaseActivity {
    @ViewInject(R.id.webview)
    private WebView mWebView;
    private AlertDialog alertDialog;
    private ProgressDialog progressBar;

    @Override
    protected int getContentView() {
        return R.layout.activity_h5;
    }

    @Override
    protected void initVariable() {

    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        new ActionbarBuilder(this).setTitleText("集客模式").setLeftImage(R.drawable.icon_actionbar_arrow_left).setLeftOnCilckListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        progressBar = ProgressDialog.show(H5Activity.this, null, "正在加载...");
        WebSettings settings = mWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setCacheMode(WebSettings.LOAD_DEFAULT);
        mWebView.loadUrl("file:///android_asset/jike.html");
        alertDialog = new AlertDialog.Builder(this).create();
        mWebView.setWebViewClient(new MyWebViewClient());
    }

    class MyWebViewClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(android.webkit.WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageFinished(android.webkit.WebView view, String url) {
            if (progressBar.isShowing()) {
                progressBar.dismiss();
            }
        }

        @Override
        public void onReceivedError(android.webkit.WebView view, int errorCode,
                                    String description, String failingUrl) {
            Toast.makeText(H5Activity.this, "网页加载出错！", Toast.LENGTH_LONG);

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
