package dev.airship;

import acm.graphics.GImage;

public class Target {
    public double horizontalVelocity = 0.0;
    public double verticalVelocity = -2.0;
    public boolean isAlive;

    private int StartXCoordinate, StartYCoordinate;
    private String src;
    private GImage spaceShip;

    public Target(String src, int StartXCoordinate, int StartYCoordinate) {
        this.src = src;
        this.StartXCoordinate = StartXCoordinate;
        this.StartYCoordinate = StartYCoordinate;
        isAlive = true;
        loadImage();
    }

    public boolean isAlive(){
        return isAlive;
    }

    public void move(){
        spaceShip.move(0, verticalVelocity);
    }

    public double getX(){
        return spaceShip.getX();
    }

    public double getY(){
        return spaceShip.getY();
    }

    private void loadImage() {
        spaceShip = new GImage(src, StartXCoordinate, StartYCoordinate);
        spaceShip.scale(0.2);
    }

    public double getWidth(){
        return spaceShip.getWidth();
    }

    public double getHeight(){
        return spaceShip.getHeight();
    }

    public GImage getImage(){
        return spaceShip;
    }
}
