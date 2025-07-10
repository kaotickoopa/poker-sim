/*
    Name: Hand class
    Author: Mason Cormany
    Date: 07/10/25
    Purpose: Works as a mini deck that has points and can determine if the player's turn is over
 */

import java.util.ArrayList;

public class Hand {
    ArrayList<Card> hand = new ArrayList<>();
    Integer points = 0;
    boolean isValid = true;

    //Purpose: Prints the player's hand *make to_string
    public void printHand(){
        System.err.println("Hand: ");
        for(int i = 0; i < hand.size();i++){
            System.out.println("Card " + i + ": " + hand.get(i));
        }
    }

    public void addToHand(Card card){
        hand.add(card);

        points += card.points;
    }

    public int getHandsPoints(){ return points; }
}
