
import java.util.ArrayList;

public class Hand {
    ArrayList<Card> hand = new ArrayList<>();
    Integer points = 0;
    boolean isValid = true;
    
    public void populateHand(Card card1, Card card2){
        hand.add(card1);
        hand.add(card2);
        points += card1.points;
        points += card2.points;
    }

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
