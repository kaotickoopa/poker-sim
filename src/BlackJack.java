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
        Hand currentHand = new Hand();
        Card firstDrawnCard = playingDeck.drawCard();
        Card secondDrawnCard = playingDeck.drawCard();
        currentHand.populateHand(firstDrawnCard, secondDrawnCard);

        handMap.put(0, currentHand);
        for(int i = 0; i < numberOfPlayers; i++){
            currentHand = new Hand();
            firstDrawnCard = playingDeck.drawCard();
            secondDrawnCard = playingDeck.drawCard();
            currentHand.populateHand(firstDrawnCard, secondDrawnCard);

            handMap.put(i+1, currentHand);
        }
    }
    @Override
     void playerTurn(){
        for(int i = 1; i < handMap.size(); i++){
            Hand currentHand = handMap.get(i);
            while (true) { 
                //draws cards until over 21 or user stops
                currentHand.printHand();
                String userInput = getUserInput(in);
                if(userInput.equals("H")){
                    Card drawnCard = playingDeck.drawCard();
                    currentHand.addToHand(drawnCard);

                    if(currentHand.getHandsPoints() > 21){
                        currentHand.isValid = false;
                        System.out.println("You busted! You lose pal");
                        break;
                    }
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
        currentHand.printHand();
        System.out.println(currentHand.getHandsPoints());
        while (true) { 
            //draws cards until over 21 or user stops
            if(currentHand.getHandsPoints() < 17){
                Card drawnCard = playingDeck.drawCard();
                currentHand.addToHand(drawnCard);
                System.out.println(currentHand.getHandsPoints());
            }
            else {
                break;
            }
        }

    }

    @Override
     void showDown(){
        Hand dealerHand = handMap.get(0);
        int dealerPoints = dealerHand.getHandsPoints();
        for(int i = 1; i < handMap.size();i++){

            Hand player_hand = handMap.get(i);
            if(player_hand.isValid){
                int player_points = player_hand.getHandsPoints();
                if( player_points > dealerPoints){
                    System.out.println("Congrats you win Player " + i + "!");
                }
                else{
                    System.out.println("Sorry you lose Player " + i + "!");
                }
            }

        }
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
