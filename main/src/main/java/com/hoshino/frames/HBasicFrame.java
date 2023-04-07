package com.hoshino.frames;

import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;

public class HBasicFrame extends JFrame {
    public HBasicFrame() {
        //默认主题：flat 亮色
        FlatLightLaf.setup();
        SwingUtilities.updateComponentTreeUI(this);

        //添加标题栏菜单
        JMenuBar titleMenuBar = new JMenuBar();
        JMenu testM1 = new JMenu("测试1");
        JMenu testM2 = new JMenu("测试2");
        JMenuItem item1 = new JMenuItem("测试1-1");
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
        setJMenuBar(titleMenuBar);
    }
}
