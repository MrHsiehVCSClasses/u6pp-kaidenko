package u6pp;

import java.util.ArrayList;

public class Uno {
    
    ArrayList<Player> players = new ArrayList<>();

    //intiializor
    CardStack deck = new CardStack();
    CardStack trash = new CardStack();

    int index;
    boolean reverse;
    

    public Uno(ArrayList<Player> players, CardStack deck, CardStack trash, int count, boolean reverse){
        this.players = players;
        this.deck = deck;
        this.trash = trash;
        this.reverse = reverse;
    }

    public Uno(int playerCount){

        players = new ArrayList<Player>(playerCount);
        
        for(int i = 0; i < playerCount; i++){
            players.add(new Player("Player #" + (i + 1)));
        }

        deck = CardStack.createUnoDeck();
        deck.shuffle();
        trash = deck;

        for (int i = 0; i < 7; i++) {
            for (Player x : players) {
                x.getHand().add(deck.pop());
            }
        }
    }
   
    public ArrayList<Player> getPlayers(){
        return players;
    }
  
    public Player getCurrentPlayer(){
        return players.get(index);
    }
   
    public Player getNextPlayer(){
        int nextPlayerIndex;
        if(reverse == true){
            nextPlayerIndex = index - 1;
            if(nextPlayerIndex < 0){
                nextPlayerIndex = players.size() - 1;
            }
        } 
        else{
            nextPlayerIndex = index + 1;
            nextPlayerIndex = (nextPlayerIndex % players.size());
        }
        return players.get(nextPlayerIndex);
    }
 
    public Card getTopDiscard(){
        if(trash.getSize() > 0){
            return trash.peek();
        }
        return null;
    }

    public Player getWinner(){
        for(Player x : players){
            if(x.getHand().size() == 0){
                return x;
            }
        }
        return null;
    }

    private void endTurn(){
        if(reverse){
            index -= 1;
            if(index < 0){
                index = players.size() - 1;
            }
        }
        else{
            index += 1;
            index = (index % players.size());
        }
    }

    private void drawCards(int draw){

        for(int i = 0; i < draw; i++){

            getCurrentPlayer().getHand().add(deck.pop());

            if(deck.isEmpty()){

                Card discardTop = trash.pop();

                while(!trash.isEmpty()){
                    deck.push(trash.pop());
                }

                deck.shuffle();
                trash.push(discardTop);

            }
        }
    }
  
    public boolean playCard(Card playedCard, String col){

        if(playedCard == null){
            drawCards(1);
            endTurn();
            return true;
        }

        if(getCurrentPlayer().getHand().contains(playedCard) == false){
            return false;
        }
        if(playedCard.canPlayOn(getTopDiscard()) == false){
            return false;
        }

        if(playedCard.getColor().equals(Card.WILD) || playedCard.getColor().equals(Card.WILD_DRAW_4)){

            if(playedCard.trySetColor(col) == true){
                return true;
            }

        }

        getCurrentPlayer().getHand().remove(playedCard);
        trash.push(playedCard);

        if(playedCard.getValue().equals(Card.REVERSE)){
            reverse = !reverse;
        }

        endTurn();

        if(playedCard.getValue().equals(Card.SKIP)){
            endTurn();
        }
        
        else if(playedCard.getValue().equals(Card.DRAW_2)){
            drawCards(2);
            endTurn();
        } 

        else if(playedCard.getValue().equals(Card.WILD_DRAW_4)){
            drawCards(4);
            endTurn();
        }

        return true;

    }

}