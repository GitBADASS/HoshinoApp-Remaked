package com.hoshino.custom.components;

import javax.swing.*;

public class HToggleButton extends JToggleButton {
    public HToggleButton() {
        super();
        setBorderPainted(false);
    }

    public HToggleButton(String text) {
        this();
        setText(text);
    }

    public HToggleButton(ImageIcon img) {
        this();
        setIcon(img);
    }

    public HToggleButton(String text, ImageIcon img) {
        this();
        setText(text);
        setIcon(img);
    }
}
