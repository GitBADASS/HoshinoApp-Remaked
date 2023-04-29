package com.hoshino.frames;

import com.hoshino.custom.components.HListCellRenderer;

import javax.swing.*;
import java.awt.*;

/**
 * <h1>启动窗口</h1>
 * <b>简短介绍</b><br>
 * 这是继承自
 * {@link HBasicFrame}
 * 的一个 {@link JFrame} 子类。它是程序的启动入口，打开程序最先显示的窗口。这个窗口需要完成许多任务，它是程序的一个门面。许多功能需要体现在这个窗口之中，可以说其它窗口只是这个窗口的附属。
 * <b>详细介绍</b><br>
 * 该类继承自
 * {@link HBasicFrame}
 * 类，同时也是 {@link JFrame} 的子类。它没有重写父类方法。它在该类的构造方法中引用了HBasicFrame父类的构造方法。
 */
public class StartFrame extends HBasicFrame{
    /**
     * <b>构造方法</b>
     * <br>
     * 引入父类
     * {@link HBasicFrame}
     * 构造方法
     */

    //TODO:解决组件自适应、组件大小及排版问题
    public StartFrame() {
        super("test"); //引入父类内容
        //设置窗口
        setSize(800, 500); //大小：800*500
        setLayout(new BorderLayout());//布局：BorderLayout

        //创建标题菜单栏
        JMenuBar titleBar = new JMenuBar();

        //TODO:==========以下内容仅为测试，待删去==========
        //将 frame 水平分割
        //左：JList 侧边栏
        DefaultListModel<String> leftName = new DefaultListModel<>();
        leftName.addElement("设置");
        leftName.addElement("内容");
        leftName.addElement("单词库");
        HListCellRenderer h = new HListCellRenderer(leftName);
        for (int i = 0; i < leftName.getSize(); i++) {
            h.addContentText(leftName.get(i));
        }
        JList<String> left = new JList<>(leftName);
        left.setCellRenderer(h);
        left.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        add(left);

        //TODO:==========以上内容仅为测试，待删去==========

        //添加到窗口
        setJMenuBar(titleBar);

        //设置可见
        setVisible(true); //可见
    }
}
