package edu.miracosta.cs112.finalproject.finalproject;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class BrickBreakerController {

    @FXML
    private Canvas gameCanvas;

    @FXML
    private Label gameOverLabel;

    @FXML
    private Button playAgainButton;

    private GameLoop gameLoop;
    private Stage primaryStage;

    public void initialize() {
        gameLoop = new GameLoop(gameCanvas, this);

        gameCanvas.setFocusTraversable(true);
        gameCanvas.requestFocus();
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    @FXML
    private void handleKeyPressed(KeyEvent event) {
        gameLoop.handleKeyPressed(event);
    }

    @FXML
    private void handleKeyReleased(KeyEvent event) {
        gameLoop.handleKeyReleased(event);
    }

    public void handleGameOver(boolean isWin) {
        gameOverLabel.setVisible(true);
        playAgainButton.setVisible(true);

        if (isWin) {
            gameOverLabel.setText("You Win!");
        } else {
            gameOverLabel.setText("Game Over!");
        }
    }

    @FXML
    public void handlePlayAgain() {
        gameOverLabel.setVisible(false);
        playAgainButton.setVisible(false);
        initialize();
    }
}
