package com.hoshino.frames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class StartFrame extends HBasicFrame{

    public StartFrame() {
        super("test"); //引入父类内容
        //设置窗口
        setSize(800, 500); //大小：800*500
        setLayout(new BorderLayout());//布局：BorderLayout

        //创建标题菜单栏
        JMenuBar titleBar = new JMenuBar();

        //TODO:==========以下内容仅为测试，待删去==========
        //重复内容使用while
        JPanel main = new JPanel();
        main.setLayout(new FlowLayout());
        main.setPreferredSize(new Dimension(300, 200));
        /*addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                main.setPreferredSize(new Dimension(300, getHeight()));
            }
        });*/
        JPanel left = new JPanel();
        left.setPreferredSize(new Dimension(150, 0));
        left.setLayout(new FlowLayout());
        JLabel bottom = new JLabel("bottom label");
        JMenuBar secBar = new JMenuBar();
        JMenu tm1 = new JMenu("test");
        JMenuItem t1Item1 = new JMenuItem("t-item1");
        JMenuItem t1Item2 = new JMenuItem("t-item2");
        JMenuItem t1Item3 = new JMenuItem("t-item3");
        JMenuItem t1Item4 = new JMenuItem("t-item4");
        JMenuItem t1Item5 = new JMenuItem("t-item5");
        JMenuItem t1Item6 = new JMenuItem("t-item6");
        tm1.add(t1Item1);
        tm1.add(t1Item2);
        tm1.add(t1Item3);
        tm1.add(t1Item4);
        tm1.add(t1Item5);
        tm1.add(t1Item6);
        JMenu tm2 = new JMenu("nice");
        JMenuItem n1Item1 = new JMenuItem("n-item1");
        JMenuItem n1Item2 = new JMenuItem("n-item2");
        JMenuItem n1Item3 = new JMenuItem("n-item3");
        JMenuItem n1Item4 = new JMenuItem("n-item4");
        JMenuItem n1Item5 = new JMenuItem("n-item5");
        JMenuItem n1Item6 = new JMenuItem("n-item6");
        tm2.add(n1Item1);
        tm2.add(n1Item2);
        tm2.add(n1Item3);
        tm2.add(n1Item4);
        tm2.add(n1Item5);
        tm2.add(n1Item6);
        JMenu tm3 = new JMenu("bad");
        JMenuItem b1Item1 = new JMenuItem("n-item1");
        JMenuItem b1Item2 = new JMenuItem("n-item2");
        JMenuItem b1Item3 = new JMenuItem("n-item3");
        JMenuItem b1Item4 = new JMenuItem("n-item4");
        JMenuItem b1Item5 = new JMenuItem("n-item5");
        JMenuItem b1Item6 = new JMenuItem("n-item6");
        tm2.add(b1Item1);
        tm2.add(b1Item2);
        tm2.add(b1Item3);
        tm2.add(b1Item4);
        tm2.add(b1Item5);
        tm2.add(b1Item6);
        secBar.add(tm1);
        secBar.add(tm2);
        secBar.add(tm3);
        JButton test = new JButton("TEST");
        JButton test2 = new JButton("TEST2");
        JButton test3 = new JButton("TEST3");
        JButton test4 = new JButton("TEST4");
        JButton test5 = new JButton("TEST5");
        JButton test6 = new JButton("TEST6");
        JButton test7 = new JButton("TEST7");
        JButton test8 = new JButton("TEST8");
        JButton test9 = new JButton("TEST9");
        JButton test0 = new JButton("TEST0[TESTING_THE_LONG_BUTTON]");
        main.add(test);
        main.add(test2);
        main.add(test3);
        main.add(test4);
        main.add(test5);
        main.add(test6);
        main.add(test7);
        main.add(test8);
        main.add(test9);
        main.add(test0);
        JScrollPane mainS = new JScrollPane(main);
        left.add(test);
        left.add(test2);
        JScrollPane leftS = new JScrollPane(left);
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
        add(secBar, BorderLayout.NORTH);
        add(mainS, BorderLayout.CENTER);
        add(leftS, BorderLayout.WEST);
        add(bottom, BorderLayout.SOUTH);
        //TODO:==========以上内容仅为测试，待删去==========

        //添加到窗口
        setJMenuBar(titleBar);

        //设置可见
        setVisible(true); //可见
    }
}
