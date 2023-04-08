package com.hoshino;


import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import java.awt.*;

public class Test {
    private static void createAndShowGUI() {
        //创建及设置窗口
        JFrame frame = new JFrame("BADASS バイダス");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setIconImage(new ImageIcon("main/src/main/resources/img/icon.png").getImage());

        //添加切换主题的按钮
        JButton blackTheme = new JButton("black");//暗色
        JButton lightTheme = new JButton("light");//亮色

        //添加文字板
        JLabel label = new JLabel("Test 测试");
        label.putClientProperty( "FlatLaf.styleClass", "h1" );//设置文字样式

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

        //设置组件布局
        frame.setLayout(new FlowLayout(FlowLayout.LEADING, 20, 20));

        //更深层次的主题更改；操作标题栏
        System.setProperty( "flatlaf.menuBarEmbedded", "true" );
        System.setProperty( "flatlaf.useWindowDecorations", "true" );
        JMenuBar menuBar = new JMenuBar();//创建菜单栏
        JMenu fileMenu = new JMenu("文件");//文件菜单
        JMenu edit = new JMenu("编辑");//编辑菜单
        JMenu settings = new JMenu("设置");//编辑菜单
        //创建属于 文件菜单 的菜单项
        JMenuItem open = new JMenuItem("打开...");//打开...
        open.addActionListener(e->{
            // 打开... 菜单项的事件监听
            System.out.println("打开文件");
        });

        JMenuItem save = new JMenuItem("保存");//保存
        save.addActionListener(e->{
            // 打开... 菜单项的事件监听
            // 小彩蛋（
            System.err.println("文件保存失败");
            System.err.println("正在尝试退出...");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
            System.exit(0);
        });
        //添加到 文件菜单 中
        fileMenu.add(open);
        fileMenu.add(save);

        //添加内容到菜单栏
        menuBar.add(fileMenu);
        menuBar.add(edit);
        menuBar.add(settings);

        //添加组件到frame
        frame.setJMenuBar(menuBar);
        frame.add(label);
        frame.getContentPane().add(blackTheme);
        frame.getContentPane().add(lightTheme);

        //默认主题：idea亮色
        FlatLightLaf.setup();
        SwingUtilities.updateComponentTreeUI(frame);

        //设置窗口并显示
        frame.setSize(400, 400);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // 显示应用 GUI
        javax.swing.SwingUtilities.invokeLater(Test::createAndShowGUI);
    }
}
