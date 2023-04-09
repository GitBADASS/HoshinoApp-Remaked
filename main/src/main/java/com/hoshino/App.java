package com.hoshino;

import com.formdev.flatlaf.FlatLaf;
import com.hoshino.frames.StartFrame;

/**
 * HoshinoApp 程序启动启动类
 *
 */
public class App 
{
    public static void main( String[] args ) {
        //注册主题文件夹
        FlatLaf.registerCustomDefaultsSource( "main/src/main/resources/themes" );
        new StartFrame();
    }
}
