package View;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class GameView {

    private BorderPane root;

    // UI Elements
    private HBox dealerCards;
    private HBox playerCards;
    private Button hitButton;
    private Button stayButton;
    private Label statusLabel;

    public GameView() {
        root = new BorderPane();

        // Dealer area
        dealerCards = new HBox(10);
        dealerCards.setAlignment(Pos.CENTER);
        Label dealerLabel = new Label("Dealer");
        VBox dealerBox = new VBox(5, dealerLabel, dealerCards);
        dealerBox.setAlignment(Pos.CENTER);

        // Player area
        playerCards = new HBox(10);
        playerCards.setAlignment(Pos.CENTER);
        Label playerLabel = new Label("Player");
        VBox playerBox = new VBox(5, playerLabel, playerCards);
        playerBox.setAlignment(Pos.CENTER);

        // Buttons
        hitButton = new Button("Hit");
        stayButton = new Button("Stay");
        HBox buttonBox = new HBox(20, hitButton, stayButton);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setPadding(new Insets(10));

        // Status label
        statusLabel = new Label("Welcome to Blackjack!");
        statusLabel.setAlignment(Pos.CENTER);

        // Layout
        VBox centerBox = new VBox(20, dealerBox, playerBox, buttonBox, statusLabel);
        centerBox.setAlignment(Pos.CENTER);
        centerBox.setPadding(new Insets(20));

        root.setCenter(centerBox);
    }

    public BorderPane getRoot() {
        return root;
    }

    // Accessors for controller
    public Button getHitButton() {
        return hitButton;
    }

    public Button getStayButton() {
        return stayButton;
    }

    public HBox getPlayerCardsBox() {
        return playerCards;
    }

    public HBox getDealerCardsBox() {
        return dealerCards;
    }

    public Label getStatusLabel() {
        return statusLabel;
    }

    // Example helper to add a card visually
    public void addCardToPlayer(ImageView cardImage) {
        playerCards.getChildren().add(cardImage);
    }

    public void addCardToDealer(ImageView cardImage) {
        dealerCards.getChildren().add(cardImage);
    }
}