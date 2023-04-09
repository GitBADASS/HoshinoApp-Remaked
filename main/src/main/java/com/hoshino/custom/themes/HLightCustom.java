package com.hoshino.custom.themes;

import com.formdev.flatlaf.FlatLightLaf;

public class HLightCustom extends FlatLightLaf {
    public static boolean setup() {
        return setup( new HLightCustom() );
    }

    @Override
    public String getName() {
        return "HLightCustom";
    }
}
