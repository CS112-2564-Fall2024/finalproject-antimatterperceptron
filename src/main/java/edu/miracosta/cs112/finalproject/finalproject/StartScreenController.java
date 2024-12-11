package edu.miracosta.cs112.finalproject.finalproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StartScreenController {

    private Stage primaryStage;

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void startGame(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("brick-breaker-view.fxml"));
            Parent root = loader.load();

            Scene gameScene = new Scene(root);
            primaryStage.setScene(gameScene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
