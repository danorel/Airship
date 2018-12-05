package dev.airship;

import acm.graphics.GImage;
import acm.io.IODialog;
import acm.program.GraphicsProgram;

import java.awt.event.KeyEvent;
import java.util.*;

public class Game extends GraphicsProgram {
    private IODialog dialog;
    private SpaceShip spaceShip;
    private Missile[] missiles;
    private static final int NumberOfMissiles = 20;
    private int currentMissile = 0;

    private Background background;
    private Timer timer;

    private static final int MyStartXCoordinate = 100;
    private static final int MyStartYCoordinate = 100;
    private static final int PAUSE_TIME = 20;

    private Target[] targets;
    private static final int NumberOfEnemies = 3;
    private int currentTarget = 0;

    private int counter = 0;
    private static final int GENERATE_TIME = 4;

    private int rememberKey;


    public void init(){
        dialog = new IODialog();
        targets = new Target[NumberOfEnemies];
        missiles = new Missile[NumberOfMissiles];
    }

    public void run(){
        addKeyListeners();
        background = new Background("image/background/background.png");
        spaceShip = new SpaceShip("image/plane_models/plane_model_1_right.png", MyStartXCoordinate, MyStartYCoordinate);
        add(background.getBackgroundImage());
        add(spaceShip.getImage());

        int randomEnemyImage = (int)(Math.random() * (6 - 2)) + 2;
        for(int counter = 0; counter < NumberOfEnemies; counter++){
            int enemyRandomY = (int) (Math.random() * (getHeight() - 200)) + 100;
            targets[counter] = new Target("image/plane_models/plane_model_" +  + randomEnemyImage + "_left.png", getWidth() - 100, enemyRandomY);
            add(targets[currentTarget].getImage());
        }

        counter++;

        while(true){
            if(spaceShip.getX() > getWidth() - spaceShip.getWidth()){
                remove(spaceShip.getImage());
                spaceShip = new SpaceShip("image/plane_models/plane_model_1_right.png", 0, MyStartYCoordinate);
                add(spaceShip.getImage());
            }
            spaceShip.move();
            if(targets[currentTarget].getY() < 50){
                targets[currentTarget].verticalVelocity = 2.0;
            } else if(targets[currentTarget].getY() + targets.get(counter - 1).getHeight() > 450) {
                targets[currentTarget].verticalVelocity = -2.0;
            }

            if(targets[currentTarget].isAlive()){
                targets[currentTarget].move();
            }

            if(currentMissile != missiles.length - 1){
                missiles[currentMissile].move();
                if((missiles[currentMissile].getX() + missiles[currentMissile].getWidth() >= targets[currentTarget].getX() ) && ( missiles[currentMissile].getY() >= targets[currentTarget].getY() ) && ( missiles[currentMissile].getY() <=  targets.get(counter - 1).getY() +  targets.get(counter - 1).getHeight() )){
                    remove(missiles[currentMissile].getImage());
                    GImage boom_effect = new GImage("image/effects/boom_effect.png", targets.get(counter - 1).getX(), targets.get(counter - 1).getY() + 20);
                    remove(targets.get(counter - 1).getImage());
                    targets.get(counter - 1).isAlive = false;
                    boom_effect.scale(0.4);
                    add(boom_effect);
                    pause(50);
                    remove(boom_effect);
                }
            } else {
                dialog.println("You've lost all the bombs!");
                this.exit();
            }
            pause(PAUSE_TIME);
        }
    }


//    class RemindTask extends TimerTask {
//        @Override
//        public void run() {
//            int enemyRandomY = (int) (Math.random() * getHeight());
//            targets.add(new Target("image/plane_models/plane_model_2_left.png", getWidth() - 100, enemyRandomY));
//            add(targets.get(counter).getImage());
//            counter++;
//            timer.cancel();
//        }
//    }

    public void keyPressed(KeyEvent event){
        rememberKey = event.getKeyCode();
        switch (event.getKeyCode()){
            case KeyEvent.VK_DOWN:
                spaceShip.verticalVelocity = 2.0;
                spaceShip.horizontalVelocity = 0.0;
                break;
            case KeyEvent.VK_UP:
                spaceShip.verticalVelocity = -2.0;
                spaceShip.horizontalVelocity = 0.0;
                break;
            case KeyEvent.VK_LEFT:
                while(spaceShip.horizontalVelocity != -2.0){
                    spaceShip.horizontalVelocity -= 1.0;
                }
                spaceShip.verticalVelocity = 0;
                break;
            case KeyEvent.VK_RIGHT:
                while(spaceShip.horizontalVelocity != 3.0){
                    spaceShip.horizontalVelocity += 1.0;
                }
                spaceShip.verticalVelocity = 0;
                break;
            case KeyEvent.VK_ENTER:
                missiles[currentMissile] = new Missile("image/missiles/missile_1.png", (int)spaceShip.getX() + (int)spaceShip.getWidth() / 4 * 3, (int)spaceShip.getY() + (int)spaceShip.getHeight()/2 - 10);
                add(missiles[currentMissile].getImage());
                break;
        }
    }

    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_RIGHT){
            spaceShip.horizontalVelocity = 0.0;
            spaceShip.verticalVelocity = 0.0;
        }
        if(key == KeyEvent.VK_LEFT){
            spaceShip.horizontalVelocity = 0.0;
            spaceShip.verticalVelocity = 0.0;
        }
        if(key == KeyEvent.VK_UP){
            spaceShip.horizontalVelocity = 0.0;
            spaceShip.verticalVelocity = 0.0;
        }
        if(key == KeyEvent.VK_DOWN){
            spaceShip.horizontalVelocity = 0.0;
            spaceShip.verticalVelocity = 0.0;
        }
    }
}
