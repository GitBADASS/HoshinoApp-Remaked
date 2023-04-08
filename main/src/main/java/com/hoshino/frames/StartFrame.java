package com.hoshino.frames;

import com.hoshino.custom.themes.HThemeType;

import javax.swing.*;

public class StartFrame extends HBasicFrame{
    int themeState;

    public StartFrame() {
        super("test");

        //添加标题栏组件栏
        JMenuBar titleBar = new JMenuBar();

        //主题切换按钮 TODO:切换为深色主题之后无法再切换回来！
        JMenu themeMenu = new JMenu("主题");
        //浅色主题
        JMenuItem light = new JMenuItem("浅色");
        light.addActionListener(e->{
            //设置为浅色主题
            super.setThemeStyle(HThemeType.LIGHT_THEME);
        });
        //深色主题
        JMenuItem dark = new JMenuItem("深色");
        dark.addActionListener(e->{
            //设置为深色主题
            super.setThemeStyle(HThemeType.DARK_THEME);
        });
        //添加到menu
        themeMenu.add(light);
        themeMenu.add(dark);
        //将menu添加到menubar
        titleBar.add(themeMenu);

        //添加内容到
        setJMenuBar(titleBar);

        //部分设置
        setSize(800, 500); //大小
        setVisible(true); //可见
    }
}
