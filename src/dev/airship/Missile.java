package dev.airship;

import acm.graphics.GImage;

public class Missile {

    public double horizontalVelocity = 4.0;
    public double verticalVelocity = 0.0;

    private int StartXCoordinate, StartYCoordinate;
    private String src;
    private GImage Missile;

    public Missile(String src, int StartXCoordinate, int StartYCoordinate) {
        this.src = src;
        this.StartXCoordinate = StartXCoordinate;
        this.StartYCoordinate = StartYCoordinate;
        loadImage();
    }

    public void move(){
        Missile.move(horizontalVelocity, verticalVelocity);
    }

    public double getX(){
        return Missile.getX();
    }

    public double getY(){
        return Missile.getY();
    }

    private void loadImage() {
        Missile = new GImage(src, StartXCoordinate, StartYCoordinate);
        Missile.scale(0.07);
    }

    public double getWidth(){
        return Missile.getWidth();
    }

    public double getHeight(){
        return Missile.getHeight();
    }

    public GImage getImage(){
        return Missile;
    }
}
