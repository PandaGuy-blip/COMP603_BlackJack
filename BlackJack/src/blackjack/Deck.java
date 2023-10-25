/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package blackjack;

/**
 *
 * @author Johnson
 * The deck, create the Deck if Player wants to play
 * Shuffle the deck so it's random each time 
 */

import java.util.ArrayList;
import java.util.Random;

public class Deck {
//Arraylist represents the list of cards in deck
    //Create List using cards from the Card Class
private ArrayList<Cards> deck;
    Deck()
{
    deck = new ArrayList<Cards>();{
}
}
//Add Card to deck 
public void add(Cards c){
        deck.add(c);
    }

//Take Card and remove 
public Cards deal()
  {
    return deck.remove(0);
  }
//boolean Method to make Deck if player wants to keep playing 
public Deck(boolean createDeck){
    deck = new ArrayList<Cards>();
    //if true than create the deck 
    if(true){
    //Goes Through all Values of Cards
        for(Value value : Value.values()){
        //Goes Through all Types of Cards
        for(Types type : Types.values()){
            deck.add(new Cards(type, value));
                }
            }
        }
    }
//Shuffles The Cards
public void shuffle()
{
    Random random = new Random();
    Cards c;
    for(int i=0; i<100; i++)
    {
        //first
        int card1 = random.nextInt(deck.size()-1);
        //second 
        int card2 = random.nextInt(deck.size()-1);
        //get and set
        c = deck.get(card2);
        deck.set(card2, deck.get(card1));
        deck.set(card1, c);
    }

}

    
}
