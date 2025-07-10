/*
    Name: Card class
    Author: Mason Cormany
    Date: 07/10/25
    Purpose: Base card class that can be used for any game! Can assign custom values to cards for different games
 */

public class Card {
    String value;
    String suit;
    Integer points;

    public Card(String value, String suit, int points){
        this.value = value;
        this.suit = suit;
        this.points = points;
    }

    public String getValue(){ return value; }

    public String getSuit(){ return suit; }

    public Integer getPoints() { return points; }

    public String toString(){
        return value + " of " + suit;
    }
}