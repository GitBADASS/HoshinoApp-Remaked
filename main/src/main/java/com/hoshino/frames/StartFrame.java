package com.hoshino.frames;

import javax.swing.*;

public class StartFrame extends HBasicFrame{

    public StartFrame() {
        super("test");

        //创建标题菜单栏
        JMenuBar titleBar = new JMenuBar();
        JButton test = new JButton("TEST");

        //添加到窗口
        setJMenuBar(titleBar);
        add(test);

        //设置窗口
        setSize(800, 500); //大小
        setVisible(true); //可见
    }
}
