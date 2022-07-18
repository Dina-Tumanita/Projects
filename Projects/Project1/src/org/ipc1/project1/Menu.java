package org.ipc1.project1;

import org.ipc1.project1.games.HangMan.HangMan;
import org.ipc1.project1.games.TicTacToe.TicTacToe;
import org.ipc1.project1.menuoptions.CRUD;
import org.ipc1.project1.menuoptions.GameStatistics;
import org.ipc1.project1.menuoptions.PlayerStatistics;
import org.ipc1.project1.utils.Player;
import org.ipc1.project1.utils.Reader;

public class Menu {
    /**
     *
     */
    private final String CHOOSE_AN_OPTION_FROM_1_TO = "Choose an option from 1 to ";
    private Reader read = new Reader();
    private TicTacToe tictactoe = new TicTacToe();
    private HangMan hangman = new HangMan();
    private CRUD crud = new CRUD();
    private GameStatistics gameStats = new GameStatistics();
    private PlayerStatistics playerStats = new PlayerStatistics();
    private Player players[] = new Player[10];
    private int[] currentPlayerPositions = {0, 1};

    private final int maxOptions = 6;
    
    public void play(){
        crud.bootPlayers(players);
        printMenu(); 

    }

    private void printMenu(){ 
        int option = 0;
        String intro = CHOOSE_AN_OPTION_FROM_1_TO + maxOptions; 
        do {
            menuOptions();
            option = read.getOption(intro, maxOptions);
            executeOption(option);  
            currentPlayerPositions = crud.getPlayerPositions();          
        } while (option != maxOptions);

    }

    private void playTicTacToe(){
        tictactoe.play(players[currentPlayerPositions[0]], players[currentPlayerPositions[1]]);
    }

    private void playHangMan(){
        hangman.play(players[currentPlayerPositions[0]], players[currentPlayerPositions[1]]);
    }

    private void showPlayerStats(){
        playerStats.showStats(players);
    }

    private void showGameStats(){
        gameStats.showStats();
    }

    private void showCRUD(){
        crud.printMenu(players);
    }

    
    private void executeOption(int option) {
        switch (option) {
            case 1:
                playTicTacToe();
                break;
            case 2:
                playHangMan();
                break;
            case 3:
                showCRUD();
                break;
            case 4:
                showPlayerStats();
                break;
            case 5:
                showGameStats();
                break;
            case 6:
                System.out.println("Good Bye!");
                break;
            default:
                System.out.println("Not an option");
                break;
        }
    }

    private void menuOptions() {
        
        System.out.println("***********WELCOME***********");
        System.out.println("1) Play Tic Tac Toe");
        System.out.println("2) Play Hangman");
        System.out.println("3) CRUD (Player Settings) ");
        System.out.println("4) Player Statistics");
        System.out.println("5) Game Statistics");
        System.out.println("6) Exit");
    
    }

}
