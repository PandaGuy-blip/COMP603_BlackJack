/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blackjack;

/**
 *
 * @author Johnson
 * IMPORTANT
 * This is for the two static classes found in Functions at the bottom
 * MyPerson and MyDealer
 */
public abstract class PlayerAndBank {

//Variables
    private List list;
    private int balance;
    private String name;
//Constructor 
    public PlayerAndBank(){
        this.list = new List();
        this.balance = 1000;
        this.name = "";
    }
//Print the person's cards 
    public void printHand(){
    System.out.println(this.name + "'s hand:" + getList().toString());
}
//This is for the Dealer's hand, DON'T USE FOR PLAYER 
    //Print the first hand and the value
    public void printFirstHand(){
    System.out.println(this.name + "'s hand:" + getList().firstCard(0));
}
//Lose Money
    	public void decrease(double amount)
	{
            setBalance((int) (getBalance() - amount));
	}
//Win Money
        public void increase(double amount)
	{
            setBalance((int) (getBalance() + amount));
	}
        
//Getters
    //Rules
    public List getList() {
        return list;
    }
    //balance
    public int getBalance() {
        return balance;
    }
    //name
    public String getName() {
        return name;
    }
//Setters
    //Rules
    public void setList(List list) {
        this.list = list;
    }
    //Balance
    public void setBalance(int balance) {
        this.balance = balance;
    }
    //Name
    public void setName(String name) {
        this.name = name;
    }
}
