package com.hoshino.custom.components;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * <h1>底部栏 类</h1>
 * <p>
 *     <b>类介绍</b>
 *     <br>
 *     该类用于方便 底部栏 的创建与添加，建议搭配
 *     {@link java.awt.BorderLayout#SOUTH}
 *     使用。
 * </p>
 * <p>
 *     <b>类信息</b>
 *     <br>
 *     继承自
 *     {@link javax.swing.JPanel}
 *     <br>
 *     无重写方法
 * </p>
 */
public class HBottomBar extends JPanel {
    //默认长度
    public static final int DEFAULT_HEIGHT = 20;
    //所含组件
    ArrayList<Component> contentComps;
    //高度
    int height;

    /**
     * <b>构造方法</b>
     * <p>
     *     构造方法完成了设置 height 的值为 DEFAULT_HEIGHT、设置栏高度、栏内所有组件高度为 DEFAULT_HEIGHT 的任务。
     * </p>
     */
    public HBottomBar() {
        height = DEFAULT_HEIGHT;
        for (Component comp : contentComps) {
            comp.setPreferredSize(new Dimension(0, DEFAULT_HEIGHT));
        }
    }

    /**
     * <b>有关添加组件的方法</b>
     * <p>
     *     这些方法负责设置新组件的高度<em>（组件高度为 height）</em>、向储存组件的 ArrayList 中添加组件并向底部栏添加组件
     * </p>
     */
    public void addComp(Component comp) {
        comp.setPreferredSize(new Dimension(0, height));
        contentComps.add(comp);
        add(comp);
    }

    public void addComp(Component...comps) {
        for (Component comp : comps) {
            comp.setPreferredSize(new Dimension(0, height));
            add(comp);
        }
    }

    public int getSizedHeight() {
        return height;
    }

    private void sizeHeight(int height) {
        this.height = height;
        for (Component contentComp : contentComps) {
            contentComp.setPreferredSize(new Dimension(0, height));
        }
        setPreferredSize(new Dimension(0, height));
    }
}
