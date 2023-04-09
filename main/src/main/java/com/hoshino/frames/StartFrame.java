package com.hoshino.frames;

import javax.swing.*;
import java.awt.*;

public class StartFrame extends HBasicFrame{

    public StartFrame() {
        super("test");

        //创建标题菜单栏
        JMenuBar titleBar = new JMenuBar();
        JButton test = new JButton("TEST");
        JButton test2 = new JButton("TEST2");

        //添加到窗口
        setJMenuBar(titleBar);
        add(test);
        add(test2);

        //设置窗口
        setSize(800, 500); //大小
        setLayout(new FlowLayout());//布局
        setVisible(true); //可见
    }
}
