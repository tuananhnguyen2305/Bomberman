package uet.oop.bomberman.entities;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.graphics.Sprite;

import java.util.Random;

public class Oneal extends Movable {

    public Oneal(int x, int y, Image img) {
        super(x, y, img);
        sprite = Sprite.oneal_right1;
    }

    @Override
    public void update() {
        animate();
        calculateMove();

        //choose direction with super basic if-else
        int direction = -1;
        if (x/32 < BombermanGame._bomber.x/32)
            direction = 3;
        if (x/32 > BombermanGame._bomber.x/32)
            direction = 2;
        if (y/32 < BombermanGame._bomber.y/32)
            direction = 0;
        if (y/32 > BombermanGame._bomber.y/32)
            direction = 1;

        if (waitTime > 0) waitTime--;
        if (waitTime == 0) {
            System.out.println("x/32: " + x/32 + "\nBombermanGame._bomber.x/32: " + BombermanGame._bomber.x/32
                    + "\ny/32: " + y/32 + "\nBombermanGame._bomber.y/32: " + BombermanGame._bomber.y/32 + "\ndirection: " + direction);

            switch (direction) {
                case 0:
                    waitTime = 30;
                    setMoveDown(true);
                    setMoveUp(false);
                    setMoveLeft(false);
                    setMoveRight(false);
                    break;
                case 1:
                    waitTime = 30;
                    setMoveDown(false);
                    setMoveUp(true);
                    setMoveLeft(false);
                    setMoveRight(false);
                    break;
                case 2:
                    waitTime = 30;
                    setMoveDown(false);
                    setMoveUp(false);
                    setMoveLeft(true);
                    setMoveRight(false);
                    break;
                case 3:
                    waitTime = 30;
                    setMoveDown(false);
                    setMoveUp(false);
                    setMoveLeft(false);
                    setMoveRight(true);
                    break;
            }
        }
    }

    @Override
    protected void chooseSprite() {
        switch(_direction) {
            case 3:
                sprite = Sprite.oneal_left1;
                if(_moving) {
                    sprite = Sprite.movingSprite(Sprite.oneal_left2, Sprite.oneal_left3, _animate, 20);
                }
                break;
            case 1:
                sprite = Sprite.oneal_right1;
                if(_moving) {
                    sprite = Sprite.movingSprite(Sprite.oneal_right2, Sprite.oneal_right3, _animate, 20);
                }
                break;
        }
    }


    @Override
    public void render(GraphicsContext gc) {
        if (isAlive) {
            chooseSprite();
            gc.drawImage(sprite.getFxImage(), x, y);
        } else {
            sprite = Sprite.oneal_dead;
        }
    }
}