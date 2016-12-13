package com.customlife.app.fragment.one;

import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.customlife.app.AppConfig;
import com.customlife.app.R;
import com.customlife.app.activity.AboutActivity;
import com.customlife.app.activity.AddressListActivity;
import com.customlife.app.activity.CareActivity;
import com.customlife.app.activity.H5Activity;
import com.customlife.app.activity.MessageActivity;
import com.customlife.app.activity.MyMemberActivity;
import com.customlife.app.activity.OpinionActivity;
import com.customlife.app.activity.OrderActivity;
import com.customlife.app.activity.SelectRoleActivity;
import com.customlife.app.activity.SettingActivity;
import com.customlife.app.adapter.MenuAdapter;
import com.customlife.app.base.BaseFragment;
import com.customlife.app.bean.MenuBean;
import com.customlife.app.utils.ActionbarBuilder;
import com.customlife.app.widget.UserGridView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;

/**
 * 我的
 * <p>
 * Created by Zeng on 2016/11/26.
 */

@ContentView(R.layout.fragment_user)
public class UserFragment extends BaseFragment {
    @ViewInject(R.id.user_gridview)
    private UserGridView gridView;
    private MenuAdapter menuAdapter;
    @ViewInject(R.id.user_img_setting)
    private ImageView settingImg;
    @ViewInject(R.id.user_layout_order)
    private LinearLayout orderLayout;
    @ViewInject(R.id.user_layout_role)
    private LinearLayout roleLayout;

    private AlertDialog ad;

    @Override
    protected void initVariable() {

    }

    @Override
    protected void initViews(View view) {

        new ActionbarBuilder(view).setTitleText("个人中心");
        orderLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent2Activity(OrderActivity.class);
            }
        });
        roleLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent2Activity(SelectRoleActivity.class);
            }
        });

        initMenu();
    }

    @Event(value = {R.id.user_img_setting})
    private void onClick(View view) {
        intent2Activity(SettingActivity.class);
    }


    @Event(type = AdapterView.OnItemClickListener.class, value = R.id.user_gridview)
    private void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        switch (i) {
            case 0:
                intent2Activity(MyMemberActivity.class);
                break;
            case 1:
                intent2Activity(CareActivity.class);
                break;
            case 2:
                intent2Activity(AddressListActivity.class);
                break;
            case 3:
                intent2Activity(MessageActivity.class);
                break;
            case 4:
                showCallPhoneAlert();
                break;
            case 5:
                intent2Activity(OpinionActivity.class);
                break;
            case 6:
                intent2Activity(H5Activity.class);
                break;
            case 7:
                intent2Activity(AboutActivity.class);
                break;
        }
    }

    public void initMenu() {
        menuAdapter = new MenuAdapter(getActivity(), R.layout.item_user_menu);
        gridView.setAdapter(menuAdapter);
        ArrayList<MenuBean> arrayList = new ArrayList<>();
        String[] menu = getResources().getStringArray(R.array.user_menu);
        ArrayList<Integer> menuImage = AppConfig.getUserMenuImage();
        ArrayList<String> menuTextColor = AppConfig.getUserMenuTextColor();
        for (int i = 0; i < 8; i++) {
            arrayList.add(new MenuBean(menu[i], menuImage.get(i), menuTextColor.get(i)));
        }
        menuAdapter.setData(arrayList);
    }

    public void showCallPhoneAlert() {

        ad = new AlertDialog.Builder(getContext()).create();
        ad.show();
        Window win = ad.getWindow();
        win.setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        win.setContentView(R.layout.alert_call_phone);
        win.setBackgroundDrawableResource(R.color.transparent);     //设置AlertDialog背景透明
        Button cancelBtn = (Button) win.findViewById(R.id.btn_left);
        Button callBtn = (Button) win.findViewById(R.id.btn_right);
        win.setGravity(Gravity.CENTER);
        win.clearFlags(WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
        callBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                Uri data = Uri.parse("tel:" + "10086");
                intent.setData(data);
                startActivity(intent);
                ad.dismiss();
            }
        });
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ad.dismiss();
            }
        });
    }

    @Override
    protected void loadData() {

    }
}
