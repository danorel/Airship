package dev.airship;

import acm.graphics.GImage;

public class Background {

    private GImage Background;
    private int w, h;

    public Background(String src){
        loadBackgroundImage(src);
    }

    private void loadBackgroundImage(String src){
        Background = new GImage(src);
    }

    public GImage getBackgroundImage(){
        return Background;
    }

    public int getBackgroundImageWidth(){
        return w;
    }

    public int getBackgroundImageHeight(){
        return h;
    }
}
