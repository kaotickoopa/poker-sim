import java.util.ArrayList;
import java.util.HashMap;
public class DeckHandler {
    HashMap<Integer, String> suitMap = new HashMap<>();
    HashMap<Integer, String> valueMap = new HashMap<>();
    HashMap<String, Integer> pointMap = new HashMap<>();
    public DeckHandler(){
        setUpSuitsList();
        setUpValuesList();
        setUpPointList();
    }

    private ArrayList<Card> initializeNewDeck(){
        ArrayList<Card> newDeck = new ArrayList<>();
        for(int i = 0; i < 13; i++){
            for(int j = 0; j < 4; j++){
                String value = valueMap.get(i);
                String suit = suitMap.get(j);
                Integer points = pointMap.get(value);
                Card card = new Card(value, suit, points);
                newDeck.add(card);
            }
        }
        return newDeck;
    }

    public ArrayList<Card> shuffleCurrentDeck(ArrayList<Card> oldDeck){
        ArrayList<Card> newDeck = new ArrayList<>();
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
        return shuffleCurrentDeck(oldDeck);
    }


    private void setUpSuitsList(){
        suitMap.put(0, "S");
        suitMap.put(1, "C");
        suitMap.put(2, "H");
        suitMap.put(3, "D");
    }

    private void setUpValuesList(){
        valueMap.put(0, "A");
        valueMap.put(1, "2");
        valueMap.put(2, "3");
        valueMap.put(3, "4");
        valueMap.put(4, "5");
        valueMap.put(5, "6");
        valueMap.put(6, "7");
        valueMap.put(7, "8");
        valueMap.put(8, "9");
        valueMap.put(9, "10");
        valueMap.put(10, "J");
        valueMap.put(11, "Q");
        valueMap.put(12, "K");
    }

    private void setUpPointList(){
        pointMap.put("A",1);
        pointMap.put("2", 2);
        pointMap.put("3", 3);
        pointMap.put("4", 4);
        pointMap.put("5", 5);
        pointMap.put("6", 6);
        pointMap.put("7", 7);
        pointMap.put("8", 8);
        pointMap.put("9", 9);
        pointMap.put("10", 10);
        pointMap.put("J", 10);
        pointMap.put("Q", 10);
        pointMap.put("K", 10);
    }

    public HashMap<Integer, String> getSuitMap() {
        return suitMap;
    }

    public void setSuitMap(HashMap<Integer, String> suitMap) {
        this.suitMap = suitMap;
    }
}
