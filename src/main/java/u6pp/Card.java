package u6pp;

public class Card {

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

    String color;
    String value;

    
	// Constructor 
	public Card(String c, String v) {
		color = c;
		value = v;
	}
    
    public boolean trySetColor(String input) {

        // inputhelper
        boolean valid = false;
        for(int i = 0; i < COLORS.length; i++) {
            if (COLORS[i].equals(input)){
                valid = true;
            }
        }
        if (valid == false){
            System.out.println("invalid input");
            return false;
        }

        //changes wild to new color
        if (color.equals(WILD)){
            color = input;
            System.out.println("color has been changed to " + input);
            return true;
        }

        if (input.equals(WILD) || input == null){
            System.out.println("invalid input");
            return false;
        }

        else{
            System.out.println("invalid input");
            return false;
        }

    }

    public boolean canPlayOn(Card input){
        if (input == null){
            return false;
        }
        if (color.equals(WILD)){
            return true;
        }
        if (input.getColor().equals(color) || input.getValue().equals(value)){
            return true;
        }
        return false;

    }

    public String getColor(){
        return color;
    }

    public String getValue(){
        return value;
    }
    

}
