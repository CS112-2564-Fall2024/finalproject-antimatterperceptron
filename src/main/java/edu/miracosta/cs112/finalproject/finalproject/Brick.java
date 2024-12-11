package edu.miracosta.cs112.finalproject.finalproject;

import javafx.scene.canvas.GraphicsContext;

public abstract class Brick extends GameObject {
    protected int hitPoints;

    public Brick(int x, int y, int width, int height, int hitPoints) {
        super(x, y, width, height);
        this.hitPoints = hitPoints;
    }

    public abstract void takeHit();

    public boolean isDestroyed() {
        return hitPoints <= 0;
    }

    @Override
    public void draw(GraphicsContext gc) {
        if (!isDestroyed()) {
            gc.fillRect(x, y, width, height);
        }
    }
}
