package Model;/*
    Name: Model.Game class (abstract)
    Author: Mason Cormany
    Date: 07/10/25
    Purpose: Abstract class for any casino card game
 */


import java.util.HashMap;
import java.util.Scanner;

public abstract class Game {
    Scanner in = new Scanner(System.in);
    HashMap<Integer, Hand> handMap = new HashMap<>();
    int numberOfPlayers;
    int chips = 500;
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

    private boolean checkIfOver(){
        while(true) {
            System.out.println("Would you like to keep playing? (y) or (n)");
            String answer = in.next();
            if (answer.equals("y")) {
                return true;
            } else if (answer.equals("n")) {
                return false;
            } else {
                System.out.println("Improper input, please try again.");
            }
        }
    }

    public void playGame(){
        boolean gameWanted = true;
        while(gameWanted){
            startGame();
            playerTurn();
            dealerTurn();
            showDown();
            gameWanted = checkIfOver();
        }

    }
}
