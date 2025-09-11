package Model;/*
    Name: Model.DeckHandler class
    Author: Mason Cormany
    Date: 07/10/25
    Purpose: Acts like the dealer of cards. Makes an arraylist of cards that can be returned to a proper object. Mainly used for getting a shuffled deck


    !!! MERGE WITH DECK !!! - 09/10/2025
 */

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

    //Purpose: Makes all the cards with according suits, comes unshuffled.
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
    //Purpose: Takes in a deck, normally an unshuffled one, and shuffles it.
    private ArrayList<Card> shuffleCurrentDeck(ArrayList<Card> oldDeck){
        ArrayList<Card> newDeck = new ArrayList<>();
        while(!oldDeck.isEmpty()){
            int deckSize = oldDeck.size()-1;
            int randomIndex = (int)(Math.random()*deckSize);
            Card newCard = oldDeck.remove(randomIndex);
            newDeck.add(newCard);           
        }
        return newDeck;
    }
    //Purpose: Calls the two previous functions to get a new usable deck
    public ArrayList<Card> shuffleNewDeck(){
        ArrayList<Card> oldDeck = initializeNewDeck();
        return shuffleCurrentDeck(oldDeck);
    }

    //Purpose: sets up HashMap for easy suit allocation
    private void setUpSuitsList(){
        suitMap.put(0, "S");
        suitMap.put(1, "C");
        suitMap.put(2, "H");
        suitMap.put(3, "D");
    }
    //Purpose: sets up HashMap for easy value allocation
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
    //Purpose: sets up HashMap for easy point allocation
    private void setUpPointList(){
        pointMap.put("A",11);
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
}
