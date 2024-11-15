import java.util.ArrayList;
import java.util.HashMap;
public class DeckHandler {
    HashMap<Integer, String> suitMap = new HashMap<Integer, String>();
    HashMap<Integer, String> valueMap = new HashMap<Integer, String>();

    public DeckHandler(){
        setUpSuitsList();
        setUpValuesList();
    }

    private ArrayList<Card> initializeNewDeck(){
        ArrayList<Card> newDeck = new ArrayList<Card>();
        for(int i = 0; i < 13; i++){
            for(int j = 0; j < 4; j++){
                String value = valueMap.get(i);
                String suit = suitMap.get(j);
                Card card = new Card(value, suit);
                newDeck.add(card);
            }
        }
        return newDeck;
    }

    public ArrayList<Card> shuffleCurrentDeck(ArrayList<Card> oldDeck){
        ArrayList<Card> newDeck = new ArrayList<Card>();
        while(!oldDeck.isEmpty()){
            int deckSize = oldDeck.size()-1;
            int randomIndex = (int)(Math.random()*deckSize);
            Card newCard = oldDeck.remove(randomIndex);
            newDeck.add(newCard);           
        }
        return newDeck;
    }

    public ArrayList<Card> shuffleNewDeck(){
        ArrayList<Card> oldDeck = initializeNewDeck();
        ArrayList<Card> newDeck = shuffleCurrentDeck(oldDeck);
        return newDeck;
    }

    public void printDeck(ArrayList<Card> deckOfCards){
        for(int i = 0; i < deckOfCards.size(); i++){
            Card currentCard = deckOfCards.get(i);
            System.out.println(i + 1 + ". Value: " + currentCard.getValue() + ", Suit: " + currentCard.getSuit());
        }
    }

    private void setUpSuitsList(){
        suitMap.put(0, "S");
        suitMap.put(1, "C");
        suitMap.put(2, "H");
        suitMap.put(3, "D");
    }

    private void setUpValuesList(){
        valueMap.put(0, "A");
        valueMap.put(2, "2");
        valueMap.put(3, "3");
        valueMap.put(4, "4");
        valueMap.put(5, "5");
        valueMap.put(6, "6");
        valueMap.put(7, "7");
        valueMap.put(8, "8");
        valueMap.put(9, "9");
        valueMap.put(10, "10");
        valueMap.put(11, "J");
        valueMap.put(12, "Q");
        valueMap.put(13, "K");
    }
}
