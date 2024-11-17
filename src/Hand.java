
import java.util.ArrayList;

public class Hand {
    ArrayList<Card> hand = new ArrayList<>();
    
    public void populateHand(Card card1, Card card2){
        hand.add(card1);
        hand.add(card2);
    }

    public void printHand(){
        System.err.println("Hand: ");
        for(int i = 0; i < hand.size();i++){
            System.out.println("Card " + i + ": " + hand.get(i));
        }
    }

    public void addToHand(Card card){
        hand.add(card);
    }
}
