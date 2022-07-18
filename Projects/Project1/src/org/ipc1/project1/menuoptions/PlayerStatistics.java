package org.ipc1.project1.menuoptions;

import org.ipc1.project1.utils.Reader;
import org.ipc1.project1.utils.Player;

public class PlayerStatistics {
    private CRUD crud = new CRUD();
    private Reader read = new Reader();

    public void showStats(Player[] player){
        
        System.out.println("Player Stats");

        String question = "Who do you wish to show stats?";
        int option = 0;
        int activePlayers = crud.howManyPlayers(player);

        do {
            crud.printPlayers(player);
            System.out.println(activePlayers + ") Exit");           
            option = read.getOption(question, activePlayers); 
            if (option != activePlayers) playerStats(player[option-1]);      
        } while (option != activePlayers);
                  
    }

    private void playerStats(Player player){        
        System.out.println(player.name + " stats: ");
        System.out.println("Games won: " + player.wins );
        System.out.println("Games lost: " + player.losses);
        System.out.println("Games played: " + player.gamesPlayed);
    }

}
