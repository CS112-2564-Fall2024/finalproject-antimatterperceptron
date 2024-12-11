package edu.miracosta.cs112.finalproject.finalproject;

import javafx.geometry.BoundingBox;
import javafx.geometry.Bounds;
import javafx.scene.canvas.GraphicsContext;

import java.util.List;


public abstract class GameObject {
    protected int x, y, width, height;

    public GameObject(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public abstract void move();

    public abstract void collide(GameObject other);

    public void draw(GraphicsContext gc) {
        gc.fillRect(x, y, width, height);
    }

    public Bounds getBounds() {
        return new BoundingBox(x, y, width, height);
    }
}
