package u6pp;
import java.util.Random;

public class CardStack {

    public static String RED = "RED";
    public static String GREEN = "GREEN";
    public static String BLUE = "BLUE";
    public static String YELLOW = "YELLOW";

    public static String ZERO = "0";
    public static String ONE = "1";
    public static String TWO = "2";
    public static String THREE = "3";
    public static String FOUR = "4";
    public static String FIVE = "5";
    public static String SIX = "6";
    public static String SEVEN = "7";
    public static String EIGHT = "8";
    public static String NINE = "9";

    public static String DRAW_2 = "DRAW_2";
    public static String REVERSE = "REVERSE";
    public static String SKIP = "SKIP";
    public static String WILD = "WILD";
    public static String WILD_DRAW_4 = "WILD_DRAW_4";

    // Wild color is the default color for wilds, before they are played. 
    public static String[] COLORS = {RED, GREEN, BLUE, YELLOW, WILD}; 
    public static String[] VALUES = {ZERO, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, 
        DRAW_2, REVERSE, SKIP, WILD, WILD_DRAW_4};


    private Card[] deck = new Card[108];

    private int cardsLeft;
    private int draw;

    public boolean isEmpty(){
        if (deck[0] == null){
            return true; 
        }
        else{
            return false;
        }
    }

    public void Deck() {
        cardsLeft = 108;
        draw = 0;
        int k = 0;

        for (int i = 0; i< COLORS.length; i++) {
            for (int j = 0; j < VALUES.length; j++){
                deck [k] =  new Card(COLORS[i], VALUES[j]);
                k += 1;
            }
        }
        System.out.println(deck.toString());
         
    }

    public int getSize(){
        return cardsLeft;
    }

    public Card deal() {
        draw += 1;
        cardsLeft -= 1;

        return deck[draw - 1];

    }

    public void shuffle() {
            
        Random rand = new Random();
            
        for (int i = 0; i < 108; i++) {
            int randomPosiiton = rand.nextInt(108);
            Card temp = deck[randomPosiiton];
            deck[randomPosiiton] = deck[i];
            deck[i] = temp;
        }

        cardsLeft = 108;
        draw = 0;

    }

}
