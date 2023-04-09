package com.hoshino.frames;

import com.formdev.flatlaf.intellijthemes.FlatDarkFlatIJTheme;
import com.hoshino.custom.img.HImageCompress;
import com.hoshino.custom.themes.HCyan;
import com.hoshino.custom.themes.HDarkCustom;
import com.hoshino.custom.themes.HLightCustom;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class HBasicFrame extends JFrame {
    private ImageIcon icon;
    private String themeStyle;

    public HBasicFrame() {
        //加载用户设置
        updateSettings();
        UIManager.put("accentFocusColor", Color.decode("#4600C7"));
        //窗口居中出现
        setLocationRelativeTo(null);
    }

    //带参构造：自定义标题文本
    public HBasicFrame(String titleText) {
        this();
        this.setTitle(titleText);
    }

    //带参构造：自指定标题文本、图标
    public HBasicFrame(String titleText, ImageIcon icon) {
        this();
        this.setTitle(titleText);
        this.icon = icon;
        this.setIconImage(icon.getImage());
    }

    //设置主题
    public void setThemeStyle(String themeStyle) {
        switch (themeStyle) {
            case "LIGHT":
                HLightCustom.setup();
                break;
            case "DARK":
                HDarkCustom.setup();
                break;
        }
        SwingUtilities.updateComponentTreeUI(this);
        this.themeStyle = themeStyle;
    }

    //获取当前主题
    public String getThemeStyle() {
        return themeStyle == null ? "LIGHT" : themeStyle;
    }

    public ImageIcon getIcon() {
        return icon;
    }

    //加载、更新用户配置
    public void updateSettings() {
        //读取xml文件并加载
        File userSettings = new File("main/src/main/resources/user/settings.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        }
        Document document;
        try {
            document = builder.parse(userSettings);
        } catch (SAXException | IOException e) {
            throw new RuntimeException(e);
        }
        document.getDocumentElement().normalize();
        NodeList nodeList = document.getElementsByTagName("userSettings");
        //遍历
        for(int i = 0; i < nodeList.getLength(); i++) {
            //获取当前节点
            Node node = nodeList.item(i);
            System.out.println("Current Element: " + node.getNodeName());
            if(node.getNodeType() == Node.ELEMENT_NODE) {
                //获取元素
                Element element = (Element) node;

                //主题方面的自定义  TODO:主题的话，读取官方给定的properties文件！！！
                Node themeNode = element.getElementsByTagName("theme").item(0); //获取标签
                String themeContent = themeNode.getTextContent(); //获取内容
                themeStyle = themeContent; //更新当前主题
                setThemeStyle(themeContent); //设置主题

                //图标自定义
                Node iconNode = element.getElementsByTagName("icon").item(0); //获取标签
                String iconPath = iconNode.getTextContent(); //获取内容
                icon = new ImageIcon(iconPath); //更新当前图标
                setIconImage(HImageCompress.compressedImage(icon)); //设置图标到标题栏
            }
        }
    }
}
