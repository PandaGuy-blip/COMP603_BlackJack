/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blackjack;

import java.util.Scanner;

/**
 *
 * @author Johnson
 * Functions to use in Main to play the game
 * INCLUDES: Shuffle, MakeDecision, dealerDecision, BustWins, findWinner
 * This Class also includes two static classes called MyPerson and MyDealer that extends to PlayerAndBank
 */

public class Functions {
    Scanner keyboard = new Scanner(System.in);
    //Find these two classes at the end 
    MyPerson myperson = new MyPerson();
    MyDealer mydealer = new MyDealer();
    //Get Deck Class
    private Deck deck;
    //Use this in Main 
    public Functions(){
        //Create A Deck 
        deck = new Deck(true);
        //Shuffle the Deck so it's Random
        deck.shuffle();
        //Start the game
        myDealerStart();
        myPersonStart();
        //MakeDecision
        makeDecision();
        //Dealer's Turn
        dealerDecision();
        //Check if anyone has Bust
        BustWins();
        //Announce the WINNER Gain or Lose Money
        findWinner();
}
//Start the game and give 2 cards to each person 
//User's Start
private void myPersonStart(){
    myperson.getList().TakeCard(deck);
    myperson.getList().TakeCard(deck);
    myperson.printHand();
}
//Dealer's Start
private void myDealerStart(){
    mydealer.getList().TakeCard(deck);
    mydealer.getList().TakeCard(deck);
    mydealer.printFirstHand();
}
//Hit or Stand 
    private void makeDecision(){
        boolean done = true;
        //Check For BlackJack IF Statement 
        if(myperson.getList().hasBlackjack() == false && mydealer.getList().hasBlackjack() == false){
        //While True the User can keep hitting unless it meets certain boundaries then stop the loop
            //Make it keep going until User enters either A or B 
            while(true){    
            System.out.println("Would you like to: A) Hit or B) Stand");
            char user_char = keyboard.next().charAt(0);
            done = false;
                
            if(user_char == 'A' || user_char == 'A' + 32){
                myperson.getList().TakeCard(deck);
                myperson.printHand();
                if(myperson.getList().Calculate() == 21){
                    System.out.println("You got BlackJack");
                    return;
                }
                else if(myperson.getList().Calculate() > 21){
                    System.out.println("You Went Over");
                    return;
                }//End of Player Over 21
            }//End of Hit
            if(user_char == 'B' || user_char == 'B' + 32){
//            System.out.println("Dealer's Turn");
            return;
            }//End Of Stand
            }//End of While Loop
        }//End Of First IF
    }
//Dealer's Turn 
    //void dealerDecision
    private void dealerDecision(){
        boolean done = true;
        //If dealer has blackjack set to true then show card
        if(mydealer.getList().hasBlackjack() == true){
         System.out.println("DEALER HAS BLACKJACK");
         mydealer.printHand();
        }
        //If user and dealer both don't have blackjack then give card
        if(myperson.getList().hasBlackjack() == false && mydealer.getList().hasBlackjack() == false){
            //If user has more than 22 than don't give card to dealer
            if(myperson.getList().Calculate() < 22){
            mydealer.printHand();
            //Loop until the while loop meets the boundaries
            while(true){
                done = false;
                //if User's value is higher than Dealer, give card to Dealer 
                if(myperson.getList().Calculate() > mydealer.getList().Calculate()){
                 mydealer.getList().TakeCard(deck);
                 //Show Cards
                 mydealer.printHand();
                 //If Dealer goes over 21 than User Wins 
                    if(myperson.getList().Calculate() > 21){
                    System.out.println("Dealer Went Over");
                    return;
                }
             } 
             //End the loop IF don't meet requirements
             else{
                 return;
            }
        }
      }
    }
}
//Create a boolean method(True or False) to see if anyone has got Bust
    private boolean BustWins()
    {
        //If the person is the one to bust, return false and make them lose money later
        if(myperson.getList().busted())
        {
            return false;
            //Make MyPerson lose 50 Dollars Later
        }
        //If the dealer is the one to bust, return true and make person gain money later
        else if(mydealer.getList().busted())
        {
            return true;
            //Make MyPerson Win 50 Dollars Later
        }
    //If no-one has bust, then return    
        return myperson.getList().Calculate() > mydealer.getList().Calculate();
    }
//See who won and if BlackJack then add 100
    //if Tie then money stays the same 
        //if loss then money decreases by 50 AND if won then money increases by 50
    //THIS WAS JUST INT BEFORE
    private int findWinner()
    {
        Boolean b1 = true;  
        //IF BustWins is true then Player Wins
        if(b1.equals(BustWins()))
        {
            System.out.println("You Won!");
            //IF BlackJack then they Win 100!
            if(myperson.getList().hasBlackjack())
            {
                myperson.increase(100);
                return myperson.getBalance();
            }
            myperson.increase(50);
            return myperson.getBalance();
        }
        else if(myperson.getList().Calculate() == mydealer.getList().Calculate())
        {
            System.out.println("You Both Have the Same Amount");
            return myperson.getBalance();
        }
        else
        {
            System.out.println("Dealer Won");
            myperson.decrease(50);
            return myperson.getBalance();
        }
    }

//Classes for Dealer and User
    static class MyDealer extends PlayerAndBank{
        public MyDealer(){
        //Name the dealer "Dealer"
        super.setName("Dealer");
        //Set the balance for the dealer to be 1M
            //Not planned to use, just incase
//        super.setBalance(10000000);
        }
    }
    //End of Dealer Class
    
    static class MyPerson extends PlayerAndBank{
        public MyPerson() {
        //Set Person to 
        super.setName("User");
        //Set Person Balance to 1000
        super.setBalance(1000);
        }
    }
    //End of Player Class
}