package u6pp;
import java.util.ArrayList;
import java.util.Random;

public class CardStack {

    ArrayList<Card> deck = new ArrayList<Card>();

    public CardStack(){

    }

    public void push(Card card){
        deck.add(0, card);
    }

    public Card peek(){
        if(this.isEmpty()){
            return null;
        } 
        return(deck.get(0));
    }

    public boolean isEmpty(){
        if(deck.size() == 0){
            return true;
        }
        return false;
    }

    public int getSize(){
        return deck.size();
    }

    public Card pop(){

        Card topCard = deck.get(0);
        deck.remove(0);

        return topCard;
    }

    public void clear(){

        deck.clear();

    }

    public void addAll(CardStack deck2){

        ArrayList<Card> trash = new ArrayList<Card>();

        if(deck.equals(deck2.deck)){
            return;
        }

        while(deck2.isEmpty() == false){
            trash.add(0, deck2.deck.get(0));
            deck2.deck.remove(0);
        }

        while(trash.isEmpty() == false){
            deck.add(0, trash.get(0));
            trash.remove(0);
        }

    }

    public void shuffle(){

        Random random = new Random(); 

        for (int i = 0; i < deck.size(); i++) {
            int base = random.nextInt(i, deck.size());

            if (base == i) {
                continue;
            }

            Card check = deck.get(i);
            deck.set(i, deck.get(base));
            deck.set(base, check);
        }
    }

    public static CardStack createUnoDeck() {

        CardStack cardStack = new CardStack();

        for (String color : Card.COLORS) {

            if (color.equalsIgnoreCase(Card.WILD)) {
                continue;
            }
    
            for (String value : Card.VALUES) {

                if (value.equals(Card.WILD) || value.equals(Card.WILD_DRAW_4)) {
                    continue;
                }

                cardStack.push(new Card(color, value));

                if (!value.equalsIgnoreCase(Card.ZERO)) {
                    cardStack.push(new Card(color, value));
                }

            }
        }
    
        for (int i = 0; i < 4; i++) {

            cardStack.push(new Card(Card.WILD, Card.WILD));
            cardStack.push(new Card(Card.WILD, Card.WILD_DRAW_4));

        }
    
        return cardStack;
    }
}