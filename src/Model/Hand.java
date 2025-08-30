package Model;/*
    Name: Model.Hand class
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
        for(int i = 0; i < hand.size();i++){
            System.out.println("Model.Card " + i + ": " + hand.get(i));
        }
        System.out.println("\n");
    }

    public void addToHand(Card card){
        hand.add(card);

        points += card.points;
    }

    public int getHandsPoints(){
        boolean ace_checker = false;

        for(Card current_card : hand){
            if(current_card.value.equals("A")){
                ace_checker = true;
                break;
            }
        }
        if(ace_checker && points > 21){
            return points - 10;
        }
        return points;
    }
}
