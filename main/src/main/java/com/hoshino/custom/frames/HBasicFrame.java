package com.hoshino.custom.frames;

import com.hoshino.custom.themes.HCyan;
import com.hoshino.custom.themes.HDarkCustom;
import com.hoshino.custom.themes.HLightCustom;

import javax.swing.*;
import java.awt.*;

/**
 * <h1>千夜基本窗口</h1>
 * <b>简短介绍</b><br>
 * 这是继承自
 * {@link JFrame}
 * 的一个类。它是所有星夜窗口的基本框架。
 * <b>详细介绍</b><br>
 * 该类继承自
 * {@link JFrame}
 * 类。它没有重写父类方法。可以它的构造方法提供了自定义窗口标题、窗口图标的实现。它负责为其它继承自它的窗口提供一些基本的实现，比如加载用户设置、窗口出现位置的设置等。
 */
public class HBasicFrame extends JFrame {
    protected ImageIcon icon;
    protected String currentTheme;

    public HBasicFrame() {
        //UIManager.put("accentFocusColor", Color.decode("#4600C7"));

        //窗口居中出现
        setLocationRelativeTo(null);
    }

    //带参构造：自定义标题文本
    public HBasicFrame(String titleText) {
        this();
        this.setTitle(titleText);
    }

    //带参构造：自指定标题文本、图标
    public HBasicFrame(String titleText, ImageIcon icon) {
        this();
        this.setTitle(titleText);
        this.icon = icon;
        this.setIconImage(icon.getImage());
    }

    //设置主题
    public void setCurrentTheme(String currentTheme) {
        switch (currentTheme) {
            case "DARK":
                HDarkCustom.setup();
                break;
            case "CYAN":
                HCyan.setup();
                break;
            default:
                HLightCustom.setup();
                break;
        }
        //TODO:主题更换牵扯到配置文件
        SwingUtilities.updateComponentTreeUI(this);
        this.currentTheme = currentTheme;
    }

    //获取当前主题
    public String getCurrentTheme() {
        return currentTheme == null ? "LIGHT" : currentTheme;
    }

    public ImageIcon getIcon() {
        return icon;
    }

    //添加多个组件操作
    public void addAll(Component... components) {
        for (Component component : components) {
            add(component);
        }
    }

    /**
     * <b>加载用户配置</b>
     * <br>
     * 亟待更改：<br>
     * 首先它最好有返回值，返回一个 java bean 类包含着读取出来的用户配置。<br>
     * 它也应该分得更细一点，将主题、其他一些配置的加载分开来<br>
     * 多线程
     */

}
