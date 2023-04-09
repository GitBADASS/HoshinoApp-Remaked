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
        //
        JMenu m1 = new JMenu("wow1");
        JMenuItem mi1 = new JMenuItem("w1");
        JMenuItem mi2 = new JMenuItem("w2");
        JMenuItem mi3 = new JMenuItem("w3");
        m1.add(mi1);
        m1.add(mi2);
        m1.add(mi3);
        JMenu m2 = new JMenu("wow2");
        JMenuItem mi_1 = new JMenuItem("w2-1");
        JMenuItem mi_2 = new JMenuItem("w2-2");
        JMenuItem mi_3 = new JMenuItem("w2-3");
        m2.add(mi_1);
        m2.add(mi_2);
        m2.add(mi_3);
        titleBar.add(m1);
        titleBar.add(m2);
        //

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
