import java.util.Scanner;

public class BlackJack extends Game{
    Scanner in = new Scanner(System.in);
    boolean isGameOver = false;

    public BlackJack(){
    }

    @Override
     void startGame(){
        System.out.println("How many people are playing Blackjack?");
        numberOfPlayers = in.nextInt();
        for(int i = 0; i < numberOfPlayers; i++){
            Hand currentHand = new Hand();
            Card firstDrawnCard = playingDeck.drawCard();
            Card secondDrawnCard = playingDeck.drawCard();
            currentHand.populateHand(firstDrawnCard, secondDrawnCard);

            handMap.put(0, currentHand);
        }
    }
    @Override
     void playerTurn(){
        for(int i = 1; i < handMap.size(); i++){
            Hand currentHand = handMap.get(i);
            while (true) { 
                //draws cards until over 21 or user stops
                String userInput = getUserInput(in);
                if(userInput.equals("H")){
                    Card drawnCard = playingDeck.drawCard();
                    currentHand.addToHand(drawnCard);
                }
                else if (userInput.equals("S")) {
                    break;
                }
                else {
                    System.out.println("Invalid input. Try again");
                }
            }
        }
    }

    @Override
     void dealerTurn(){
        Hand currentHand = handMap.get(0);
        while (true) { 
            //draws cards until over 21 or user stops
            if(){
                Card drawnCard = playingDeck.drawCard();
                currentHand.addToHand(drawnCard);
            }
            else if () {
                break;
            }
        }

    }

    @Override
     void showDown(){

    }
    @Override
    public void playGame(){
        startGame();
        playerTurn();
        dealerTurn();
        showDown();
    }

    @Override
     String getUserInput(Scanner in){
        System.out.println("Do you hit (H) or stay (S)?");
        return in.next();
    } 
}
