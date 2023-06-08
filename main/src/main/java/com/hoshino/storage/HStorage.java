package com.hoshino.storage;

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
import java.util.ArrayList;

//加载器类，加载用户配置文件
public class HStorage {
    private String filePath;

    private String iconDir;

    private Document document;

    private UserSettings userSettings;

    private ArrayList<HXMLFollower> followers = new ArrayList<>();

    public static final String THEME_TAG = "theme";

    //TODO: 如何把这个方法和 WelcomePage 的 updateAll() 方法联系到一起？ 可能的解答：订阅、通知、操作（也就是模仿 C# 的 Event 处理机制
    public HStorage(String path) {
        this.filePath = path;
    }

    public UserSettings load() {
        this.userSettings = new UserSettings();
        //读取xml文件并加载
        loadXML();
        operateElement(node -> {
            //获取元素
            Element elements = (Element) node;

            //主题方面的自定义  TODO:主题读取官方给定的 properties 文件
            Node getter = elements.getElementsByTagName(THEME_TAG).item(0); //获取标签
            userSettings.setTheme(getter.getTextContent());

            //用户名称
            getter = elements.getElementsByTagName("userName").item(0); //获取标签
            userSettings.setUserName(getter.getTextContent());
        });

        return this.userSettings;
    }

    //更新配置文件路径 + 重新加载
    public void updateFilePath(String filePath) {
        this.filePath = filePath;
        this.userSettings = new HStorage(filePath).load();
    }

    //操作属性区域 ==============================================
    public String getFilePath() {
        return filePath;
    }

    public String getIconDir() {
        return iconDir;
    }

    public UserSettings getUserSettings() {
        return userSettings;
    }

    public ArrayList<HXMLFollower> getFollowers() {
        return followers;
    }

    public void setFollowers(ArrayList<HXMLFollower> followers) {
        this.followers = followers;
    }

    public void addFollowers(HXMLFollower followers) {
        this.followers.add(followers);
    }

    //文件修改区域 ==============================================
    //修改和重新加载用户名
    public void modifyAndUpdateUserName(String newName) {

    }

    //修改和重新加载主题
    public void modifyAndUpdateTheme(String newTheme) {
        operateElement(node -> {
            Element elements = (Element) node;
            Node nodeGetter = elements.getElementsByTagName(THEME_TAG).item(0);

            nodeGetter.setTextContent(newTheme);
            userSettings.setTheme(nodeGetter.getTextContent());
        });

        for (HXMLFollower follower : followers) {
            follower.updateTheme();
        }
    }

    public void operateElement(ElementOperator operator){
        //读取xml文件并加载
        Document document = this.document;
        NodeList userSettingsList = document.getElementsByTagName("userSettings");
        //遍历
        for(int i = 0; i < userSettingsList.getLength(); i++) {
            //获取当前节点
            Node node = userSettingsList.item(i);
            //System.out.println("Current Element: " + node.getNodeName());
            if(node.getNodeType() == Node.ELEMENT_NODE) {
                //对获取到的内容进行操作
                operator.operate(node);
            }

        }
    }

    private interface ElementOperator {
        void operate(Node node);
    }

    //加载读取模块 便于阅读
    private void loadXML() {
        //读取xml文件并加载
        File userSettingsFile = new File(filePath);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        }
        Document document;
        try {
            document = builder.parse(userSettingsFile);
        } catch (SAXException | IOException e) {
            throw new RuntimeException(e);
        }
        document.getDocumentElement().normalize();
        this.document = document;
    }
}
