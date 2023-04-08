package com.hoshino.custom.img;

import javax.swing.*;
import java.awt.*;

public class HImageCompress {

    public static ImageIcon compressedImageIcon(ImageIcon target) {
        ImageIcon compressed = new ImageIcon();
        compressed.setImage(target.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH));
        return compressed;
    }

    public static Image compressedImage(ImageIcon target) {
        Image compressed = target.getImage();
        compressed.getScaledInstance(16, 16, Image.SCALE_SMOOTH);
        return compressed;
    }

    public static void imageCompress(ImageIcon target) {
        target.setImage(target.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH));
    }
}
