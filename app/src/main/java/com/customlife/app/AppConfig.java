package com.customlife.app;

import com.customlife.app.bean.ADInfo;

import java.util.ArrayList;

/**
 * Created by Zeng on 2016/11/26.
 */

public class AppConfig {
    public final static String WX_APP_ID = "";
    public static ArrayList<ADInfo> AD_INFOS;
    public static String URL = "http://www.yougelicai.com/clientapi/";
    public static String LOGIN_STATE = "login_state";
    public static String USER_INFO = "user_info";
    public static String MAIN_ACTIVITY = "mainActivity";

    public static ArrayList<Integer> getHomeMenuImage() {
        ArrayList<Integer> userMenu = new ArrayList<>();
        userMenu.add(R.drawable.icon_home_menu1);
        userMenu.add(R.drawable.icon_home_menu2);
        userMenu.add(R.drawable.icon_home_menu3);
        userMenu.add(R.drawable.icon_home_menu4);
        return userMenu;
    }
    public static ArrayList<Integer> getUserMenuImage() {
        ArrayList<Integer> userMenu = new ArrayList<>();
        userMenu.add(R.drawable.icon_member);
        userMenu.add(R.drawable.icon_collect);
        userMenu.add(R.drawable.icon_address);
        userMenu.add(R.drawable.icon_message);
        userMenu.add(R.drawable.icon_menu_phone);
        userMenu.add(R.drawable.icon_opinion);
        userMenu.add(R.drawable.icon_jike);
        userMenu.add(R.drawable.icon_about);
        return userMenu;
    }
    public static ArrayList<String> getUserMenuTextColor() {
        ArrayList<String> userMenu = new ArrayList<>();
        userMenu.add("#ff9800");
        userMenu.add("#3f51b5");
        userMenu.add("#03a9f4");
        userMenu.add("#ff4081");
        userMenu.add("#ff5722");
        userMenu.add("#607d8b");
        userMenu.add("#8bc34a");
        userMenu.add("#e51c23");
        return userMenu;
    }
}
