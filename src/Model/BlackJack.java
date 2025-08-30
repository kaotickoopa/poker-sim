package Model;/*
    Name: Model.BlackJack class
    Author: Mason Cormany
    Date: 07/10/25
    Purpose: Concrete Blackjack class that holds all game rules.
 */

import java.util.Scanner;
import java.lang.*;

public class BlackJack extends Game {
    boolean isGameOver = false;

    public BlackJack(){
        System.out.println("Let's play Blackjack! Press any button to continue");
        in.nextLine();
    }
    //Purpose: Adds cards to the dealer and specified number of players. Sets up handmap
    @Override
     void startGame(){

        Hand currentHand = new Hand();
        Card firstDrawnCard = playingDeck.drawCard();
        Card secondDrawnCard = playingDeck.drawCard();
        currentHand.addToHand(firstDrawnCard);
        currentHand.addToHand(secondDrawnCard);

        handMap.put(0, currentHand);
        currentHand = new Hand();
        firstDrawnCard = playingDeck.drawCard();
        secondDrawnCard = playingDeck.drawCard();
        currentHand.addToHand(firstDrawnCard);
        currentHand.addToHand(secondDrawnCard);
        handMap.put(1, currentHand);

        System.out.printf("You currently have %d chips\n", chips);
    }

    //Purpose: Base player turn, player can hit or stand. They lose when they bust
    @Override
     void playerTurn(){
        Hand currentHand = handMap.get(1);
        System.out.println("Player's Model.Hand");
        currentHand.printHand();
        while (true) {
            //draws cards until over 21 or user stops

            String userInput = getUserInput(in).toLowerCase();
            if(userInput.equals("h")){
                Card drawnCard = playingDeck.drawCard();
                currentHand.addToHand(drawnCard);
                System.out.println("Player's Model.Hand");
                currentHand.printHand();
                if(currentHand.getHandsPoints() > 21){
                    currentHand.isValid = false;
                    System.out.println("You busted! You lose pal");
                    break;
                }
            }
            else if (userInput.equals("s")) {
                break;
            }
            else {
                System.out.println("Invalid input. Try again");
            }
        }
    }
    //Purpose: Normal dealer turn, they draw until their hand value is greater than 16
    @Override
     void dealerTurn(){
        Hand currentHand = handMap.get(0);
        System.out.println("Dealer's Model.Hand");
        currentHand.printHand();
        while (true) {
            //draws cards until over 21 or user stops
            if(currentHand.getHandsPoints() < 17){
                Card drawnCard = playingDeck.drawCard();
                currentHand.addToHand(drawnCard);
                System.out.println("Dealer's Model.Hand");
                currentHand.printHand();
            }
            else {
                break;
            }
        }

    }
    //Purpose: Ends the game, sees if the players are able to beat the dealer. Skips players who have busted.
    @Override
     void showDown(){
        Hand dealerHand = handMap.get(0);
        int dealerPoints = dealerHand.getHandsPoints();
        Hand player_hand = handMap.get(1);
        if(player_hand.isValid){
            int player_points = player_hand.getHandsPoints();
            if( player_points > dealerPoints || dealerPoints > 21){
                System.out.println("Congrats you win !");
                chips *= 2;
            }
            else{
                System.out.println("Sorry you lose!");
                chips = 0;
            }
        }

    }

    //Purpose: Easy function to ask for player's input
    @Override
     String getUserInput(Scanner in){
        System.out.println("Do you hit (H) or stay (S)?");
        return in.next();
    } 
}
