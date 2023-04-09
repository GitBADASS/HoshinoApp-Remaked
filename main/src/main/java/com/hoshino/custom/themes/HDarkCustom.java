package com.hoshino.custom.themes;

import com.formdev.flatlaf.FlatDarkLaf;

public class HDarkCustom extends FlatDarkLaf {
    public static boolean setup() {
        return setup( new HDarkCustom() );
    }

    @Override
    public String getName() {
        return "HDarkCustom";
    }
}
