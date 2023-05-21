package com.hoshino.userSettings;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

//加载器类，加载用户配置文件
public class HXMLLoader {
    private String filePath;

    private String iconDir;

    private UserSettings userSettings;


    public HXMLLoader(String path) {
        this.filePath = path;
    }

    public UserSettings load() {
        this.userSettings = new UserSettings();
        //读取xml文件并加载
        File userSettings = new File(filePath);
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
        NodeList userSettingsList = document.getElementsByTagName("userSettings");
        //遍历
        for(int i = 0; i < userSettingsList.getLength(); i++) {
            //获取当前节点
            Node node = userSettingsList.item(i);
            //System.out.println("Current Element: " + node.getNodeName());
            if(node.getNodeType() == Node.ELEMENT_NODE) {
                //获取元素
                Element element = (Element) node;

                //主题方面的自定义  TODO:主题读取官方给定的properties文件
                Node themeNode = element.getElementsByTagName("theme").item(0); //获取标签
                this.userSettings.setTheme(themeNode.getTextContent());

                themeNode = element.getElementsByTagName("userName").item(0); //获取标签
                this.userSettings.setUserName(themeNode.getTextContent());
            }

        }
        return this.userSettings;
    }
}
