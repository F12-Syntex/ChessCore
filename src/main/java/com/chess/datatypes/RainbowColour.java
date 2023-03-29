package com.chess.datatypes;

import java.awt.Color;

public class RainbowColour extends Color {

    boolean increasing;
    private final float SPEED = 0.005f;
    private final float MAX = 0.5f;
    private final float MIN = 0.3f;

    public RainbowColour(float r, float g, float b, boolean increasing) {
        super(r, g, b);
        this.increasing = increasing;
    }

    public RainbowColour updateColour() {

        float r = this.getRed() / 255f;
        float g = this.getGreen() / 255f;
        float b = this.getBlue() / 255f;

        if(r < MAX-SPEED && increasing){
            r += SPEED;
        }else if(g < MAX-SPEED && increasing){
            g += SPEED;
        }else if(b < MAX-SPEED && increasing){
            b += SPEED;
        }else if(increasing){
            increasing = false;
            System.out.println(r + " " + g + " " + b + " " + increasing);
        }

        if(r > MIN && !increasing){
            r -= SPEED;
        }else if(g > MIN && !increasing){
            g -= SPEED;
        }else if(b > MIN && !increasing){
            b -= SPEED;
        }else if(!increasing){
            increasing = true;
        }

        RainbowColour color = new RainbowColour(r, g, b, increasing);

        return color;
    }

}
