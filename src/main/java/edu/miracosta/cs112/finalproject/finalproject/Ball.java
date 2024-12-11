package edu.miracosta.cs112.finalproject.finalproject;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Ball extends GameObject {
    private int speedX, speedY;

    public Ball(int x, int y, int width, int height, int speedX, int speedY) {
        super(x, y, width, height);
        this.speedX = speedX;
        this.speedY = speedY;
    }

    @Override
    public void move() {
        x += speedX;
        y += speedY;
    }

    @Override
    public void collide(GameObject other) {
        speedX = -speedX;
        speedY = -speedY;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(Color.RED);
        gc.fillOval(x, y, width, height);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void reverseX() {
        speedX = -speedX;
    }

    public void reverseY() {
        speedY = -speedY;
    }
}
