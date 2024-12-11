# Brick Breaker Game

## Overview
Brick Breaker is a Java and JavaFX based game where players control a paddle to bounce a ball to destroy bricks. The goal is to break all the bricks without letting the ball hit the ground. Darker bricks are harder to destroy than lighter bricks.

## Features
- Live updates rendering ball movement, paddle control, and collision detection
- Start Screen, Game Screen, and End Screen with a results message and the option to play again
- Built with JavaFX

## Technologies Used
- **Language**: Java
- **Framework**: JavaFX

## Classes and Design

### Core Class
- **GameLoop**: Handles game logic, rendering, and collision detection.

### Additional Classes
- **BrickBreakerController**: Handles user input and GUI updates.
- **GameObject**: Abstract class for all game objects (`Ball`, `Paddle`, and `Brick`).
- **ToughBrick & NormalBrick**: Subclasses of `Brick` with unique behaviors.
- **BallOutOfBoundsException**: Custom exception for handling the ball falling below the paddle.


## Future Updates
- Add difficulty levels (faster ball, more bricks)
- Add sounds and music
- Add a high-score tracking system


