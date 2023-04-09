package com.hoshino.custom.themes;

import com.formdev.flatlaf.themes.FlatMacLightLaf;

public class HCyan extends FlatMacLightLaf {
    public static boolean setup() {
        return setup( new HCyan() );
    }

    @Override
    public String getName() {
        return "HCyan";
    }
}
