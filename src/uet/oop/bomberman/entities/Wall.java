package uet.oop.bomberman.entities;

import javafx.scene.image.Image;

public class Wall extends Entity {

    public Wall(int x, int y, Image img) {
        super(x, y, img);
    }

    @Override
    public void update() {

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean collide(Entity e) {
        return false;
    }
}
