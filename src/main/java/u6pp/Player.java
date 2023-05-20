package u6pp;
import java.util.ArrayList;

public class Player {

    String myName;

    ArrayList<Card> hand = new ArrayList<Card>();

    public Player(String name){
        myName = name;
    }

    public void setName(String name){
        myName = name;
    }

    public String getName(){
        return myName;
    }
    
    public ArrayList<Card> getHand(){
        return hand;
    }

}
