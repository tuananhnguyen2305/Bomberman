package uet.oop.bomberman.entities;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import uet.oop.bomberman.graphics.Sprite;

public class Brick extends Entity {
    private boolean destroy = false;
    private boolean remove = false;
    public Brick(int x, int y, Image img) {
        super( x, y, img);
    }

    @Override
    public void render(GraphicsContext gc) {
        gc.drawImage(img, x, y);
        if (destroy) {
            img = Sprite.movingSprite(Sprite.brick_exploded, Sprite.brick_exploded1, Sprite.grass, _animate, 40).getFxImage();
            gc.drawImage(img, x, y);
        }
    }

    @Override
    public void update() {
        animate();
    }

    @Override
    public boolean collide(Entity e) {
        return false;
    }
}
