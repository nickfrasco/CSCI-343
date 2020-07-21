
package lab3;

import java.util.*;
import java.io.*;

public interface Card {
	
	
	//create a full deck of cards (with 52 cards; no Jokers)
	int[] deck = new int[52];
    String[] suits = { "C", "D", "H", "S" };
    String[] numbers = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
	
    
	public void initialize();
	
	randomNumbers = new Random();
	String[] myCard = 
    //draw a card, and return the card in the format of a string, e.g, 2S (2 of Spades)
    //the single letter representation for shapes:
    //S (spades), C (clubs), H (hearts) and D (diamonds)
    
    public String drawCard(); 
    	
    
}


