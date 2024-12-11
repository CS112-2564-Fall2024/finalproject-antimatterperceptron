package edu.miracosta.cs112.finalproject.finalproject;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;

public class GameLoop {

    private final GraphicsContext gc;
    private final Canvas canvas;
    private final BrickBreakerController controller;

    private Ball ball;
    private Paddle paddle;
    private Brick[][] bricks;
    private int remainingBricks;

    private boolean isGameOver = false;
    private AnimationTimer timer;

    public GameLoop(Canvas canvas, BrickBreakerController controller) {
        this.canvas = canvas;
        this.controller = controller;
        this.gc = canvas.getGraphicsContext2D();

        setupGame();

        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                update();
                render();
                checkGameEnd();
            }
        };
        timer.start();
    }

    //used ai for help with this
    private void setupGame() {
        ball = new Ball(500, 500, 20, 20, 4, 3);
        paddle = new Paddle(450, 550, 150, 15, 7);

        int rows = 3;
        int cols = 11;

        bricks = new Brick[rows][cols];
        remainingBricks = rows * cols;

        int brickWidth = 80;
        int brickHeight = 20;

        int brickSpacing = 10;
        int startX = 10;
        int startY = 10;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int brickX = startX + col * (brickWidth + brickSpacing);
                int brickY = startY + row * (brickHeight + brickSpacing);

                if (row == 0) {
                    bricks[row][col] = new ToughBrick(brickX, brickY, brickWidth, brickHeight);
                } else {
                    bricks[row][col] = new NormalBrick(brickX, brickY, brickWidth, brickHeight);
                }
            }
        }
    }


    private void update() {
        if (!isGameOver) {
            ball.move();
            handleCollisions();
            paddle.move();
        }
    }

    private void render() {
        if (!isGameOver) {
            gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
            ball.draw(gc);
            paddle.draw(gc);

            for (Brick[] row : bricks) {
                for (Brick brick : row) {
                    if (brick != null && !brick.isDestroyed()) {
                        brick.draw(gc);
                    }
                }
            }
        }
    }


    private void handleCollisions() {
        if (ball.getX() <= 0 || ball.getX() >= canvas.getWidth() - ball.getWidth()) {
            ball.reverseX();
        }
        if (ball.getY() <= 0) {
            ball.reverseY();
        }

        if (ball.getBounds().intersects(paddle.getBounds())) {
            ball.reverseY();
        }

        //used ai here
        for (int row = 0; row < bricks.length; row++) {
            for (int col = 0; col < bricks[row].length; col++) {
                Brick brick = bricks[row][col];
                if (brick != null && !brick.isDestroyed() && ball.getBounds().intersects(brick.getBounds())) {
                    brick.takeHit();
                    ball.reverseY();
                    if (brick.isDestroyed()) {
                        bricks[row][col] = null;
                        remainingBricks--;
                    }
                }
            }
        }

        try {
            if (ball.getY() >= canvas.getHeight()) {
                throw new BallOutOfBoundsException("The ball hit the floor!");
            }
        } catch (BallOutOfBoundsException e) {
            System.out.println(e.getMessage());
            controller.handleGameOver(false);
            timer.stop();
            isGameOver = true;
        }
    }

    private void checkGameEnd() {
        if (!isGameOver && remainingBricks <= 0) {
            controller.handleGameOver(true);
            timer.stop();
            isGameOver = true;
        }
    }

    public void handleKeyPressed(KeyEvent event) {
        switch (event.getCode()) {
            case LEFT -> paddle.setMovingLeft(true);
            case RIGHT -> paddle.setMovingRight(true);
        }
    }

    public void handleKeyReleased(KeyEvent event) {
        switch (event.getCode()) {
            case LEFT -> paddle.setMovingLeft(false);
            case RIGHT -> paddle.setMovingRight(false);
        }
    }
}
