package edu.miracosta.cs112.finalproject.finalproject;

import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;

public class NormalBrick extends Brick {

    public NormalBrick(int x, int y, int width, int height) {
        super(x, y, width, height, 1);
    }

    @Override
    public void takeHit() {
        hitPoints--;
    }

    @Override
    public void collide(GameObject other) {
        if (other instanceof Ball) {
            takeHit();
        }
    }

    public void move() {
    }

    @Override
    public void draw(GraphicsContext gc) {
        if (!isDestroyed()) {
            gc.setFill(Color.DARKORANGE);
            super.draw(gc);
        }
    }
}
