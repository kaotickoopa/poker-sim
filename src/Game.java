import java.util.HashMap;
import java.util.Scanner;

public abstract class Game {
    HashMap<Integer, Hand> handMap = new HashMap<>();
    int numberOfPlayers;
    DeckHandler dh = new DeckHandler();
    Deck playingDeck = new Deck();

    public Game(){
        playingDeck.setDeck(dh.shuffleNewDeck());
    }

    abstract void startGame();

    abstract void playerTurn();

    abstract void dealerTurn();

    abstract void showDown();

    abstract String getUserInput(Scanner in);

    public void playGame(){
        startGame();
        playerTurn();
        dealerTurn();
        showDown();
    }
}
