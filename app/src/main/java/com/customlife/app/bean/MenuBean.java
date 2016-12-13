package com.customlife.app.bean;

/**
 * Created by Zeng on 2016/11/27.
 */

public class MenuBean {
    private String menu;
    private int image;
    private String textColor;


    public MenuBean(String menu, int image) {
        this.menu = menu;
        this.image = image;
    }

    public MenuBean(String menu, int image, String textColor) {
        this.menu = menu;
        this.image = image;
        this.textColor = textColor;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public String getTextColor() {
        return textColor;
    }

    public void setTextColor(String textColor) {
        this.textColor = textColor;
    }
}
