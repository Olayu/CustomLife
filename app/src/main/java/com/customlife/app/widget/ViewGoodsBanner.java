package com.customlife.app.widget;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.RequestManager;
import com.customlife.app.R;
import com.customlife.app.bean.Banner;
import com.customlife.app.utils.TDevice;

//import net.oschina.app.util.UIHelper;

/**
 * Created by huanghaibin
 * on 16-5-23.
 */
public class ViewGoodsBanner extends RelativeLayout implements View.OnClickListener {
    private Banner banner;
    private ImageView iv_banner;
    //private TextView tv_title;

    public ViewGoodsBanner(Context context) {
        super(context, null);
        init(context);
    }

    private void init(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_news_banner, this, true);

        Log.i("aaaaaaaaaaa", "" + TDevice.getScreenWidth());
        iv_banner = (ImageView) findViewById(R.id.iv_banner);
        iv_banner.setLayoutParams(new RelativeLayout.LayoutParams((int) TDevice.getScreenWidth(), (int) TDevice.getScreenWidth()));
        //tv_title = (TextView) findViewById(R.id.tv_title);
        setOnClickListener(this);
    }

    public void initData(RequestManager manager, Banner banner) {
        this.banner = banner;
        //tv_title.setText(banner.getName());
        manager.load(banner.getImg()).into(iv_banner);

    }

    @Override
    public void onClick(View v) {
        if (banner != null) {
//            int type = banner.getType();
//            long id = banner.getId();
//            UIHelper.showDetail(getContext(), type, id,banner.getHref());
        }
    }


    public String getTitle() {
//        return banner.getName();
        return "";
    }
}
