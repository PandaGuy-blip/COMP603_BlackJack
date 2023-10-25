/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blackjack;

import java.util.ArrayList;

/**
 *
 * @author Johnson
 * This class creates a List to store cards
 * Also Includes BustWins and BlackJack
 */
public class List {
// This represents the list of cards in the hand.
    private ArrayList<Cards> list;
//Constructor
    public List()
    {
        list = new ArrayList<Cards>();
    }
//Show Dealer First Card
    public Cards firstCard(int x){
        return list.get(x);
    }
//TakeCard && Connect to Deck 
    //deal is created in Deck
    public void TakeCard(Deck d)
    {
        list.add(d.deal());
    }
//toString method 
    public String toString(){
    //A string to hold everything we're going to return
    String sentence = "";
    //for each Card "card" in the deck
    for(Cards c: list){
    	//add the card and the escape character for a new line
        sentence += c + " ";
    }
    sentence += "(" + Calculate() + ")";
    return sentence;
}
//BlackJack WINNER CHICKEN DINNER 
    //Public Boolean(True or False) if BlackJack
    //Use In Function Class Later
    public boolean hasBlackjack()
    {
        //If the amount from the public int Calculate equals to 21 then they have BlackJack
        return Calculate() == 21;
        //        return Calculate() == 21 && list.size() == 2;
    }
//Busted Player or dealer loses
    //Use In Functions later
    public boolean busted()
    {
        //If the amount if more than 21, they Bust
        return Calculate() > 21;
    }
 //calculate the Value and change Ace 
    public int Calculate()
    {
        int aceAmount = 0;
        int amount = 0;
        //Goes through the cards in list 
        for(Cards c: list)
        {
            amount += c.getValue();
            
            if(c.getValue() == 11)
            {
                aceAmount++;
            }
        }
        //Change Ace
        while(amount > 21 && aceAmount > 0)
        {
            amount -= 10;
            aceAmount--;
        }
        //return the amount  
        return amount;
    }
    
}
