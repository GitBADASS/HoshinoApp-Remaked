package com.hoshino.frames;

import com.formdev.flatlaf.intellijthemes.FlatDarkFlatIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatLightFlatIJTheme;
import com.hoshino.custom.components.HToggleButton;
import com.hoshino.custom.img.HImageCompress;

import javax.swing.*;
import java.awt.*;

public class StartFrame extends HBasicFrame{
    int themeState;

    public StartFrame() {
        super("test");

        //添加标题栏组件栏
        JMenuBar titleBar = new JMenuBar();
        //日夜间切换按钮
        HToggleButton dayOrNight = new HToggleButton("day", HImageCompress.compressedImageIcon(new ImageIcon("main/src/main/resources/img/icon.png")));
        themeState = 1;
        dayOrNight.addChangeListener(e->{
            if(themeState == 1){
                dayOrNight.setText("night");
                FlatDarkFlatIJTheme.setup();
                SwingUtilities.updateComponentTreeUI(this);
                this.setIconImage(HImageCompress.compressedImage(new ImageIcon("main/src/main/resources/img/icon-night.png")));
            } else if(themeState == 2) {
                themeState = 1;
                dayOrNight.setText("day");
                FlatLightFlatIJTheme.setup();
                SwingUtilities.updateComponentTreeUI(this);
                this.setIconImage(HImageCompress.compressedImage(new ImageIcon("main/src/main/resources/img/icon.png")));
            }
        });
        titleBar.add(dayOrNight);

        //添加内容到
        setJMenuBar(titleBar);

        //部分设置
        setSize(800, 500); //大小
        setVisible(true); //可见
    }
}
