import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        DeckHandler deckHandler= new DeckHandler();
        ArrayList<Card> myDeck = deckHandler.shuffleNewDeck();
        deckHandler.printDeck(myDeck);
    }
    
}
