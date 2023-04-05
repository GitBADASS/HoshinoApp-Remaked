package com.hoshino;


import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.ui.FlatInternalFrameUI;
import com.formdev.flatlaf.ui.FlatRootPaneUI;
import com.formdev.flatlaf.ui.FlatTitlePane;

import javax.swing.*;
import java.awt.*;

public class MainForm {
    private static void createAndShowGUI() {
        //确保一个漂亮的外观风格
        //FlatLightLaf.setup();

        //创建及设置窗口
        JFrame frame = new JFrame("Flatlaf");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //添加切换主题的按钮
        JButton blackTheme = new JButton("black");//暗色
        JButton lightTheme = new JButton("light");//亮色

        //暗色主题切换按钮监听事件
        blackTheme.addActionListener(e->{
            FlatDarculaLaf.setup();
            SwingUtilities.updateComponentTreeUI(frame);
        });

        //亮色色主题切换按钮监听事件
        lightTheme.addActionListener(e->{
            FlatLightLaf.setup();
            SwingUtilities.updateComponentTreeUI(frame);
        });

        //添加组件到frame
        frame.getContentPane().add(blackTheme);
        frame.getContentPane().add(lightTheme);

        //设置组件布局
        frame.setLayout(new FlowLayout(FlowLayout.LEADING, 20, 20));

        //默认主题：idea亮色
        FlatLightLaf.setup();
        SwingUtilities.updateComponentTreeUI(frame);

        //更深层次的主题更改
        JComponent titleBar = (JComponent) frame.getRootPane().getComponent(1);
        // 创建一个标签
        JLabel label = new JLabel("Hello World");
        label.setForeground(Color.WHITE);
        // 在标题栏上添加标签
        titleBar.add(label, BorderLayout.WEST);

        //设置窗口并显示
        frame.setSize(400, 400);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // 显示应用 GUI
        javax.swing.SwingUtilities.invokeLater(MainForm::createAndShowGUI);
    }
}
