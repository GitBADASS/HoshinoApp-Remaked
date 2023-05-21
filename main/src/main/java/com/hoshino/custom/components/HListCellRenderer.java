package com.hoshino.custom.components;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

/**
 * <h1>
 *     自定义
 *     {@link ListCellRenderer}
 *     组件
 * </h1>
 * 实现了
 * {@link ListCellRenderer}
 * 的一个类,用于自定义
 * {@link JList}
 * 的项.
 */
public class HListCellRenderer extends JPanel implements ListCellRenderer<Object> {
    private final JLabel textLabel = new JLabel();
    private final ArrayList<String> contentTexts = new ArrayList<>();

    public HListCellRenderer(DefaultListModel<String> model) {
        //容器有关设置
        setLayout(new GridLayout()); //布局：网格布局；目的：使内部组件填充
        setPreferredSize(new Dimension(0, 80)); //尺寸：80px

        //内部组件加载
        setUpContents(model);
    }

    public HListCellRenderer(DefaultListModel<String> model, int height) {
        //容器有关设置
        setLayout(new GridLayout()); //布局：网格布局；目的：使内部组件填充
        setPreferredSize(new Dimension(0, height)); //尺寸：100px

        //内部组件加载
        setUpContents(model);
    }

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
            textLabel.setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
            textLabel.setForeground(list.getForeground());
        }
        textLabel.setText(contentTexts.get(index));

        return this;
    }

    public void addContentText(String text) {
        contentTexts.add(text);
    }

    public ArrayList<String> getContentTexts() {
        return contentTexts;
    }

    private void setUpContents(DefaultListModel<String> model) {
        //文本标签的添加
        //textLabel.setText("什么也没有的..."); //默认内容
        textLabel.setVerticalAlignment(SwingConstants.CENTER); //垂直居中
        textLabel.setHorizontalAlignment(SwingConstants.CENTER); //水平居中
        for (int i = 0; i < model.getSize(); i++) {
            contentTexts.add(model.get(i));
        }
        add(textLabel);
    }

}
