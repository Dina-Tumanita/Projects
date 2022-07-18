package org.ipc1.project1.games.HangMan;

import org.ipc1.project1.utils.Dice;
import org.ipc1.project1.utils.Player;
import java.util.Scanner;

public class TurnHM {
    private Dice dice = new Dice();
    private Scanner scanner = new Scanner(System.in);

    public int firstTurn(Player p1, Player p2){

        int p1Throw = 0;
        int p2Throw = 0;

        do {
        System.out.println("\nDice determines first turn\n");
        p1Throw = dice.isThrown();
        System.out.println(p1.name + " gets: " + p1Throw );
        System.out.println("Enter to continue");
        scanner.nextLine();

        p2Throw = dice.isThrown();
        System.out.println(p2.name + " gets: " + p2Throw);
        System.out.println("Enter to continue");
        scanner.nextLine();
        
        } while (p1Throw == p2Throw);

        return (p1Throw > p2Throw) ? 1 : 2;

    }

    public int nextPlayer(int turn){
        return (turn == 1) ? 2 : 1;

    }

    public void placeLetter(char[] secretWordarray, char[] guessingWordarray){
        String word = "";
        for (int i = 0; i < secretWordarray.length; i++){
            if (guessingWordarray[i] == ' '){ word += " ";
       
        }
            else {word += guessingWordarray[i];  }           
        }  
        System.out.println(word);
        for (int i = 0; i < secretWordarray.length; i++){
            System.out.print("_");                 
        }
        System.out.println(""); 
    }

    public void checkWin(Player p1, Player p2, int hangmanParts){
        if (hangmanParts == 0){
            System.out.println("*********" + p2.name + " WON!!!************");
            p1.lostHM++;
            p1.losses = p1.lostHM + p1.lostTTT ;
            
            p2.wonHM++;
            p2.wins = p2.wonHM + p2.wonTTT; 

        } else {      
            p2.lostHM++;
            p2.losses = p2.lostHM + p2.lostTTT ;
            
            p1.wonHM++;
            p1.wins = p1.wonHM + p1.wonTTT;             
            System.out.println("*********" + p1.name + " WON!!!************");            
        }
        System.out.println("Enter to continue");
        scanner.nextLine();

    }

    public int checkExisting(String word, char letter){        
        int letterPosition = word.indexOf(letter); 
        return letterPosition;

    }

}
