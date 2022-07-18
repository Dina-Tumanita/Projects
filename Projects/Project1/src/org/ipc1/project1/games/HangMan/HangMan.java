package org.ipc1.project1.games.HangMan;

import org.ipc1.project1.utils.Player;

public class HangMan {
    
    private HangedMan hangman = new HangedMan();

    public void play(Player player1, Player player2) {
        System.out.println("\n****Welcome to Hangman!****");
        System.out.println(player1.name + " vs " + player2.name);

        hangman.startGame(player1, player2);      

    }

   



    

    





}
