package Model;/*
    Name: Model.Deck class
    Author: Mason Cormany
    Date: 07/10/25
    Purpose: Holds an arraylist of cards. Holds methods to add and remove cards as needed.
 */


import java.util.ArrayList;

public class Deck {
    ArrayList<Card> deck = new ArrayList<>();

    public Deck(){
    }
    //Purpose: Works as a to_string
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
        return deck.removeFirst();
    }

    public Card removeCard(int index){
        return deck.remove(index);
    }

    public void setDeck(ArrayList<Card> deck) {
        this.deck = deck;
    }

}
