/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blackjack;

import static blackjack.Reader.openResource;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Johnson
 */

public class Main{
    public Reader reader;
    
    public static void main(String[] args) throws FileNotFoundException, IOException{
        Scanner keyboard = new Scanner(System.in);
        
        boolean done = true;
        
//        Functions blackjack = new Functions();
        
        //Read the Introduction from Txt File BlackJackIntro.txt
        openResource();      
        //While the user still wants to play set True
        while(done){
            //Menu to controls 
            System.out.print("\n");
            System.out.println("Choose a letter to Play \r\n"
                    + "A. BlackJack \r\n"
                    + "B. Look at Introduction \r\n"
                    + "C. Leave Game");
            char user_char = keyboard.next().charAt(0);
                if(user_char == 'A' || user_char == 'A' + 32){
                Functions blackjack = new Functions();
            }//End of IF A 
                if(user_char == 'B' || user_char == 'B' + 32){
                openResource();        
            }//End of IF B
                if(user_char == 'C' || user_char == 'C' + 32){
                    System.out.println("Thank you for playing!");
                    done = false;
            }//End of IF D
        }
    }
}
