package com.hoshino.storage;

public class UserSettings {
    private String userName;

    private String theme;

    //用户采取哪个文件夹的图标决定于 theme

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getIconDir() {
        return "main/src/main/resources/icons" + theme + "/";
    }
}
