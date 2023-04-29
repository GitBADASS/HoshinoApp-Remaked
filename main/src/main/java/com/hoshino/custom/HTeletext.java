package com.hoshino.custom;

import javax.swing.*;
import java.awt.*;

public class HTeletext {
    private ImageIcon contentImage;
    private String contentText;

    public HTeletext(String contentText) {
        this.contentText = contentText;
    }

    public ImageIcon getContentImage() {
        return contentImage;
    }

    public void setContentImage(ImageIcon contentImage) {
        this.contentImage = contentImage;
    }

    public void setContentImage(Image image) {
        contentImage = new ImageIcon(image);
    }

    public String getContentText() {
        return contentText;
    }

    public void setContentText(String contentText) {
        this.contentText = contentText;
    }

    @Override
    public String toString() {
        return contentText;
    }
}
