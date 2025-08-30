package Controller;

import Model.*;
import View.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class GameController {

    private final GameView View;
    private final BlackjackGame game;

    public GameController(GameView view) {
        this.View = view;
        this.game = new BlackJack(); // or inject externally

        // Initially display cards
        refreshUI();

        view.getHitButton().setOnAction(e -> {
            game.playerHit();
            refreshUI();
            if (game.isGameOver()) {
                view.getStatusLabel().setText("Bust or round over!");
            }
        });

        view.getStayButton().setOnAction(e -> {
            game.dealerPlay();
            refreshUI();
            view.getStatusLabel().setText("Dealer finished. Round over.");
        });
    }

    private void refreshUI() {
        // Clear current displayed cards
        view.getPlayerCardsBox().getChildren().clear();
        view.getDealerCardsBox().getChildren().clear();

        // Add player cards
        for (Card card : game.getPlayerHand().getCards()) {
            view.addCardToPlayer(makeCardImage(card));
        }

        // Add dealer cards
        for (Card card : game.getDealerHand().getCards()) {
            view.addCardToDealer(makeCardImage(card));
        }
    }

    private ImageView makeCardImage(Card card) {
        // Assuming card has rank/suit, and you have matching PNG file in resources/cards/
        String filename = "/cards/" + card.getRank() + card.getSuit() + ".png";
        Image img = new Image(getClass().getResourceAsStream(filename));
        ImageView imgView = new ImageView(img);
        imgView.setFitWidth(80);
        imgView.setPreserveRatio(true);
        return imgView;
    }
}