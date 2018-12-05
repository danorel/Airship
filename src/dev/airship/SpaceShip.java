package dev.airship;

import acm.graphics.GImage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class SpaceShip {

    public double horizontalVelocity = 2.0;
    public double verticalVelocity = 0.0;

    private int StartXCoordinate, StartYCoordinate;
    private String src;
    private GImage spaceShip;
    public Missile missile;

    public SpaceShip(String src, int StartXCoordinate, int StartYCoordinate) {
        this.src = src;
        this.StartXCoordinate = StartXCoordinate;
        this.StartYCoordinate = StartYCoordinate;
        loadImage();
    }

    public void move(){
        spaceShip.move(horizontalVelocity, verticalVelocity);
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
