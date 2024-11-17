import java.util.ArrayList;

public class Deck {
    ArrayList<Card> deck = new ArrayList<>();

    public Deck(){
    }

    public void printDeck(){
        System.out.println("Printing deck...");
        for(int i = 0; i < deck.size(); i++){
            Card currentCard = deck.get(i);
            System.out.println(i + 1 + ". Value: " + currentCard.getValue() + ", Suit: " + currentCard.getSuit());
        }
    }

    public void addCardToDeck(Card c){
        deck.add(c);
    }

    public Card drawCard(){
        Card drawnCard = deck.remove(0);
        return drawnCard;
    }

    public int getsize(){
        return deck.size();
    }

    public Card removeCard(int index){
        Card removedCard = deck.remove(index);
        return removedCard;
    }

    public void setDeck(ArrayList<Card> deck) {
        this.deck = deck;
    }

}
