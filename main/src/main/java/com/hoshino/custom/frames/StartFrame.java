package com.hoshino.custom.frames;

import com.hoshino.custom.img.HImageCompress;
import javafx.scene.control.ToolBar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static com.formdev.flatlaf.FlatClientProperties.TABBED_PANE_TAB_ICON_PLACEMENT;

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
    //private JMenuBar titleBar;
    /**
     * <b>构造方法</b>
     * <br>
     * 引入父类
     * {@link HBasicFrame}
     * 构造方法、并添加组件
     */
    //TODO:解决组件自适应、组件大小及排版问题
    public StartFrame() {
        super(); //引入父类内容
        setTitle("Hello, " + getSettings().getUserName() + " !");
        setIconImage(new ImageIcon("main/src/main/resources/img/icon.png").getImage());
        //设置窗口
        setSize(800, 500); //大小：800*500
        getContentPane().setLayout(new BorderLayout()); //布局：BorderLayout

        //设置退出操作
        //setDefaultCloseOperation(EXIT_ON_CLOSE); //退出窗口 = 退出程序

        //创建并展示内容
        createAndShowGUI(); //创建
        //SwingUtilities.updateComponentTreeUI(this); //刷新 UI
        setVisible(true); //显示

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("程序退出");
                System.exit(0);
            }
        });
    }

    private void createAndShowGUI() {
        Container contentPane = getContentPane();
        //标题菜单栏
        JMenuBar titleBar = new JMenuBar(); //创建标题菜单栏
        titleBar.add(new JMenu("TEST"));

        //次要选项栏
        /*JTabbedPane secondBar = new JTabbedPane();
        secondBar.addTab("创建单词库", HImageCompress.compressedImageIcon(new ImageIcon("main/src/main/resources/icons/forLight/create.png"), 40), new JPanel(), "A test 1"); //添加测试 Tab
        secondBar.addTab("浏览现有库", HImageCompress.compressedImageIcon(new ImageIcon("main/src/main/resources/icons/forLight/whs.png"), 40), new JPanel(), "WHS"); //添加测试 Tab*/
        //secondBar.putClientProperty(TABBED_PANE_TAB_ICON_PLACEMENT, SwingConstants.TOP); //设置为图标在上文字在下

        JPanel secondBar = new JPanel();
        secondBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        //TODO:Button目前不符合要求，考虑其他符合要求的。样式参考：见 TIM 自己聊天
        secondBar.add(new JButton("TEST"));
        secondBar.add(new JButton("TEST"));
        secondBar.add(new JButton("TEST"));


        contentPane.add(secondBar, BorderLayout.NORTH); //添加 次要选项栏 到窗体

        setJMenuBar(titleBar); //添加 标题菜单栏 到窗口
    }

}