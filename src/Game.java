/*
    Name: Game class (abstract)
    Author: Mason Cormany
    Date: 07/10/25
    Purpose: Abstract class for any casino card game
 */


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
