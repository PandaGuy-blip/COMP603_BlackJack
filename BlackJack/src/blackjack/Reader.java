/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blackjack;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Johnson
 * In this Class it uses File/Io to read a quick Introduction to BlackJack and
 * the rules of the game
 */
public class Reader {
//Create a static void to read the created Txt File BlackJackIntro into the console
    //Contains FileReader and BufferedReader
    public static void openResource() throws IOException {
        FileReader inputFile = new FileReader("./resources/BlackJackIntro.txt");
        BufferedReader br=new BufferedReader(inputFile);    

          int i;    
          //Make a while loop and keep increasing i, until it gets to the end of the Txt File 
          while((i=br.read())!=-1){  
          System.out.print((char)i); 
          }  
          //Make sure to close everything 
          br.close();    
          inputFile.close();   
          
    }
}
