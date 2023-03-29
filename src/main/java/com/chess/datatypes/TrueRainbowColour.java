package com.chess.datatypes;

import java.awt.Color;

public class TrueRainbowColour extends Color {

    boolean increasing;
    private int increment = 0;

    public TrueRainbowColour(int r, int g, int b, boolean increasing, int increment) {
        super(r, g, b);
        this.increasing = increasing;
        this.increment = increment;
    }

    public TrueRainbowColour updateColour() {

        int r = (int)(increment / (255*255));
        int g = (int)(increment / 255);
        int b = (int)(increment % 255);

        System.out.println(r + " " + g + " " + b + " " + increasing);

        TrueRainbowColour color = new TrueRainbowColour(r, g, b, increasing, (increment+5));

        return color;
    }

}
