package View;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import Controller.GameController;

public class BlackjackApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        GameView gameView = new GameView();         // Create the UI layout
        GameController controller = new GameController(gameView); // Hook up controller

        Scene scene = new Scene(gameView.getRoot(), 800, 600);
        scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());

        primaryStage.setTitle("Blackjack");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}