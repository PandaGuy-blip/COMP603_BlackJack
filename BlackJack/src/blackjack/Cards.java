/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blackjack;

/**
 *
 * @author Johnson
 * Contains the cards that will be played 
 * Two enum: Type and Value
 * Use the enum in Cards Class
 */

//Create an enum to store the types of cards
//Clubs, Diamonds, Hearts, Spades
enum Types {
    Hearts("Hearts"),
    Diamonds("Diamonds"),
    Spades("Spades"),
    Clubs("Clubs");
//Variables
    String typeName;
//toString for the variable name 
    public String toString(){
        return typeName;
    }
//Constructor 
    Types(String typeName){
        this.typeName = typeName;
    }
}
//Create an enum to store the value of the cards
//Give each Value a name and number 
enum Value {
    Card1("Ace", 11),
    Card2("Two", 2),
    Card3("Three", 3),
    Card4("Four",4),
    Card5("Five",5),
    Card6("Six",6),
    Card7("Seven",7),
    Card8("Eight",8),
    Card9("Nine",9),
    Card10("Ten",10),
    //All cards are at face value, except for the King, Queen and Jack which count as 10
    Card11("Jack",10),
    Card12("Queen",10),
    Card13("King",10);
//Variables
    int rankValue;
    String rankName;
//Constructor 
    Value(String rankName, int rankValue){
        this.rankName = rankName;
        this.rankValue = rankValue;
    }
//toString for the values name 
    public String toString(){
        return rankName;
    }
}

public class Cards {
//Variables
    private Types type;
    private Value value;
//Constrcutor 
    Cards(Types type, Value value)
{
    this.value=value;
    this.type=type;
}
//Value
     public int getValue(){
        return value.rankValue;
    }
    public Value getRank(){
        return value;
    }
//Types
    public Types getType(){
        return type;
    }
//The only thing it does is match the suit and rank of one Card to another Card specified in the parameters
    public Cards(Cards card){
        this.type = card.getType();
        this.value = card.getRank();
    }
//toString method  
    public String toString()
    {
        return ("["+value+" of "+ type + "]");
    }
}
