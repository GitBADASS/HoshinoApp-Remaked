package com.hoshino.frames;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.intellijthemes.FlatDarkFlatIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatLightFlatIJTheme;
import com.hoshino.custom.img.HImageCompress;

import javax.swing.*;

public class HBasicFrame extends JFrame {
    private ImageIcon icon;
    private String themeStyle;

    public HBasicFrame() {
        //默认主题：flat 亮色
        //FlatDarkFlatIJTheme.setup();
        FlatLightFlatIJTheme.setup();
        SwingUtilities.updateComponentTreeUI(this);
        icon = new ImageIcon("main/src/main/resources/img/icon.png");
        setIconImage(HImageCompress.compressedImage(icon));
        /*//添加标题栏菜单
        JMenuBar titleMenuBar = new JMenuBar();
        JMenu testM1 = new JMenu("测试1");
        JMenu testM2 = new JMenu("测试2");
        JMenuItem item1 = new JMenuItem("测试1-1");
        item1.setIcon(HImageCompress.compressedImageIcon(new ImageIcon("main/src/main/resources/img/quit.png")));
        JMenuItem item2 = new JMenuItem("测试1-2");
        JMenuItem item3 = new JMenuItem("测试1-3");
        JMenuItem item21 = new JMenuItem("测试2-1");
        JMenuItem item22 = new JMenuItem("测试2-2");
        JMenuItem item23 = new JMenuItem("测试2-3");
        testM1.add(item1);
        testM1.add(item2);
        testM1.add(item3);
        testM2.add(item21);
        testM2.add(item22);
        testM2.add(item23);
        titleMenuBar.add(testM1);
        titleMenuBar.add(testM2);
        titleMenuBar.add(new JToggleButton("test"));
        setJMenuBar(titleMenuBar);*/
    }

    public HBasicFrame(String titleText) {
        this();
        this.setTitle(titleText);
    }

    public HBasicFrame(String titleText, ImageIcon icon) {
        this();
        this.setTitle(titleText);
        this.icon = icon;
        this.setIconImage(icon.getImage());
    }

    //设置主题
    public void setThemeStyle(String themeStyle) {
        switch (themeStyle) {
            case "LIGHT":
                FlatLightFlatIJTheme.setup();
                break;
            case "DARK":
                FlatDarkFlatIJTheme.setup();
                break;
        }
        SwingUtilities.updateComponentTreeUI(this);
        this.themeStyle = themeStyle;
    }

    //获取当前主题
    public String getThemeStyle() {
        return themeStyle == null ? "LIGHT" : themeStyle;
    }

    public ImageIcon getIcon() {
        return icon;
    }
}
