package org.ipc1.project1.games.HangMan;

import org.ipc1.project1.utils.Player;
import org.ipc1.project1.utils.Reader;

public class HangedMan {
    private TurnHM turn = new TurnHM();
    private Reader read = new Reader();
    
    private int playerCounter = 0;
    private String secretWord = "";
    private char[] secretWordarray;
    private char[] guessingWordarray;
    private int hangmanParts; //attempts
    private boolean gaming;
    private final int BODY_SEGMENTS = 6;
    private String[] hangedMan = new String[BODY_SEGMENTS]; 
    

    
    public void startGame(Player player1, Player player2) {   
        cleanGame();
        player1.gamesPlayed++;
        player2.gamesPlayed++;

        if (playerCounter == 0){
        playerCounter = turn.firstTurn(player1, player2);
        }

        if (playerCounter == 1){ 
            askSecretWord(player1);
            guessWord(player2, player1);
            playerCounter = 2;
        }
        else {
            askSecretWord(player2);
            guessWord(player1, player2);
            playerCounter = 1;
        }

    }

    public void resetTurns(){
        playerCounter = 0;
    }

    private void cleanGame(){
        hangmanParts = 8; 
        gaming = true;
        hangedMan[0] = ("");                 //rope
        hangedMan[1] = ("");                 //head
        hangedMan[2] = ("");                 //arms  and body
        hangedMan[3] = ("");                 //body
        hangedMan[4] = ("");                 //legs
        hangedMan[5] = ("");                 //legs

    }

    private void askSecretWord(Player player){
        System.out.println("\nFirst player is " );
        System.out.println(player.name);
        System.out.println(player.name + ", please enter your secret word " );

        secretWord = player.sendPlayString().toLowerCase();
        secretWordarray = read.string2Char(secretWord);   
        guessingWordarray = new char[secretWordarray.length];   
        for (int i = 0; i < secretWordarray.length; i++){
            guessingWordarray[i] = ' ';                 
        }

    }

    private void guessWord(Player player, Player p2){
    
        String guess = "";
            do {
            System.out.println("\nYou have "+ hangmanParts + " attempts left" );
            System.out.println(player.name + ", please enter your guess: " );
            printHangMan();
            guess = player.sendPlayString();
            try{
                checkWord(guess.charAt(0));
                editHangedMan();
            } catch(Exception e) { 
                System.out.println("Enter 1 letter at a time please"); 
            }
    } while (gaming);
    printHangMan();
    turn.checkWin(player, p2, hangmanParts);
    cleanGame();
}

    private void printHangMan(){  
        System.out.println("******************");  
        System.out.println("   ---------- ");   

        for (int i = 0; i < BODY_SEGMENTS; i++){
            System.out.println("   |       " + hangedMan[i]);                 
        }   
        System.out.println("---------------");     
        System.out.println("******************");  
        turn.placeLetter(secretWordarray, guessingWordarray); 
             
    }

    private void checkWord(char letter){
        int sameWord = 0; 
        int wordLen = secretWordarray.length;
        int letterPosition = turn.checkExisting(secretWord, letter);

        if (letterPosition == -1 ){
            System.out.println("Not in word"); 
            hangmanParts--;
        }
        else {
            System.out.println("Good Job!"); 
            guessingWordarray[letterPosition] = letter;
            for (int i = 0; i < wordLen; i++){
                if (guessingWordarray[i] != ' ') sameWord++;
            }
            gaming = (wordLen == sameWord) ? false : true;
        }

    }

    private void editHangedMan(){
        switch(hangmanParts){
            case 0:
                hangedMan[4] = "/ \\"; 
                hangedMan[5] = "**********YOU DIED**********";
                gaming = false; 
            break;
            case 1:  
                hangedMan[4] = "/";               
            break;
            case 2:        
                hangedMan[3] = " |";        
            break;
            case 3:
                hangedMan[2] = "/|\\";                
            break;
            case 4:
                hangedMan[2] = "/|";                
            break;
            case 5:
                hangedMan[2]= "/";                 
            break;
            case 6:
                hangedMan[1] = " O";                
            break;
            case 7:
                hangedMan[0] = " |";
            break;
            default:
            break;
        }
    }
}

/*
 *          O  
 *         /|\
 *          | 
 *         / \
 * 
 */