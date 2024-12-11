package edu.miracosta.cs112.finalproject.finalproject;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Paddle extends GameObject {
    private int speed;
    private boolean isMovingLeft;
    private boolean isMovingRight;

    public Paddle(int x, int y, int width, int height, int speed) {
        super(x, y, width, height);
        this.speed = speed;
        this.isMovingLeft = false;
        this.isMovingRight = false;
    }

    @Override
    public void move() {
        if (isMovingLeft && x > 0) {
            x -= speed;
        }
        if (isMovingRight && x + width < 1000) {
            x += speed;
        }
    }

    @Override
    public void collide(GameObject other) {
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(Color.BLUE);
        gc.fillRect(x, y, width, height);
    }


    public void setMovingLeft(boolean movingLeft) {
        this.isMovingLeft = movingLeft;
    }

    public void setMovingRight(boolean movingRight) {
        this.isMovingRight = movingRight;
    }
}
